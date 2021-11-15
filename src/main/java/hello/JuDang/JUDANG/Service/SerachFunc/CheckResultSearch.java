package hello.JuDang.JUDANG.Service.SerachFunc;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Shop;

import java.util.List;

public interface CheckResultSearch {
    List<Shop> SearchFunc(String searchWord);
}
