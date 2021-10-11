package hello.JuDang.JUDANG.Controller.Join;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {
    private final MemberService memberService;

    @GetMapping
    public String joinForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "join/join";
    }


    @PostMapping
    public String join(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());
        member.setAge(form.getAge());

        //타입 정해주기
        if ("BUYER".equals(form.getTypeBuyer())) {
            member.setUserType(UserType.BUYER);
        }else if ("SELLER".equals(form.getTypeSeller())) {
            member.setUserType(UserType.SELLER);
        }else return null;

        int result = memberService.memberRegister(member);
        if(result==0){
            return "redirect:";
        } return "_main/main";
    }
}