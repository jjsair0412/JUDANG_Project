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
                "INSERT INTO shop(sellerId,shopName,category,totalSeat,currentSeat,latitude,longitude,open,htmlId) values(?,?,?,?,?,?,?,?,?)",
                ps -> {
                    ps.setString(1, shop.getSellerId());
                    ps.setString(2, shop.getShopName());
                    ps.setString(3, shop.getCategory());
                    ps.setInt(4, shop.getTotalSeat());
                    ps.setInt(5, shop.getCurrentSeat());
                    ps.setDouble(6, shop.getLatitude());
                    ps.setDouble(7, shop.getLongitude());
                    ps.setBoolean(8,shop.isOpen());
                    ps.setString(9,shop.getHtmlId());
                });
        return result;
    }

    @Override
    public Shop findById(int shopNum) {
        List<Shop> shopList = jdbcTemplate.query("SELECT * FROM shop WHERE id=?", shopRowMapper());
        Shop shop = shopList.get(0);
        return shop;
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
    public List<Shop> findNearShop(String lat, String lon) {
        List<Shop> shopList = jdbcTemplate.query
                ("SELECT *,(6371*acos(cos(radians(?))*cos(radians(latitude))*cos(radians(longitude)-radians(?))+sin(radians(?))*sin(radians(latitude)))) AS distance FROM shop HAVING distance <= 0.3",
                shopRowMapper(), lat,lon,lat);
        return shopList;
    }

    @Override
    public List<Shop> findByName(String name) {
        List<Shop> shopList = jdbcTemplate.query("select * from shop where shopName = ?", shopRowMapper(), name);
        log.info("이름 검색 = {}",shopList.get(0));
        if(shopList.isEmpty()){
            return null;
        }else return shopList;
    }

    @Override
    public List<Shop> findByCategory(String category) {
        List<Shop> shopList = jdbcTemplate.query("select * from shop where category = ?", shopRowMapper(), category);
        log.info("카테고리 검색 = {}",shopList.get(0));
        if(shopList.isEmpty()){
            return null;
        }else return shopList;
    }

    @Override
    public int update(Shop shop) {
        return jdbcTemplate.update("Update shop set open = ? where shopName = ? And sellerId = ? And htmlId = ?",
                shop.isOpen(),shop.getShopName(),shop.getSellerId(), shop.getHtmlId()
        );
    }


    @Override
    public int delete(Shop shop) {
        return jdbcTemplate.update("delete from shop where sellerId = ? AND shopNum=?", shop.getSellerId(),shop.getShopNum());
    }


    private RowMapper<Shop> shopRowMapper(){
        return new RowMapper<Shop>() {
            @Override
            public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
                Shop shop = new Shop();
                shop.setShopNum(rs.getInt("shopNum"));
                shop.setSellerId(rs.getString("sellerId"));
                shop.setShopName(rs.getString("shopName"));
                shop.setCategory(rs.getString("category"));
                shop.setTotalSeat(rs.getInt("totalSeat"));
                shop.setCurrentSeat(rs.getInt("currentSeat"));
                shop.setLeftSeat(rs.getInt("leftSeat"));
                shop.setLatitude(rs.getDouble("latitude"));
                shop.setLongitude(rs.getDouble("longitude"));
                shop.setOpen(rs.getBoolean("open"));
                shop.setHtmlId(rs.getString("htmlId"));
                return shop;
            }
        };
    }

}

