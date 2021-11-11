package hello.JuDang.JUDANG.Service.SerachFunc.Validationcategory;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Category;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ValidationCategoryImpl implements ValidationCategory {

    private final ShopRepository shopRepository;

    @Override
    public int CheckLogic(SearchWord searchWord) {
        Category category = shopRepository.ValidationCategory(searchWord);
        if(category == null){
            // 가게이름검색인거임
            return 0;
        }else{
            // 카테고리검색인거임
            return 1;
        }
    }
}
