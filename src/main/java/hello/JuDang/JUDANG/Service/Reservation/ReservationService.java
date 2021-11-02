package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ReservationForm;
import hello.JuDang.JUDANG.Domain.Reservation;

import java.util.List;

public interface ReservationService {
    int makeReservation(Reservation reservation) throws Exception;
    int acceptReservation(Reservation reservation);
    List<Reservation> selectAllReservation(Reservation reservation); // 전체 예약 가져오기
}
