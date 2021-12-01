package hello.JuDang.JUDANG.Controller.MemberManage;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/Member")
@RequiredArgsConstructor
public class MemberManageController {
    private final MemberService memberService;

    @GetMapping("/myInfo")
    public String createMemberInfo(){
        return "MemberManage/myInfo";
    }

    @PostMapping("/update")
    public String memberModify(Model model,
                               MemberForm form,
                               @SessionAttribute(name="loginMember",required = false)String loginId,
                               @SessionAttribute(name="loginPassword",required = false)String loginPassword){
        Member member =(Member) model.getAttribute("member");
        member.setPassword(form.getPassword());
        int result = memberService.memberModify(member);
        if (result==0){
            return "redirect:";
        }
        return "";
    }

    @GetMapping("delete")
    public String deleteMember(Model model,
                               HttpSession session){
        Member member =(Member) model.getAttribute("member");
        int result = memberService.memberDelete(member);
        if (result == 0){
            return "redirect:";
        }else {
            session.removeAttribute("loginMember");
            session.removeAttribute("loginPassword");
            return "redirect:_main/main";
        }
    }
}
