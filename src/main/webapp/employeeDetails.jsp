<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h1>Employee Details</h1>
    <%
        Employee employee = (Employee) request.getAttribute("employee");
        if (employee != null) {
    %>
    <p>ID: <%= employee.getEid() %></p>
    <p>Name: <%= employee.getEname() %></p>
    <p>Phone: <%= employee.getPhono() %></p>
    <%
        }
    %>
    <a href="/getall">Back to List</a>
</body>
</html>