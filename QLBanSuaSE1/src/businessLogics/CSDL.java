package businessLogics;

import java.sql.DriverManager;

import java.sql.Connection;

public class CSDL {
	private static Connection ketnoi;
	public static Connection getKetnoi()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbansua?useUnicode=true&characterEncoding=utf8";
			ketnoi = DriverManager.getConnection(url, "root","Fatestaynight1");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ketnoi;
	}
	public static void main(String[] args) {
		if(CSDL.getKetnoi() != null)
			System.out.print("Thanh cong");		
	}
}
