package hello.JuDang.JUDANG.Service.ShopRegister;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.Optional;

public interface ShopRegister {
    int shopRegister(Shop shop);
    Optional<Shop> findAllShop();
    Shop findByName(String name);
    Shop findByCategory(String category);
    int modifyShop(Shop shop);
    int deleteShop(Shop shop);

}
