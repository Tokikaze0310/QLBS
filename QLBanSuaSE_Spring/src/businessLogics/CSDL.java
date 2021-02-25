package businessLogics;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CSDL {
	private static JdbcTemplate jdbc;
	public static JdbcTemplate getJdbc() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/qlbansua?useUnicode=true&characterEncoding=UTF-8");
		ds.setUsername("root");
		ds.setPassword("sonmatquy");
		jdbc = new JdbcTemplate(ds);
		return jdbc;
	}
}
