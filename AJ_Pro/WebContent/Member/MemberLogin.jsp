<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="./etc/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("form").on("submit", function(event) {
		var userloginid = $("#loginid").val();
		var passwd = $("#passwd").val();
		
		if(userloginid.length == 0 || passwd.length == 0){
			console.log("submit defense");
			alert("아이디 및 비밀번호를 확인해주세요")
			event.preventDefault();
		}
	});
});
</script>

<form action="MemberLoginServlet" method="post">
아이디<input type="text" name="loginid" id="loginid"><br>
패스워드<input type="password" name="passwd" id="passwd"><br>
로그인<input type="submit" value="로그인">
</form>