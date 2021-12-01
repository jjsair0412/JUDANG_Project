package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Repository.Shop.Seats.SeatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckLeftSeats {

    public String check(Seats selectShop,String seatsType){
        int leftTwo = selectShop.getTwoSeats() - selectShop.getSitTwoSeats();
        int leftFour = selectShop.getFourSeats() - selectShop.getSitFourSeats();
        int leftSix = selectShop.getSixSeats() - selectShop.getSitSixSeats();
        int leftEight = selectShop.getEightSeats() - selectShop.getSitEightSeats();

        switch (seatsType){
            case "8인 이상":
                return "8인 이상";
            case "2인":
                if(leftTwo<1){
                    log.info("남은 자리 없음");
                    return "대기";
                }else{
                    log.info("2인 테이블");
                    return "2인";
                }
            case "4인":
                if(leftFour<1){
                    log.info("남은 자리 없음");
                    return "대기";
                }else{
                    log.info("4인 테이블");
                    return "4인";
                }
            case "6인":
                if(leftSix<1){
                    log.info("남은 자리 없음");
                    return "대기";
                }else{
                    log.info("6인 테이블");
                    return "6인";
                }
            case "8인":
                if(leftEight<1){
                    log.info("남은 자리 없음");
                    return "대기";
                }else{
                    log.info("8인 테이블");
                    return "6인";
                }
            default:
                log.info("");
                return "";
        }
    }
}
