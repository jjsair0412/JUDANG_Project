package hello.JuDang.JUDANG.Service.Login;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;
import hello.JuDang.JUDANG.Service.LoginTypeCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{ // 얘 테스트코드 있음
    private final LoginRepository loginRepository;
    private final LoginTypeCheck loginTypeCheck;

    @Override
    public Member login(Member member) {
        List<Member> loginMember = loginTypeCheck.checkType(member);
        if(loginMember.size()!=0) {
            return loginMember.get(0);
        }else return null;
    }

}