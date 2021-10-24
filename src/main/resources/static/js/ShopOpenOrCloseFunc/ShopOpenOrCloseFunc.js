let storeCheckBoxIds = { // 체크박스에 동적으로 할당시킬 id값들 저장해두고 있는 객체
    'checkBoxId': 0
}

let a = 0;

if (myShops.length === 1) {
    $('#myshopsInfoPosition').append('<div>가게가 없어요. 먼저 등록해주세요.</div>')
} else {
    $('#myshopsInfoPosition').empty();
    for (let i = 0; i < myShops.length; i++) {
        const nowShop = myShops[i].shopName;
        storeCheckBoxIds.checkBoxId = +a;

        $('#myshopsInfoPosition').append('가게 이름 : <div>' + myShops[i].shopName + '</div>')
        $('#myshopsInfoPosition').append('가게 카테고리 : <div>' + myShops[i].category + '</div>')
        $('#myshopsInfoPosition').append('전체 좌석수 : <div>' + myShops[i].totalSeat + '</div>')
        $('#myshopsInfoPosition').append('현재 좌석수 : <div>' + myShops[i].currentSeat + '</div>')

        if(myShops[i].open){
            $('#myshopsInfoPosition').append('<input type="checkbox" checked id="' + storeCheckBoxIds.checkBoxId + '" onclick="openLogic(\'' + a + '\',\'' + nowShop + '\');">')
        }else{
            $('#myshopsInfoPosition').append('<input type="checkbox" id="' + storeCheckBoxIds.checkBoxId + '" onclick="openLogic(\'' + a + '\',\'' + nowShop + '\');">')
        }

        ++a;

        function openLogic(id, shopName) {
            let checked = document.getElementById(eval("id")).checked;
            let openShop = new Object();
            openShop.shopName = shopName;
            openShop.isOpen = checked;
            $.ajax({
                type: "get",
                url: "/SellerPage/openCloseFunc",
                data: openShop,
                success: function (result) {
                    console.log(result);
                    if (result == 1) {
                        alert("열고닫기 완료")
                    } else {
                        alert("가게 열고 닫기 실패")
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("통신 실패.")
                }
            });

        }
    }
}