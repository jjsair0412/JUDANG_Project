package hello.JuDang.JUDANG.Service.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public interface MenuManageService {
    int save(Shop shop);
    Optional<Menu> findAllShop();
    int menuModify(Shop shop);
    int menuDelete(Shop shop);
}
