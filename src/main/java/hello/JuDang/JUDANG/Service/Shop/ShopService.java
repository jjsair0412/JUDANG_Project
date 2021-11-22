package hello.JuDang.JUDANG.Service.Shop;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    int shopRegister(ShopForm shopForm, String id);
    List<Shop> findAllShop();
    List<Shop> searchShop(String searchWord);
    List<Shop> findNearShop(String lat,String lon);
    int modifyShop(Shop shop);
    int deleteShop(Shop shop);

}
