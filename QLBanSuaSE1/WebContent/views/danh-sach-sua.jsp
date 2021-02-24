<%-- 
    Document   : san-pham
    Author     : hv
--%>
<script type="text/javascript">
function getdsspmh(mh) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				document.getElementById("maLoai").style.display = 'none';
				document.getElementById("maHang").style.display = 'table-row-group';
		}
	};
	xhr.open("GET","DanhsachsuaAJAX?mh="+mh,true);
	xhr.send(); 	
}

function getdsspml(ml) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200){
				document.getElementById("maHang").style.display = 'none';
				document.getElementById("maLoai").style.display = 'table-row-group';
		}
	};
	xhr.open("GET","DanhsachsuaAJAX?ml="+ml,true);
	xhr.send();
}
</script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="col1">
        <p id="sp">Sản phẩm theo hãng sữa</p>
        <ul>
            <c:forEach items="${dshs}" var="hs">
                <li><a href="trang-chu.jsp?maHang=${hs.maHang}&trang=1">${hs.tenHang}</a></li>
<%--                 <li><a href="javascript:getdsspmh('${hs.maHang}')">${hs.tenHang}</a></li> --%>
            </c:forEach>
        </ul>
        <p>Sản phẩm theo loại</p>
        <ul>
            <c:forEach items="${dsls}" var="ls">
               <li><a href="trang-chu.jsp?maLoai=${ls.maLoai}&trang=1">${ls.tenLoai}</a></li>
<%--                <li><a href="javascript:getdsspml('${ls.maLoai}')">${ls.tenLoai}</a></li> --%>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="col21">
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
                <tbody id="maHang">
                    <c:forEach items="${dsspmh}" var="spmh">    
                    <tr>
                        <td style="text-align: center;"><img src="images/${spmh.hinhAnh}"/></td>
                        <td><a href="trang-thong-tin-sua.jsp?maSua=${spmh.maSua}">${spmh.tenSua}</a></td>
                        <td style="text-align: right;">${spmh.trongLuong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="${spmh.donGia}" var="donGia" type="number"></fmt:formatNumber>
                        <td style="text-align: right;">${donGia}</td>
                    </tr>
                    </c:forEach>
                </tbody>
                
				<tbody id="maLoai">
                    <c:forEach items="${dsspml}" var="spml">    
                    <tr>
                        <td style="text-align: center;"><img src="images/${spml.hinhAnh}"/></td>
                        <td><a href="trang-thong-tin-sua.jsp?maSua=${spml.maSua}">${spml.tenSua}</a></td>
                        <td style="text-align: right;">${spml.trongLuong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="${spml.donGia}" var="donGia" type="number"></fmt:formatNumber>
                        <td style="text-align: right;">${donGia}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="danh-sach-trang">
            <c:if test="${tongSoTrang>1}">
                <c:forEach var="i" begin="1" end="${tongSoTrang}" step="1">
                    <c:if test="${!empty param.maHang}">
                        <a href="trang-chu.jsp?maHang=${param.maHang}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${!empty param.maLoai}">
                        <a href="trang-chu.jsp?maLoai=${param.maLoai}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${empty param.maHang && empty param.maLoai}">
                        <a href="trang-chu.jsp?trang=${i}"> ${i} </a>
                    </c:if>
                </c:forEach>
            </c:if>
            </div>
        </div>
        <div class="col22">
            <%@include file="hinh-anh.html"%>
        </div>
    </div>
</div>