package hello.JuDang.JUDANG.Repository.Login;

import hello.JuDang.JUDANG.Domain.Member;

import java.util.List;

public interface LoginRepository {
    List<Member> selectSeller(Member member);
    List<Member> selectBuyer(Member member);

}
