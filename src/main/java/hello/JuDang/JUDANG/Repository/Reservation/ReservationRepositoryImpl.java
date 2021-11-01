package hello.JuDang.JUDANG.Repository.Reservation;

import hello.JuDang.JUDANG.Domain.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    private final JdbcTemplate jdbcTemplate;
    public ReservationRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int insert(Reservation reservation) {
        int result = jdbcTemplate.update("INSERT INTO reservation(shopId,shopName,buyerId,buyerName,numberOfPeople,phoneNumber) values (?,?,?,?,?,?,?)",
                reservation.getShopNum(),
                reservation.getShopName(),
                reservation.getBuyerId(),
                reservation.getBuyerName(),
                reservation.getNumberOfPeople(),
                reservation.getPhoneNumber());
        return result;
    }

    @Override
    public int update(Reservation reservation) {
        int result = jdbcTemplate.update("UPDATE reservation SET status = 1 WHERE buyerId = ?", reservation.getBuyerId());
        return result;
    }
}
