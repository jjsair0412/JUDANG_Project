package hello.JuDang.JUDANG.Service.Member;

import hello.JuDang.JUDANG.Domain.Member;

import java.util.Optional;

public interface MemberService {
    int memberRegister(Member member);
    Optional<Member> searchById(String Id);
    int memberModify(Member member);
    int memberDelete(Member member);

}
