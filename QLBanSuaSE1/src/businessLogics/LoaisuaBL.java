package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import businessLogics.CSDL;
import javaBeans.LoaiSuaBean;

public class LoaisuaBL {
	public static List<LoaiSuaBean> getListLoaiSua()
    {
    	 List<LoaiSuaBean> ListLoaiSua = null;
    	  try(Connection con = CSDL.getKetnoi()) {
    		 Statement stm = con.createStatement();
     		 String sql = "Select * from loai_sua";
     		 ResultSet rs = stm.executeQuery(sql);
     		 ListLoaiSua = new ArrayList<>();
     		 while(rs.next()){
              	LoaiSuaBean s = new LoaiSuaBean();
          		s.setMaLoai(rs.getString("Ma_loai_sua"));
          		s.setTenLoai(rs.getString("Ten_loai"));
          		ListLoaiSua.add(s);
              }
              con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    		 return ListLoaiSua;
    }
}
