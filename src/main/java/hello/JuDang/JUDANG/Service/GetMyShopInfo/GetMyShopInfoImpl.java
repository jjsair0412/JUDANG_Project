package hello.JuDang.JUDANG.Service.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.GetMyShopInfo.SellerShopInfo;
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
    public List<Shop> myShops(String sellerId) {
        List<Shop> allMyShops = sellerShopInfo.getAllMyShops(sellerId);
        if(allMyShops.size()==0){
            return null;
        }
        return allMyShops;
    }
}
