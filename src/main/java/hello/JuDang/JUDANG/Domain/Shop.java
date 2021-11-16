package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
    private int shopNum;
    private String sellerId;
    private String shopName;
    private String category;
    private int totalSeat;
    private int currentSeat;
    private int leftSeat;
    private int twoSeats;
    private int fourSeats;
    private int sixSeats;
    private int eightSeats;
    private double latitude;
    private double longitude;
    private boolean open;
    private String phoneNumber;
    private String businessHours;
    private String htmlId;
}
