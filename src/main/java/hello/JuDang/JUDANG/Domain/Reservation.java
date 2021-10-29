package hello.JuDang.JUDANG.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
    private String shopId;
    private String buyerId;
    private String buyerName;
    private int numberOfPeople;
    private String phoneNumber;
}
