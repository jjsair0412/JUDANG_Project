package hello.JuDang.JUDANG.Service.ShopRegister;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public class ShopRegisterImpl implements ShopRegister{
    @Override
    public int shopRegister(Shop shop) {
        return 0;
    }

    @Override
    public Optional<Shop> findAllShop() {
        return Optional.empty();
    }

    @Override
    public Shop findByName(String name) {
        return null;
    }

    @Override
    public Shop findByCategory(String category) {
        return null;
    }

    @Override
    public int modifyShop(Shop shop) {
        return 0;
    }

    @Override
    public int deleteShop(Shop shop) {
        return 0;
    }
}
