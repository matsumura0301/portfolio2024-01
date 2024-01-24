<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Date,java.util.ArrayList"%>
<%@ page import="databaseControll.DatabaseDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章一覧</title>
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
	<h3>文章一覧</h3>
<a href="admin.jsp" class="btn">管理者ページにもどる</a>	
	<%-- サーブレットから渡されたArrayList（"sentenceDataList"）を取得 --%>
    <%
        ArrayList<DatabaseDTO> sentenceDataList = (ArrayList<DatabaseDTO>) request.getAttribute("sentenceDataList");
    %>
	
	
	<c:forEach  var="sentence" items="${sentenceDataList}">
		<table class="table table-striped table-bordered">
			<tr>
				<td>${sentence.sentenceId}</td>
			</tr> 
			<tr>
				<td>${sentence.sentenceName}</td>
			</tr> 
			<tr>
				<td>${sentence.sentenceMain}</td>
			</tr> 
			<tr>
				<td>${sentence.sentenceLine}</td>
			</tr> 
			<tr>
				<td>${sentence.sentenceKind}</td>
			</tr> 
			<tr>
				<td>${sentence.sentenceTemp}</td>
			</tr> 	
		</table>		
	</c:forEach>
</body>
</html>