package hello.JuDang.JUDANG.Repository.Shop;

import hello.JuDang.JUDANG.Domain.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class ShopRepositoryImpl implements ShopRepository{
    private JdbcTemplate jdbcTemplate;

    public ShopRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int save(Shop shop) {
        int result = jdbcTemplate.update(
                "INSERT INTO shop(sellerId,shopName,category,totalSeat,currentSeat,latitude,longitude,open) values(?,?,?,?,?,?,?,?)",
                ps -> {
                    ps.setString(1, shop.getSellerId());
                    ps.setString(2, shop.getShopName());
                    ps.setString(3, shop.getCategory());
                    ps.setInt(4, shop.getTotalSeat());
                    ps.setInt(5, shop.getCurrentSeat());
                    ps.setString(6, shop.getLatitude());
                    ps.setString(7, shop.getLongitude());
                    ps.setBoolean(8,shop.isOpen());
                });
        return result;
    }

    @Override
    public List<Shop> findAllShop() {
        List<Shop> shopList = jdbcTemplate.query("select * from shop", shopRowMapper());
        if(shopList.isEmpty()){
            log.info("가게 정보 없음");
        }
        return shopList;
    }

    @Override
    public List<Shop> findByName(String name) {
        List<Shop> shopList = jdbcTemplate.query("select * from shop where shopName = ?", shopRowMapper(), name);
        if(shopList.isEmpty()){
            return null;
        }else return shopList;
    }

    @Override
    public List<Shop> findByCategory(String category) {
        List<Shop> shopList = jdbcTemplate.query("select * from shop where category = ?", shopRowMapper(), category);
        if(shopList.isEmpty()){
            return null;
        }else return shopList;
    }

    @Override
    public int update(Shop shop) {
        return 0;
    }

    @Override
    public int delete(Shop shop) {
        return jdbcTemplate.update("delete from shop where sellerId = ?", shop.getSellerId());
    }


    private RowMapper<Shop> shopRowMapper(){
        return new RowMapper<Shop>() {
            @Override
            public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
                Shop shop = new Shop();
                shop.setSellerId(rs.getString("sellerId"));
                shop.setShopName(rs.getString("shopName"));
                shop.setCategory(rs.getString("category"));
                shop.setTotalSeat(rs.getInt("totalSeat"));
                shop.setCurrentSeat(rs.getInt("currentSeat"));
                shop.setLatitude(rs.getString("latitude"));
                shop.setLongitude(rs.getString("longitude"));
                shop.setOpen(rs.getBoolean("open"));
                return null;
            }
        };
    }

}

