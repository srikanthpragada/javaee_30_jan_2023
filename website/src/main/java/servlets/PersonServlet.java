package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String input = request.getParameter("age");
       int age = Integer.parseInt(input);
       
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       
       if(age < 30)
    	   pw.println("<h1>Young!!!</h1>");
       else
    	   pw.println("<h1>Not so young!!!</h1>");
	}

}
