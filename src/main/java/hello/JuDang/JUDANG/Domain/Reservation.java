package hello.JuDang.JUDANG.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
    private int shopNum; // 가게 ID Auto Increasement
    private String shopName; // 가게 이름
    private String buyerId; // 구매자 ID
    private String buyerName; // 구매자 이름
    private int numberOfPeople; // 예약 인원
    private String reservationSeats; // 예약한 좌석 종류
    private String phoneNumber; // 연락처
    private boolean status; // 예약 수락 여부
    private String time; //예약 시간
}
