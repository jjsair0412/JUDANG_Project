package hello.JuDang.JUDANG.Controller.Main;

import hello.JuDang.JUDANG.Controller.ControllerDomain.LoginForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Login.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String StartLogin(@Validated @ModelAttribute LoginForm loginForm,BindingResult bindingResult,
                             HttpServletRequest request){
        Member member = new Member();
        member.setId(loginForm.getId());
        member.setPassword(loginForm.getPassword());
        HttpSession session = request.getSession();
        Member loginMember = loginService.login(member);
        session.setAttribute("loginMemberName",loginMember.getName());
        session.setAttribute("loginMember",loginMember.getId());
        session.setAttribute("loginPassword",loginMember.getPassword()); // ...최신화실험 2
        if (loginMember.getUserType().equals(UserType.BUYER)) {
            return "buyer";
        } else if (loginMember.getUserType().equals(UserType.SELLER)) {
            return "seller";
        }else
            return "fail";
    }
}
