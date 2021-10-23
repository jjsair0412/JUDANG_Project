package hello.JuDang.JUDANG.Repository.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface SellerShopInfo {
    List<Shop> getAllMyShops(String sellerId);
}
