package hello.JuDang.JUDANG.Repository.Shop;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {
    int save(Shop shop);
    List<Shop> findAllShop();
    List<Shop> findByName(String name);
    List<Shop> findByCategory(String category);
    Shop findById(int shopNum);
    int update(Shop shop);
    int delete(Shop shop);
}
