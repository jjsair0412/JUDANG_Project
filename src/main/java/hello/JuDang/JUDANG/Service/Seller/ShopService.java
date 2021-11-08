package hello.JuDang.JUDANG.Service.Seller;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    int shopRegister(Shop shop);
    List<Shop> findAllShop();
    List<Shop> findByName(String name);
    List<Shop> findByCategory(String category);
    List<Shop> findNearShop(String lat,String lon);
    int modifyShop(Shop shop);
    int deleteShop(Shop shop);

}
