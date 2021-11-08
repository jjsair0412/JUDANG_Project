package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Seller.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/BuyerPage")
public class BuyerPage {
    private final ShopService shopService;

    @GetMapping
    public String goBuyerPage(Model model,
                              @RequestParam long lat,@RequestParam long lon) {
        //현재 위치기반 지도 띄우기


        return "";
    }

    @PostMapping("/search/name")
    public String searchByName(@RequestParam String searchWord){
        Optional<List<Shop>> shops = shopService.findByName(searchWord);

        return "";
    }

    @PostMapping("/search/category")
    public String searchByCategory(@RequestParam String searchWord){
        Optional<List<Shop>> shops = shopService.findByCategory(searchWord);

        return "";
    }
}
