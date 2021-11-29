package hello.JuDang.JUDANG.Controller.WebSocketController;

import hello.JuDang.JUDANG.Controller.ControllerDomain.Greeting;
import hello.JuDang.JUDANG.Controller.ControllerDomain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(500); // simulated delay 메시지 받으면 sendto해서 보내줌
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
