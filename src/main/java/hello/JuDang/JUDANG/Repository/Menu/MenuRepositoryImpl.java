package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    private JdbcTemplate jdbcTemplate;

    public MenuRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Menu menu,int shopNum) {
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
        return null;
    }

    @Override
    public int update(Shop shop, Menu menu) {
        return 0;
    }

    @Override
    public int delete(Shop shop) {
        return 0;
    }
}
