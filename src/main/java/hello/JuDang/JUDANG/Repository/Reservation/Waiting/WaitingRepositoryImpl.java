package hello.JuDang.JUDANG.Repository.Reservation.Waiting;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Waiting;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WaitingRepositoryImpl implements WaitingRepository{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Waiting waiting) {
        int result = jdbcTemplate.update("INSERT INTO waiting(shopNum,shopName,buyerId,buyerName,numberOfPeople,reservationSeats,phoneNumber) values(?,?,?,?,?,?,?)",
                waiting.getShopNum(),
                waiting.getShopName(),
                waiting.getBuyerId(),
                waiting.getBuyerName(),
                waiting.getNumberOfPeople(),
                waiting.getReservationSeats(),
                waiting.getPhoneNumber());
        return result;
    }

    @Override
    public int statusUpdate(Waiting waiting) {
        int result = jdbcTemplate.update("UPDATE reservation SET status = 1 WHERE buyerId = ?", waiting.getBuyerId());
        return result;
    }

    @Override
    public List<Waiting> select(String buyerId) {
        List<Waiting> waiting = jdbcTemplate.query("SELECT * FROM waiting WHERE buyerId=?", watingRowMapper(), buyerId);
        return waiting;
    }

    @Override
    public int delete(String buyerId) {
        int del = jdbcTemplate.update("DELETE FROM waiting WHERE buyerId = ?", buyerId);
        return del;
    }

    private RowMapper<Waiting> watingRowMapper() {
        return new RowMapper<Waiting>() {
            @Override
            public Waiting mapRow(ResultSet rs, int rowNum) throws SQLException {
                Waiting waiting = new Waiting();
                waiting.setShopNum(rs.getInt("shopNum"));
                waiting.setShopName(rs.getString("shopName"));
                waiting.setBuyerId(rs.getString("buyerId"));
                waiting.setBuyerName(rs.getString("buyerName"));
                waiting.setPhoneNumber(rs.getString("phoneNumber"));
                waiting.setNumberOfPeople(rs.getInt("numberOfPeople"));
                waiting.setReservationSeats(rs.getString("reservationSeats"));
                waiting.setStatus(rs.getBoolean("status"));
                waiting.setTime(rs.getString("time"));
                return waiting;
            }
        };
    }
}
