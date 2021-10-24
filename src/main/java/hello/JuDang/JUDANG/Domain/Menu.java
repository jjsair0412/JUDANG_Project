package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Menu {
    private String menuName;
    private int price;

    public Menu(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }
}
