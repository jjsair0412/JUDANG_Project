package hello.JuDang.JUDANG.Service.SerachFunc;

import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.SerachFunc.Validationcategory.ValidationCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckResultSearchImpl implements CheckResultSearch {
    private final ValidationCategory validationCategory;
    private final ShopRepository shopRepository;

    @Override
    public List<Shop> SearchFunc(String searchWord) {
        int i = validationCategory.CheckLogic(searchWord);
        if(i == 0){ // 카테고리검색
            List<Shop> byCategory = shopRepository.findByCategory(searchWord);
            return byCategory;
        }else{ // 가게이름검색
            List<Shop> byName = shopRepository.findByName(searchWord);
            return byName;
        }
    }
}