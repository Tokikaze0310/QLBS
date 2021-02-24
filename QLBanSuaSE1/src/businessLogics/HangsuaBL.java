package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import businessLogics.CSDL;
import javaBeans.HangsuaBean;

public class HangsuaBL {
	public static List<HangsuaBean> getListHangSua()
    {
    	 List<HangsuaBean> ListHangSua = null;
    	 try(Connection con = CSDL.getKetnoi())
    	 {
    		 Statement stm = con.createStatement();
    		 String sql = "Select * from hang_sua";
    		 ResultSet rs = stm.executeQuery(sql);
    		 ListHangSua = new ArrayList<>();
    		 while(rs.next()){
    			HangsuaBean s = new HangsuaBean();
    			s.setMaHang(rs.getString("Ma_hang_sua"));
    			s.setTenHang(rs.getString("Ten_hang_sua"));
    			s.setDiaChi(rs.getString("Dia_chi"));
    			s.setDienThoai(rs.getString("Dien_thoai"));
    			s.setEmail(rs.getString("Email"));
         		ListHangSua.add(s);
             } 
    		 con.close();
    	 }catch (Exception e) {
     			// TODO: handle exception
     	 }
    	 return ListHangSua;
}
	
	public static HangsuaBean DocTheoMaHang(String maHang)
	{
		HangsuaBean s = null;
		try(Connection con = CSDL.getKetnoi())
   	 {
   		 PreparedStatement pst = con.prepareStatement("Select * from hang_sua where Ma_hang_sua like ?"); 
   		 pst.setString(1,maHang);

   		 ResultSet rs = pst.executeQuery();
   		 while(rs.next()){
   			s = new HangsuaBean();
   			s.setMaHang(rs.getString("Ma_hang_sua"));
   			s.setTenHang(rs.getString("Ten_hang_sua"));
   			s.setDiaChi(rs.getString("Dia_chi"));
   			s.setDienThoai(rs.getString("Dien_thoai"));
   			s.setEmail(rs.getString("Email"));
            }
            con.close();
   	 } catch (Exception e) {
			// TODO: handle exception
		}
   	 return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
