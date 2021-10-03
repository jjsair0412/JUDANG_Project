package hello.JuDang.JUDANG.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
    private String sellerId;
    private String shopName;
    private String category;
    private int totalSeat;
    private int currentSeat;
    private Long latitude;
    private Long longitude;
    private boolean open;
}
