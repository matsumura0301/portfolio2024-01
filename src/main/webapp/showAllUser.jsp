<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Date, java.util.ArrayList" %>
<%@ page import="userControll.UserDTO" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー一覧</title>
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
    <h3>ユーザー一覧</h3>
    
    <%-- サーブレットから渡されたArrayList（"userDataList"）を取得 --%>
    <%
        ArrayList<UserDTO> userDataList = (ArrayList<UserDTO>) request.getAttribute("userDataList");
    %>
    
    <c:forEach var="user" items="${userDataList}">
        <table class="table table-striped table-bordered">
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
</body>
</html>