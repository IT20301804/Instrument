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
 <div align="center">
  <h1>Update Instrument Form</h1>
  <form action="<%= request.getContextPath() %>/InstrumentUpdateServlet" method="post">
   <table style="with: 80%">
   <tr>
     <td>Id</td>
     <input type="text" name="id"  value=<%out.print(a.getId()); %> readonly />
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="name"  value=<%out.print(a.getName()); %> required/></td>
    </tr>
    <tr>
     <td>Price</td>
     <td><input type="text" name="price"  value=<%out.print(a.getPrice()); %> required/></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="des"  value=<%out.print(a.getDes()); %> required /></td>
    </tr>
    <tr>
     <td>Category</td>
     <td><input type="text" name="category"  value=<%out.print(a.getCategory()); %> required /></td>
    </tr>
    <tr>
     <td>Warrenty</td>
     <td><input type="text" name="warrenty"  value=<%out.print(a.getWarrenty()); %> required /></td>
    </tr>
    
   </table>
   <input type="submit" value="Update" />
  </form>
 </div>
</body>
</html>