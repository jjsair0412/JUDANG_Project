package hello.JuDang.JUDANG.Controller.ControllerDomain;


import lombok.Data;
import org.hibernate.validator.constraints.CodePointLength;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MemberForm {
    @NotBlank
    @NotNull
    @CodePointLength(min = 4,max = 15)
    private String id;

    @NotBlank
    @NotNull
    @CodePointLength(min = 4,max = 15)
    private String password;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Email
    private String email;

    @NotNull
    private Integer age;

    private String typeBuyer;

    private String typeSeller;
}
