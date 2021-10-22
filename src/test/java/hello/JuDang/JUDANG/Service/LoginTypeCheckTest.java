package hello.JuDang.JUDANG.Service;

import hello.JuDang.JUDANG.Domain.Member;
import hello.JuDang.JUDANG.Domain.UserType;
import hello.JuDang.JUDANG.Repository.Member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginTypeCheckTest {
    @Qualifier("buyerJoinRepository")
    @Autowired
    MemberRepository buyerJoin;

    @Qualifier("sellerJoinRepository")
    @Autowired
    MemberRepository sellerJoin;

    @Autowired
    LoginTypeCheck loginTypeCheck;

    Member buyer = new Member();
    Member seller = new Member();

    @BeforeEach
    void 사전정보_삽입(){
        buyer.setId("abcd");
        buyer.setName("주진성");
        buyer.setPassword("123");
        buyer.setUserType(UserType.BUYER);
        buyer.setEmail("aaaa@aaaa.aaa");
        buyer.setAge(15);


        seller.setId("bbbb");
        seller.setName("구구구");
        seller.setPassword("333");
        seller.setUserType(UserType.SELLER);
        seller.setEmail("bbb@bbbb.bbb");
        seller.setAge(19);
    }

    @Test
    void 회원가입(){
        buyerJoin.save(buyer);
        sellerJoin.save(seller);
    }

    @Test
    void 구매자_정보체크(){
        Member member = loginTypeCheck.checkType(buyer);
        assertThat(member.getUserType()).isEqualTo(UserType.BUYER);
    }

    @Test
    void 판매자_정보체크(){
        Member member = loginTypeCheck.checkType(seller);
        assertThat(member.getUserType()).isEqualTo(UserType.SELLER);
    }

    @Test
    void 회원정보삭제(){
        buyerJoin.delete(buyer);
        sellerJoin.delete(seller);
    }
}