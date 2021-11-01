package hello.JuDang.JUDANG.Controller.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Service.Reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public String goReservation(Model model){
        model.addAttribute("reservation",new Reservation());
        return "";
    }

    @PostMapping
    public String makeReservation(@ModelAttribute Reservation reservation, RedirectAttributes redirectAttributes, HttpSession session){
        reservation.setShopId((String)session.getAttribute("shopId"));
        int result = reservationService.makeReservation(reservation);
        redirectAttributes.addAttribute("buyerId",reservation.getBuyerId());
        if(result<1){
            return "";
        }
        return "redirect:/";
    }

    @GetMapping("/accept")
    public String acceptReservation(@ModelAttribute Reservation reservation){
        int result = reservationService.acceptReservation(reservation);

        return "redirect:";
    }

}
