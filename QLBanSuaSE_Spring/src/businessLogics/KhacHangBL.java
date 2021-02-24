package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.KhachhangBean;

public class KhacHangBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	static class Anhxadong implements RowMapper<KhachhangBean>{
		@Override
		public KhachhangBean mapRow(ResultSet rs, int numRow) throws SQLException {
 			KhachhangBean s = new KhachhangBean();
 			s.setMakhachHang(rs.getString("Ma_khach_hang"));
 			s.setTenkhachHang(rs.getString("Ten_khach_hang"));
 			s.setGioiTinh(rs.getInt("Phai"));
 			s.setDiaChi(rs.getString("Dia_chi"));
 			s.setDienThoai(rs.getString("Dien_thoai"));
 			s.setEmail(rs.getString("Email"));
			return s;
		}
	}
	
	public static List<KhachhangBean> getListKH() {
		String sql = "Select * from Khach_hang";
		return jdbc.query(sql, new Anhxadong());
	}
	
	public static int addKH(KhachhangBean kh) {
		return jdbc.update("insert into Khach_hang(Ma_khach_hang,Ten_khach_hang,Phai,Dia_chi,Dien_Thoai,Email) values (?,?,?,?,?,?)",
				kh.getMakhachHang(),
				kh.getTenkhachHang(),
				kh.getGioiTinh(),
				kh.getDiaChi(),
				kh.getDienThoai(),
				kh.getEmail());
	}
}
