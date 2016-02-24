<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>My Labs</title>
</head>
<body>
<%
    Map<String,String> labs = (Map<String,String>)request.getAttribute("labs");
%>
<h3>Login successful. Your labs:</h3>
<br>
<%
    for(Map.Entry<String,String> entry : labs.entrySet()) {
        String lab = entry.getKey();
        String link = entry.getValue();
%>
<br>
<a href="<%=link%>"><%=lab%></a>
<%}%>
</body>
</html>