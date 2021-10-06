package hello.JuDang.JUDANG.Service.Buyer.Search;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopSearchServiceImpl implements ShopSearchService {
    private final ShopRepository shopRepository;

    @Override
    public Optional<List<Shop>> searchByShopName(String name) {
        Optional<List<Shop>> optionalList = Optional.of(shopRepository.findByName(name));
        return optionalList;
    }

    @Override
    public Optional<List<Shop>> searchByCategory(String category) {
        Optional<List<Shop>> optionalList = Optional.of(shopRepository.findByCategory(category));
        return optionalList;
    }
}
