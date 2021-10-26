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

import java.util.List;

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
        if (i == 1) { // 판매자일 경우
            model.addAttribute("shop",new Shop());
            if(myShops.AllmyShops(id) == null){ // 가게를 하나도 갖고있지 않다면
                return "seller_main/seller_form";
            }else{ // 한개라도 가게가 있다면
                List<Shop> shops = myShops.AllmyShops(id);
                for (Shop firstShop :shops){
                    model.addAttribute("firstShopName",firstShop.getShopName());
                    model.addAttribute("allSeat",firstShop.getTotalSeat());
                }
                model.addAttribute("myShops", shops);
                return "seller_main/seller_store";
            }
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
        return openCloseFunc.OpenCloseFunc(
                id,
                openCloseForm.getShopName(),
                openCloseForm.getHtmlId(),
                Boolean.parseBoolean(openCloseForm.getIsOpen())
        );
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(
            @SessionAttribute(name = "loginMember", required = false) String id,
            ShopForm shopForm) {

        Shop shop = new Shop();

        shop.setHtmlId(shopForm.getHtmlId());
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

    @GetMapping("/goMyShopInfo")
    public String goThisStore(@RequestParam(value = "shopName") String shopName){

    }

}
