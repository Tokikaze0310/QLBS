<%-- 
    Document   : them-khach-hang
    Author     : hv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="page5" class="main">
    <div class="col1 thuc-don" >
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
        <form name="frmThemKhachHang" action="add-kh" method="post">
        <table border="0">
            <thead>
                <tr>
                    <th colspan="4">THÊM KHÁCH HÀNG MỚI</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Mã KH</td>
                    <td><input type="text" name=makhachHang value="Mã KH" /></td>
                    <td>Tên KH</td>
                    <td><input type="text" name="tenkhachHang" value="Tên KH" /></td>
                </tr>
                <tr>
                    <td>Phái</td>
                    <td>
                        <input type="radio" name="gioiTinh" value = 0 />Nam
                        <input type="radio" name="gioiTinh" value = 1 />Nữ
                    </td>
                    <td>Địa chỉ</td>
                    <td><input type="text" name="diaChi" value="Địa chỉ" /></td>
                </tr>
                <tr>
                    <td>Điện thoại:</td>
                    <td><input type="text" name="dienThoai" value="Điện thoại" /></td>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="Email" /></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="submit" value="Thêm mới" name="btnThemMoi" />
                    </td>
                </tr>
            </tbody>
        </table>
        </form>        
    </div>
</div>