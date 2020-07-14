package com.todo.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.DBServices.DBServices;
import com.todo.bean.Todo;

public class DeleteTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTodo() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int todoId = Integer.parseInt(request.getParameter("todoId").trim());
		
		try {
            DBServices.deleteTodo(todoId);
            HttpSession session = request.getSession();
			List<Todo> todos = DBServices.getTodoList((int)session.getAttribute("userId"));
			request.setAttribute("todos", todos);
			request.getRequestDispatcher("UserHome.jsp").forward(request, response);
			
		}catch (Exception e) {
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
