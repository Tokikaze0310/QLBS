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
            <c:forEach items="${spbc}" var="sbc">
                <li><a href="suabanchay-detail?maSua=${sbc.maSua}">${sbc.tenSua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
		<c:forEach items="${sbcdt}" var="s"> 
            <tr>
                <td colspan="2" class="tieu-de-sua">${s.tenSua}</td>
            </tr>
            <tr>
                <td><img src="${pageContext.request.contextPath}/images/${s.hinhAnh}"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${s.tpdinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br>${s.loiIch}</p>
                    <fmt:formatNumber value="${s.donGia}" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> ${s.trongLuong} gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>