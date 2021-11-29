package hello.JuDang.JUDANG.Repository.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;

import java.util.List;

public interface ReservationRepository {
    int insert(Reservation reservation);
    int statusUpdate(Reservation reservation);
    List<Reservation> select(String buyerId);
    List<Reservation> selectStoreReservation(Reservation reservation);
}
