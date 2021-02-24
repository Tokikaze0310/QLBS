package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.KhacHangBL;
import javaBeans.KhachhangBean;

@Controller
public class KhachHangController {		
	
	@RequestMapping(path = "/add-kh")
	public String themKH() {
		return "addkh";
	}
	@RequestMapping(path = "/add-kh", method = RequestMethod.POST)
	public String themKH(KhachhangBean kh) {
		KhacHangBL.addKH(kh);
		return "redirect:/add-kh";
	}
}
