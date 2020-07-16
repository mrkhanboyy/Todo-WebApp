package com.todo.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.DBServices.DBServices;
import com.todo.bean.User;


public class SignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name").trim();
		String email  = request.getParameter("email").trim();
		String password  = request.getParameter("password").trim();
		
		try {
			if(DBServices.checkEmail(email)) {
				request.setAttribute("mes", "email already exists.");
				request.getRequestDispatcher("SignUp.jsp").forward(request , response); 
				
				}else {
					User user = new User(name,email,password);
					DBServices.addUser(user);
					response.sendRedirect("Login.jsp");
				}
			}
			catch (ClassNotFoundException | SQLException e) {
				errorMessage(request, response);
			}	
	}
	
	
	public static void errorMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "Sorry an Error Has Occured");
		request.setAttribute("link", "SignUp.jsp");
		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	}

}
