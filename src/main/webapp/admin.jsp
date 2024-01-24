<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理者ページ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            text-align: center;
        }
        .card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            text-decoration: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>管理者画面</h1>

        <div class="card">
            <h2>ユーザー管理</h2>
            <p>ユーザーに関する操作を行います。</p>
            <a href="userManagement.jsp" class="btn">ユーザー管理ページへ</a>
        </div>

        <div class="card">
            <h2>データベース管理</h2>
            <p>データベースに関する操作を行います。</p>
            <a href="databaseManagement.jsp" class="btn">データベース管理ページへ</a>
        </div>

        <div class="card">
            <h2>ツール</h2>
            <p>ツールを起動します。</p>
            <a href="tool.jsp" target="_blank" class="btn">ツール画面へ</a>
        </div>
    </div>

</body>
</html>