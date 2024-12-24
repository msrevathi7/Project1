<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h1>Update Employee</h1>
    <form action="/update" method="post">
        <%
            Employee employee = (Employee) request.getAttribute("employee");
            if (employee != null) {
        %>
        <input type="hidden" name="eid" value="<%= employee.getEid() %>"/>
        <label for="ename">Name:</label>
        <input type="text" id="ename" name="ename" value="<%= employee.getEname() %>"/>
        <label for="phono">Phone:</label>
        <input type="text" id="phono" name="phono" value="<%= employee.getPhono() %>"/>
        <%
            }
        %>
        <input type="submit" value="Update"/>
    </form>
</body>
</html>