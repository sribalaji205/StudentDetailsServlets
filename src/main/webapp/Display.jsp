<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<center>
	<a href="index.html">HOME</a>&nbsp&nbsp&nbsp
	<a href="Edit.jsp">EDIT</a>&nbsp&nbsp&nbsp
	<a href="Display.jsp">DISPLAY</a>&nbsp&nbsp&nbsp
	
	<form action="Display" method="POST">
	<br>
		<input type="text" name="rolldis" placeholder="Enter rollno" /><br><br>
		<input type="submit" name="Submit1" value="Search" /> <br>
	</form>
	<form action="Display" method="POST">
		<input type="submit" name="Submit2" value="Display All" /> <br>
	</form>
	<table border=1>
		<% 
ArrayList<String> reqdata1 = (ArrayList<String>)request.getAttribute("data1");

ArrayList<String> reqdata2 = (ArrayList<String>)request.getAttribute("data2");
if(reqdata1 != null) {
%>
		<tr>
			<th>NAME</th>
			<th>ROLL NO.</th>
			<th>AGE</th>
			<th>DEPARTMENT</th>
			<th>PHONE NUMBER</th>
			<th>EMAIL ID</th>
		</tr>

		<tr>
			<td><%= reqdata1.get(0) %></td>
			<td><%= reqdata1.get(1) %></td>
			<td><%= reqdata1.get(2) %></td>
			<td><%= reqdata1.get(3) %></td>
			<td><%= reqdata1.get(5) %></td>
			<td><%= reqdata1.get(4) %></td>
		</tr>
		<%
}
else
{
if(reqdata2!=null)
{
%>
		<tr>
			<th>NAME</th>
			<th>ROLL NO.</th>
			<th>AGE</th>
			<th>DEPARTMENT</th>
			<th>PHONE NUMBER</th>
			<th>EMAIL ID</th>
		</tr>

		<%
int i=0;
int len=reqdata2.size();
while(i<len){
String[] temp=reqdata2.get(i).split("#.@");
%>

		<tr>
			<td><%= temp[0] %></td>
			<td><%= temp[1] %></td>
			<td><%= temp[2] %></td>
			<td><%= temp[5] %></td>
			<td><%= temp[3] %></td>
			<td><%= temp[4] %></td>
		</tr>

		<% i++;
}
}
}
%>

	</table>
	</center>
</body>
</html>