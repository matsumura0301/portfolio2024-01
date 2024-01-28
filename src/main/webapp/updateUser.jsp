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
      
    <c:forEach var="user" items="${userDataList}">
        <table class="table table-striped table-bordered">
        	<tr>
        		<td>変更対象ユーザー
        	</tr>
            <tr>
                <th>ユーザーID</th>
                <td>${user.user_ID}</td>
            </tr>
            <tr>
                <th>ユーザー名</th>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <th>パスワード</th>
                <td>${user.password}</td>
            </tr>
            <tr>
                <th>役職</th>
                <td>${user.position}</td>
            </tr>
        </table>
    </c:forEach>
    
	<form action="UpdateUserServlet" method="get">
		<table>
			<tr>
				<th>ユーザー名</th>
					<td><input type="text" name="userName" pattern="[a-zA-z]" required></td>
				<th>パスワード</th>
					<td><input type="password" name="password" pattern="[a-zA-z]" required></td>
				<th>ポジション</th>
					<td><input type="text" name="position" pattern="(admin | ope)" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="ユーザー情報変更"></td>
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
</body>
</html>