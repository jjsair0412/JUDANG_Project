package hello.JuDang.JUDANG.Controller.Login;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
@Controller
public class loginController {

    private final LoginService loginService;

    @GetMapping
    public String createLogin(){
        return "login/login";
    }

    @PostMapping
    public String login(MemberForm form, HttpSession session) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        Member loginMember = loginService.login(member);
        session.setAttribute("loginMember",loginMember);
        if (loginMember.getUserType().equals(UserType.BUYER)) {
            return "BUYERPAGE";
        } else if (loginMember.getUserType().equals(UserType.SELLER)) {
            return "seller_main/seller_main";
        }else return "/redirect:";
    }
}
