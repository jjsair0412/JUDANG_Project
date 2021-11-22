package hello.JuDang.JUDANG.Repository.Shop.Seats;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.JuDang.JUDANG.Domain.Seats;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
class SeatsRepositoryImplTest {

    @Autowired
    SeatsRepository seatsRepository;

    Seats one = new Seats();

    @BeforeEach
    void 좌석정보저장(){
        one.setShopNum(1);
        one.setTwoSeats(0);
        one.setFourSeats(8);
        one.setSixSeats(7);
        one.setEightSeats(1);
        int save = seatsRepository.save(one);
        assertThat(save).isEqualTo(1);
    }

    @Test
    void 좌석정보삭제(){
        assertThat(seatsRepository.delete(one)).isEqualTo(1);
    }

    @Test
    @Transactional
    void 가게정보있을때(){
        Seats result = seatsRepository.select(one.getShopNum());
        assertThat(result.getShopNum()).isEqualTo(one.getShopNum());
        assertThat(result.getSixSeats()).isEqualTo(one.getSixSeats());
    }

    @Test
    @Transactional
    void 가게정보없을때(){
        Seats result = seatsRepository.select(9);
        assertThat(result).isEqualTo(null);
    }

}