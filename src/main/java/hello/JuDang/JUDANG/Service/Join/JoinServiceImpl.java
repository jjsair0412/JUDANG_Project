package hello.JuDang.JUDANG.Service.Join;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Join.JoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService{
    private final JoinRepository buyerJoinRepository;
    private final JoinRepository sellerJoinRepository;

    @Override
    public void memberRegister(Member member) {
        if(member.getUserType().equals(UserType.BUYER)){
            buyerJoinRepository.save(member);
        }
        else sellerJoinRepository.save(member);

    }

    @Override
    public Member searchById(String Id) {
        return null;
    }

    @Override
    public Member memberModify(Member member) {
        return null;
    }

    @Override
    public int memberDelete(Member member) {
        return 0;
    }
}
