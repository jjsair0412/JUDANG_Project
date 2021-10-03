package hello.JuDang.JUDANG.Service.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuManageServiceImpl implements MenuManageService{
    @Override
    public int save(Shop shop) {
        return 0;
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
