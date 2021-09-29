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

    public List<Member> selectSeller(Member member) {
        List<Member> loginMember = jdbcTemplate.query("select * from seller where id = ?and password=?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setId(rs.getString("Id"));
                        member.setId(rs.getString("Password"));
                        member.setName(rs.getString("Name"));
                        member.setEmail(rs.getString("Email"));
                        member.setAge(rs.getInt("age"));
                        return member;
                    }
                }, member.getId(), member.getPassword());
        loginMember = loginMember;
        if(loginMember.isEmpty()){
            return null;
        }else return loginMember;
    }

    @Override
    public List<Member> selectBuyer(Member member) {
        List<Member> loginMember = jdbcTemplate.query("select * from buyer where id = ?and password=?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setId(rs.getString("Id"));
                        member.setId(rs.getString("Password"));
                        member.setName(rs.getString("Name"));
                        member.setEmail(rs.getString("Email"));
                        member.setAge(rs.getInt("age"));
                        return member;
                    }
                }, member.getId(), member.getPassword());
        if(loginMember.isEmpty()){
            return null;
        }else return loginMember;
    }

}
