package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Repository.Reservation.ReservationRepository;
import hello.JuDang.JUDANG.Service.Seller.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
    private final ShopService shopService;
    private final ReservationRepository reservationRepository;

    @Override
    public int makeReservation(Reservation reservation) {
        return reservationRepository.insert(reservation);
    }


}
