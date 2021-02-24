package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javaBeans.KhachhangBean;

public class KhachhangBL {

	public static List<KhachhangBean> getlistKH()
	{
		List<KhachhangBean> dskh = null;
		try(Connection ketnoi = CSDL.getKetnoi()) {
			Statement stm = ketnoi.createStatement();
			String sql = "Select * from khach_hang";
			ResultSet rs = stm.executeQuery(sql);
			dskh = new ArrayList<>();
	   		 while(rs.next()){
	    			KhachhangBean s = new KhachhangBean();
	    			s.setMakhachHang(rs.getString("Ma_khach_hang"));
	    			s.setTenkhachHang(rs.getString("Ten_khach_hang"));
	    			s.setGioiTinh(rs.getInt("Phai"));
	    			s.setDiaChi(rs.getString("Dia_chi"));
	    			s.setDienThoai(rs.getString("Dien_thoai"));
	    			s.setEmail(rs.getString("Email"));
	    			dskh.add(s);
	             } 
	   		ketnoi.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return dskh;
	}
	
	public static void addKH(KhachhangBean kh)
	{
		String sql = "INSERT INTO khach_hang(Ma_khach_hang, Ten_khach_hang, Phai, Dia_chi, Dien_thoai, Email) values(?,?,?,?,?,?)";
		try(Connection ketnoi = CSDL.getKetnoi()) {
			PreparedStatement pst = ketnoi.prepareStatement(sql);
			pst.setString(1, kh.getMakhachHang());
			pst.setString(2, kh.getTenkhachHang());
			pst.setInt(3, kh.getGioiTinh());
			pst.setString(4, kh.getDiaChi());
			pst.setString(5, kh.getDienThoai());
			pst.setString(6, kh.getEmail());
			pst.execute();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
