package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Controller.ControllerDomain.coordinateForm;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    private final ShopRegisterService ShopService;
    
    @GetMapping
    public String goSellerPage(){
        return "seller_main/seller_main";
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(ShopForm shopForm){
        Shop shop = new Shop();
        BigDecimal Latitude = new BigDecimal(shopForm.getLatitude());
        BigDecimal Longitude = new BigDecimal(shopForm.getLongitude());

        Long long_Latitude = new Long(Latitude.longValue());
        Long long_Longitude = new Long(Longitude.longValue());

        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(shopForm.getSellerId());
        shop.setShopName(shopForm.getShopName());
        shop.setLatitude(long_Latitude);
        shop.setLongitude(long_Longitude);

        log.info("판매자 위도 ={}",shopForm.getLatitude()); // 위도경도 둘다 String으로 넘어와서 String으로 프로퍼티객체 변경시켰음
        log.info("판매자 경도 ={}",shopForm.getLongitude());
        return ShopService.shopRegister(shop);
    }
}
