package hello.JuDang.JUDANG.Service.Seller.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Menu.MenuManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuManageServiceImpl implements MenuManageService{
    private final MenuManageRepository menuManageRepository;

    @Override
    public int addMenu(Menu menu, String sellerId) {
        int result = menuManageRepository.save(menu,sellerId);
        return result;
    }

    @Override
    public Optional<Menu> findAllShop() {
        return Optional.empty();
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
