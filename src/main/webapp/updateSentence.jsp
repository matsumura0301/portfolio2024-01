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
		<td>変更対象文章
	</tr>
	<tr>
		<th>文章ID</th>
		<td>${getData.sentenceId}</td>
	</tr>
	<tr>
		<th>文章タイトル</th>
		<td>${getData.sentenceName}</td>
	</tr>
	<tr>
		<th>本文</th>
		<td>${getData.sentenceMain}</td>
	</tr>
	<tr>
		<th>文章の位置</th>
		<td>${getData.sentenceLine}</td>
	</tr>
	<tr>
		<th>文章の種類</th>
		<td>${getData.sentenceKind}</td>
	</tr>
	<tr>
		<th>文章の熱量</th>
		<td>${getData.sentenceTemp}</td>
	</tr>
</table>

    
<form action="UpdateSentenceServlet" method="get">
			<input type="hidden" name="sentenceId" value="${getData.sentenceId}">
	<table>
		<tr>
			<th>文章タイトル</th>
				<td><input type="text" name="sentenceName" id="sentenceNameInput"></td>
			<th>本文</th>
				<td><input type="text" name="sentenceMain" id="sentenceMainInput" ></td>
			<th>文章の位置</th>
				<td><input type="number" name="sentenceLine" id="sentenceLineInput"></td>
			<th>文章の種類</th>
				<td><input type="text" name="sentenceKind" id="sentenceKindInput"></td>
			<th>文章の熱量</th>
				<td>
					<select name="sentenceTemp" id="sentenceTempSelect">
						<option value="H">H</option>
        				<option value="N">N</option>
    				</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="文章変更"></td>
			</tr>
	</table>
</form>	
<script>
   	// JavaScriptで動的なデフォルト値を設定
	document.getElementById("sentenceNameInput").value = "${getData.sentenceName}";
   	document.getElementById("sentenceMainInput").value = "${getData.sentenceMain}";
	document.getElementById("sentenceLineInput").value = "${getData.sentenceLine}";
   	document.getElementById("sentenceKindInput").value = "${getData.sentenceKind}";
   	
   	var sentenceTempValue = "${getData.sentenceTemp}";
	if (sentenceTempValue) {document.getElementById("sentenceTempSelect").value = sentenceTempValue;}
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