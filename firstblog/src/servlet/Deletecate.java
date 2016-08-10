package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.catedal;
import dal.blogdal;

public class Deletecate extends HttpServlet {
	
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
			
			catedal ctdal=new catedal();
			blogdal bgdal=new blogdal();
		
			if(bgdal.deletblogcate(id))
			{
				
				if(ctdal.deletcate(id))
				{
					ms+="类别删除成功";
					session=req.getSession();
					 session.setAttribute("ms",ms);
				res.sendRedirect("catelist.jsp");
				}
				else{
					
					ms+="类别删除失败";
					session=req.getSession();
					 session.setAttribute("ms",ms);
				res.sendRedirect("catelist.jsp");
				}
				
				
				
			}else{
				
				ms+="类别删除失败";
				session=req.getSession();
				 session.setAttribute("ms",ms);
			    res.sendRedirect("catelist.jsp");
				
			   }
						
			
		
			
		}
		
		
		
		
		
		
	}
	

}
