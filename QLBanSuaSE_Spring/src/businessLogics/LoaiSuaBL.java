package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import businessLogics.HangSuaBL.Anhxadong;
import javaBeans.HangsuaBean;
import javaBeans.LoaiSuaBean;

public class LoaiSuaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	static class Anhxadong implements RowMapper<LoaiSuaBean>{
		@Override
		public LoaiSuaBean mapRow(ResultSet rs, int numRow) throws SQLException {
			LoaiSuaBean s = new LoaiSuaBean();
      		s.setMaLoai(rs.getString("Ma_loai_sua"));
      		s.setTenLoai(rs.getString("Ten_loai"));
			return s;
		}	
	}
	
	public static List<LoaiSuaBean> getListLoai()
	{
		String sql = "Select * from Loai_sua";
		return jdbc.query(sql, new Anhxadong());
	}
	
	public static void main(String[] args) {
		List<LoaiSuaBean> hs = getListLoai();
		for(LoaiSuaBean h:hs)
			System.out.println(h.getTenLoai());

	}
}
