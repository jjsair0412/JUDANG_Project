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
        url: "/map/mylocation",
        data: coordinate,
        success: function (result) {
            console.log(result)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
}