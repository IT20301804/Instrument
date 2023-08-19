<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.instruments.model.Instrument" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Instrument a=(Instrument)request.getAttribute("instrument"); %>
<h1>Instrument Details</h1>

<table border=1>
<tr>
<th>Property</th>
<th>Value</th>
<tr>
<tr>
<td>Name: </td>
<td><%out.print(a.getName()); %> </td>
</tr>
<tr>
<td>Price: </td>
<td><%out.print(a.getPrice()); %> </td>
</tr>
<tr>
<td>Description: </td>
<td><%out.print(a.getDes()); %> </td>
</tr>
<tr>
<td>Category: </td>
<td><%out.print(a.getCategory()); %> </td>
</tr>
<tr>
<td>Warrenty Period: </td>
<td><%out.print(a.getWarrenty()); %> </td>
</tr>
</table>
<a href="InstrumentAllViewServlet">View all Products</a>
</body>
</html>