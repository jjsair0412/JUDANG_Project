package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ShopForm {
    private String sellerId;
    private String shopName;
    private String category;
    private String totalSeat; // 폼에서 넘어오는게 String이라 int에서 String으로 변경
    private int currentSeat;
    private String latitude; // 위도
    private String longitude; // 경도
    private boolean open;
}
