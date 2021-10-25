package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/BuyerPage")
public class BuyerPage {

    @GetMapping
    public String goBuyerPage() {
        //현재 위치기반 지도 띄우기
        return "";
    }

    @PostMapping("/search/name")
    public String searchByName(){
        return "";
    }

    @PostMapping("/search/category")
    public String searchByCategory(){
        return "";
    }
}
