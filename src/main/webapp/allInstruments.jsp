<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.instruments.model.Instrument" %>
  <%@ page import="com.instruments.dao.InstrumentsDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Instrument> instruments=(ArrayList<Instrument>)InstrumentsDao.viewAllInstruments(); %>
<h1>Instrument List</h1>
<table>
<tr>
<th>Name</th>
<th>Price</th>
<th>Description</th>
<th>Category</th>
<th>Warrenty</th>
<% for(int x=0;x<instruments.size();x++) {  %>
    <% 
    Instrument a = (Instrument)instruments.get(x); 
    %>
<tr> 
<td><%out.print(a.getName()); %> </td>
<td><%out.print(a.getPrice()); %> </td>
<td><%out.print(a.getDes()); %> </td>
<td><%out.print(a.getCategory()); %> </td>
<td><%out.print(a.getWarrenty()); %> </td>
<td><a href="/Demo01/InstrumentUpdateServlet?ID=<% out.print(a.getId());%>">Edit</a></td>
<td><a href="/Demo01/InstrumentDeleteServlet?ID=<% out.print(a.getId());%>" onclick="return confirm('Are you sure you want to delete')">Delete</a></td>
</tr>

<% } %>
</table>
</body>
</html>