package hello.JuDang.JUDANG.Service;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoginTypeCheck {
    private final LoginRepository loginRepository;

    public List<Member> checkType(Member member){
        List<Member> buyerLogin = loginRepository.selectBuyer(member);
        List<Member> sellerLogin = loginRepository.selectSeller(member);

        if(buyerLogin.isEmpty()){
            return sellerLogin;
        }else if(sellerLogin.isEmpty()){
            return buyerLogin;
        }else return null;

    }

}
