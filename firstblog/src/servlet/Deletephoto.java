package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deletephoto extends HttpServlet {
	
	
	public boolean deletePhoto(String path) {  
		   boolean flag = false;  
		   File file = new File(path);  
		    // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		        flag = true;  
		    }  
		    return flag;  
		}  
		
		
		
		String ms="";
		
		@Override
	    protected void service(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
	         
	        //ȡ�ñ�������
			String uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\photos\\";
			
			HttpSession session=req.getSession(false);  
			  if(session==null){  
				  res.setHeader("Refresh","2;URL=login.jsp");
			       
			  }  
			  
			  String login =(String)session.getAttribute("Login");
			  if(login==null){    
			        
			        res.setHeader("Refresh","2;URL=login.jsp");
			  }else{
				  
				  
				  if(req.getParameter("path")!="")
				  { 
				      String path=uploadPath+req.getParameter("path");
				      if(deletePhoto(path))
						 {
						  ms="ͼƬɾ���ɹ�";
			        	  session=req.getSession();
			 			 session.setAttribute("ms",ms);
						  res.sendRedirect("photos.jsp");
						 }else{
							 ms="ͼƬɾ��ʧ��";
				        	  session=req.getSession();
				 			 session.setAttribute("ms",ms);
							  res.sendRedirect("photos.jsp");
							 
						 }
					  
				  }
				  
				  
			  }
			  
			  
			  }

}