package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopOpenCloseForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.ShopManagServices.GetMyShopInfo.GetMyShopInfo;
import hello.JuDang.JUDANG.Service.LoginTypeCheck;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import hello.JuDang.JUDANG.Service.ShopManagServices.OpenCloseFunc.OpenCloseFunc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    private final ShopRegisterService ShopService;
    private final LoginTypeCheck typeCheck;
    private final GetMyShopInfo myShops;
    private final OpenCloseFunc openCloseFunc;

    @GetMapping
    public String goSellerPage(
            @SessionAttribute(name = "loginMember", required = false) String id,
            @SessionAttribute(name = "loginPassword", required = false) String password,
            Model model
    ) {
        int i = typeCheck(id, password);
        if (i == 1) {
            model.addAttribute("shop",new Shop());
            model.addAttribute("myShops", myShops.myShops(id));
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

    @GetMapping("/openCloseFunc")
    @ResponseBody
    public int openFunc(
            @SessionAttribute(name = "loginMember",required = false) String id,
            ShopOpenCloseForm openCloseForm
    ){
        return openCloseFunc.OpenCloseFunc(id,openCloseForm.getShopName(),Boolean.parseBoolean(openCloseForm.getIsOpen()));
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(
            @SessionAttribute(name = "loginMember", required = false) String id,
            ShopForm shopForm) {

        Shop shop = new Shop();


        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(id);
        shop.setShopName(shopForm.getShopName());
        shop.setCurrentSeat(0);
        shop.setTotalSeat(Integer.parseInt(shopForm.getTotalSeat()));
        shop.setLatitude(shopForm.getLongitude());
        shop.setLongitude(shopForm.getLatitude());
        shop.setOpen(false);

        return ShopService.shopRegister(shop);
    }

}
