package hello.JuDang.JUDANG.Repository.Member;

import hello.JuDang.JUDANG.Domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyerJoinRepository implements MemberRepository {


    private JdbcTemplate jdbcTemplate;

    public BuyerJoinRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int save(Member member) {
        int result = 0;
        final String sql = "INSERT INTO buyer(id,password,name,email,age) values (?,?,?,?,?)";

        result = jdbcTemplate.update(sql, ps -> {
            ps.setString(1, member.getId());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getName());
            ps.setString(4, member.getEmail());
            ps.setInt(5, member.getAge());
        });
        return result;
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> memberList = jdbcTemplate.query("select * from buyer where id = ?", memberRowMapper());
        return memberList.stream().findAny();
    }

    @Override
    public int update(Member member) {
        int result = jdbcTemplate.update("UPDATE BUYER SET password=?"
                ,memberRowMapper()
                ,member.getPassword());
        return result;
    }

    @Override
    public int delete(Member member) {
        int result = jdbcTemplate.update("DELETE FROM BUYER WHERE id=?", memberRowMapper());




        return result;
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
