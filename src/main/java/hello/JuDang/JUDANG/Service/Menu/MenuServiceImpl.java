package hello.JuDang.JUDANG.Service.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    @Override
    public int addMenu(Menu menu, int shopNum) {
        return menuRepository.save(menu,shopNum);
    }

    @Override
    public List<Menu> findAllMenu(int shopNum) {
        List<Menu> allMenu = menuRepository.findAllMenu(shopNum);
        return allMenu;
    }

    @Override
    public int menuModify(Shop shop, String MenuName) {
        Menu menu = new Menu();
        menu.setMenuName(MenuName);
        return menuRepository.updateMenuName(shop,menu);
    }

    @Override
    public int menuPriceModify(Shop shop, int MenuPrice) {
        Menu menu = new Menu();
        menu.setPrice(MenuPrice);
        return menuRepository.updatePrice(menu,shop);
    }

    @Override
    public int menuDelete(int shopNum, int MenuNum) {
        Shop shop= new Shop();
        shop.setShopNum(shopNum);

        Menu menu = new Menu();
        menu.setMenuNum(MenuNum);

        return menuRepository.delete(shop,menu);
    }
}
