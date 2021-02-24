<%-- 
    Document   : thong-tin-sua
    Author     : hv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
        <table border="0" width="100%">
            <tr>
                <td colspan="2" class="tieu-de-sua">Sữa đang chọn</td>
            </tr>
            <tr>
                <td><img src="images/${tts.hinhAnh}"/></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${tts.tpdinhDuong}</p>
                    <p><b><i>Lợi ích:</i></b><br>${tts.loiIch}</p>
					<fmt:formatNumber value="${tts.donGia}" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> ${tts.trongLuong} gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>