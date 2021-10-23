package hello.JuDang.JUDANG.Repository.GetMyShopInfo;

import hello.JuDang.JUDANG.Domain.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class SellerShopInfoImpl implements SellerShopInfo{
    private final JdbcTemplate template;

    @Override
    public List<Shop> getAllMyShops(String sellerId) {
        String sql = "select * from shop where sellerId = ?";
        return template.query(
                sql, new RowMapper<Shop>() {
                    @Override
                    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Shop shops = new Shop();
                        shops.setSellerId(rs.getString("sellerId"));
                        shops.setShopName(rs.getString("shopName"));
                        shops.setCategory(rs.getString("category"));
                        shops.setTotalSeat(rs.getInt("totalSeat"));
                        shops.setCurrentSeat(rs.getInt("currentSeat"));
                        shops.setLatitude(rs.getString("latitude"));
                        shops.setLongitude(rs.getString("longitude"));
                        shops.setOpen(rs.getBoolean("open"));
                        return shops;
                    }
                }, sellerId
        );

    }
}
