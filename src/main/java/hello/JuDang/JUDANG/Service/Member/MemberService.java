package hello.JuDang.JUDANG.Service.Member;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;

import java.util.Optional;

public interface MemberService {
    int memberRegister(MemberForm form);
    Optional<Member> searchById(String Id);
    int memberModify(Member member);
    int memberDelete(Member member);
    Member exchangeType(MemberForm form); // memberForm을 member로 타입지정해주어서 변환해주는 메서드
}
