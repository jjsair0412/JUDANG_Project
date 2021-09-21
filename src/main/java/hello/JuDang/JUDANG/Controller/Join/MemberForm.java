package hello.JuDang.JUDANG.Controller.Join;

import hello.JuDang.JUDANG.Domain.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberForm {
    private String Id;
    private String Password;
    private String Name;
    private String Email;
    private int age;
    private UserType userType;
}
