package hello.JuDang.JUDANG.Repository.Shop.Seats;

import hello.JuDang.JUDANG.Domain.Seats;
import hello.JuDang.JUDANG.Domain.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
public class SeatsRepositoryImpl implements SeatsRepository {
    private JdbcTemplate jdbcTemplate;


    public SeatsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Seats seats, int shopNum) {
        int result = jdbcTemplate.update("update seats set twoSeats = ?, fourSeats = ?, sixSeats = ?, eightSeats = ? where shopNum = ?  ",
            seats.getTwoSeats(), seats.getFourSeats(), seats.getSixSeats(), seats.getEightSeats(), shopNum);
        return result;
    }

    public int insertPK(Shop shop){
        return jdbcTemplate.update("insert into seats(shopNum) values(?)",shop.getShopNum());
    }


    @Override
    public int delete(Seats seats) {
        return jdbcTemplate.update("delete from seats where shopNum = ?",seats.getShopNum());
    }

    @Override
    public Seats select(int shopNum) {
        List<Seats> seats = jdbcTemplate.query("SELECT * FROM seats WHERE shopNum = ?", seatsRowMapper(),shopNum);
        return seats.isEmpty() ? null : seats.get(0);
    }

    @Override
    public int update(Seats seats) {
        jdbcTemplate.update("UPDATE seats SET ");
        return 0;
    }


    private RowMapper<Seats> seatsRowMapper(){
        return new RowMapper<Seats>() {
            @Override
            public Seats mapRow(ResultSet rs, int rowNum) throws SQLException {
                Seats seats = new Seats();
                seats.setShopNum(rs.getInt("shopNum"));
                seats.setTwoSeats(rs.getInt("twoSeats"));
                seats.setSitTwoSeats(rs.getInt("sitTwoSeats"));
                seats.setFourSeats(rs.getInt("fourSeats"));
                seats.setSitFourSeats(rs.getInt("sitFourSeats"));
                seats.setSixSeats(rs.getInt("sixSeats"));
                seats.setSitSixSeats(rs.getInt("sitSixSeats"));
                seats.setEightSeats(rs.getInt("eightSeats"));
                seats.setSitEightSeats(rs.getInt("sitEightSeats"));
                return seats;
            }
        };
    }
}
