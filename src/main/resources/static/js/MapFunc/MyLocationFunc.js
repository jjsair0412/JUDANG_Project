function testSellerFunc(){
    if('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition(success)
    } else {
        alert("geolocation을 사용할 수가 없어요")
    }
}

function success(pos){

    let coordinate = new Object(); // 현재 좌표값 저장되는 객체

    coordinate.latitude = pos.coords.latitude;
    coordinate.longitude = pos.coords.longitude;


    $.ajax({
        type: "post",
        url: "/SellerPage/saveShop",
        data: coordinate,
        success: function (result) {
            if(result === 1){
                alert("등록완료")
            }else{
                alert("등록실패")
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
}