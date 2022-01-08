<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert</title>
</head>
<body>
<center>
	<a href="index.html">HOME</a>&nbsp&nbsp&nbsp
	<a href="Edit.jsp">EDIT</a>&nbsp&nbsp&nbsp
	<a href="Display.jsp">DISPLAY</a>&nbsp&nbsp&nbsp<br>
	<form action="Edit" method="POST">
	<br>
		<input type="text" name="Uproll" placeholder="Enter rollno" /><br><br>
		<input type="submit" name="Submit1" value="Search" /> <br><br>
	</form>
	<form action="Edit" method="POST">

<% 
ArrayList<String> reqdata = (ArrayList<String>)request.getAttribute("data");
if(reqdata != null) {
%>

<input type="text" name="Name" placeholder="Enter name"
			value='<%= reqdata.get(0) %>' /><br><br> <input
			type="text" name="Roll" placeholder="Enter rollno"
			value='<%= reqdata.get(1) %>' readonly/><br><br> <input
			type="text" name="Age" placeholder="Enter Age"
			value='<%= reqdata.get(2) %>' /><br><br> <input
			type="text" name="dept" placeholder="Enter Department"
			value='<%= reqdata.get(3) %>' /><br><br> <input
			type="text" name="email" placeholder="Enter Email Id"
			value='<%= reqdata.get(4) %>' /><br><br> <input
			type="text" name="phno" placeholder="Enter Phone Number"
			value='<%= reqdata.get(5) %>' /><br><br>

<% }

else{
%>
<input type="text" name="Name" placeholder="Enter name"
			 /><br><br> <input
			type="text" name="Roll" placeholder="Enter rollno"
			readonly/><br><br> <input
			type="text" name="Age" placeholder="Enter Age"
			 /><br><br> <input
			type="text" name="dept" placeholder="Enter Department"
			 /><br><br> <input
			type="text" name="email" placeholder="Enter Email Id"
			 /><br><br> <input
			type="text" name="phno" placeholder="Enter Phone Number"
			
			 /><br><br>
<% } %>
	<input type="submit" name="Submit2" value="Update" />
	
	</form>
</center>
</body>
</html>