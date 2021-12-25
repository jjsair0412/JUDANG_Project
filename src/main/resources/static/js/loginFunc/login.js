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
            if (goSellerPageOrBuyerPage1 === null) {
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
        navigator.geolocation.getCurrentPosition(function (pos) {
            location.href = "/BuyerPage?lat=" + pos.coords.latitude + "&lon=" + pos.coords.longitude
        });
    } else if (result === "seller") {
        location.href = "/SellerPage"
    } else {
        return null;
    }
};