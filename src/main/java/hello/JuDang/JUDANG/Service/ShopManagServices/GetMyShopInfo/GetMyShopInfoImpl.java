package hello.JuDang.JUDANG.Service.ShopManagServices.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.GetMyShopInfo.SellerShopInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetMyShopInfoImpl implements GetMyShopInfo{

    private final SellerShopInfo sellerShopInfo;
    @Override
    public List<Shop> AllmyShops(String sellerId) {
        List<Shop> allMyShops = sellerShopInfo.getAllMyShops(sellerId);
        if(allMyShops.size()==0){
            return null;
        }
        return allMyShops;
    }

    @Override
    public Shop getMyShopInfo(String sellerId, String shopName, String htmlId) {
        List<Shop> myShopInfo = sellerShopInfo.getMyShopInfo(sellerId, shopName, htmlId);
        return  myShopInfo.get(0);
    }
}
