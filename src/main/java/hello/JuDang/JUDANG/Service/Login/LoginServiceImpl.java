package hello.JuDang.JUDANG.Service.Login;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{ // 얘 테스트코드 있음
    private final LoginRepository loginRepository;

    @Override
    public Member login(Member member) {
        List<Member> buyerLogin = loginRepository.selectBuyer(member);
        List<Member> sellerLogin = loginRepository.selectSeller(member);
        if(buyerLogin == null){
            Member memberSeller = sellerLogin.get(0);
            memberSeller.setUserType(UserType.SELLER);
            return memberSeller;
        }else if(sellerLogin == null){
            Member memberBuyer = sellerLogin.get(0);
            memberBuyer.setUserType(UserType.BUYER);
            return memberBuyer;
        }else return null;

    }

}