package hello.JuDang.JUDANG.Repository.Shop.Seats;

import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;

public interface SeatsRepository {
    int save(Seats seats, int shopNum);
    Seats select(int shopNum);
    int update(Seats seats);
    int delete(Seats seats); // 테스트용 삭제코드
    int insertPK(Shop shop);

}
