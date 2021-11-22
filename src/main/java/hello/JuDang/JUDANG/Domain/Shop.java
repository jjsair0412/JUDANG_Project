package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
    private int shopNum;// 가게 아이디
    private String sellerId;
    private String shopName;
    private String category;
    private double latitude;
    private double longitude;
    private boolean open;
    private String phoneNumber; // 가게 전화번호
    private String businessHours;
    private String htmlId;
}
