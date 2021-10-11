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
            alert(result)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
});
