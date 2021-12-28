package hello.JuDang.JUDANG.Controller.Reservation;


import hello.JuDang.JUDANG.Domain.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReservationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Reservation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Reservation reservation = (Reservation) target;

        //인원수 미입력
        if(reservation.getNumberOfPeople()==null){
            errors.rejectValue("numberOfPeople","empty");
        }
        //구매자 연락처 미입력
        if(StringUtils.hasText(reservation.getPhoneNumber())){
            errors.rejectValue("phoneNumber","empty");
        }
    }
}

