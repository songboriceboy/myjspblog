package servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deletefile extends HttpServlet {
	
	public boolean deleteFile(String path) {  
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
         
        //ȡ�ñ�����
         
		
		String uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\files\\";
		
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
			     // System.out.print(path);
				 if(deleteFile(path))
				 {
				  ms="�ļ�ɾ���ɹ�";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
				  res.sendRedirect("file.jsp");
				 }else{
					 ms="�ļ�ɾ��ʧ��";
		        	  session=req.getSession();
		 			 session.setAttribute("ms",ms);
					  res.sendRedirect("file.jsp");
					 
				 }
				  
			  }
			  
			  
		  }
		  
		  
		  }
		

}
