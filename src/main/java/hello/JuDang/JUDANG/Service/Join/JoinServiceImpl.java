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
    public int memberRegister(Member member) {
        int result;
        if(member.getUserType().equals(UserType.BUYER)){
            result = buyerJoinRepository.save(member);
        }
        else{
            result = sellerJoinRepository.save(member);
        }
        return result;

    }

    @Override
    public Member searchById(String Id) {
        int result =0;
        if(buyerJoinRepository.findById(Id).equals(1)){
            result = buyerJoinRepository.findById(Id);
            return
        }
        return ;
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
