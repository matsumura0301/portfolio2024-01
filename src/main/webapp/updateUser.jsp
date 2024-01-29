<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="userControll.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー変更画面</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        h3 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<a href="admin.jsp" class="btn">管理者ページにもどる</a>
      

<table class="table table-striped table-bordered">
	<tr>
		<td>変更対象ユーザー
	</tr>
	<tr>
		<th>ユーザーID</th>
		<td>${getUser.userId}</td>
	</tr>
	<tr>
		<th>ユーザー名</th>
		<td>${getUser.userName}</td>
	</tr>
	<tr>
		<th>パスワード</th>
		<td>${getUser.password}</td>
	</tr>
	<tr>
		<th>ポジション</th>
		<td>${getUser.position}</td>
	</tr>
</table>

    
	<form action="UpdateUserServlet" method="get">
		<table>
			<tr>
				<%--ユーザーIDは隠してサーブレットに情報を転送する --%>
				<input type="hidden" name="userId" value="${getUser.userId}">
				<th>ユーザー名</th>
					<td><input type="text" name="userName" pattern="[a-zA-z]+" id="userNameInput"></td>
				<th>パスワード</th>
					<td><input type="password" name="password" pattern="[a-zA-Z0-9]+" id="passwordInput"></td>
				<th>ポジション</th>
					<td>
						<select name="position" id="positionSelect" >
							<option value="admin">admin</option>
        					<option value="ope">ope</option>
    					</select>
					</td>
			</tr>
			<tr>
				<td><input type="submit" value="ユーザー情報変更"></td>
			</tr>
		</table>
	</form>
	
<script>
   	// JavaScriptで動的なデフォルト値を設定
	document.getElementById("userNameInput").value = "${getUser.userName}";
   	document.getElementById("passwordInput").value = "${getUser.password}";

   	var positionValue = "${getUser.position}";
	if (positionValue) {document.getElementById("positionSelect").value = positionValue;}
</script>	
	
	<c:if
		test="${requestScope.alert != null && requestScope.alert != ''}">
		<tr>
			<td>
				<c:out value="${requestScope.alert}"/>
			</td>
		</tr>
	</c:if>
</body>
</html>