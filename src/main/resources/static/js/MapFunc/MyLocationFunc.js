function storeSave(){
    if('geolocation' in navigator) {
        navigator.geolocation.getCurrentPosition(success)
    } else {
        alert("geolocation을 사용할 수가 없어요")
    }
}

function success(pos){

    let data = new Object(); // 현재 좌표값 저장되는 객체

    data.latitude = pos.coords.latitude;
    data.longitude = pos.coords.longitude;

    data.shopName = $('#storeName').val();
    data.totalSeat = $('#allSeat').val();
    data.category = $('#category').val();

    $.ajax({
        type: "post",
        url: "/SellerPage/saveShop",
        data: data,
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