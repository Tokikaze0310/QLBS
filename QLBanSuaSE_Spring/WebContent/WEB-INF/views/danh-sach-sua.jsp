<%-- 
    Document   : san-pham
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="panel-left">
        <p id="sp">Sản phẩm theo hãng sữa</p>
        <ul class="list-cate-milk">
            <c:forEach items="${dshs}" var="hs">
                <li><a href="mahang?maHang=${hs.maHang}&trang=1">${hs.tenHang}</a></li>
            </c:forEach>
        </ul>
        <p>Sản phẩm theo loại</p>
        <ul class="list-cate-milk">
            <c:forEach items="${dsms}" var="ms">
               <li><a href="maloai?maLoai=${ms.maLoai}&trang=1">${ms.tenLoai}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="panel-content">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="content-main">
            <table border="1" width="100%">
                <caption>DANH SÁCH SỮA</caption>
                <thead>
                    <tr>
                        <th>Hình</th>
                        <th>Tên sữa</th>
                        <th>Trọng lượng</th>
                        <th>Đơn giá</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dssp}" var="sp">    
                    <tr>
                        <td style="text-align: center;"><img src="${pageContext.request.contextPath}/images/${sp.hinhAnh}"/></td>
                        <td><a href="detail?maSua=${sp.maSua}">${sp.tenSua}</a></td>
                        <td >${sp.trongLuong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="${sp.donGia}" var="donGia" type="number"></fmt:formatNumber>
                        <td>${donGia}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="danh-sach-trang">
            <c:if test="${tongSoTrang>1}">
                <c:forEach var="i" begin="1" end="${tongSoTrang}" step="1">
                    <c:if test="${!empty param.maHang}">
                        <a href="mahang?maHang=${param.maHang}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${!empty param.maLoai}">
                        <a href="maloai?maLoai=${param.maLoai}&trang=${i}"> ${i} </a>
                    </c:if>
<%--                     <c:if test="${empty param.maHang && empty param.maLoai}"> --%>
<%--                         <a href="trang-chu.jsp?trang=${i}"> ${i} </a> --%>
<%--                     </c:if> --%>
                </c:forEach>
            </c:if>
            </div>
       	 </div>
   		 </div>
     <div class="panel-right">
     <%@include file="hinh-anh.html"%>
 </div>
</div>