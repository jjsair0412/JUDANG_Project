package hello.JuDang.JUDANG.Service;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class LoginTypeCheck {
    private final LoginRepository loginRepository;

    public Member checkType(Member member){
        List<Member> buyerLogin = loginRepository.selectBuyer(member);
        List<Member> sellerLogin = loginRepository.selectSeller(member);

        if(buyerLogin.size()!=0){
            Member buyer = buyerLogin.get(0);
            buyer.setUserType(UserType.BUYER);
            return buyer;
        }else if(sellerLogin.size()!=0){
            Member seller = sellerLogin.get(0);
            seller.setUserType(UserType.SELLER);
            return seller;
        }else return null;
    }
}
