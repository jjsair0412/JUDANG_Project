package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Repository.Shop.Seats.SeatsRepository;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ShopRepository shopRepository;
    private final ReservationRepository reservationRepository;
    private final SeatsRepository seatsRepository;

    @Override
    public int makeReservation(Reservation reservation) throws Exception {
        Seats selectShop = seatsRepository.select(reservation.getShopNum());
        int leftTwo = selectShop.getTwoSeats() - selectShop.getSitTwoSeats();
        int leftFour = selectShop.getFourSeats() - selectShop.getSitFourSeats();
        int leftSix = selectShop.getSixSeats() - selectShop.getSitSixSeats();
        int leftEight = selectShop.getEightSeats() - selectShop.getSitEightSeats();

        int numberOfPeople = reservation.getNumberOfPeople();
        checkSeatsType(numberOfPeople);
        return 0;

    }



    @Override
    public int acceptReservation(Reservation reservation) {
        Shop shop = shopRepository.findById(reservation.getShopNum());
        if(shop.getLeftSeat()<reservation.getNumberOfPeople()){
            return 0;
        } else{
        updateShopSeat(reservation, shop);
        return reservationRepository.statusUpdate(reservation);
        }
    }

    @Override
    public List<Reservation> selectAllReservation(Reservation reservation) {
        return null;
    }

    private void updateShopSeat(Reservation reservation, Shop shop) {
        int addReservationSeat = shop.getCurrentSeat() + reservation.getNumberOfPeople();
        int leftSeat = shop.getTotalSeat() - addReservationSeat;
        shop.setCurrentSeat(addReservationSeat);
        shop.setLeftSeat(leftSeat);
        shopRepository.update(shop);
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

