<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="LoginServlet" method="post">
	<table>
		<tr>
			<th>ユーザー名</th>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td> <input type="submit" value="送信">
		</tr>
	</table>
</form>
	<c:if
		test="${requestScope.alert != null && requestScope.alert != ''}">
		<tr>
			<td>
				<c:out value="${requestScope.alert}"/>
			</td>
		</tr>
	</c:if>
<a href="admin.jsp" class="btn">管理者ページにもどる</a>
</body>
</html>