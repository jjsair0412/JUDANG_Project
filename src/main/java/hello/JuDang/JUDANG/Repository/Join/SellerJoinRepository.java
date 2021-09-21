package hello.JuDang.JUDANG.Repository.Join;

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
public class SellerJoinRepository implements JoinRepository{
    private JdbcTemplate jdbcTemplate;

    public SellerJoinRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int save(Member member) {
        int result = jdbcTemplate.update("INSERT INTO buyer(id,password,name,email,age) values (?,?,?,?,?)", ps -> {
            ps.setString(1,member.getId());
            ps.setString(2,member.getPassword());
            ps.setString(3,member.getName());
            ps.setString(4,member.getEmail());
            ps.setInt(5,member.getAge());
        });
        return result;
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> memberList = jdbcTemplate.query("select * from seller where id = ?", memberRowMapper());
        return memberList.stream().findAny();
    }

    @Override
    public int update(Member member) {
        int result =jdbcTemplate.update("UPDATE seller SET id=?,password=?,name=?,Email=?,age=?",memberRowMapper());
        return result;
    }

    @Override
    public int delete(Member member) {
        int result = jdbcTemplate.update("DELETE FROM seller WHERE id=?", memberRowMapper());
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

