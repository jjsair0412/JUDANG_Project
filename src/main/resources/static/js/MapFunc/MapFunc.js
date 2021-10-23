let data = new Object(); // 서버로 전달할 값들 저장하는 객체
function SearchMyStore() {
    let position = $('#positionSearch').val();
    naver.maps.Service.geocode({
        query: position
    }, function (status, response) {
        if (status !== naver.maps.Service.Status.OK) {
            return alert('Something wrong!');
        }

        var result = response.v2, // 검색 결과의 컨테이너
            items = result.addresses; // 검색 결과의 배열

        data.latitude = items[0].y; // 위도
        data.longitude = items[0].x; // 경도

        console.log("위도 ="+data.latitude+ " 경도 = "+data.longitude)

        showMap(data);
    });
}

function storeSave() {
    data.shopName = $('#storeName').val();
    data.totalSeat = $('#allSeat').val();
    data.category = $('#category').val();

    $.ajax({
        type: "post",
        url: "/SellerPage/saveShop",
        data: data,
        success: function (result) {
            if (result == 1) {
                alert("가게 등록완료")
            } else {
                alert("가게 등록실패")
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
}

function showMap(pos) {
    var HOME_PATH = window.HOME_PATH || '.';
    var myPosition = new naver.maps.LatLng(data.latitude, data.longitude),
        map = new naver.maps.Map('map', {
            center: myPosition,
            zoom: 15
        }),
        marker = new naver.maps.Marker({
            map: map,
            position: myPosition
        });

    // 가게정보 json으로 받아와서 html코드로 작성
    var contentString = [
        '<div class="iw_inner">',
        '   <h3>서울특별시청</h3>',
        '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
        // '       <img src="'+ HOME_PATH +'/img/example/hi-seoul.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br />',
        '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
        '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
        '   </p>',
        '</div>'
    ].join('');

    var infowindow = new naver.maps.InfoWindow({ // 마커정보인듯
        content: contentString,
        maxWidth: 140,
        backgroundColor: "#eee",
        borderColor: "#2db400",
        borderWidth: 5,
        anchorSize: new naver.maps.Size(30, 30),
        anchorSkew: true,
        anchorColor: "#eee",
        pixelOffset: new naver.maps.Point(20, -20)
    });

    naver.maps.Event.addListener(marker, "click", function (e) { // 클릭시 마커에 등록된 정보들 출력하는 함수인듯
        if (infowindow.getMap()) {
            infowindow.close();
        } else {
            infowindow.open(map, marker);
        }
    });
}