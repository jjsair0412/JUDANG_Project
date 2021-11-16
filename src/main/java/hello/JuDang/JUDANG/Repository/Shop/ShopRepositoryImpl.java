package hello.JuDang.JUDANG.Repository.Shop;

import hello.JuDang.JUDANG.Controller.ControllerDomain.SearchWord;
import hello.JuDang.JUDANG.Domain.Category;
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
                "INSERT INTO shop(sellerId,shopName,category,totalSeat,currentSeat,twoSeats,fourSeats,sixSeats,eightSeats,latitude,longitude,open,phoneNumber,businessHours,htmlId) " +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                ps -> {
                    ps.setString(1, shop.getSellerId());
                    ps.setString(2, shop.getShopName());
                    ps.setString(3, shop.getCategory());
                    ps.setInt(4, shop.getTotalSeat());
                    ps.setInt(5, shop.getCurrentSeat());
                    ps.setInt(6,shop.getTwoSeats());
                    ps.setInt(7,shop.getFourSeats());
                    ps.setInt(8,shop.getSixSeats());
                    ps.setInt(9,shop.getEightSeats());
                    ps.setDouble(10, shop.getLatitude());
                    ps.setDouble(11, shop.getLongitude());
                    ps.setBoolean(12,shop.isOpen());
                    ps.setString(13,shop.getPhoneNumber());
                    ps.setString(14,shop.getBusinessHours());
                    ps.setString(15,shop.getHtmlId());
                });
        jdbcTemplate.update("INSERT into category(categoryName) values(?) ON DUPLICATE KEY UPDATE cnt = cnt+1",shop.getCategory());
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
                ("SELECT *,(6371*acos(cos(radians(?))*cos(radians(latitude))*cos(radians(longitude)-radians(?))+sin(radians(?))*sin(radians(latitude)))) AS distance FROM shop HAVING distance <= 1",
                shopRowMapper(), lat,lon,lat);
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
    public List<Category> ValidationCategory(String searchWord) {
        List<Category> categoryList =  jdbcTemplate.query("select * from category where categoryName = ?",
                new RowMapper<Category>() {
                    @Override
                    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Category category = new Category();
                        category.setCategoryName(rs.getString("categoryName"));
                        category.setCount(rs.getInt("cnt"));
                        return category;
                    }
                }, searchWord
        );
        return categoryList;
    }

    @Override // 테스트용 코드
    public int TESTINSERTCATEGORY(SearchWord searchWord) {
        return jdbcTemplate.update("insert into category(categoryName) values(?)",searchWord.getSearchWord());
    }

    @Override // 테스트용 코드
    public int TESTDELETECATEGORY(SearchWord searchWord) {
        return jdbcTemplate.update("delete from category where categoryName = ?",searchWord.getSearchWord());
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
                shop.setTwoSeats(rs.getInt("twoSeats"));
                shop.setFourSeats(rs.getInt("fourSeats"));
                shop.setSixSeats(rs.getInt("sixSeats"));
                shop.setEightSeats(rs.getInt("eightSeats"));
                shop.setLatitude(rs.getDouble("latitude"));
                shop.setLongitude(rs.getDouble("longitude"));
                shop.setOpen(rs.getBoolean("open"));
                shop.setPhoneNumber(rs.getString("phoneNumber"));
                shop.setBusinessHours(rs.getString("businessHours"));
                shop.setHtmlId(rs.getString("htmlId"));
                return shop;
            }
        };
    }

}

