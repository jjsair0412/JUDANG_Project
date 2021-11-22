package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ShopForm {
    private int shopNum;// 가게 아이디
    private String sellerId;
    private String shopName;
    private String category;
    private String totalSeat; // 폼에서 넘어오는게 String이라 int에서 String으로 변경
    private int currentSeat;
    private double latitude; // 위도
    private double longitude; // 경도
    private boolean open;
    private String htmlId;

    // 추가정보
    private String businessHours; // 영업시간
    private String phoneNumber; // 가게 전화번호
    private int twoSeats;
    private int fourSeats;
    private int sixSeats;
    private int eightSeats;
}
