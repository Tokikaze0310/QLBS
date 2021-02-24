package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.HangsuaBean;

public class HangSuaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	static class Anhxadong implements RowMapper<HangsuaBean>{
		@Override
		public HangsuaBean mapRow(ResultSet rs, int numRow) throws SQLException {
			HangsuaBean s = new HangsuaBean();
 			s.setMaHang(rs.getString("Ma_hang_sua"));
 			s.setTenHang(rs.getString("Ten_hang_sua"));
 			s.setDiaChi(rs.getString("Dia_chi"));
 			s.setDienThoai(rs.getString("Dien_thoai"));
 			s.setEmail(rs.getString("Email"));
			return s;
		}	
	}
	
	public static List<HangsuaBean> getListHang()
	{
		String sql = "Select * from hang_sua";
		return jdbc.query(sql, new Anhxadong());
	}
	
	public static List<HangsuaBean> doctheoHang(String maHang)
	{
		String sql = "Select * from hang_sua where Ma_hang_sua = '"+maHang+"'";
		return jdbc.query(sql, new Anhxadong());
	}
	
	public static void main(String[] args) {
		List<HangsuaBean> hs = getListHang();
		for(HangsuaBean h:hs)
			System.out.println(h.getTenHang());

	}
}
