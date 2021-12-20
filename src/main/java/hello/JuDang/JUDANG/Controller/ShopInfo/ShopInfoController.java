package hello.JuDang.JUDANG.Controller.ShopInfo;

import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.Menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ShopInfo")
public class ShopInfoController {
    private final ShopRepository shopRepository;
    private final MenuService menuService;
    @GetMapping("/{shopNum}")
    public String goShopInfo(@PathVariable("shopNum") int shopNum,
                             Model model,
                             HttpSession session){
        model.addAttribute("shopInfo",shopRepository.findById(shopNum));
        model.addAttribute("shopMenu",menuService.findAllMenu(shopNum));
        session.setAttribute("shopNum",shopNum);
        return "/buyer/shopInfo";
    }


}