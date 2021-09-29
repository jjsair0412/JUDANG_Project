package hello.JuDang.JUDANG.Service.Login;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;

import java.util.List;

public class LoginServiceImpl implements LoginService{
    private LoginRepository loginRepository;

    @Override
    public Member login(Member member) {
        List<Member> buyerLogin = loginRepository.selectBuyer(member);
        List<Member> sellerLogin = loginRepository.selectSeller(member);

        if(buyerLogin.isEmpty()){
            return sellerLogin.get(0);
        }else if(sellerLogin.isEmpty()){
            return buyerLogin.get(0);
        }else  return null;
    }
}
