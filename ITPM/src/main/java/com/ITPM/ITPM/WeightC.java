package com.ITPM.ITPM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/weight")
public class WeightC extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Keyword = request.getParameter("Keyword");
	    String Identifier = request.getParameter("Identifier");
	    String Operator = request.getParameter("Operator");
	    String Numericalvalue = request.getParameter("Numericalvalue");
	    String Stringliteral = request.getParameter("Stringliteral");
	    String Globalv = request.getParameter("Globalv");
	    String Localv = request.getParameter("Localv");
	    String Primitive = request.getParameter("Primitive");
	    String Composite = request.getParameter("Composite");
	    String primitivert = request.getParameter("primitivert");
	    String compositert = request.getParameter("compositert");
	    String voidrt = request.getParameter("voidrt");
	    String pparameter = request.getParameter("pparameter");
	    String cparameter = request.getParameter("cparameter");
	    
	    
	    
	    response.sendRedirect("Result.jsp"); 
		
	}

}