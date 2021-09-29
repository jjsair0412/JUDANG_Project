package hello.JuDang.JUDANG.Repository.Login;

import hello.JuDang.JUDANG.Domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginRepositoryImpl implements LoginRepository{
    private JdbcTemplate jdbcTemplate;

    public LoginRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public Member select(String id, String password) {
        Member member = jdbcTemplate.query("select * from seller where id = ?,password=?",id,password);

    }

    private RowMapper<Member> memberRowMapper(){
        return new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setId(rs.getString("Id"));
                member.setPassword(rs.getString("Password"));
                member.setName(rs.getString("Name"));
                member.setEmail(rs.getString("Email"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        };
    }
}
