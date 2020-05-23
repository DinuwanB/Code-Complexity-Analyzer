package com.ITPM.ITPM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResultCal extends HttpServlet {
	String Upload_Directory = "D:\\Workspace\\23\\dinu2.java";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test a = new test();
		test.operatorsans(Upload_Directory);
	}

}
