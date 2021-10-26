package hello.JuDang.JUDANG.Service.Seller.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface MenuManageService {
    int addMenu(Menu menu,String sellerId);
    Optional<List<Menu>> findAllMenu(String sellerId);
    int menuModify(Shop shop);
    int menuDelete(Shop shop);
}
