package hello.JuDang.JUDANG.Repository.Shop.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SellerShopInfoImplTest {

    @Autowired
    SellerShopInfo SellerShopInfoImpl;

    @Autowired
    ShopRepository ShopRepo;

    Shop shop1 = new Shop();
    Shop shop2 = new Shop();
    Shop shop3 = new Shop();

    @BeforeEach
    void 테스트_더미값(){
        shop1.setSellerId("one");
        shop1.setShopName("첫번째");
        shop1.setCategory("이자카야");
        shop1.setTotalSeat(100);
        shop1.setCurrentSeat(50);
        shop1.setLatitude("34.123123");
        shop1.setLongitude("127.322323");
        shop1.setHtmlId("0");
        shop1.setOpen(true);

        shop2.setSellerId("two");
        shop2.setShopName("두번째");
        shop2.setCategory("걍술집");
        shop2.setTotalSeat(30);
        shop2.setCurrentSeat(20);
        shop2.setLatitude("30.123123");
        shop2.setLongitude("120.322323");
        shop2.setHtmlId("1");
        shop2.setOpen(false);

        shop3.setSellerId("two");
        shop3.setShopName("세번째");
        shop3.setCategory("ㄹㅇ그냥술집");
        shop3.setTotalSeat(550);
        shop3.setCurrentSeat(10);
        shop3.setLatitude("302.123123");
        shop3.setLongitude("1202.322323");
        shop3.setHtmlId("2");
        shop3.setOpen(true);

        ShopRepo.save(shop1);
        ShopRepo.save(shop2);
        ShopRepo.save(shop3);

    }



    @Test
    void 가게를_한개만_가지고있는경우(){
        List<Shop> one = SellerShopInfoImpl.getAllMyShops("one");
        assertThat(one.size()).isEqualTo(1);

    }

    @Test
    void 가게를_여러개_가지고있는경우(){
        List<Shop> two = SellerShopInfoImpl.getAllMyShops("two");
        assertThat(two.size()).isEqualTo(2);

        Shop firstShop = two.get(0);
        assertThat(firstShop.getShopName()).isEqualTo("두번째");
        Shop twiceShop = two.get(1);
        assertThat(twiceShop.getShopName()).isEqualTo("세번째");
    }

    @Test
    void 내가_선택한_가게정보_가져오기(){
        List<Shop> myShopInfo = SellerShopInfoImpl.getMyShopInfo("two", "두번째", "1");
        for (Shop one:myShopInfo){
            assertThat(one.getTotalSeat()).isEqualTo(30);
            assertThat(one.getLatitude()).isEqualTo("30.123123");
            assertThat(one.getLongitude()).isEqualTo("120.322323");
        }
    }

    @Test
    void 가게가_없을경우(){
        List<Shop> three = SellerShopInfoImpl.getAllMyShops("three");
        assertThat(three.size()).isEqualTo(0);
    }

    @AfterEach
    void 테스트_후_가게삭제(){
        ShopRepo.delete(shop1);
        ShopRepo.delete(shop2);
        ShopRepo.delete(shop3);
    }
}