package hello.JuDang.JUDANG.Repository.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReservationRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int insert(Reservation reservation) {
        int result = jdbcTemplate.update("INSERT INTO reservation(shopNum,shopName,buyerId,buyerName,numberOfPeople,phoneNumber) values (?,?,?,?,?,?)",
                reservation.getShopNum(),
                reservation.getShopName(),
                reservation.getBuyerId(),
                reservation.getBuyerName(),
                reservation.getNumberOfPeople(),
                reservation.getPhoneNumber());
        return result;
    }

    @Override
    public int statusUpdate(Reservation reservation) {
        int result = jdbcTemplate.update("UPDATE reservation SET status = 1 WHERE buyerId = ?", reservation.getBuyerId());
        return result;
    }

    @Override
    public List<Reservation> selectStoreReservation(Reservation reservation) {
        String sql = "select * from reservation where shopNum = ? and shopName = ?";
        return jdbcTemplate.query(sql,
                new RowMapper<Reservation>() {
                    @Override
                    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Reservation resva = new Reservation();
                        resva.setShopNum(rs.getInt("shopNum"));
                        resva.setShopName(rs.getString("shopName"));
                        resva.setBuyerId(rs.getString("buyerId"));
                        resva.setBuyerName(rs.getString("buyerName"));
                        resva.setPhoneNumber(rs.getString("phoneNumber"));
                        resva.setNumberOfPeople(rs.getInt("numberOfPeople"));
                        resva.setStatus(rs.getBoolean("status"));
                        return resva;
                    }
                },reservation.getShopNum(), reservation.getShopName()
        );
    }
}
