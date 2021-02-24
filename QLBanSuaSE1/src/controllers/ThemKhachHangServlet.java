package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachhangBL;
import javaBeans.KhachhangBean;

@WebServlet("/ThemKhachHangServlet")
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemKhachHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String maKH, tenKH, diaChi, dienThoai, email;
        int phai;
        String thongbao = null;
        
        if(request.getParameter("btnThemMoi")!=null)
        {
            maKH = request.getParameter("txtMaKH");
            tenKH = request.getParameter("txtTenKH");
            phai = Integer.parseInt(request.getParameter("rdbPhai"));
            diaChi = request.getParameter("txtDiaChi");
            dienThoai = request.getParameter("txtDienThoai");
            email = request.getParameter("txtEmail");
            
            KhachhangBean kh = new KhachhangBean();
            kh.setMakhachHang(maKH);
            kh.setTenkhachHang(tenKH);
            kh.setGioiTinh(phai);
            kh.setDienThoai(dienThoai);
            kh.setDiaChi(diaChi);
            kh.setEmail(email);
            
            KhachhangBL.addKH(kh);
            
            thongbao = "Thêm thành công !";
        }
        request.setAttribute("tb", thongbao);
		request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

}
