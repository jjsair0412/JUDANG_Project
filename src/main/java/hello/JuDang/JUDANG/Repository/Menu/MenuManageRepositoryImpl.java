package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public class MenuManageRepositoryImpl implements MenuManageRepository{
    @Override
    public int save(Menu menu) {
        return 0;
    }

    @Override
    public Optional<Menu> findAllMenu(Shop shop) {
        return Optional.empty();
    }

    @Override
    public int update(Shop shop, Menu menu) {
        return 0;
    }

    @Override
    public int delete(Shop shop) {
        return 0;
    }
}
