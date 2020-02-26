package com.capg.webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/LoginServlet" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "praveen")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		  out.print(" Servlet  <br>");
		  out.print("<h1 style='color:red'>LOGIN PAGE</h1>");
		  
		User uobject=new User();  
		 String uname= request.getParameter("uname");
		 String pwd=request.getParameter("pwd");
		 uobject.setUserName(uname);
		 uobject.setPassword(pwd);
		 Service service=new Service();
		 
		 int count=service.addUser(uobject);
		 
		 
		request.setAttribute("count", count);
		out.print("login servlet");
		 
		 RequestDispatcher dispatch= request.getRequestDispatcher("DisplayServlet");
		 
		 //dispatch.forward(request, response);
		 dispatch.include(request, response);
		 
		 /* out.print("username:"+uname);
		 
		  out.print("<br>");
		  out.print("password:"+pwd);*/
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
