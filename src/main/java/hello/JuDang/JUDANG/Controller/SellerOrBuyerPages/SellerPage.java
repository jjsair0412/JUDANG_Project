package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Controller.ControllerDomain.coordinateForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.LoginTypeCheck;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    private final ShopRegisterService ShopService;
    private final LoginTypeCheck typeCheck;

    @GetMapping
    public String goSellerPage(
            @SessionAttribute(name = "loginMember", required = false) String id,
            @SessionAttribute(name = "loginPassword", required = false) String password
    ) {
        int i = typeCheck(id, password);
        if (i == 1) {
            return "seller_main/seller_form";
        } else {
            return "/";
        }
    }

    public int typeCheck(String id, String password) {
        Member member = new Member();
        member.setId(id);
        member.setPassword(password);
        Member result = typeCheck.checkType(member);
        if (result.getUserType().equals(UserType.SELLER)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 얘 저장은 되는데,
     * 폼에서 받아온 위도=37.6584085
     * 폼에서 받아온 경도=127.0292881
     *
     * 변경후 위도=127
     * 변경후 경도=37
     *
     * 요렇게 long타입으로 캐스팅해주면 소수점날아감..
     * 아예 String으로 받는거 고려 ㄱㄱ
     */

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(
            @SessionAttribute(name = "loginMember", required = false) String id,
            ShopForm shopForm) {

        Shop shop = new Shop();

        long long_Longitude = (long) Double.parseDouble(shopForm.getLongitude());
        long long_Latitude = (long)  Double.parseDouble(shopForm.getLatitude());

        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(id);
        shop.setShopName(shopForm.getShopName());
        shop.setLatitude(long_Latitude);
        shop.setLongitude(long_Longitude);

        shop.setOpen(true); // 얘 DB값이 notnull이라 true로 일단 줘슴

        return ShopService.shopRegister(shop);
    }

}
