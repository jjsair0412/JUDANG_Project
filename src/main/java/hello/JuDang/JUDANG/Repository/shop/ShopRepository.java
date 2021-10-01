package hello.JuDang.JUDANG.Repository.shop;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public interface ShopRepository {
    int save(Shop shop);
    Optional<Shop> findAllShop();
    Shop findByName(String name);
    Shop findByCategory(String category);
    int update(Shop shop);
    int delete(Shop shop);
}
