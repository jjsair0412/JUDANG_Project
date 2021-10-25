package hello.JuDang.JUDANG.Service.Reservation;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Override
    public int reservation(String buyerId, String SellerId,int total,int current) {
        if((total - current)==0){
            return 0;
        }

        return 0;
    }
}
