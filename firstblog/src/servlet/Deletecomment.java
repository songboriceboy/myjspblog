package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.commentdal;


public class Deletecomment extends HttpServlet {
	
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
			
			commentdal comdal=new commentdal();
			//blogdal bgdal=new blogdal();
		
			
				
				if(comdal.deletecommentbyid(id))
				{
					ms="ÆÀÂÛÉ¾³ý³É¹¦";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("commentlist.jsp");
		         		rd.forward(req,res);
					
				}
				else{
					
					ms="ÆÀÂÛÉ¾³ýÊ§°Ü";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("commentlist.jsp");
		         		rd.forward(req,res);
					
				}
				
		
			
		}
		
		
		
		
		
		
	}
	

}
