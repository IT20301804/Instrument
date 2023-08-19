<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Add Instrument Form</h1>
  <form action="<%= request.getContextPath() %>/InstrumentServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" required/></td>
    </tr>
    <tr>
     <td>Price</td>
     <td><input type="text" name="price" required/></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="des" required/></td>
    </tr>
    <tr>
     <td>Category</td>
     <td><input type="text" name="category" required/></td>
    </tr>
    <tr>
     <td>Warrenty</td>
     <td><input type="number" name="warrenty" required/></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>