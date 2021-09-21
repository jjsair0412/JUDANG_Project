package hello.JuDang.JUDANG.Controller.Join;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Service.Join.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @GetMapping
    public String joinForm(){
        return "join/join";
    }

    @PostMapping
    public String join(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());
        member.setAge(form.getAge());

        joinService.memberRegister(member);
        return "redirect:/";
    }



}
