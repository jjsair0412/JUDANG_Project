package hello.JuDang.JUDANG.Controller.ControllerDomain;


import lombok.Data;
import org.hibernate.validator.constraints.CodePointLength;

import javax.validation.constraints.*;

@Data
public class MemberForm {
    @NotBlank
    @CodePointLength(min = 4,max = 15)
    @Pattern(regexp = "[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]")
    private String id;

    @NotBlank
    @CodePointLength(min = 4,max = 15)
    private String password;

    @NotBlank
    @Pattern(regexp = "[^a-z|A-Z]")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Min(20)
    private Integer age;

    private String typeBuyer;

    private String typeSeller;
}
