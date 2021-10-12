package hello.JuDang.JUDANG.Controller.ShopRegister;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopRegister")
@RequiredArgsConstructor
public class ShopRegisterController {
    private final ShopRegisterService shopRegister;

    @GetMapping("")
    public String createRegister(Model model){
        model.addAttribute("Shop",new Shop());
        return "";
    }

    @PostMapping("")
    public String shopRegister(Shop shop, HttpSession session){
        Member loginMember =(Member) session.getAttribute("loginMember");
        shop.setSellerId(loginMember.getId());
        int result = shopRegister.shopRegister(shop);
        if(result==0){
            return "";
        }else return "";
    }


}