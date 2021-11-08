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
    public List<Shop> findNearShop(String lat, String lon) {
        return shopRepository.findNearShop(lat, lon);
    }

    @Override
    public List<Shop> findByName(String name) {
        return shopRepository.findByName(name);

    }

    @Override
    public List<Shop> findByCategory(String category) {
        return shopRepository.findByCategory(category);
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
