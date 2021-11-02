package hello.JuDang.JUDANG.Controller.Reservation;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ReservationForm;
import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Service.Reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Reservation")
public class TestController {
    private final ReservationService reservationService;

    @GetMapping
    public String goReservation(Model model){
        model.addAttribute("reservation",new Reservation());
        return "TestReservation/TestPage1ReservSend";
    }

    @PostMapping("/goReser")
    @ResponseBody
    public int makeReservation(
            Reservation reservation) throws Exception{
        return reservationService.makeReservation(reservation);
    }
}
