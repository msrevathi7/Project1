<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Actions</th>
        </tr>
        <%
            List<Employee> list = (List<Employee>) request.getAttribute("list");
            if (list != null) {
                for (Employee employee : list) {
        %>
        <tr>
            <td><%= employee.getEid() %></td>
            <td><%= employee.getEname() %></td>
            <td><%= employee.getPhono() %></td>
            <td>
                <a href="/delete/<%= employee.getEid() %>">Delete</a>
                <a href="/update/<%= employee.getEid() %>">Update</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>