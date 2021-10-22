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
            @SessionAttribute(name = "loginMember", required = false) String id
    ) {
        int i = typeCheck(id);
        if (i == 1) {
            return "seller_main/seller_form";
        } else {
            return "/";
        }
    }

    public int typeCheck(String id) {
        Member member = new Member();
        member.setId(id);
        Member result = typeCheck.checkType(member);
        if (result.getUserType().equals(UserType.SELLER)) {
            return 1;
        } else {
            return 0;
        }
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(
            @SessionAttribute(name = "loginMember", required = false) String id,
                               ShopForm shopForm) {

        Shop shop = new Shop();
        BigDecimal Latitude = new BigDecimal(shopForm.getLatitude());
        BigDecimal Longitude = new BigDecimal(shopForm.getLongitude());

        Long long_Latitude = new Long(Latitude.longValue());
        Long long_Longitude = new Long(Longitude.longValue());

        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(id);
        shop.setShopName(shopForm.getShopName());
        shop.setLatitude(long_Latitude);
        shop.setLongitude(long_Longitude);

        return ShopService.shopRegister(shop);
    }
}
