package javaBeans;

import java.io.Serializable;

public class SuaBean implements Serializable{
	private String maSua;
	private String tenSua;
	private String mahangSua;
	private String maloaiSua;
	private int trongLuong;
	private int donGia;
	private String tpdinhDuong;
	private String loiIch;
	private String hinhAnh;
	
	public SuaBean() {
		super();
	}
	
	
	public String getMaSua() {
		return maSua;
	}
	public void setMaSua(String maSua) {
		this.maSua = maSua;
	}
	public String getTenSua() {
		return tenSua;
	}
	public void setTenSua(String tenSua) {
		this.tenSua = tenSua;
	}
	public String getMahangSua() {
		return mahangSua;
	}
	public void setMahangSua(String mahangSua) {
		this.mahangSua = mahangSua;
	}
	public String getMaloaiSua() {
		return maloaiSua;
	}
	public void setMaloaiSua(String maloaiSua) {
		this.maloaiSua = maloaiSua;
	}
	public int getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getTpdinhDuong() {
		return tpdinhDuong;
	}
	public void setTpdinhDuong(String tpdinhDuong) {
		this.tpdinhDuong = tpdinhDuong;
	}
	public String getLoiIch() {
		return loiIch;
	}
	public void setLoiIch(String loiIch) {
		this.loiIch = loiIch;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}
