package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javaBeans.SuaBean;

public class SuaBL {
	private static JdbcTemplate jdbc = CSDL.getJdbc();
	static class Anhxadong implements RowMapper<SuaBean>{
		@Override
		public SuaBean mapRow(ResultSet rs, int numRow) throws SQLException {
			 SuaBean s = new SuaBean();
			 s.setMaSua(rs.getString("ma_sua"));
			 s.setTenSua(rs.getString("ten_sua"));
			 s.setMaloaiSua(rs.getString("ma_loai_sua"));
			 s.setMahangSua(rs.getString("ma_hang_sua"));
			 s.setTrongLuong(rs.getInt("trong_luong"));
			 s.setDonGia(rs.getInt("don_gia"));
			 s.setTpdinhDuong(rs.getString("tp_dinh_duong"));
			 s.setLoiIch(rs.getString("loi_ich"));
			 s.setHinhAnh(rs.getString("hinh"));
			 return s;
		}	
	}
	
	public static List<SuaBean> getListsuaByHang(String maHang, int vitri, int soDongTrang){
		if(vitri==-1 && soDongTrang==0) {
			String sql = "SELECT * FROM sua WHERE Ma_hang_sua = '"+maHang+"'";
			return jdbc.query(sql, new Anhxadong());
		}else {
			String sql = "SELECT * FROM sua WHERE Ma_hang_sua = '"+maHang+"' LIMIT "+ vitri + "," + soDongTrang;
			return jdbc.query(sql, new Anhxadong());
		}
	}
	
	public static List<SuaBean> getListsuaByLoai(String maLoai, int vitri, int soDongTrang){
		if(vitri==-1 && soDongTrang==0) {
			String sql = "SELECT * FROM sua WHERE Ma_loai_sua = '"+maLoai+"'";
			return jdbc.query(sql, new Anhxadong());
		}else {
			String sql = "SELECT * FROM sua WHERE Ma_loai_sua = '"+maLoai+"' LIMIT "+ vitri + "," + soDongTrang;
			return jdbc.query(sql, new Anhxadong());
		}
	}
	
	 public static List<SuaBean> getListsua(){
			String sql = "SELECT * FROM sua" ;
			return jdbc.query(sql, new Anhxadong());
	 }
	 
	 public static List<SuaBean> getsuaByMa(String maSua){
			String sql = "SELECT * FROM sua WHERE ma_sua = '"+maSua+"'" ;
			return jdbc.query(sql, new Anhxadong());
	 }
	 
	 public static int add(SuaBean sua) {
			return jdbc.update("insert into sua(ma_sua,ten_sua,ma_hang_sua,ma_loai_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values (?,?,?,?,?,?,?,?,?)",
					sua.getMaSua(),
					sua.getTenSua(),
					sua.getMahangSua(),
					sua.getMaloaiSua(),
					sua.getTrongLuong(),
					sua.getDonGia(),
					sua.getTpdinhDuong(),
					sua.getLoiIch(),
					sua.getHinhAnh());
	 }
	 
	 public static List<SuaBean> suabanChay(int top)
	 {
		 String sql = "SELECT *, sum(ct.So_luong) as tsl FROM sua s left join ct_hoadon ct on s.Ma_sua = ct.Ma_sua "+
				 	  "group by 1 "+
				      "order by tsl desc " +
				      "LIMIT "+ 0 + "," + top;
		 return jdbc.query(sql, new Anhxadong());
	 }
	 
	 public static List<SuaBean> TimTheoLoaiHangTen(String maLoai, String maHang, String tenSua) {
		 String sql = "select * from sua where ma_loai_sua = '"+maLoai+"' and ma_hang_sua = '"+maHang+"' and ten_sua like '%"+tenSua+"%'";
		 return jdbc.query(sql, new Anhxadong());
	 }	 
	 
	 public static void main(String[] args) {
		 List<SuaBean> s = TimTheoLoaiHangTen("SB", "AB", "ab");
		 for(SuaBean sp:s)
		 System.out.println(sp.getTenSua());
	}
}
