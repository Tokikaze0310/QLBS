<%-- 
    Document   : them-sua-moi
    Author     : hv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include  file="thuc-don.jsp" %>
    </div>
    <div class="col2">
        <form name="frmThemSua" action="add-sua" method="post" enctype="multipart/form-data">
        <table border="0">
            <tbody>
                <tr>
                    <td>Mã sữa: </td>
                    <td><input type="text" name="maSua" value="Mã sữa" /></td>
                </tr>
                <tr>
                    <td>Tên sữa: </td>
                    <td><input type="text" name="tenSua" value="Tên sữa" /></td>
                </tr>
                <tr>
                    <td>Hãng sữa: </td>
                    <td><select name="maHang">
                            <c:forEach items="${dshs}" var="hs">
                            <option value="${hs.maHang}" ${(param.maHang!=null)?(param.maHang==hs.maHang?"selected":""):""}>${hs.tenHang}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Lọai sữa: </td>
                    <td><select name="maLoai">
                            <c:forEach items="${dsls}" var="ls">
                            <option value="${ls.maLoai}" ${(param.maLoai!=null)?(param.maLoai==ls.maLoai?"selected":""):""}>${ls.tenLoai}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Trọng lượng: </td>
                    <td><input type="text" name="trongLuong" value="Trọng lượng" /></td>
                </tr>
                <tr>
                    <td>Đơn giá: </td>
                    <td><input type="text" name="donGia" value="Đơn giá" /></td>
                </tr>
                <tr>
                    <td>TP dinh dưỡng: </td>
                    <td><textarea name="tpdinhDuong" rows="4" cols="20">
                            
                        </textarea></td>
                </tr>
                <tr>
                    <td>Lợi ích: </td>
                    <td><textarea name="loiIch" rows="4" cols="20">
                            
                        </textarea></td>
                </tr>
                <tr>
                    <td>Hình ảnh: </td>
                    <td><input type="file" name="hinhAnh" value="" width="50" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Thêm mới" name="btnThemMoi" />
                    </td>
                </tr>
            </tbody>
        </table>
                <p>${tb}</p>
        </form>                 
    </div>
</div>