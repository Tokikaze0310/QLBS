package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import businessLogics.HangsuaBL;
import businessLogics.LoaisuaBL;
import businessLogics.SuaBL;
import javaBeans.HangsuaBean;
import javaBeans.LoaiSuaBean;
import javaBeans.SuaBean;

@WebServlet("/ThemSuaMoiServlet")
@MultipartConfig
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemSuaMoiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HangsuaBean> dshs = HangsuaBL.getListHangSua();
        List<LoaiSuaBean> dsls = LoaisuaBL.getListLoaiSua();
		request.setAttribute("dshs", dshs);
		request.setAttribute("dsls", dsls);
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String maSua,tenSua,maHang,maLoai,tpDinhDuong,loiIch,hinh;
		String thongbao = null;
		int trongLuong,donGia;
		Part part = request.getPart("txtHinh");
		SuaBean s = null;
		if(request.getParameter("btnThemMoi")!=null)
		{
			maSua = request.getParameter("txtMaSua");
			tenSua = request.getParameter("txtTenSua");
			maHang =  request.getParameter("cboHangSua");
			maLoai = request.getParameter("cboLoaiSua");
			tpDinhDuong = request.getParameter("txtTPDinhDuong");
			loiIch = request.getParameter("txtLoiIch");
			trongLuong = Integer.parseInt(request.getParameter("txtTrongLuong"));
			donGia = Integer.parseInt(request.getParameter("txtDonGia"));
			hinh = part.getSubmittedFileName();
			
			s = new SuaBean();
			s.setMaSua(maSua);
			s.setTenSua(tenSua);
			s.setMahangSua(maHang);
			s.setMaloaiSua(maLoai);
			s.setTpdinhDuong(tpDinhDuong);
			s.setLoiIch(loiIch);
			s.setDonGia(donGia);
			s.setTrongLuong(trongLuong);
			s.setHinhAnh(hinh);
			
			//upload file
			String path = request.getServletContext().getRealPath("/images/");
			
			InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(path+hinh);
			byte[] mb = new byte[1024];
			int len=0;
			while((len=is.read(mb,0,1024))>0)
				os.write(mb, 0, len);
			is.close();
			os.close();
		}
			
			if(SuaBL.AddSua(s)){
				response.sendRedirect("trang-them-sua-moi.jsp");
				thongbao = "Da them sua thanh cong";
				PrintWriter pr = response.getWriter();
				pr.print(thongbao);
			}else {
				thongbao = "Da them sua that bai";
				PrintWriter pr = response.getWriter();
				pr.print(thongbao);
			}
			

//	public static void main(String[] args) {
//		SuaBean s = new SuaBean();
//		s.setMaSua("ml0001");
//		s.setTenSua("milo");
//		s.setMahangSua("DS");
//		s.setMaloaiSua("ST");
//		s.setTpdinhDuong("");
//		s.setLoiIch("");
//		s.setDonGia(15000);
//		s.setTrongLuong(100);
//		s.setHinhAnh("mili.jpg");
//
//		SuaBL.AddSua(s);
//	}
}
	}
