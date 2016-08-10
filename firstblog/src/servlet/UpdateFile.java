package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UpdateFile extends HttpServlet {
	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		
		
		  
		  
		  HttpSession session=req.getSession(false);  
		  if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        res.setHeader("Refresh","2;URL=login.jsp");
		  }else{
		  
		  
		  
		  
		  
		if(req.getParameter("filename")!=""&&req.getParameter("filename").length()<50&&req.getParameter("types")!="")
		{ 
			
			
			String filename=new String(req.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
			String filepath=new String(req.getParameter("filepath").getBytes("ISO-8859-1"),"UTF-8");
	        String type=req.getParameter("types");
	        
			 
	        String uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\files\\";
			
			switch(type){
			case "f":
			uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\files\\";
			break;
			case "m":
			uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\musics\\";
			break;
			case "p":
			uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\photos\\";
			break;
			case "v":
			uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload\\videos\\";
			break;
			}
			
			
				
			File   file=new  File(uploadPath+filepath);
	
			file.renameTo(new   File(uploadPath+filename)); 	
			
			switch(type){
			case "f":
				  ms="文件重命名成功";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
				res.sendRedirect("file.jsp");
			break;
			case "m":
				ms="音乐重命名成功";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
				res.sendRedirect("music.jsp");
			break;
			case "p":
				ms="图片重命名成功";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
				res.sendRedirect("photos.jsp");
			break;
			case "v":
				ms="视频重命名成功";
	        	  session=req.getSession();
	 			 session.setAttribute("ms",ms);
				res.sendRedirect("video.jsp");
			break;
			}
			
			
			
			
		}else{
			ms="重命名失败";
      	    session=req.getSession();
			 session.setAttribute("ms",ms);
			res.sendRedirect("rename.jsp");
			  
		  }

		
	
	}
	}
}
	
	
	
	




	      
