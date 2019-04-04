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
	function toAdd() {
		location.href="add.jsp";
	}
	
	function toUpdate(id) {
		location.href="update.jsp?id="+id;
	}
	function del(id){
		$.post(
			"del.do",
			{id:id},
			function(data) {
				if(data){
					alert("删除成功");
					location.reload();
				}
			}
		);
	}
</script>
</head>
<body>
<form action="" method="post">
	<input type="text" name="name" value="${name}">
	<input type="submit" value="查询">

	<table>
		<tr>
			<td>选择</td>
			<td>编号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>性别</td>
			<td>学校</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="l">
			<tr>
				<td>
					<input type="checkbox" value="${l.id}" name="ck">
				</td>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td>${l.pwd}</td>
				<td>${l.sex}</td>
				<td>${l.school}</td>
				<td>
					<input type="button" value="删除" onclick="del(${l.id})">
					<input type="button" value="添加" onclick="toAdd()">
					<input type="button" value="修改" onclick="toUpdate(${l.id})">
				</td>
			</tr>
		</c:forEach>
	</table>
	${user.pageStr}
	</form>
</body>
</html>