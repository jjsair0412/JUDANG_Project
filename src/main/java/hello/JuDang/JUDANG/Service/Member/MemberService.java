package hello.JuDang.JUDANG.Service.Member;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;

import java.util.Optional;

public interface MemberService {
    int memberRegister(MemberForm form);
    Optional<Member> searchById(String Id);
    int memberModify(Member member);
    int memberDelete(Member member);

}
