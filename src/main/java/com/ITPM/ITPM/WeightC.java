package com.ITPM.ITPM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/weight")
public class WeightC extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * get users weight input from Weight JSP Form 
		 * 
		 */
		
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
	    
	    /*
	     *  1. Define object using from Calculation java class 
	     *  2. Call Methods and input get weight Values
	     *  3. Send that values to Calculation methods
	     */
	    
	    Calculation object = new Calculation();
	    
	    String output1 = object.SizeF();
	    
	    response.getWriter().write(output1);
	    
	    Calculation object2 = new Calculation();
	    
	    String output2 = object2.Variables();
	    
	    response.getWriter().write(output2);
	    
	    Calculation object3 = new Calculation();
	    
	    String output3 = object3.Methods();
	    
	    response.getWriter().write(output3);
	    
	    response.sendRedirect("newReult.jsp"); 
		
	}

}
