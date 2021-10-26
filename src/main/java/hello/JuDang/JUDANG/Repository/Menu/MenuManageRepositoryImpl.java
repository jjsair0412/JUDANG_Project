package hello.JuDang.JUDANG.Repository.Menu;

import hello.JuDang.JUDANG.Domain.Menu;
import hello.JuDang.JUDANG.Domain.Shop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class MenuManageRepositoryImpl implements MenuManageRepository{
    private JdbcTemplate jdbcTemplate;

    public MenuManageRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Menu menu,String sellerId) {
        int result = jdbcTemplate.update(" ", menu.getMenuName(), menu.getPrice());
        return result;
    }

    @Override
    public List<Menu> findAllMenu(String sellerId) {
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
