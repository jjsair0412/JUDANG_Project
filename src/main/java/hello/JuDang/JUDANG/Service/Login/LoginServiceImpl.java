package hello.JuDang.JUDANG.Service.Login;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Repository.Login.LoginRepository;

public class LoginServiceImpl implements LoginService{
    private LoginRepository loginRepository;

    @Override
    public Member login(Member member) {
        Member loginMember = loginRepository.select(member.getId(), member.getPassword());


        return null;
    }
}
