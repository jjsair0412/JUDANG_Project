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
        int result = jdbcTemplate.update("INSERT INTO reservation(shopId,buyerId,buyerName,numberOfPeople,phoneNumber) values (?,?,?,?,?,?)",
                reservation.getShopId(),
                reservation.getBuyerId(),
                reservation.getBuyerName(),
                reservation.getNumberOfPeople(),
                reservation.getPhoneNumber());
        return result;
    }


}
