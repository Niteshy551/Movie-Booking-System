<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Msg</title>
</head>
<body>

	<%
		String msg = (String) request.getAttribute("msg");
		String emsg = (String) request.getAttribute("emsg");
	%>
	<div class="msg">
		<%
			if (msg != null) {
		%>
		<span style='color: green'><%=msg%></span>
		<%
			}
		%>

		<%
			if (emsg != null) {
		%>
		<span style='color : Red'><%=emsg%></span>
		<%
			}
		%>

	</div>

</body>
</html>