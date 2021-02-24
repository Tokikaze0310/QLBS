package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangsuaBean;
import javaBeans.LoaiSuaBean;
import javaBeans.SuaBean;

@Controller
public class TrangChuContrller {
	private int soDongTrang=5, tongSoTrang;
	@RequestMapping("/")
	public String home(Model model)
	{
		List<HangsuaBean> dshs = HangSuaBL.getListHang();
		List<LoaiSuaBean> dsms = LoaiSuaBL.getListLoai();

		List<SuaBean> dsspmh1 = SuaBL.getListsua();
		
		model.addAttribute("dssp",dsspmh1);
		
		model.addAttribute("dshs",dshs);
		model.addAttribute("dsms",dsms);
		return "home";
	}
	
	@RequestMapping("/mahang")
	public String maHang(@RequestParam Map<String,String> requestParams, Model model)
	{
		String maHang = requestParams.get("maHang");
		int trang = Integer.parseInt(requestParams.get("trang"));
		
		List<HangsuaBean> dshs = HangSuaBL.getListHang();
		List<LoaiSuaBean> dsms = LoaiSuaBL.getListLoai();
		
		List<SuaBean> dsspmh = SuaBL.getListsuaByHang(maHang, -1, 0);
		int nspmh = dsspmh.size();
		tongSoTrang = nspmh/soDongTrang +(nspmh%soDongTrang!=0?1:0);
		
		if(trang > 0) {
			int vitri = (trang -1)*soDongTrang;
			List<SuaBean> dsspmhpage = SuaBL.getListsuaByHang(maHang, vitri, soDongTrang);
			model.addAttribute("tongSoTrang", tongSoTrang);
			model.addAttribute("dssp", dsspmhpage);
		}
		
		model.addAttribute("dshs",dshs);
		model.addAttribute("dsms",dsms);
		return "home";
	}
	
	@RequestMapping("/maloai")
	public String maLoai(@RequestParam Map<String,String> requestParams, Model model)
	{
		List<HangsuaBean> dshs = HangSuaBL.getListHang();
		List<LoaiSuaBean> dsms = LoaiSuaBL.getListLoai();
		
		String maLoai = requestParams.get("maLoai");
		int trang = Integer.parseInt(requestParams.get("trang"));
		
		List<SuaBean> dsspml = SuaBL.getListsuaByLoai(maLoai, -1, 0);
		int nspml = dsspml.size();
		tongSoTrang = nspml/soDongTrang +(nspml%soDongTrang!=0?1:0);
		
		if(trang > 0) {
			int vitri = (trang -1)*soDongTrang;
			List<SuaBean> dsspmhpage = SuaBL.getListsuaByLoai(maLoai, vitri, soDongTrang);
			model.addAttribute("tongSoTrang", tongSoTrang);
			model.addAttribute("dssp", dsspmhpage);
		}
		
		model.addAttribute("dshs", dshs);
		model.addAttribute("dsms", dsms);
		return "home";
	}
	
	public static void main(String[] args) {
		List<SuaBean> dsspmhpage = SuaBL.getListsuaByLoai("SB", 0, 5);
		for(SuaBean sp:dsspmhpage)
			System.out.println(sp.getTenSua());
	}
}
