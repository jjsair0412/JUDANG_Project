package hello.JuDang.JUDANG.Controller.Join;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberForm memberForm = (MemberForm) target;

        //이름 검증
        if(StringUtils.hasText(memberForm.getName())){
            errors.rejectValue("name","empty");
        }
        if(StringUtils.hasText(memberForm.getId())){
            errors.rejectValue("id","empty");
        }
        if(StringUtils.hasText(memberForm.getPassword())){
            errors.rejectValue("password","empty");
        }
        if(StringUtils.hasText(memberForm.getEmail())){
            errors.rejectValue("email","empty");
        }

        //나이 검증
        if(memberForm.getAge() == null){
            errors.rejectValue("age","empty");
        }
        if(memberForm.getAge()<20){
            errors.rejectValue("age","min");
        }
    }

}
