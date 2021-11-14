package hello.JuDang.JUDANG.Service.SerachFunc.Validationcategory;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Category;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ValidationCategoryImpl implements ValidationCategory {
    private final ShopRepository shopRepository;
    @Override
    public int CheckLogic(String searchWord) {
        List<Category> categories = shopRepository.ValidationCategory(searchWord);
        if(categories.size() == 0){
            //이름 검색
            return 0;
        }else{
            // 카테고리 검색
            return 1;
        }
    }
}