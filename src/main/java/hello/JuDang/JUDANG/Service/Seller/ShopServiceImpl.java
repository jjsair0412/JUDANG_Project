package hello.JuDang.JUDANG.Service.Seller;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Override
    public int shopRegister(Shop shop) {
        int result = shopRepository.save(shop);
        return result;
    }

    @Override
    public List<Shop> findAllShop() {
        return shopRepository.findAllShop();
    }

    @Override
    public List<Shop> findNearShop(long lat, long lon) {
        return shopRepository.findNearShop(lat, lon);
    }

    @Override
    public Optional<List<Shop>> findByName(String name) {
        List<Shop> shopList = shopRepository.findByName(name);
        Optional<List<Shop>> shops = Optional.ofNullable(shopList);
        if(shops.isPresent()){
            return shops;
        }else return null;
    }

    @Override
    public Optional<List<Shop>> findByCategory(String category) {
        List<Shop> shopList = shopRepository.findByCategory(category);
        Optional<List<Shop>> shops = Optional.ofNullable(shopList);

        if(shops.isPresent()){
            return shops;
        }else return null;
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
