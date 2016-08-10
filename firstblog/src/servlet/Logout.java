package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class Logout extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse   response)  
			            throws ServletException, IOException {  
			        HttpSession session=request.getSession(false);  
			        if(session==null){  
			            response.sendRedirect("login.jsp");  
			            return;  
			        }  
			          
			        session.removeAttribute("Login");  
			        response.sendRedirect("login.jsp");  
			    }  
			  
			  
			    public void doPost(HttpServletRequest request, HttpServletResponse   
			  
			  
			response)  
			            throws ServletException, IOException {  
			       doGet(request,response);  
			    }  
			  
	
	

}
