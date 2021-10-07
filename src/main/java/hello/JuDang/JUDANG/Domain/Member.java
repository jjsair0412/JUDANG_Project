package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Member {
    private String Id;
    private String Password;
    private String Name;
    private String Email;
    private int age;
    private UserType userType;
}
