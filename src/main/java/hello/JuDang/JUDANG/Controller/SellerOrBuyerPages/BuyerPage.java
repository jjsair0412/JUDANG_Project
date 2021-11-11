package hello.JuDang.JUDANG.Controller.SellerOrBuyerPages;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.Shop.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/BuyerPage")
public class BuyerPage {
    private final ShopService shopService;

    @GetMapping
    public String goBuyerPage(Model model,
                              @RequestParam String lat,@RequestParam String lon) {
        //현재 위치기반 지도 띄우기
        List<Shop> nearShops = shopService.findNearShop(lat, lon);
        model.addAttribute("nearShops",nearShops);
        model.addAttribute("searchWord",new SearchWord());
        return "/buyer/buyer_main";
    }

    @PostMapping("/search")
    public String searchByName(SearchWord searchWord,Model model){
        List<Shop> shops = shopService.searchShop(searchWord.getSearchWord());
        model.addAttribute("searchByNameList",shops);
        return "/buyer/buyer_main";
    }

}