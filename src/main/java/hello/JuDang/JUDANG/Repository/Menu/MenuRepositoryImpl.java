package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    private JdbcTemplate jdbcTemplate;

    public MenuRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Menu menu, int shopNum) {
        return jdbcTemplate.update(
                "insert into Menu values(?,?,?,?)",
                menu.getMenuNum(),
                shopNum,
                menu.getMenuName(),
                menu.getPrice()
        );
    }

    @Override
    public List<Menu> findAllMenu(int shopNum) {
        String sql = "select * from Menu where shopNum = ?";
        return jdbcTemplate.query(
                sql, new RowMapper<Menu>() {
                    @Override
                    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Menu menu = new Menu();
                        menu.setMenuName(rs.getString("menuName"));
                        menu.setPrice(rs.getInt("price"));
                        menu.setMenuNum(rs.getInt("menuNum"));
                        return menu;
                    }
                }, shopNum
        );
    }

    @Override
    public int updatePrice(Menu menu, Shop shop) {
        return jdbcTemplate.update("Update Menu set price = ? where shopNum = ? AND menuNum = ?",
                menu.getPrice(),
                shop.getShopNum(),
                menu.getMenuNum()
        );
    }

    @Override
    public int updateMenuName(Shop shop, Menu menu) {
        return jdbcTemplate.update("Update Menu set menuName = ? where shopNum = ? AND menuNum = ?",
                menu.getMenuName(),
                shop.getShopNum(),
                menu.getMenuNum()
        );
    }


    @Override
    public int delete(Shop shop, Menu menu) {
        return jdbcTemplate.update("Delete from Menu where menuNum = ? AND shopNum = ?", menu.getMenuNum(),shop.getShopNum());
    }
}
