package hello.JuDang.JUDANG.Controller.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Shop;
import hello.JuDang.JUDANG.Repository.Shop.ShopRepository;
import hello.JuDang.JUDANG.Service.Reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
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
        Reservation reservation = new Reservation();
        reservation.setShopNum(shop.getShopNum());
        reservation.setShopName(shop.getShopName());
        reservation.setBuyerId(buyerId);
        reservation.setBuyerName(buyerName);

        model.addAttribute("reservation",reservation);
        return "buyer/buyer_form";
    }

    @PostMapping("/makeReservation")
    public String makeReservation(@ModelAttribute Reservation reservation,
                                  RedirectAttributes redirectAttributes,
                                  HttpSession session, BindingResult bindingResult) throws Exception {
        //구매자 연락처 미입력
        if(StringUtils.hasText(reservation.getPhoneNumber())){
            bindingResult.rejectValue("phoneNumber","empty");
        }

        if(bindingResult.hasErrors()){
            log.info("오류 = {}",bindingResult);
            return "redirect:buyer/buyer_form";
        }

        String result = reservationService.makeReservation(reservation);
        redirectAttributes.addAttribute("buyerId",reservation.getBuyerId());
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