package hello.JuDang.JUDANG.Service.Member;

import hello.JuDang.JUDANG.Controller.ControllerDomain.MemberForm;
import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository buyerJoinRepository;
    private final MemberRepository sellerJoinRepository;

    @Override
    public int memberRegister(MemberForm form) {
            Member member = exchangeType(form);
            switch (member.getUserType()) {
                case BUYER:
                    return buyerJoinRepository.save(member);
                case SELLER:
                    return sellerJoinRepository.save(member);
                default:
                    return 0;
            }
    }


    @Override
    public int memberModify(Member member) {
        switch (member.getUserType()){
            case BUYER:
                return buyerJoinRepository.update(member);
            case SELLER:
                return sellerJoinRepository.update(member);
            default:
                return 0;
        }
    }

    @Override
    public int memberDelete(Member member) {
        switch (member.getUserType()){
            case BUYER:
                return buyerJoinRepository.delete(member);
            case SELLER:
                return sellerJoinRepository.delete(member);
            default:
                return 0;
        }
    }

    @Override
    public Optional<Member> searchById(String id) {
        if (buyerJoinRepository.findById(id).equals(1)) {
            return buyerJoinRepository.findById(id);
        } else if (sellerJoinRepository.findById(id).equals(1)) {
            return sellerJoinRepository.findById(id);
        } else return null;
    }

    public Member exchangeType(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());
        member.setAge(form.getAge());

        //타입 정해주기
        if ("BUYER".equals(form.getTypeBuyer())) {
            member.setUserType(UserType.BUYER);
        } else if ("SELLER".equals(form.getTypeSeller())){
            member.setUserType(UserType.SELLER);
        }

        return member;
    }
}
