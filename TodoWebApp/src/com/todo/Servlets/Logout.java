package com.todo.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session != null) {
			session.removeAttribute("name");
			session.getMaxInactiveInterval();
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}else {
			errorPage(request, response);
			return;
		}
		
	}
	
	public static void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "Something Went Wrong");
		request.setAttribute("link", "Login.jsp");
		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	}

}
