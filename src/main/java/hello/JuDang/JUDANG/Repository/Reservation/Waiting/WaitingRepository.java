package hello.JuDang.JUDANG.Repository.Reservation.Waiting;


import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Waiting;

import java.util.List;

public interface WaitingRepository {
    int insert(Waiting waiting);
    int statusUpdate(Waiting waiting);
    List<Waiting> select(String buyerId);
    int delete(String buyerId);

}
