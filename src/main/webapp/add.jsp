<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="js/style.css"> 
<script type="text/javascript">
	function add() {
		$.post(
			"add.do",
			$("form").serialize(),
			function(data) {
				if(data){
					alert("添加成功");
					location.href="list.do";
				}
			},"json"
		);
	}
</script>
</head>
<body>
	<form action="">
		姓名:<input type="text" name="name">
		<input type="button" value="添加" onclick="add()">
	</form>
	
</body>
</html>