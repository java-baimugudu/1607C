<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="js/style.css"> 
<script type="text/javascript">
//update 传参
//ajax{}传参失败
	function login(){
	var name=$("[name='name']").val();
	var pwd=$("[name='pwd']").val();
		$.post(
			"login.do",
		 	{'name':name,'pwd':pwd},   
			/*  $("form").serialize(), */
			function(data){
				console.log(data);
				if(data){
					alert("登录成功");
					location.href="list.do";
				}else{
					alert("登录失败");
					location.reload();
				}
			},"json"
		);
	}
</script>
</head>
<body>
	<form action="">
		姓名:<input type="text" name="name">
		密码:<input type="text" name="pwd">
		<input type="button" value="登录" onclick="login()">
	
	</form>
</body>
</html>