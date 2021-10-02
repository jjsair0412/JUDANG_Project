package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public interface MenuManageRepository {
    int save(Menu menu);
    Optional<Menu> findAllMenu(Shop shop);
    int update(Shop shop,Menu menu);
    int delete(Shop shop);
}
