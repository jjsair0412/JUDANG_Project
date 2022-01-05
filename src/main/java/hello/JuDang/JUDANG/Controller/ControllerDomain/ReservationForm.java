package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReservationForm {
    private int shopNum; // 가게 ID

    private String shopName; // 가게 이름

    private String buyerId; // 구매자 ID

    private String buyerName; // 구매자 이름

    private int numberOfPeople; // 예약 인원

    private String phoneNumber; // 연락처

    private boolean status; // 예약 수락 여부

}
