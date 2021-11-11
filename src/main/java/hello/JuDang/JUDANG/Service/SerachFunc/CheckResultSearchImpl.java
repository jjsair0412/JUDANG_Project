package hello.JuDang.JUDANG.Service.SerachFunc;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Service.SerachFunc.Validationcategory.ValidationCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckResultSearchImpl implements checkResultSearch {
    private final ValidationCategory validationCategory;


    @Override
    public List<Shop> SearchFunc(SearchWord searchWord) {
        int i = validationCategory.CheckLogic(searchWord);
        if(i == 0){ // 카테고리검색

        }else{ // 가게이름검색

        }
        return null;
    }
}
