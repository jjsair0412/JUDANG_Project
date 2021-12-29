package hello.JuDang.JUDANG.Controller.ControllerDomain;


import lombok.Data;

@Data
public class MemberForm {
    private String id;
    private String password;
    private String name;
    private String email;
    private Integer age;
    private String typeBuyer;
    private String typeSeller;
}
