package hello.JuDang.JUDANG.Controller.ControllerDomain;


import lombok.Data;

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
