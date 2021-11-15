package hello.JuDang.JUDANG.Service.Shop;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.SerachFunc.CheckResultSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final CheckResultSearch checkResultSearch;

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
    public List<Shop> searchShop(String searchWord) {
        List<Shop> shops = checkResultSearch.SearchFunc(searchWord);
        return shops;
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