window.onload = function BuyerMap() {
    if (searchByNameList == null) {
        buyershowMap(locationShops);
    } else {
        buyershowMap(searchByNameList);
    }
}

function mapFunc(lat, lon){
    return new naver.maps.Map('map', {
        center: new naver.maps.LatLng(lat, lon),
        zoom: 15
    });
}

function buyershowMap(locations) {
    let mapResult;
    let contentResult;
    if (searchByNameList == null) {
        let sch = location.search
        const params = new URLSearchParams(sch);
        mapResult = mapFunc(params.get('lat'),  params.get('lon'));
    } else {
        mapResult = mapFunc(locations[0].latitude, locations[0].longitude);
    }


    for (let i = 0; i < locations.length; i++) {

        let marker = new naver.maps.Marker({
            map: mapResult,
            title: locations[i].shopName,
            position: new naver.maps.LatLng(locations[i].latitude, locations[i].longitude),
        });



        contentResult = [
            '<div class="iw_inner">',
            '   <h>'+locations[i].shopName+'</h3>',
            '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
            // '       <img src="'+ HOME_PATH +'/img/example/hi-seoul.jpg" width="55" height="55" alt="서울시청" class="thumb" /><br />',
            '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
            '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
            '   </p>',
            '</div>'
        ].join('');

        let infowindow = new naver.maps.InfoWindow({ // 마커정보인듯
            content: contentResult,
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
                infowindow.open(mapResult, marker);
            }
        });
    }
}
