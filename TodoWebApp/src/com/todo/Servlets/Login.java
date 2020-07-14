package com.todo.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.DBServices.DBServices;
import com.todo.bean.Todo;
import com.todo.bean.User;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email").trim();
		String password = request.getParameter("password").trim();
		
		
		
		try {
			User user = (User) DBServices.getUserDetails(email, password);
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("name", user.getName());
				List<Todo> todos = DBServices.getTodoList((int)session.getAttribute("userId"));
				request.setAttribute("todos", todos);
				request.getRequestDispatcher("UserHome.jsp").forward(request, response);
				}else {
					request.setAttribute("mes2", "please Signup.");
					request.getRequestDispatcher("SignUp.jsp").forward(request , response); 
				}
			}
			catch (ClassNotFoundException | SQLException e) {
				errorMessage(request, response);
			}	
	}
		

	public static void errorMessage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setAttribute("message", "Sorry an Error Has Occured");
	request.setAttribute("link", "Login.jsp");
	request.getRequestDispatcher("errorPage.jsp").forward(request, response);
}

}
