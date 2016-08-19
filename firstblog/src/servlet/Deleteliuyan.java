package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.liuyandal;


public class Deleteliuyan extends HttpServlet {
	
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
			
			liuyandal lydal=new liuyandal();
			//blogdal bgdal=new blogdal();
		
			
				
				if(lydal.deleteliuyanbyid(id))
				{
					ms="¡Ù—‘…æ≥˝≥…π¶";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("liuyanlist.jsp");
		         		rd.forward(req,res);
					
				}
				else{
					
					ms="¡Ù—‘…æ≥˝ ß∞‹";
					//session=req.getSession();
					// session.setAttribute("ms",ms);
				//res.sendRedirect("catelist.jsp");
					
		                 req.setAttribute("ms", ms);
		         		RequestDispatcher rd=req.getRequestDispatcher("liuyanlist.jsp");
		         		rd.forward(req,res);
					
				}
				
		
			
		}
		
		
		
		
		
		
	}
	

}
