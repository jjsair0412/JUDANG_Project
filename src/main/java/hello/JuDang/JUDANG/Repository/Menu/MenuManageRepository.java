package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface MenuManageRepository {
    int save(Menu menu,String sellerId);
    List<Menu> findAllMenu(String sellerId);
    int update(Shop shop,Menu menu);
    int delete(Shop shop);
}
