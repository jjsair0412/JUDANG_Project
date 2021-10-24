package hello.JuDang.JUDANG.Service.ShopManagServices.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GetMyShopInfoImplTest {

    @Autowired
    GetMyShopInfo shopInfoService;

    @Test
    void 가게가_없을경우_로직체크(){
        List<Shop> nostore = shopInfoService.myShops("난가게없다");
        assertThat(nostore).isEqualTo(null);
    }
}