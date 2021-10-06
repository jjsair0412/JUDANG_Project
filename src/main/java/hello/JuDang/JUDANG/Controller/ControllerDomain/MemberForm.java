package hello.JuDang.JUDANG.Controller.ControllerDomain;

import hello.JuDang.JUDANG.Domain.UserType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberForm {
    private String Id;
    private String Password;
    private String Name;
    private String Email;
    private int age;
    private String typeBuyer;
    private String typeSeller;
}
