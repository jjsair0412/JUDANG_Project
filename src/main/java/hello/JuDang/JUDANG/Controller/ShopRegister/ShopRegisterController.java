package hello.JuDang.JUDANG.Controller.ShopRegister;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Repository.shop.ShopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopRegister")
public class ShopRegisterController {
    private ShopRepository shopRepository;

    @GetMapping("")
    public String createRegister(Model model){
        model.addAttribute("shopForm",new ShopForm());
        return "";
    }
    @PostMapping("")
    public String shopRegister(ShopForm form){

        return "";
    }
}
