$('#loginFuncJs').click(function () {
    const data = {
        'Id': $("#user-id"),
        'Password': $("#user-password")
    }
    $.ajax({
        type: "POST",
        url: "/oneMovie/viewOneMovie",
        data: data,
        success: function (result) {
            newPage(result)
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("통신 실패.")
        }
    });
});

window.newPage = function (URI) {
    let newPage = window.open("about:blank");
    newPage.location.href(URI);
}
