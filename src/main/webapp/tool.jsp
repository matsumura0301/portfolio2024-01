<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.Date,java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メール作成画面</title>
</head>
<body>

<form action="ToolServlet" method="post">
	<table>
		<tr>
			<th> ご意見返信</th>
			<td> <input type="submit" value="作成">
		</tr>
	</table>
</form>
	 <%
        ArrayList<String> mail = (ArrayList<String>) request.getAttribute("mail");
     %>
     
		<c:if test="${sessionScope.mail != null}">
			<c:forEach var="mailSentence" items="${mail}" varStatus="loopStatus">
				<tr>
					<td>
						<c:out value="${mailSentence}"/>
						   <c:if test="${loopStatus.index != 2 && loopStatus.index != 3}">
                        		<br>
                        	</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>	

</body>
</html>
