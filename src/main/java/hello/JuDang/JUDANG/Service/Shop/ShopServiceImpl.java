package hello.JuDang.JUDANG.Service.Shop;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.Seats.SeatsRepository;
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
    private final SeatsRepository seatsRepository;

    @Override
    public int shopRegister(ShopForm shopForm, String id) {
        Shop shop = new Shop();
        Seats seats = new Seats();
        shop.setBusinessHours(shopForm.getBusinessHours());
        shop.setPhoneNumber(shopForm.getPhoneNumber());
        shop.setHtmlId(shopForm.getHtmlId());
        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(id);
        shop.setShopName(shopForm.getShopName());
        shop.setLatitude(shopForm.getLatitude());
        shop.setLongitude(shopForm.getLongitude());
        shop.setOpen(false);


        seats.setShopNum(shopForm.getShopNum());
        seats.setTwoSeats(shopForm.getTwoSeats());
        seats.setFourSeats(shopForm.getFourSeats());
        seats.setSixSeats(shopForm.getSixSeats());
        seats.setEightSeats(shopForm.getEightSeats());


        int save = shopRepository.save(shop);

        Shop byHtmlId = shopRepository.findByHtmlId(shopForm.getHtmlId());
        int result = MakeShopSaveResult(byHtmlId, seats);

        return save == 1 && result ==1 ? 1 : 0;
    }

    private int MakeShopSaveResult(Shop byHtmlId, Seats seats){
        return seatsRepository.save(seats, byHtmlId.getShopNum());
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