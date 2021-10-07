package hello.JuDang.JUDANG.Controller.MemberModify;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/memberModify")
@RequiredArgsConstructor
public class MemberModifyController {
    private final MemberService memberService;
    @GetMapping
    public String createMemberModify(Model model){
        model.addAttribute("modifyMember",new MemberForm());
        return "";
    }

    @PostMapping
    public String memberModify(MemberForm form, HttpSession session){
        Member loginMember = (Member)session.getAttribute("loginMember");
        loginMember.setPassword(form.getPassword());

        int result = memberService.memberModify(loginMember);
        if (result==0){
            return "redirect:";
        }
        return "";
    }
}
