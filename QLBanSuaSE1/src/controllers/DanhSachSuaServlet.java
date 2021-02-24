package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangsuaBL;
import businessLogics.LoaisuaBL;
import businessLogics.SuaBL;
import javaBeans.HangsuaBean;
import javaBeans.LoaiSuaBean;
import javaBeans.SuaBean;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<HangsuaBean> dshs =  HangsuaBL.getListHangSua();
        
        List<LoaiSuaBean> dsls =  LoaisuaBL.getListLoaiSua();
        
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        
        String mahang = request.getParameter("maHang");
        String maloai = request.getParameter("maLoai");
        
        
        List<SuaBean> dsspmh = SuaBL.getListsuaByHang(mahang, -1, 0);
        List<SuaBean> dsspml = SuaBL.getListsuaByLoai(maloai, -1, 0);

        
        //phan trang
		int soDongTrang=5, tongSoTrangmh, tongSoTrangml;
		int nspmh = dsspmh.size();
		int nspml = dsspml.size();
		  
		tongSoTrangmh = nspmh/soDongTrang +(nspmh%soDongTrang!=0?1:0);
		tongSoTrangml = nspml/soDongTrang +(nspml%soDongTrang!=0?1:0);
		
        //load lần đâu
		if(request.getParameter("trang")==null)
		{
			HangsuaBean hs1 = dshs.get(0);
			
	    	request.setAttribute("tongSoTrang", tongSoTrangmh);
	    	request.setAttribute("maHang", hs1.getMaHang());
	    	List<SuaBean> dsspmh1 = SuaBL.getListsuaByHang(hs1.getMaHang(), 0, soDongTrang);
	    	request.setAttribute("dsspmh", dsspmh1);
	    	
		}
        //load lần đâu
		  
		if(request.getParameter("trang")!=null)
		{
			int trang = Integer.parseInt(request.getParameter("trang")) ;
			int vitri = (trang -1)*soDongTrang;
			List<SuaBean> dsspmhpage = SuaBL.getListsuaByHang(mahang, vitri, soDongTrang);
			List<SuaBean> dsspmlpage = SuaBL.getListsuaByLoai(maloai, vitri, soDongTrang);

			if(request.getParameter("maHang")!=null) {
				maloai = null;
				request.setAttribute("tongSoTrang", tongSoTrangmh);
				request.setAttribute("maHang", mahang);
				request.setAttribute("dsspml", dsspmlpage);
				request.setAttribute("dsspmh", dsspmhpage);
				
			}else if(request.getParameter("maLoai")!=null){
				mahang = null;
				request.setAttribute("tongSoTrang", tongSoTrangml);
				request.setAttribute("maLoai", maloai);
				request.setAttribute("dsspmh", dsspmhpage);
				request.setAttribute("dsspml", dsspmlpage);
			}	
		}

      //phan trang
        
        //request.setAttribute("dsspml", dsspml);
        request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public static void main(String[] args) {
		List<SuaBean> dsspml = SuaBL.getListsuaByLoai("SB", 1, 5);
		for(SuaBean s:dsspml)
			System.out.println(s.getTenSua());
	}
}
