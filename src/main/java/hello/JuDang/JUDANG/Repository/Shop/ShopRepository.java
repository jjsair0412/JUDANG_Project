package hello.JuDang.JUDANG.Repository.Shop;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Category;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {
    int save(Shop shop);
    List<Shop> findAllShop();
    List<Shop> findByName(String name);
    List<Shop> findByCategory(String category);
    Shop findByHtmlId(String htmlId);
    List<Category> ValidationCategory(String searchWord);
    int TESTINSERTCATEGORY(SearchWord searchWord); // 테스트용 카테고리 저장
    int TESTDELETECATEGORY(SearchWord searchWord); // 테스트용 카테고리 삭제
    List<Shop> findNearShop(String lat,String lon);
    Shop findById(int shopNum);
    int update(Shop shop);
    int delete(Shop shop);
}
