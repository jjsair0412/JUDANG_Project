package hello.JuDang.JUDANG.Service.Join;

import hello.JuDang.JUDANG.Domain.Member;

public interface JoinService {
    void memberRegister(Member member);
    Member searchById(String Id);
    Member memberModify(Member member);
    int memberDelete(Member member);

}
