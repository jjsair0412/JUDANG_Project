package hello.JuDang.JUDANG.Service.ShopManagServices.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface GetMyShopInfo {
    List<Shop> AllmyShops(String sellerId);
    Shop getMyShopInfo(String sellerId, String shopName, String htmlId);
}
