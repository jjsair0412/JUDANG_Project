package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/SellerPage")
public class SellerPage {
    
    @GetMapping
    public String goSellerPage(){

        return "seller_main/seller_main";
    }
}
