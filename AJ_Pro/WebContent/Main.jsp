<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<c:if test="${!empty success}">
		<script type="text/javascript">
			alert('${success}');
		</script>
	</c:if>
<%-- 	<c:if test="${!empty login}"> --%>
<!-- 		<script type="text/javascript"> -->
<%--  			alert('${login}'); --%>
<!-- 		</script> -->
<%-- 	</c:if> --%>
	<h1>여행스케치</h1>
	<hr>
	<c:if test="${empty login}">
		<a href="MemberForm.jsp">회원가입</a>
		<a href="MemberLogin.jsp">로그인</a>
	</c:if>
	<c:if test="${!empty login}">
		<a href="MemberForm.jsp">회원가입</a>
		<a href="">로그아웃</a>
	</c:if>
</body>
</html>



<!-- flush true는  buffer를 비어준다는것. 그때그때마다 쏴주는것. -->
