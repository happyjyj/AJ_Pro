<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<script type="text/javascript" src="./etc/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("form").on("submit", function(event) {
		console.log("asdsdfasdfsf");
		var userloginid = $("#userloginid").val();
		var passwd = $("#passwd").val();
		var email = $("#email").val();
		var phone = $("#phone").val();
		
		if(userloginid.length == 0 || passwd.length == 0 || email.length == 0 || phone.length == 0){
			console.log("submit defense");
			alert("*가 있는 부분은 반드시 입력해주셔야해요!")
			event.preventDefault();
		}
	});
});
</script>

<form action="MemberJoinServlet" method="post" enctype="multipart/form-data">
*아이디<input type="text" name="userloginid" id="userloginid">
<span id="resultid"></span><br>
*비밀번호<input type="password" name="passwd" id="passwd"><br>
이름<input type="text" name="username" id="username"><br>
*이메일<input type="email" name="email" id="email" placeholder="직접 입력하세요">
<span id="resultemail"></span><br>
*휴대폰<input type="text" name="phone" id="phone" placeholder="- 없이 입력하세요"><br>
<span id="resultphone"></span><br>
유져사진<input type="file" name="userphoto"><br>
커버사진<input type="file" name="userbackgroundphoto"><br>
	<input type="submit" value="회원가입">
	<input type="reset" value="전체 취소 및 재입력">
</form>
