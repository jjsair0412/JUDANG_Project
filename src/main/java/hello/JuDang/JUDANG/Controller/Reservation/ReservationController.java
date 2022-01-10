package hello.JuDang.JUDANG.Controller.Reservation;

import hello.JuDang.JUDANG.Controller.ControllerDomain.ReservationForm;
import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.Reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final ShopRepository shopRepository;

    @GetMapping
    public String goReservation(Model model,
                                @SessionAttribute (name="shopNum") int shopNum,
                                @SessionAttribute (name="loginMember") String buyerId,
                                @SessionAttribute (name="loginMemberName") String buyerName){
        Shop shop = shopRepository.findById(shopNum);
        ReservationForm reservationForm = new ReservationForm(shopNum,shop.getShopName(),buyerId,buyerName);
        model.addAttribute("reservation",reservationForm);
        return "buyer/buyer_form";
    }

    @PostMapping("/makeReservation")
    public String makeReservation(@Validated @ModelAttribute ReservationForm form,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes,
                                  HttpSession session ) throws Exception {

        if(bindingResult.hasErrors()){
            log.info("오류 = {}",bindingResult);
            return "redirect:buyer/buyer_form";
        }

        Reservation reservation = new Reservation(form.getShopNum(), form.getShopName(), form.getBuyerId(), form.getBuyerName(),
                form.getNumberOfPeople(), form.getPhoneNumber());

        String result = reservationService.makeReservation(reservation);
        if(result.equals("실패")){ // 실패
            return "";
        }
        return "redirect:/MemberManage/myInfo"; //성공 (내 정보 -> 예약 현황으로)
    }

    @GetMapping("/accept")
    public String acceptReservation(@ModelAttribute Reservation reservation){
        int result = reservationService.acceptReservation(reservation);
        if(result<1){
            log.info("예약 수락 실패");
        }else{
            log.info("예약 수락 성공");
        }
        return "알림을 주도록 하자";
    }
}