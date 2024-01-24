<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ユーザー管理</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
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

        form {
            margin-bottom: 10px;
        }

        input {
            padding: 8px;
            margin: 5px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        p {
            color: #4caf50;
        }
    </style>
</head>
<body>
<a href="admin.jsp" class="btn">管理者ページにもどる</a>
	<table>
		<tr>
			<th>ユーザー一覧</th>
			<td>
				<form action="AllUserServlet" method="post">
					<input type="submit" value="表示">
				</form>
			</td>
		</tr>
		
		<%--ユーザー登録機能 --%>
		<tr>
			<th>ユーザー登録</th>
			<td>
				<form action="UserAddServlet" method="get">
					<table>
						<tr>
							<th>ユーザーID</th>
							<td><input type="text" name="user_id" required></td>
							<th>ユーザー名</th>
							<td><input type="text" name="userName" required></td>
							<th>パスワード</th>
							<td><input type="password" name="password" required></td>
							<th>ポジション</th>
							<td><input type="text" name="position" required></td>
						</tr>
						<tr>
							<td><input type="submit" value="ユーザー追加"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
			<%--もし直前に登録したデータがあれば表示する --%>
		<c:if test="${sessionScope.userAdd != null}">
			<tr>
				<td>
					<c:out value="${sessionScope.userAdd.userName}"/>
					<p>を追加しました</p>
				</td>
			</tr>
		</c:if>			
		</tr>
		<%--ユーザー削除機能 --%>
		<tr>
			<th>ユーザー削除</th>
			<td>
				<form action="UserDeleteServlet" method="post">
					<table>
						<tr>
							<th>ユーザー名</th>
							<td><input type="text" name="userName" required></td>
							<th>パスワード</th>
							<td><input type="password" name="password" required></td>
						</tr>
						<tr>
							<td><input type="submit" value="ユーザー削除"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
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