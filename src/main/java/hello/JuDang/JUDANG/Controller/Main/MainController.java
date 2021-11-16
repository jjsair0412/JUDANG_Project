package hello.JuDang.JUDANG.Controller.Main;

import hello.JuDang.JUDANG.Controller.ControllerDomain.LoginForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {
    private final LoginService loginService;

    @GetMapping
    public String mainPage(){
        return "_main/main";
    }

    @PostMapping("/StartLogin")
    @ResponseBody
    public String StartLogin(LoginForm loginForm,
                             HttpServletRequest request,
                             Model model){
        Member member = new Member();
        member.setId(loginForm.getId());
        member.setPassword(loginForm.getPassword());
        HttpSession session = request.getSession();
        Member loginMember = loginService.login(member);
        model.addAttribute("loginMember",loginMember);
        session.setAttribute("loginMember",loginMember.getId());
        session.setAttribute("loginPassword",loginMember.getPassword()); // ...
        if (loginMember.getUserType().equals(UserType.BUYER)) {
            return "buyer";
        } else if (loginMember.getUserType().equals(UserType.SELLER)) {
            return "seller";
        }else
            return "fail";
    }
}
