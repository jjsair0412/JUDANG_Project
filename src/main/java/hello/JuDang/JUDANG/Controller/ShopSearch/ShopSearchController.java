package hello.JuDang.JUDANG.Controller.ShopSearch;

import hello.JuDang.JUDANG.Domain.Customer;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Service.Buyer.Search.ShopSearchService;
import hello.JuDang.JUDANG.Service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/buyerMain")
@RequiredArgsConstructor
public class ShopSearchController {
    private final ShopSearchService shopSearchService;
    private final MemberService memberService;

    @GetMapping
    public String buyerMap(Model model, HttpSession session){
        model.addAttribute("customer",new Customer());
        Member loginMember =(Member) session.getAttribute("loginMember");
        return "";
    }


}
