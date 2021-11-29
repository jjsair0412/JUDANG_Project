package hello.JuDang.JUDANG.Service.Reservation;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.GetMyShopInfo.SellerShopInfo;
import hello.JuDang.JUDANG.Service.Shop.ShopService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceImplTest {
    @Autowired
    ReservationService reservationService;

    @Autowired
    ShopService shopService;

    @Autowired
    SellerShopInfo sellerShopInfo;

    @Test
    @Rollback
    @Transactional
    void 좌석배정테스트() throws Exception {
        Reservation reservation = getReservation();
        String result = reservationService.makeReservation(reservation);
        Assertions.assertThat(result).isEqualTo("6인 완료");

    }

    @Test
    @Rollback
    @Transactional
    void 만석테스트() throws Exception {
        Reservation reservation = getReservation();
        String result = reservationService.makeReservation(reservation);
        Assertions.assertThat(result).isEqualTo("4인 대기");

    }


    Reservation getReservation(){
        Reservation reservation = new Reservation();
        reservation.setShopNum(181);
        reservation.setShopName("첫번째");
        reservation.setBuyerId("kkk");
        reservation.setBuyerName("준범");
        reservation.setNumberOfPeople(4);
        reservation.setPhoneNumber("1234567");
        return reservation;
    }



}