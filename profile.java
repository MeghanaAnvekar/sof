package mysite;

import java.io.IOException;
import java.util.* ;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class profile
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("index.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<!DOCTYPE html>\n" + 
				"<head>\n" + 
				"<title>\n" + 
				"		My Profile\n" + 
				"	</title>\n" + 
				"	<link  rel='stylesheet' type=\"text/css\" href=\"conf.css\" />\n" + 
				"</head>\n" + 
				"<body>");
		String fname = request.getParameter("fname");
		writer.println("<div id ='h1'>"+fname +" "+request.getParameter("sname")+ "</div><br><hr><br>");
		writer.println("<div id='h2'>"+ "....I'm feeling"+request.getParameter("review") +" :) </div>");
		writer.println("<table>\n" + 
				"	<tr><td>Date of Birth</td><td>"+request.getParameter("dob") +"</td></tr>");
		writer.println("<tr><td>Email</td><td>"+request.getParameter("email")+"</td></tr>");
		writer.println("<tr><td>Mobile</td><td>"+request.getParameter("mobile")+"</td></tr>");
		writer.println("<tr><td>Country</td><td>"+request.getParameter("country")+"</td></tr>");
		/*request.setAttribute("fname", request.getParameter("fname"));
		request.setAttribute("dob", request.getParameter("dob"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("country", request.getParameter("country"));
		request.setAttribute("review", request.getParameter("review"));
		request.setAttribute("mobile", request.getParameter("mobile"));
		RequestDispatcher view = request.getRequestDispatcher("confirm.html");
		view.forward(request, response);*/
		
	}

}
