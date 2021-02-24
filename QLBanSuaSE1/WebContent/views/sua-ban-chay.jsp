<%-- 
    Document   : sua-ban-chay
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach items="${dsspbc}" var="spbc">
                <li><a href="trang-sua-ban-chay.jsp?maSua=${spbc.maSua}">${spbc.tenSua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
            <tr>
                <td colspan="2" class="tieu-de-sua"></td>
            </tr>
            <tr>
                <td><img src="images/${sbc.hinhAnh}"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${sbc.tpdinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br>${sbc.loiIch}</p>
                    <fmt:formatNumber value="${sbc.donGia}" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> ${sbc.trongLuong} gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>