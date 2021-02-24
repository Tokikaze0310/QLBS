<%-- 
    Document   : thong-tin-sua
    Author     : hv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
        <table border="0" width="100%">
        <c:forEach items="${spdt}" var="sp">
            <tr>
                <td colspan="2" class="tieu-de-sua">${sp.tenSua}</td>
            </tr>
            <tr>
                <td><img src="${pageContext.request.contextPath}/images/${sp.hinhAnh}"/></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br> ${sp.tpdinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br> ${sp.loiIch}</p>
                    <fmt:setLocale value="vi-VN"></fmt:setLocale>
                    <fmt:formatNumber value="${sp.donGia}" var="donGia" type="number"></fmt:formatNumber>
                    <p><b><i>Trọng lượng:</i></b> ${sp.trongLuong} gr - <b><i>Đơn giá: ${donGia}</i></p>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
</div>