package hello.JuDang.JUDANG.Repository.Join;

import hello.JuDang.JUDANG.Domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class BuyerJoinRepository implements JoinRepository{

    private JdbcTemplate jdbcTemplate;

    public BuyerJoinRepository(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int save(Member member) {
        int result = 0;
        final String sql = "INSERT INTO buyer(id,password,name,email,age) values (?,?,?,?,?)";

        result = jdbcTemplate.update(sql, ps -> {
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
        return Optional.empty();
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(Member member) {
        return 0;
    }

}
