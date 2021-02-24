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

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HangsuaBean> dshs = HangsuaBL.getListHangSua();
        List<LoaiSuaBean> dsls = LoaisuaBL.getListLoaiSua();
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String maHang, maLoai, tenSua;
        maHang = request.getParameter("cboHangSua");
        maLoai = request.getParameter("cboLoaiSua");
        tenSua = request.getParameter("txtTenSuaTim");
        
        List<HangsuaBean> dshs = HangsuaBL.getListHangSua();
        List<LoaiSuaBean> dsls = LoaisuaBL.getListLoaiSua();
        List<SuaBean> timSua = SuaBL.TimTheoLoaiHangTen(maLoai, maHang, tenSua);
        HangsuaBean hs = HangsuaBL.DocTheoMaHang(maHang);
        
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        request.setAttribute("soSp", timSua.size());
        request.setAttribute("dsS", timSua);
        request.setAttribute("hs", hs);
        
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}
	public static void main(String[] args) {
		List<HangsuaBean> dshs = HangsuaBL.getListHangSua();
		for(HangsuaBean s:dshs)
			System.out.println(s.getTenHang());
	}
}
