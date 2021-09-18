package hello.JuDang.JUDANG.Repository.Join;


import hello.JuDang.JUDANG.Domain.Member;

import java.util.Optional;

public interface JoinRepository {
    int save(Member member);
    Optional<Member> findById(String id);
    int update(Member member);
    int delete(Member member);

}
