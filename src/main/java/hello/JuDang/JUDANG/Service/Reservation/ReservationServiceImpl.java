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
    private final ShopRepository shopRepository;
    private final ReservationRepository reservationRepository;
    private final SeatsRepository seatsRepository;
    private final WaitingRepository waitingRepository;
    private final CheckLeftSeats checkLeftSeats;
    @Override
    public String makeReservation(Reservation reservation) throws Exception {
        Seats selectShop = seatsRepository.select(reservation.getShopNum());
        int numberOfPeople = reservation.getNumberOfPeople();
        Waiting waiting = new Waiting();
                waiting.setShopNum(reservation.getShopNum());
                waiting.setShopName(reservation.getShopName());
                waiting.setBuyerId(reservation.getBuyerId());
                waiting.setBuyerName(reservation.getBuyerName());
                waiting.setNumberOfPeople(reservation.getNumberOfPeople());
                waiting.setPhoneNumber(reservation.getPhoneNumber());

        int seatsType = checkSeatsType(numberOfPeople);
        String leftSeats = checkLeftSeats.check(selectShop, seatsType);

        if(leftSeats.equals("대기")){
            waitingRepository.insert(waiting);
        }else{
            reservationRepository.insert(reservation);
        }
        return leftSeats;

    }



    @Override
    public int acceptReservation(Reservation reservation) {
        Shop shop = shopRepository.findById(reservation.getShopNum());

        return 0;
    }

    @Override
    public List<Reservation> selectAllReservation(Reservation reservation) {
        return null;
    }


    private int checkSeatsType(int numberOfPeople) {
        if(numberOfPeople <3){
            return 2;
        }else if(numberOfPeople >2 && numberOfPeople <=4){
            return 4;
        }else if (numberOfPeople > 4 && numberOfPeople <=6){
            return 6;
        }else if (numberOfPeople > 6 && numberOfPeople <=8){
            return 8;}
        else return 0;
    }

}

