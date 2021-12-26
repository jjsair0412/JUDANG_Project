package hello.JuDang.JUDANG.Service.Menu;


import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface MenuService {
    int addMenu(Menu menu,int shopNum);
    List<Menu> findAllMenu(int shopNum);
    int menuModify(Shop shop, String MenuName);
    int menuPriceModify(Shop shop, int MenuPrice);
    int menuDelete(int shopNum, int MenuNum);
}
