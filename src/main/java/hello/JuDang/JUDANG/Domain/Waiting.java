package hello.JuDang.JUDANG.Domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Waiting {
    private int shopNum; // 가게 ID Auto Increasement
    private String shopName; // 가게 이름
    private String buyerId; // 구매자 ID
    private String buyerName; // 구매자 이름
    private int numberOfPeople; // 예약 인원
    private String phoneNumber; // 연락처
    private boolean status; // 예약 수락 여부

}
