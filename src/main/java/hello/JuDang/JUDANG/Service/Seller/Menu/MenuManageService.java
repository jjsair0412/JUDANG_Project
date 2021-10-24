package hello.JuDang.JUDANG.Service.Seller.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public interface MenuManageService {
    int addMenu(Menu menu,String sellerId);
    Optional<Menu> findAllShop();
    int menuModify(Shop shop);
    int menuDelete(Shop shop);
}
