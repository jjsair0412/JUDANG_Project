package hello.JuDang.JUDANG.Service.Login;

import hello.JuDang.JUDANG.Domain.Member;

import hello.JuDang.JUDANG.Repository.Member.MemberRepository;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceImplTest {
    @Autowired LoginService loginService;
    @Autowired static MemberRepository sellerJoinRepository;
    @Autowired static MemberRepository buyerJoinRepository;

    @Test
    static void 회원가입진행() {
        Member member = new Member();
        member.setId("hi");
        member.setPassword("123");
        member.setAge(25);
        member.setName("주진성");
        member.setEmail("abcd@adbc");
        assertThat(sellerJoinRepository.save(member)).isEqualTo(1);
    }

    @Test
    void 판매자_구매자모두_로그인에실패해서_null이반환된경우(){
        Member member = new Member();
        member.setId("aa");
        member.setPassword("asdf");
        assertThat(loginService.login(member)).isEqualTo(null);

    }

    @Test
    static void 회원가입한거삭제(){
        Member member = new Member();
        member.setId("hi");
        assertThat(sellerJoinRepository.delete(member)).isEqualTo(1);
    }
}