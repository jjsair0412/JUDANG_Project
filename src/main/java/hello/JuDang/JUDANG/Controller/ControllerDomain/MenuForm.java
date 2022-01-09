package hello.JuDang.JUDANG.Controller.ControllerDomain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MenuForm {
    @NotBlank
    private String menuName;

    @NotBlank
    private int price;
}
