package javaBeans;

import java.io.Serializable;

public class KhachhangBean implements Serializable{
	private String makhachHang;
	private String tenkhachHang;
	private int gioiTinh;
	private String diaChi;
	private String dienThoai;
	private String Email;
	public KhachhangBean() {
		super();
	}
	public String getMakhachHang() {
		return makhachHang;
	}
	public void setMakhachHang(String makhachHang) {
		this.makhachHang = makhachHang;
	}
	public String getTenkhachHang() {
		return tenkhachHang;
	}
	public void setTenkhachHang(String tenkhachHang) {
		this.tenkhachHang = tenkhachHang;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
