package hello.JuDang.JUDANG.Service.Join;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Join.JoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
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
    public Optional<Member> searchById(String Id) {
        if(buyerJoinRepository.findById(Id).equals(1)){
            return buyerJoinRepository.findById(Id);
        }else if(sellerJoinRepository.findById(Id).equals(1)){
            return sellerJoinRepository.findById(Id);
        }else return null;
    }

    @Override
    public int memberModify(Member member) {
        return null;
    }

    @Override
    public int memberDelete(Member member) {
        return 0;
    }
}
