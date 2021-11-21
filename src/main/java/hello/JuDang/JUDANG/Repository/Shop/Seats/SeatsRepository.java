package hello.JuDang.JUDANG.Repository.Shop.Seats;

import hello.JuDang.JUDANG.Domain.Seats;

public interface SeatsRepository {
    int save(Seats seats);
    Seats select(int shopNum);
    int update(Seats seats);
}
