package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;

import businessLogics.SuaBL;
import javaBeans.HangsuaBean;
import javaBeans.LoaiSuaBean;
import javaBeans.SuaBean;

@Controller
public class SuaController {
	@RequestMapping("/detail")
	public String chitietSua(@RequestParam(name = "maSua") String maSua, Model model)
	{
		List<SuaBean> sua = SuaBL.getsuaByMa(maSua);
		model.addAttribute("spdt", sua);
		return "detail-sua";
	}
	
	@RequestMapping(path = "/add-sua")
	public String themSua(Model model)
	{
        List<HangsuaBean> dshs = HangSuaBL.getListHang();
        List<LoaiSuaBean> dsls = LoaiSuaBL.getListLoai();
        model.addAttribute("dshs", dshs);
        model.addAttribute("dsls", dsls);
        return "add-sua";
	}
	
	@RequestMapping(path = "/add-sua", method = RequestMethod.POST)
	public String themSua(MultipartFile hinhAnh, HttpServletRequest request, Model model) throws IOException, ServletException
	{	
		String maSua,tenSua,maHang,maLoai,tpDinhDuong,loiIch;
		int trongLuong,donGia;
		SuaBean s = null;
		if(request.getParameter("btnThemMoi")!=null)
		{
			maSua = request.getParameter("maSua");
			tenSua = request.getParameter("tenSua");
			maHang =  request.getParameter("maHang");
			maLoai = request.getParameter("maLoai");
			tpDinhDuong = request.getParameter("tpdinhDuong");
			loiIch = request.getParameter("loiIch");
			trongLuong = Integer.parseInt(request.getParameter("trongLuong"));
			donGia = Integer.parseInt(request.getParameter("donGia"));
			
			s = new SuaBean();
			s.setMaSua(maSua);
			s.setTenSua(tenSua);
			s.setMahangSua(maHang);
			s.setMaloaiSua(maLoai);
			s.setTpdinhDuong(tpDinhDuong);
			s.setLoiIch(loiIch);
			s.setDonGia(donGia);
			s.setTrongLuong(trongLuong);
			
			//upload file
				String tentaptin = hinhAnh.getOriginalFilename();
				s.setHinhAnh(tentaptin);
				String duongDan = request.getServletContext().getRealPath("/images/");
				try {
					byte[] mb = hinhAnh.getBytes();
					OutputStream os = new FileOutputStream(duongDan +  tentaptin);
					os.write(mb);
					os.close();
				} catch (Exception e) {
					e.getStackTrace();
				} 
		}
		if(SuaBL.add(s)==1)
			model.addAttribute("tb", "Thêm thanh công");

		return "add-sua";
	}
	
	@RequestMapping(path = "/suabanchay")
	public String suabanChay(Model model)
	{
		List<SuaBean> sbc5 =  SuaBL.suabanChay(5);
    	List<SuaBean> sbc1 = SuaBL.getsuaByMa(sbc5.get(0).getMaSua());
    	model.addAttribute("sbcdt", sbc1);
		model.addAttribute("spbc",sbc5);
        return "sua-banchay";
	}
	
	@RequestMapping(path = "/suabanchay-detail")
	public String suabanChaydt(@RequestParam(name = "maSua") String maSua, Model model)
	{
		List<SuaBean> sbc =  SuaBL.suabanChay(5);
		model.addAttribute("spbc",sbc);
        List<SuaBean> dssbc = SuaBL.getsuaByMa(maSua);
        model.addAttribute("sbcdt", dssbc);
		
		return "sua-banchay";
	}
	
	@RequestMapping(path = "/find-sua")
	public String timSua(Model model)
	{
        List<HangsuaBean> dshs = HangSuaBL.getListHang();
        List<LoaiSuaBean> dsls = LoaiSuaBL.getListLoai();
        model.addAttribute("dshs", dshs);
        model.addAttribute("dsls", dsls);
        return "tim-sua";
	}
	
	@RequestMapping(path = "/find-sua", method = RequestMethod.POST)
	public String timSua(Model model, HttpServletRequest request)
	{
		String maHang, maLoai, tenSua;
		maHang = request.getParameter("maHang");
		maLoai = request.getParameter("maLoai");
		tenSua = request.getParameter("tenSua");
		List<SuaBean> timSua = SuaBL.TimTheoLoaiHangTen(maLoai, maHang, tenSua);
		List<HangsuaBean> hs = HangSuaBL.doctheoHang(maHang);
		model.addAttribute("sosp", timSua.size());
		model.addAttribute("dsS", timSua);
		model.addAttribute("hs", hs);
        return "tim-sua";
	}
	public static void main(String[] args) {
		List<SuaBean> sbc5 =  SuaBL.suabanChay(5);
    	List<SuaBean> sbc1 = SuaBL.getsuaByMa(sbc5.get(0).getMaSua());
    		for(SuaBean s:sbc1)
			System.out.println(s.getTenSua());

	}

}
