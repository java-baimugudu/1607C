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
$(function(){
	//回显
	var id ="${param.id}";
	$.post(
		"huixian.do",
		{id:id},
		function(data){
			$("[name='name']").val(data.name);
			$("[name='sex'][value='"+data.sex+"']").attr("checked",true);
		},"json"
	);
})
	function update() {
		$.post(
			"update.do",
			$("form").serialize(),
			function(data) {
				if(data){
					alert("修改成功");
					location.href="list.do";
				}
			},"json"
		);
	}
</script>
</head>
<body>
	<form action="">
		<input type="hidden" name="id" value="${param.id}">
		姓名:<input type="text" name="name">
			<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女
		<input type="button" value="修改" onclick="update()">
	</form>
	
</body>
</html>