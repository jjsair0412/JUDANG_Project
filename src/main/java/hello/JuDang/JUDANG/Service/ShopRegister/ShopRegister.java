package hello.JuDang.JUDANG.Service.ShopRegister;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRegister {
    int shopRegister(Shop shop);
    List<Shop> findAllShop();
    Optional<List<Shop>> findByName(String name);
    Optional<List<Shop>> findByCategory(String category);
    int modifyShop(Shop shop);
    int deleteShop(Shop shop);

}
