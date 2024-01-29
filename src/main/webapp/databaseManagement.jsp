<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データベース管理画面</title>
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
	<table>
		<tr>
			<th>文章一覧</th>
			<td>
				<form action="DatabaseShowServlet" method="post">
					<input type="submit" value="表示">
				</form>
			</td>
		</tr>
		
		<%--文章登録機能 --%>
		<tr>
			<th>文章登録</th>
			<td>
				<form action="SentenceAddServlet" method="get">
					<table>
						<tr>
							<th>文章タイトル</th>
							<td><input type="text" name="sentenceName"  required></td>
							<th>本文</th>
							<td><input type="text" name="sentenceMain" required></td>
							<th>文章の位置</th>
							<td><input type="number" name="sentenceLine"  required></td>
							<th>文章の種類</th>
							<td><input type="text" name="sentenceKind"  required></td>
							<th>文章の熱量</th>
							<td>
								<select name="sentenceTemp" required >
									<option value="">選択してください</option>
									<option value="H">H</option>
        							<option value="N">N</option>
    							</select>
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="文章追加"></td>
						</tr>
					</table>
				</form>
			</td>
		<c:if
			test="${requestScope.addMessage != null && requestScope.addMessage != ''}">
		<tr>
			<td>
			<c:out value="${requestScope.addMessage}"/>
			</td>
		</tr>
		</c:if>
		<%--文章削除機能 --%>
		<tr>
			<th>文章削除</th>
			<td>
				<form action="SentenceDeleteServlet" method="post">
					<table>
						<tr>
							<th>文章ID</th>
							<td><input type="text" name="sentenceId" required></td>
							<th>文章タイトル</th>
							<td><input type="text" name="sentenceName" required></td>
						</tr>
						<tr>
							<td><input type="submit" value="文章削除"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	<c:if
		test="${requestScope.deleteAlert != null && requestScope.deleteAlert != ''}">
		<tr>
			<td>
			<c:out value="${requestScope.deleteAlert}"/>
			</td>
		</tr>
	</c:if>
		
		<%--文章データ変更機能 --%>
		<tr>
			<th>文章データ変更</th>
			<td>
				<form action="UpdateSentenceSearchServlet" method="post">
					<table>
						<tr>
							<td>変更したい文章のIDを入力してください
						</tr>
						<tr>
							<th>文章ID</th>
							<td><input type="number" name="sentenceId" required></td>
						</tr>
						<tr>
							<td><input type="submit" value="変更へ"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<a href="admin.jsp" class="btn">管理者ページにもどる</a>
</body>
</html>