$('#loginFuncJs').click(function () {
    const data = {
        'id': $("#ID").val(),
        'password': $("#Password").val()
    }
    $.ajax({
        type: "post",
        url: "/StartLogin",
        data: data,
        success: function (result) {
            let goSellerPageOrBuyerPage1 = goSellerPageOrBuyerPage(result);
            if (goSellerPageOrBuyerPage1 === null){
                alert("로그인 실패")
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
});

window.goSellerPageOrBuyerPage = function (result) {



    if (result === "buyer") {
        navigator.geolocation.getCurrentPosition(function(pos) {
            let latitude;
            let longitude;
            latitude = pos.coords.latitude;
            longitude = pos.coords.longitude;

            const newWindow = window.open("about:blank");
            newWindow.location.href = "/BuyerPage?lat="+latitude+"&lon="+longitude
        });
    } else if (result === "seller") {
        const newWindow = window.open("about:blank");
        newWindow.location.href = "/SellerPage"
    } else {
        return null;
    }
};