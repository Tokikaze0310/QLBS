<%-- 
    Document   : them-khach-hang
    Author     : hv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div id="page5" class="main">
    <div class="col1 thuc-don" >
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
        <form name="frmThemKhachHang" action="trang-them-khach-hang.jsp" method="post">
        <table border="0">
            <thead>
                <tr>
                    <th colspan="4">THÊM KHÁCH HÀNG MỚI</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Mã KH</td>
                    <td><input type="text" name="txtMaKH" value="" placeholder="Mã khách hàng"/></td>
                    <td>Tên KH</td>
                    <td><input type="text" name="txtTenKH" value="" placeholder="Tên khách hàng" /></td>
                </tr>
                <tr>
                    <td>Phái</td>
                    <td>
                        <input type="radio" name="rdbPhai" value="0"/>Nam
                        <input type="radio" name="rdbPhai" value="1" />Nữ
                    </td>
                    <td>Địa chỉ</td>
                    <td><input type="text" name="txtDiaChi" value="" placeholder="Địa chỉ"/></td>
                </tr>
                <tr>
                    <td>Điện thoại:</td>
                    <td><input type="text" name="txtDienThoai" value="" placeholder="Điện thoại" /></td>
                    <td>Email:</td>
                    <td><input type="text" name="txtEmail" value="" placeholder="Email" /></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="submit" value="Thêm mới" name="btnThemMoi" />
                    </td>
                </tr>
                <c:if test="${tb!=null}">
                	<tr>
	                    <td colspan="2" style="color:red;text-align:center;">${tb}</td>
	                </tr>
                </c:if>
            </tbody>
        </table>
        </form>        
    </div>
</div>