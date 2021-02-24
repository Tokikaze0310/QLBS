<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<header>
	<tiles:insertAttribute name="dauTrang"/>
</header>
<section>
	<article>
		<tiles:insertAttribute name="noiDung"/>
	</article>
</section>
<footer>
	<tiles:insertAttribute name="cuoiTrang"/>
</footer>
</body>
</html>