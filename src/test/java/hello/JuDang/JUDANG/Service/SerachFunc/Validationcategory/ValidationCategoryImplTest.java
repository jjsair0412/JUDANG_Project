package hello.JuDang.JUDANG.Service.SerachFunc.Validationcategory;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ValidationCategoryImplTest {

    @Autowired
    private ValidationCategory validationCategory;
    @Autowired
    private ShopRepository shopRepository;
    SearchWord first = new SearchWord();
    SearchWord searchWord = new SearchWord();

    @BeforeEach
    void 카테고리저장(){

        first.setSearchWord("주진성");
        searchWord.setSearchWord("두번째카테고리");

        shopRepository.TESTINSERTCATEGORY(first);
        shopRepository.TESTINSERTCATEGORY(searchWord);
    }

    @AfterEach
    void 카테고리_삭제(){
        shopRepository.TESTDELETECATEGORY(first);
        shopRepository.TESTDELETECATEGORY(searchWord);
    }

    @Test
    void 카테고리있는경우(){
        int i = validationCategory.CheckLogic(first.getSearchWord());
        assertThat(i).isEqualTo(1);
    }

    @Test
    void 카테고리_없는경우(){
        SearchWord third = new SearchWord();
        third.setSearchWord("없당");
        int i = validationCategory.CheckLogic(third.getSearchWord());
        assertThat(i).isEqualTo(0);
    }
}