package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationForm {
    private int shopNum;
    private String buyerId;
    private String buyerName;
    private String numberOfPeople;
    private String phoneNumber;
    private String shopName;
}
