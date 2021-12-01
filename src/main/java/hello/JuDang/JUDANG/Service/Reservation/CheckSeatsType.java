package hello.JuDang.JUDANG.Service.Reservation;

import org.springframework.stereotype.Component;

@Component
public class CheckSeatsType {
    public String check(int numberOfPeople) {
        if(numberOfPeople <3){
            return "2인";
        }else if(numberOfPeople >2 && numberOfPeople <=4){
            return "4인";
        }else if (numberOfPeople > 4 && numberOfPeople <=6){
            return "6인";
        }else if (numberOfPeople > 6 && numberOfPeople <=8){
            return "8인";}
        else return "8인 이상";
    }
}
