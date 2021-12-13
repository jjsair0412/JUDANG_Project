package hello.JuDang.JUDANG.Message;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
@Slf4j
public class MessageTest {
    @Autowired
    MessageSource ms;

    @Test
    void 메시지프로퍼티스출력(){
        log.info("{}",ms.getMessage("label.id", null, "메시지 없음",null));
    }
}
