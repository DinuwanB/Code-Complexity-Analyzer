<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ITPM.ITPM.Calculation"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">Code Complexity Analyzer</a>
		</div>
		<a href="https://github.com/DinuwanB/Code-Complexity-Analyzer">
		<button class="btn btn" type="submit" id="inputGroupFileAddon04" >
			<i class="fab fa-github-square">GitHub</i>
		</button>
		</a>
	</nav>
	<br>
	
	
	<div class="container">

					<%
						Calculation itemObj = new Calculation();
						out.print(itemObj.SizeF());
					%>
					
					<br>
					
					<%
					Calculation itemObj2 = new Calculation();
					out.print(itemObj2.Variables());
					%>
					
					<br>
					
					<%
					Calculation itemObj3 = new Calculation();
					out.print(itemObj3.Methods());
					%>

</div>
</body>
</html>