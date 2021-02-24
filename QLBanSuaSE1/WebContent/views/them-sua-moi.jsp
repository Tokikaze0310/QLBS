<%-- 
    Document   : them-sua-moi
    Author     : hv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function thongbao() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
				if(this.readyState == 4 && this.status == 200){
				var tb = this.responseText;
				var ob = document.getElementById("chao");
				ob.innerHTML = tb;
			}
		};
		xhr.open("POST","ThemSuaMoiServlet");
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send();
	}
</script>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include  file="thuc-don.jsp" %>
    </div>
    <div class="col2">
        <form name="frmThemSua" action="ThemSuaMoiServlet" method="POST" enctype="multipart/form-data" id="addMilk">
        <table border="0">
            <tbody>
                <tr>
                    <td>Mã sữa: </td>
                    <td><input type="text" name="txtMaSua" value="" placeholder="Mã sữa" 
                    			required="required"  />
                    			</td>    
                </tr>
                <tr>
                    <td>Tên sữa: </td>
                    <td><input type="text" name="txtTenSua" value="" placeholder="Tên sữa" /></td>
                </tr>
                <tr>
                    <td>Hãng sữa: </td>
                    <td><select name="cboHangSua">
                            <c:forEach items="${dshs}" var="hs">
                            <option value="${hs.maHang}" ${(param.cboHangSua!=null)?(param.cboHangSua==hs.maHang?"selected":""):""}>${hs.tenHang}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Lọai sữa: </td>
                    <td><select name="cboLoaiSua">
                            <c:forEach items="${dsls}" var="ls">
                            <option value="${ls.maLoai}" ${(param.cboLoaiSua!=null)?(param.cboLoaiSua==ls.maLoai?"selected":""):""}>${ls.tenLoai}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Trọng lượng: </td>
                    <td><input type="text" name="txtTrongLuong" value="" placeholder="Trọng lượng" /></td>
                </tr>
                <tr>
                    <td>Đơn giá: </td>
                    <td><input type="text" name="txtDonGia" value="" placeholder="Đơn gia" /></td>
                </tr>
                <tr>
                    <td>TP dinh dưỡng: </td>
                    <td><textarea name="txtTPDinhDuong" rows="4" cols="20" placeholder="Thành phần dinh dưỡng">
                    </textarea></td>
                </tr>
                <tr>
                    <td>Lợi ích: </td>
                    <td><textarea name="txtLoiIch" rows="4" cols="20" placeholder="Lợi ích">
                    </textarea></td>
                </tr>
                <tr>
                    <td>Hình ảnh: </td>
                    <td><input type="file" name="txtHinh" value="" width="50" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Thêm mới" name="btnThemMoi" onclick="ThemSuaMoiServlet"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <div id="chao" style="color: red;"></div>
        </form>                 
    </div>
</div>