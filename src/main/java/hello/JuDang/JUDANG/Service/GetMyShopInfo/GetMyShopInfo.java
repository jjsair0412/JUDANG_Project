package hello.JuDang.JUDANG.Service.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface GetMyShopInfo {
    List<Shop> myShops(String sellerId);
}
