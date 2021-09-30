package hello.JuDang.JUDANG.Repository.Login;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Join.JoinRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LoginRepositoryImplTest {

    @Autowired LoginRepository loginRepository;
    @Autowired JoinRepository buyerJoinRepository;
    @Autowired JoinRepository sellerJoinRepository;

    @Test
    void selectBuyer() {
        //given
        Member member = new Member();
        member.setId("koo");
        member.setPassword("1234");
        member.setName("준범");
        member.setAge(24);
        member.setEmail("qwer");
        member.setUserType(UserType.BUYER);
        buyerJoinRepository.save(member);

        //when
        List<Member> members = loginRepository.selectBuyer(member);
        Member loginMember = members.get(0);

        //then
        Assertions.assertThat(loginMember.getId()).isEqualTo("koo");
        Assertions.assertThat(loginMember.getPassword()).isEqualTo("1234");

    }

    @Test
    void selectSeller() {
        //given
        Member member = new Member();
        member.setId("koo");
        member.setPassword("1234");
        member.setName("준범");
        member.setAge(24);
        member.setEmail("qwer");
        member.setUserType(UserType.SELLER);
        sellerJoinRepository.save(member);

        //when
        List<Member> members = loginRepository.selectSeller(member);
        Member loginMember = members.get(0);

        //then
        Assertions.assertThat(loginMember.getId()).isEqualTo("koo");
        Assertions.assertThat(loginMember.getPassword()).isEqualTo("1234");
    }
}