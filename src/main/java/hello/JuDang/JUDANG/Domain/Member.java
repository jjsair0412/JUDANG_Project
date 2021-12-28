package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Member {
    private String id;
    private String password;
    private String name;
    private String email;
    private Integer age;
    private UserType userType;
}
