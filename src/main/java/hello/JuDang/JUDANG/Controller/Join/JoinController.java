package hello.JuDang.JUDANG.Controller.Join;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Service.Member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/join")
@RequiredArgsConstructor
public class JoinController {
    private final MemberService memberService;
    private final JoinValidator joinValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(joinValidator);
    }

    @GetMapping
    public String joinForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "join/join";
    }

    @PostMapping
    public String join(@Validated @ModelAttribute MemberForm form) {
        int result = memberService.memberRegister(form);
        if(result==0){ // 회원가입 실패 페이지 필요할듯 ?
            return "redirect:";
        }else{
            return "join.commit/join.successful";
        }
    }
}