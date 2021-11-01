package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Shop {
    private int shopNum;
    private String sellerId;
    private String shopName;
    private String category;
    private int totalSeat;
    private int currentSeat;
    private int leftSeat;
    private String latitude;
    private String longitude;
    private boolean open;
    private String htmlId;
}
