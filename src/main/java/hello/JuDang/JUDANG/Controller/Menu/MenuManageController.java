package hello.JuDang.JUDANG.Controller.Menu;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MenuForm;
import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Service.Seller.Menu.MenuManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/menu/editMenu")
public class MenuManageController {
    private final MenuManageService menuManageService;

    @GetMapping
    public String shopMenu(Model model){
        model.addAttribute("menu",new MenuForm());
        return "";
    }

    @PostMapping("/add")
    public String addMenu(MenuForm addMenu, HttpSession session){
        Menu menu = new Menu(addMenu.getMenuName(),addMenu.getPrice());
        int result = menuManageService.addMenu(menu, (String) session.getAttribute("loginMember"));
        if(result<1){
            return "실패";
        }else return "성공";
    }

    @PostMapping("/delete")
    public String deleteMenu(){

        return "";
    }


}
