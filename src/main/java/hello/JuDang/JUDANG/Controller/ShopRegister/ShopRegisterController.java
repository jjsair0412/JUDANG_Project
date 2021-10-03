package hello.JuDang.JUDANG.Controller.ShopRegister;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.ShopRegister.ShopRegister;
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
    private final ShopRegister shopRegister;

    @GetMapping("")
    public String createRegister(Model model){
        model.addAttribute("shopForm",new ShopForm());
        return "";
    }
    @PostMapping("")
    public String shopRegister(ShopForm form, HttpSession session){
        Shop shop = new Shop();
        shop.setSellerId(session.getId()); //로그인 중인 아이디 가져오기
        shop.setShopName(form.getShopName());
        shop.setTotalSeat(form.getTotalSeat());
        shop.setCategory(form.getCategory());
        shop.setLatitude(form.getLatitude());
        shop.setLongitude(form.getLongitude());
        int result = shopRegister.shopRegister(shop);
        if(result==0){
            return "";
        }else return "";
    }
}