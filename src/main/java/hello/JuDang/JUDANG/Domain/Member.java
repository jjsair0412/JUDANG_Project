package hello.JuDang.JUDANG.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;
    private String password;
    private String name;
    private String email;
    private Integer age;
    private UserType userType;

    public Member(){

    }

    public Member(String id, String password, String name, String email, Integer age, UserType userType) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
        this.userType = userType;
    }
}
