let storeCheckBoxIds = { // 체크박스에 동적으로 할당시킬 id값들 저장해두고 있는 객체
    'checkBoxId': 0
}


let a = 0;

if (myShops === null) {

} else {
    $('#myshopsInfoPosition').empty();
    for (let i = 0; i < myShops.length; i++) {
        ++a;

        let htmlId = myShops[i].htmlId;
        if(storeCheckBoxIds.checkBoxId === htmlId){
            a += htmlId;
        }

        const nowShop = myShops[i].shopName;
        storeCheckBoxIds.checkBoxId = +a;


        $('#myshopsInfoPosition').append('가게 이름 : <div onclick="goThisStoreInfo(\'' + myShops[i].shopName + '\',\'' + storeCheckBoxIds.checkBoxId + '\');">' + myShops[i].shopName + '</div>')
        // $('#myshopsInfoPosition').append('가게 카테고리 : <div>' + myShops[i].category + '</div>')
        // $('#myshopsInfoPosition').append('전체 좌석수 : <div>' + myShops[i].totalSeat + '</div>')
        // $('#myshopsInfoPosition').append('현재 좌석수 : <div>' + myShops[i].currentSeat + '</div>')

        if (myShops[i].open) {
            $('#myshopsInfoPosition').append('영업 종료 : <input type="checkbox" checked id="' + storeCheckBoxIds.checkBoxId + '" onclick="openLogic(\'' + a + '\',\'' + nowShop + '\',\'' + storeCheckBoxIds.checkBoxId + '\');"></br>')
        } else {
            $('#myshopsInfoPosition').append('영업 시작 : <input type="checkbox" id="' + storeCheckBoxIds.checkBoxId + '" onclick="openLogic(\'' + a + '\',\'' + nowShop + '\',\'' + storeCheckBoxIds.checkBoxId + '\');"></br>')
        }


        function openLogic(id, shopName, htmlId) {
            let checked = document.getElementById(eval("id")).checked;
            let openShop = new Object();
            openShop.shopName = shopName;
            openShop.isOpen = checked;
            openShop.htmlId = htmlId - 1;

            $.ajax({
                type: "get",
                url: "/SellerPage/openCloseFunc",
                data: openShop,
                success: function (result) {
                    if (result == 1) {
                        if (checked) {
                            alert(shopName + " 가게 영업 시작")
                        } else {
                            alert(shopName + " 가게 영업 종료")
                        }
                    } else {
                        alert("가게 열고 닫기 실패")
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("통신 실패.")
                }
            });
        }

        function goThisStoreInfo(shopName, htmlId){
            const number = htmlId-1;
            const newWindow = window.open("about:blank");
            newWindow.location.href = "/SellerPage/goMyShopInfo/?shopName="+shopName+"&&htmlId="+number;
        }
    }
}

function saveStore(){
    const newWindow = window.open("about:blank");
    const htmlnumber = storeCheckBoxIds.checkBoxId;
    newWindow.location.href = "SellerPage/saveStoreRequest/?htmlnumber="+htmlnumber;
}