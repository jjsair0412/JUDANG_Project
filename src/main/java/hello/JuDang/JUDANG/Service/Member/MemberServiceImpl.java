package hello.JuDang.JUDANG.Service.Member;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository buyerJoinRepository;
    private final MemberRepository sellerJoinRepository;

    @Override
    public int memberRegister(Member member) {
        int result=0;
        if(member.getUserType().equals(UserType.BUYER)){
            result = buyerJoinRepository.save(member);

        }else if(member.getUserType().equals(UserType.SELLER)){
            result = sellerJoinRepository.save(member);

        }else return 0;
        return result;
    }

    @Override
    public Optional<Member> searchById(String id) {
        if(buyerJoinRepository.findById(id).equals(1)){
            return buyerJoinRepository.findById(id);
        }else if(sellerJoinRepository.findById(id).equals(1)){
            return sellerJoinRepository.findById(id);
        }else return null;
    }

    @Override
    public int memberModify(Member member) {
        return buyerJoinRepository.update(member);
    }

    @Override
    public int memberDelete(Member member) {
        return 0;
    }
}
