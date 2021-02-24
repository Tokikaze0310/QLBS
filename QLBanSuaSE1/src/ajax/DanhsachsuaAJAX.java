package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javaBeans.SuaBean;
import businessLogics.SuaBL;

/**
 * Servlet implementation class DanhsachsuaAJAX
 */
@WebServlet("/DanhsachsuaAJAX")
public class DanhsachsuaAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhsachsuaAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String maHang, maLoai;
        maHang = request.getParameter("mh");
        maLoai = request.getParameter("ml");
        List<SuaBean> dsspmh = SuaBL.getListsuaByHang(maHang,-1,0);
        List<SuaBean> dsspml = SuaBL.getListsuaByLoai(maLoai,-1,0);
        
    	request.setAttribute("dsspmh", dsspmh);
        request.setAttribute("dsspml", dsspml);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		public static void main(String[] args) {
		List<SuaBean> dsspml = SuaBL.getListsuaByHang("DL", -1, 0);
		for(SuaBean s:dsspml)
			System.out.println(s.getTenSua());
	}
}
