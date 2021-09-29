package hello.JuDang.JUDANG.Controller.login;

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
    public String login(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        Member loginMember = loginService.login(member);
        if (loginMember.getUserType().equals(UserType.BUYER)) {
            return "";
        } else if (loginMember.getUserType().equals(UserType.SELLER)) {
            return "";
        }else return "/redirect:";

    }
}