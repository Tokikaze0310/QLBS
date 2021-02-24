package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;
import javaBeans.SuaBean;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaBanChayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<SuaBean> dsspbc = SuaBL.suaBanChay(5);
        request.setAttribute("dsspbc", dsspbc);
        
        String masua = request.getParameter("maSua");
        if(masua == null)
        {
        	SuaBean first = dsspbc.get(0);
        	SuaBean spbc = SuaBL.getListsuaByMa(first.getMaSua());
        	request.setAttribute("sbc", spbc);
        }else {
            SuaBean spbc = SuaBL.getListsuaByMa(masua);
            request.setAttribute("sbc", spbc);
        }
        request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
