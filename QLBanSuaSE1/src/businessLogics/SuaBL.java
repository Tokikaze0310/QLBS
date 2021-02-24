package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import businessLogics.CSDL;
import javaBeans.SuaBean;

public class SuaBL {
	public static List<SuaBean> getListsuaByHang(String maHang, int vitri, int soDongTrang)
    {
    	List<SuaBean> DSsuaByHang = null;
    	try (Connection ketNoi = CSDL.getKetnoi()) {
    		Statement stm = ketNoi.createStatement();
    		
    		if(vitri==-1 && soDongTrang==0)
    		{
    			String sql = "SELECT * FROM sua WHERE Ma_hang_sua = '"+maHang+"'";
       		 	ResultSet rs = stm.executeQuery(sql);
       		    DSsuaByHang = new ArrayList<>();
    			while(rs.next()){
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
                     DSsuaByHang.add(s);
    			}
    		}else {
    			String sql = "SELECT * FROM sua WHERE Ma_hang_sua = '"+maHang+"' LIMIT "+ vitri + "," + soDongTrang;
       		 	ResultSet rs = stm.executeQuery(sql);
       		    DSsuaByHang = new ArrayList<>();
    			while(rs.next()){
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
                     DSsuaByHang.add(s);
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return DSsuaByHang;
    }
	
	public static List<SuaBean> getListsuaByLoai(String maLoai, int vitri, int soDongTrang)
    {
    	List<SuaBean> DSsuaByLoai = null;
    	try (Connection ketNoi = CSDL.getKetnoi()) {
    		Statement stm = ketNoi.createStatement();
    		if(vitri==-1 && soDongTrang==0)
    		{
        		String sql = "SELECT * FROM sua WHERE Ma_loai_sua = '"+maLoai+"'";
       		 	ResultSet rs = stm.executeQuery(sql);
       		 	DSsuaByLoai = new ArrayList<>();
    			while(rs.next()){
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
                     DSsuaByLoai.add(s);
    			}
    		}else {
    			String sql = "SELECT * FROM sua WHERE Ma_loai_sua = '"+maLoai+"' LIMIT "+ vitri + "," + soDongTrang;
       		 	ResultSet rs = stm.executeQuery(sql);
       		 	DSsuaByLoai = new ArrayList<>();
    			while(rs.next()){
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
                     DSsuaByLoai.add(s);
    			}
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}
    	return DSsuaByLoai;
    }
	
	
	public static List<SuaBean> suaBanChay(int top){
		List<SuaBean> dsSuabanchay = null;
		try (Connection ketNoi = CSDL.getKetnoi()){
    		Statement stm = ketNoi.createStatement();
    		String sql = "SELECT *, sum(ct.So_luong) as tsl FROM sua s left join ct_hoadon ct on s.Ma_sua = ct.Ma_sua " + 
    				"group by 1 " + 
    				"order by tsl desc";
   		 	ResultSet rs = stm.executeQuery(sql);
   		 	dsSuabanchay = new ArrayList<>();
   		 	while(rs.next()){
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
	             dsSuabanchay.add(s);
	             dsSuabanchay = dsSuabanchay.stream().limit(top).collect(Collectors.toList());
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsSuabanchay;
	}
	
	public static SuaBean getListsuaByMa(String maSua)
    {
    	SuaBean DSsuaByMa = null;
    	try (Connection ketNoi = CSDL.getKetnoi()) {
    		Statement stm = ketNoi.createStatement();
    		String sql = "SELECT * FROM sua WHERE Ma_sua = '"+maSua+"'";
   		 	ResultSet rs = stm.executeQuery(sql);
   		    DSsuaByMa = new SuaBean();
			while(rs.next()){
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
                 DSsuaByMa = s;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return DSsuaByMa;
    }
	
    public static boolean AddSua(SuaBean sua)
    {
    	String sql = "insert into sua(ma_sua,ten_sua,ma_hang_sua,ma_loai_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values (?,?,?,?,?,?,?,?,?)";
    	try (Connection ketNoi = CSDL.getKetnoi()){
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, sua.getMaSua());
			pst.setString(2,sua.getTenSua());
			pst.setString(3, sua.getMahangSua());
			pst.setString(4, sua.getMaloaiSua());
			pst.setInt(5, sua.getTrongLuong());
			pst.setInt(6, sua.getDonGia());
			pst.setString(7,sua.getTpdinhDuong());
			pst.setString(8,sua.getLoiIch());
			pst.setString(9,sua.getHinhAnh());
			pst.executeUpdate();
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return true;
    }
    
	public static List<SuaBean> TimTheoLoaiHangTen(String maLoai, String maHang, String tenSua){
	    List<SuaBean> dsSua = null;
	    try (Connection con = CSDL.getKetnoi()){
	        PreparedStatement pst = con.prepareStatement("select * from sua where ma_loai_sua = ? and ma_hang_sua=? and ten_sua like ?");
	        pst.setString(1, maLoai);
	        pst.setString(2, maHang);
	        pst.setString(3, "%"+tenSua+"%");
	        ResultSet rs = pst.executeQuery();
	        dsSua = new ArrayList<>();
	        while(rs.next()){
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
	            dsSua.add(s);
	        }
	        con.close();
	    } catch (Exception e) {
	        throw new RuntimeException("Bao loi: "+e.getMessage());
	    }
	    return dsSua;
	}
    
	public static void main(String[] args) {
		List<SuaBean> dsSua = TimTheoLoaiHangTen("SB", "AB", "Ab");
		for(SuaBean s:dsSua)
			System.out.println(s.getTenSua());
	}
}
