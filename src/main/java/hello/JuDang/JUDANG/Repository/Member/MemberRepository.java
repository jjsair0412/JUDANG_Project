package hello.JuDang.JUDANG.Repository.Member;

import hello.JuDang.JUDANG.Domain.Member;

import java.util.Optional;

public interface MemberRepository {
    int save(Member member);
    Optional<Member> findById(String id);
    int update(Member member);
    int delete(Member member);
}
