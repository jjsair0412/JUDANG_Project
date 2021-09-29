package hello.JuDang.JUDANG.Repository.Login;

import hello.JuDang.JUDANG.Domain.Member;

public interface LoginRepository {
    Member select(String id,String password);
}
