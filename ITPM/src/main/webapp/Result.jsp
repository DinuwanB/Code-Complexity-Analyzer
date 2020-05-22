<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page import="com.ITPM.ITPM.Variables"%>
<%@page import="com.ITPM.ITPM.Methods"%>
<%@page import="com.ITPM.ITPM.DuetoSize"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%

System.out.println("Button not clicked");
int s1 = 0;
int s2 = 0;
int s3 = 0;
int s4 = 0;
int s5 = 0;
int s6 = 0;

int v1 = 0;
int v2 = 0;
int v3 = 0;

int m1 = 0;
int m2 = 0;
int m3 = 0;
int m4 = 0;

//if(request.getParameter("btn-sub")!= null) {
	System.out.println("Button clicked");
	String Upload_Directory = "D:\\Workspace\\23\\dinu2.java";
String data = "";
try {
    File myObj = new File(Upload_Directory);
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
     data = myReader.nextLine();
      System.out.println(data);
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
	
	
	int result[] = DuetoSize.operatorsans(Upload_Directory);
	int result2[] = Methods.MethodController(Upload_Directory);
	int result3[] = Variables.VariableController(Upload_Directory);
	
	
	
	 s1 = result[3];
	 s2 = result[4]+result[5]+result[6];
	 s3 = result[0];
	 s4 = result[1];
	 s5 = result[2];
	 s6 = result[4]+ result[0]+ result[1]+ result[2]+result[3]+result[5]+result[6];
	 
	 
	 v1 = result3[0];
	 v2 = result3[1];
	 v3 = result3[0]+result3[1];
	 
	 m1 = result2[0]+result2[1];
	 m2 = result2[2];
	 m3 = result2[3];
	 m4 = result2[0]+result2[1]+result2[2]+result2[3];
	 
	 System.out.println(m4);
	 session.setAttribute("a1", s1);

	
	
%>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand" href="#">Code Complexity Analyzer</a>
		</div>
	</nav>
	<br>
	
	
	<div class="container">
	
	<div class="column">
	<div class="row">
<div class="col-md-4">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Due to Size</th>
      <th scope="col">Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Keywords</th>
      <td><%  out.print(s1);  %></td>
    </tr>
    <tr>
      <th scope="row">Identifiers</th>
      <td><%out.print(s2); %></td>    
    </tr>
    <tr>
      <th scope="row">Operators</th>
      <td><%out.print(s3); %></td>
    </tr>
    <tr>
      <th scope="row">Numerical Values</th>
      <td><%out.print(s4); %></td>
    </tr>
    <tr>
      <th scope="row">String Literals</th>
      <td><%out.print(s5); %></td>
    </tr>
    <tr>
      <th scope="row">Cs</th>
      <td><%out.print(s6); %></td>
    </tr>
  </tbody>
</table>
</div>
<div class="col-md-4">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Due to Variables</th>
      <th scope="col">Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Variable Scope</th>
      <td><%out.print("0"); %></td>
    </tr>
    <tr>
      <th scope="row"> Primitive Variables</th>
      <td><%out.print(v1); %></td>    
    </tr>
    <tr>
      <th scope="row">Composite Variables</th>
      <td><%out.print(v2); %></td>
    </tr>
    <tr>
      <th scope="row">Cv</th>
      <td><%out.print(v3); %></td>
    </tr>
  </tbody>
</table>
</div>
<div class="col-md-4">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Due to Methods</th>
      <th scope="col">Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Method Return Type</th>
      <td><%out.print(m1); %></td>
    </tr>
    <tr>
      <th scope="row">Primitive Data Type Parameters</th>
      <td><%out.print(m2); %></td>    
    </tr>
    <tr>
      <th scope="row">Composite Data Type Parameters</th>
      <td><%out.print(m3); %></td>
    </tr>
    <tr>
      <th scope="row">Cm</th>
      <td><%out.print(m4); %></td>
    </tr>
  </tbody>
</table>
</div>
</div>
</div>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Code</h1>

  
</div>
</div>
</div>
</body>
</html>