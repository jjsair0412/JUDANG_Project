package hello.JuDang.JUDANG.Repository.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import hello.JuDang.JUDANG.Domain.Waiting;
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
        int result = jdbcTemplate.update("INSERT INTO reservation(shopNum,shopName,buyerId,buyerName,numberOfPeople,reservationSeats,phoneNumber) values (?,?,?,?,?,?,?)",
                reservation.getShopNum(),
                reservation.getShopName(),
                reservation.getBuyerId(),
                reservation.getBuyerName(),
                reservation.getNumberOfPeople(),
                reservation.getReservationSeats(),
                reservation.getPhoneNumber());
        return result;
    }

    @Override
    public Reservation select(String buyerId) {
        List<Reservation> reservations = jdbcTemplate.query("SELECT * FROM reservation WHERE buyerId=?", reservationRowMapper(), buyerId);
        return reservations.get(0);
    }


    @Override
    public int statusUpdate(String buyerId) {
        int result = jdbcTemplate.update("UPDATE reservation SET status = 1 WHERE buyerId = ?", buyerId);
        return result;
    }

    @Override
    public List<Reservation> selectStoreReservation(Reservation reservation) {
        String sql = "select * from reservation where shopNum = ? and shopName = ? ORDER BY 'time'";
        return jdbcTemplate.query(sql,
                reservationRowMapper(),reservation.getShopNum(), reservation.getShopName()
        );
    }

    private RowMapper<Reservation> reservationRowMapper() {
        return new RowMapper<Reservation>() {
            @Override
            public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                Reservation resva = new Reservation();
                resva.setShopNum(rs.getInt("shopNum"));
                resva.setShopName(rs.getString("shopName"));
                resva.setBuyerId(rs.getString("buyerId"));
                resva.setBuyerName(rs.getString("buyerName"));
                resva.setPhoneNumber(rs.getString("phoneNumber"));
                resva.setNumberOfPeople(rs.getInt("numberOfPeople"));
                resva.setReservationSeats(rs.getString("reservationSeats"));
                resva.setStatus(rs.getBoolean("status"));
                resva.setTime(rs.getString("time"));
                return resva;
            }
        };
    }


}
