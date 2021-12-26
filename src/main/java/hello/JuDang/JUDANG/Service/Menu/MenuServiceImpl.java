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
        return 0;
    }

    @Override
    public List<Menu> findAllMenu(int shopNum) {
        List<Menu> allMenu = menuRepository.findAllMenu(shopNum);
        return allMenu;
    }

    @Override
    public int menuModify(Shop shop) {
        return 0;
    }

    @Override
    public int menuDelete(Shop shop) {
        return 0;
    }
}
