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

    const newWindow = window.open("about:blank");

    if (result === "buyer") {
        newWindow.location.href = "/BuyerPage"
    } else if (result === "seller") {
        newWindow.location.href = "/SellerPage"
    } else {
        return null;
    }
};