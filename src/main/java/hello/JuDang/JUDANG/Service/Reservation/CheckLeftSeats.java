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

    public String check(Seats selectShop,int seatsType){
        int leftTwo = selectShop.getTwoSeats() - selectShop.getSitTwoSeats();
        int leftFour = selectShop.getFourSeats() - selectShop.getSitFourSeats();
        int leftSix = selectShop.getSixSeats() - selectShop.getSitSixSeats();
        int leftEight = selectShop.getEightSeats() - selectShop.getSitEightSeats();

        switch (seatsType){
            case 0:
                return "8인 이상";
            case 2:
                if(leftTwo<1){
                    log.info("남은 자리 없음");
                    return "2인 대기";
                }else{
                    log.info("2인 테이블");
                    return "2인 완료";
                }
            case 4:
                if(leftFour<1){
                    log.info("남은 자리 없음");
                    return "4인 대기";
                }else{
                    log.info("4인 테이블");
                    return "4인 완료";
                }
            case 6:
                if(leftSix<1){
                    log.info("남은 자리 없음");
                    return "6인 대기";
                }else{
                    log.info("6인 테이블");
                    return "6인 완료";
                }
            case 8:
                if(leftEight<1){
                    log.info("남은 자리 없음");
                    return "6인 대기";
                }else{
                    log.info("6인 테이블");
                    return "6인 완료";
                }
            default:
                log.info("");
                return "";
        }
    }
}
