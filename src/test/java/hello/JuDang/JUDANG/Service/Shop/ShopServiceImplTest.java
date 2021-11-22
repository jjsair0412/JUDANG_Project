package hello.JuDang.JUDANG.Service.Shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
class ShopServiceImplTest {
    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;


    @Test
    @Rollback
    @Transactional
    void 가게등록() {
        ShopForm shopForm = new ShopForm();
        shopForm.setHtmlId("1");
        shopForm.setSellerId("jjsjjsair");
        shopForm.setCategory("이자카야");
        shopForm.setShopName("주진성가게");
        shopForm.setCurrentSeat(100);
        shopForm.setLatitude(34.123123);
        shopForm.setLongitude(128.123123);
        shopForm.setOpen(true);

        shopForm.setBusinessHours("10~21");
        shopForm.setPhoneNumber("02-1234-1234");
        shopForm.setShopNum(10);
        shopForm.setTwoSeats(13);
        shopForm.setFourSeats(20);
        shopForm.setSixSeats(30);
        shopForm.setEightSeats(1);

        int i = shopService.shopRegister(shopForm, shopForm.getSellerId());
        assertThat(i).isEqualTo(1);

    }


}