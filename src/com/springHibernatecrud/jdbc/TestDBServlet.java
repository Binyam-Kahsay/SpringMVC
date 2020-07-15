package com.springHibernatecrud.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String user = "springstudent3";
		String password = "springstudent3";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&ServerTimeZone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
              		
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Database connecttion to : > \n"+jdbcUrl);
			
			Class.forName(driver);
			
		  Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
		   
		  out.println("\nsuccess!!!");
		  
		  //t1 //con //fetch from db into ui
		  
		  myConn.close();
		  
		  //t2 //insert from ui into db
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
		
		
		
	}

}
