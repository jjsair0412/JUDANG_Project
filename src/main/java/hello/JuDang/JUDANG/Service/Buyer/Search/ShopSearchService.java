package hello.JuDang.JUDANG.Service.Buyer.Search;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopSearchService {
    Optional<List<Shop>> searchByShopName(String name);
    Optional<List<Shop>> searchByCategory(String category);

}
