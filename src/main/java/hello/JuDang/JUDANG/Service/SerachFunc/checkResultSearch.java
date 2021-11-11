package hello.JuDang.JUDANG.Service.SerachFunc;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface checkResultSearch {
    List<Shop> SearchFunc(SearchWord searchWord);
}
