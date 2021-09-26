package hello.JuDang.JUDANG.Controller.Main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping
    public String mainPage(){
        return "_main/main";
    }
}
