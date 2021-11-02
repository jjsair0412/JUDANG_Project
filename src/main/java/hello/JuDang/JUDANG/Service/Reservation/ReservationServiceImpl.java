package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.ConfigFiles.WebSocket.SocketHandler;
import hello.JuDang.JUDANG.Controller.ControllerDomain.ReservationForm;
import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.Seller.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ShopRepository shopRepository;
    private final ReservationRepository reservationRepository;
    private final SocketHandler socketHandler;

    @Override
    public int makeReservation(Reservation reservation) throws Exception {
        int reserveResult = reservationRepository.insert(reservation); // 예약
        socketHandler.shopReservationFind(reservationRepository.selectStoreReservation(reservation)); // 예약결과 뿌려줌
        return reserveResult;
    }

    @Override
    public int acceptReservation(Reservation reservation) {
        Shop shop = shopRepository.findById(reservation.getShopNum());
        if(shop.getLeftSeat()<reservation.getNumberOfPeople()){
            return 0;
        } else{
        updateShopSeat(reservation, shop);
        return reservationRepository.update(reservation);
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

}

