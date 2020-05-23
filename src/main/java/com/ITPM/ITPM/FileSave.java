package com.ITPM.ITPM;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload")
public class FileSave extends HttpServlet {
	
	private final String Upload_Directory = "D:\\Workspace\\23";
	public String data = "";


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//User Input files write to Directory

		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> multifiles = sf.parseRequest(request);

			for (FileItem item : multifiles) {
				String name = new File(item.getName()).getName();
				System.out.println(name);
				item.write(new File(Upload_Directory + File.separator + name));
				data = item.getString();

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		response.sendRedirect("Weight.jsp");  
	}

}
