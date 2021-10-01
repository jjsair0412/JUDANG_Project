package hello.JuDang.JUDANG.Repository.shop;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public class ShopRepositoryImpl implements ShopRepository{
    @Override
    public int save(Shop shop) {
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
    public int update(Shop shop) {
        return 0;
    }

    @Override
    public int delete(Shop shop) {
        return 0;
    }
}
