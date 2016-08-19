package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.notificationdal;


public class Deletenoti extends HttpServlet {
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		HttpSession session=req.getSession(false);  
		if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		     
		}  

		String login =(String)session.getAttribute("Login");
		if(login==null){    
		      
		      res.setHeader("Refresh","2;URL=login.jsp");
		}else{
			
			
		
			notificationdal notidal=new notificationdal();
				
				if(notidal.deletenoti(id))
				{
					ms="通知删除成功";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("notification.jsp");
		         		rd.forward(req,res);
					
				}
				else{
					
					ms="通知删除失败";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("notification.jsp");
		         		rd.forward(req,res);
					
				}
				
		
			
		}
		
		
		
		
		
		
	}
	

}
