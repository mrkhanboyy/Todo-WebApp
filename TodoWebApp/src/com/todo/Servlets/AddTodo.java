package com.todo.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.DBServices.DBServices;
import com.todo.bean.Todo;

public class AddTodo extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      
    
	/**
	 * This method fetches three parameters (subject, description, date) from request
	 * coming from AddTodo.jsp.   
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject").trim();
		String description = request.getParameter("description").trim();
		String date = request.getParameter("date").toString().trim();
		
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		
		Todo todo = new Todo();
		todo.setSubject(subject);
		todo.setDescription(description);
		todo.setUserId(userId);
		todo.setDate(date);
		
		try {
			DBServices.addTodo(todo);
			
			List<Todo> todos = DBServices.getTodoList((int)session.getAttribute("userId"));
			request.setAttribute("todos", todos);
			request.getRequestDispatcher("UserHome.jsp").forward(request, response);
			
		}catch(Exception e) {
			errorMessage(request, response);
		}
		
		
	}
	
	public static void errorMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "Sorry an Error Has Occured");
		request.setAttribute("link", "UserHome.jsp");
		request.getRequestDispatcher("errorPage.jsp").forward(request, response);
	}

}
