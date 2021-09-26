package hello.JuDang.JUDANG.Controller.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
@Controller
public class loginController {

    @GetMapping
    public String login(){
        return "login/login";
    }
}
