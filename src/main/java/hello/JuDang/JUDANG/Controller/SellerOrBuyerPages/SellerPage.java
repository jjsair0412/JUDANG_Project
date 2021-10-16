package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Controller.ControllerDomain.coordinateForm;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Seller.ShopRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    private final ShopRegisterService ShopService;
    
    @GetMapping
    public String goSellerPage(@SessionAttribute(name = "loginMember",required = false) String id){
        if(id==null){ // 판매자인지 아닌지 체크로직 삽입 필요
            return "_main/main";
        }
        return "seller_main/seller_main";
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public int myGetMyPosition(@SessionAttribute(name = "loginMember",required = false) String id ,
                               ShopForm shopForm){


        Shop shop = new Shop();
        BigDecimal Latitude = new BigDecimal(shopForm.getLatitude());
        BigDecimal Longitude = new BigDecimal(shopForm.getLongitude());

        Long long_Latitude = new Long(Latitude.longValue());
        Long long_Longitude = new Long(Longitude.longValue());

        shop.setCategory(shopForm.getCategory());
        shop.setSellerId(id);
        shop.setShopName(shopForm.getShopName());
        shop.setLatitude(long_Latitude);
        shop.setLongitude(long_Longitude);

        log.info("판매자 위도 ={}",shopForm.getLatitude());
        log.info("판매자 경도 ={}",shopForm.getLongitude());
        return ShopService.shopRegister(shop);
    }
}
