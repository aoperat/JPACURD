<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/admin/update" method="post">
		<input type="hidden" value="${user.id}" name="id" />
		<input type="text" value="${user.username}" readonly="readonly" /> <br />
		<select name="role">
			<option value="user" id="user">user</option>
			<option value="admin" id="admin">admin</option>
		</select> <br/>
		<input type="submit" value="변경" />
	</form>

<script>
function changeSelect(){
    var role = document.getElementById(${user.role});
     
    // select element에서 선택된 option의 value가 저장된다.
    var selectValue = role.options[role.selectedIndex].selected=selected;
 
}
</script>
</body>
</html>