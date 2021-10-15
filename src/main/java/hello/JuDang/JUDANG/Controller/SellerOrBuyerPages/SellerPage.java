package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ShopForm;
import hello.JuDang.JUDANG.Controller.ControllerDomain.coordinateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    
    @GetMapping
    public String goSellerPage(){
        return "seller_main/seller_main";
    }

    @PostMapping("/saveShop")
    @ResponseBody
    public String myGetMyPosition(ShopForm shopForm){
        log.info("판매자 위도 ={}",shopForm.getLatitude()); // 위도경도 둘다 String으로 넘어와서 String으로 프로퍼티객체 변경시켰음
        log.info("판매자 경도 ={}",shopForm.getLongitude());
        return "ok";
    }
}
