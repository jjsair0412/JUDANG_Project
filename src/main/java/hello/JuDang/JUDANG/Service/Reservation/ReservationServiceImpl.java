package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Domain.Waiting;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Repository.Reservation.Waiting.WaitingRepository;
import hello.JuDang.JUDANG.Repository.Shop.Seats.SeatsRepository;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final SeatsRepository seatsRepository;
    private final WaitingRepository waitingRepository;
    private final CheckLeftSeats checkLeftSeats;
    private final CheckSeatsType checkSeatsType;

    @Override
    public String makeReservation(Reservation reservation) throws Exception {
        Seats selectShop = seatsRepository.select(reservation.getShopNum());
        int numberOfPeople = reservation.getNumberOfPeople();

        String seatsType = checkSeatsType.check(numberOfPeople);
        String allottedSeats = checkLeftSeats.check(selectShop, seatsType);
        log.info("allottedSeats={}, satsType={}",allottedSeats,seatsType);

        if(allottedSeats.equals("대기")){
            Waiting waiting = getWaiting(reservation);
            waiting.setReservationSeats(allottedSeats);
            int result = waitingRepository.insert(waiting);
            log.info("waiting result = {}",result);
        }else{
            reservation.setReservationSeats(allottedSeats);
            int result = reservationRepository.insert(reservation);
            log.info("reservation result = {}",result);
        }
        return allottedSeats;
    }

    @Override
    public int acceptReservation(Reservation reservation) {
        Reservation selectReservation = reservationRepository.select(reservation.getBuyerId());
        Seats selectShop = seatsRepository.select(reservation.getShopNum());
        String allottedSeats = checkLeftSeats.check(selectShop, selectReservation.getReservationSeats());

        int update = reservationRepository.statusUpdate(reservation.getBuyerId());
        if (allottedSeats.equals("대기")){
            log.info("예약 가능한 좌석이 없음");
            return 0;
        }else {
            if (update < 1){
                log.info("예약 수락 실패");
                return 0;
            }else{
                return leftSeatsCount(selectShop, allottedSeats);
            }
        }
    }

    @Override
    public List<Reservation> selectAllReservation(Reservation reservation) {
        return null;
    }


    private Waiting getWaiting(Reservation reservation) {
        Waiting waiting = new Waiting();
        waiting.setShopNum(reservation.getShopNum());
        waiting.setShopName(reservation.getShopName());
        waiting.setBuyerId(reservation.getBuyerId());
        waiting.setBuyerName(reservation.getBuyerName());
        waiting.setNumberOfPeople(reservation.getNumberOfPeople());
        waiting.setPhoneNumber(reservation.getPhoneNumber());
        return waiting;
    }



    private int leftSeatsCount(Seats selectShop, String allottedSeats) {
        String sql;
        switch (allottedSeats){
            case "2인":
                sql="UPDATE seats SET sitTwoSeats=sitTwoSeats+1 WHERE shopNum=?";
                log.info("{}",sql);
                return seatsRepository.updateLeftSeats(selectShop,sql);
            case "4인":
                sql="UPDATE seats SET sitFourSeats=sitFourSeats+1 WHERE shopNum=?";
                log.info("{}",sql);
                return seatsRepository.updateLeftSeats(selectShop,sql);
            case "6인":
                sql="UPDATE seats SET sitSixSeats=sitSixSeats+1 WHERE shopNum=?";
                log.info("{}",sql);
                return seatsRepository.updateLeftSeats(selectShop,sql);
            case "8인":
                sql="UPDATE seats SET sitEightSeats=sitEightSeats+1 WHERE shopNum=?";
                log.info("{}",sql);
                return seatsRepository.updateLeftSeats(selectShop,sql);
            case "8인 이상":
                return 0;
            default:return 0;
        }
    }
}