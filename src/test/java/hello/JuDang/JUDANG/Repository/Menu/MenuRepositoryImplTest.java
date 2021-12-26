package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuRepositoryImplTest {

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    MenuRepository menuRepository;

    Shop shop = new Shop();
    Shop shop2 = new Shop();

    @Test
    void 테스트용_가게_등록() {

        shop.setSellerId("Test_ID_SHOP");
        shop.setShopName("Test_SHOP");
        shop.setCategory("Test_Category");
        shop.setLatitude(37.6618728);
        shop.setLongitude(127.0333126);
        shop.setOpen(true);
        shop.setPhoneNumber("010-0000-0000");
        shop.setBusinessHours("Test_21~Test_09");
        shop.setHtmlId(UUID.randomUUID().toString());

        int save = shopRepository.save(shop);
        assertThat(save).isEqualTo(1);
    }

    @Test
    void 두번째_테스트용_가게_등록() {

        shop2.setSellerId("Test_ID_SHOP2");
        shop2.setShopName("Test_SHOP2");
        shop2.setCategory("Test_Category2");
        shop2.setLatitude(37.6618728);
        shop2.setLongitude(127.0333126);
        shop2.setOpen(true);
        shop2.setPhoneNumber("010-0000-0000");
        shop2.setBusinessHours("Test_21~Test_09");
        shop2.setHtmlId(UUID.randomUUID().toString());

        int save = shopRepository.save(shop2);
        assertThat(save).isEqualTo(1);
    }


    @Test
    @Transactional
    @Rollback(value = false)
    void 일번가게_메뉴_등록_테스트() {
        Menu menu = new Menu(); // 183번 가게의 1번 매뉴
        menu.setMenuName("Test_Menu");
        menu.setMenuNum(1);
        menu.setPrice(1000);


        Menu menu2 = new Menu(); // 183번 가게의 2번 매뉴
        menu2.setMenuName("Test_Menu_2");
        menu2.setMenuNum(2);
        menu2.setPrice(2000);


        assertAll(
                () -> assertThat(menuRepository.save(menu, 189)).isEqualTo(1),
                () -> assertThat(menuRepository.save(menu2, 189)).isEqualTo(1)
        );
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 이번가게_메뉴_등록_테스트() {
        Menu menu3 = new Menu(); // 184번 가게의 1번 매뉴
        menu3.setMenuName("Test_Menu_3");
        menu3.setMenuNum(1);
        menu3.setPrice(1300);


        Menu menu4 = new Menu(); // 184번 가게의 2번 매뉴
        menu4.setMenuName("Test_Menu_4");
        menu4.setMenuNum(2);
        menu4.setPrice(53000);

        assertAll(
                () -> assertThat(menuRepository.save(menu3, 190)).isEqualTo(1),
                () -> assertThat(menuRepository.save(menu4, 190)).isEqualTo(1)
        );

    }
}