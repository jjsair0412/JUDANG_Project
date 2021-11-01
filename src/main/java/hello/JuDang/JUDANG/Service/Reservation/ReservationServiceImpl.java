package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.ConfigFiles.WebSocket.SocketHandler;
import hello.JuDang.JUDANG.Controller.ControllerDomain.ReservationForm;
import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Service.Seller.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ShopService shopService;
    private final ReservationRepository reservationRepository;
    private final SocketHandler socketHandler;

    @Override
    public int makeReservation(ReservationForm reservationForm) throws Exception {
        Reservation reservation = new Reservation();

        reservation.setBuyerId(reservationForm.getBuyerId());
        reservation.setBuyerName(reservationForm.getBuyerName());
        reservation.setShopName(reservationForm.getShopName());
        reservation.setShopId(reservationForm.getShopId());
        reservation.setNumberOfPeople(Integer.parseInt(reservationForm.getNumberOfPeople()));
        reservation.setPhoneNumber(reservationForm.getPhoneNumber());

        int reserveResult = reservationRepository.insert(reservation); // 예약
        socketHandler.shopReservationFind(reservationRepository.selectStoreReservation(reservation)); // 예약결과 뿌려줌
        return reserveResult;
    }

    @Override
    public int acceptReservation(Reservation reservation) {

        return reservationRepository.update(reservation);
    }

    @Override
    public List<Reservation> selectAllReservation(Reservation reservation) {
        return null;
    }
}
