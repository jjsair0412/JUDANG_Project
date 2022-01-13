package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ReservationForm {
    @NotNull
    private int shopNum; // 가게 ID

    @NotEmpty
    private String shopName; // 가게 이름

    @NotEmpty
    private String buyerId; // 구매자 ID

    @NotEmpty
    private String buyerName; // 구매자 이름

    @NotNull
    private int numberOfPeople; // 예약 인원

    @NotBlank
    private String phoneNumber; // 연락처

    private boolean status; // 예약 수락 여부

    public ReservationForm() {
    }

    public ReservationForm(int shopNum, String shopName, String buyerId, String buyerName) {
        this.shopNum = shopNum;
        this.shopName = shopName;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
    }

}
