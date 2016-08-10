package servlet;

import javax.servlet.http.HttpServlet;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Uploadmusic extends HttpServlet {
	

	
	
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String ms="";
		String path = request.getContextPath();
		
	
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
 
        
        HttpSession session=request.getSession(false);  
		  if(session==null){  
			  response.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        response.setHeader("Refresh","2;URL=login.jsp");
		  }else{
         
        
        
 
//   图片上传路径
   String uploadPath =request.getSession().getServletContext().getRealPath("/")+"upload/musics/";
//   图片临时上传路径
   String tempPath = request.getSession().getServletContext().getRealPath("/")+"upload/musics/temp/";
//   图片网络相对路径
   String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
//   文件夹不存在就自动创建：
   if(!new File(uploadPath).isDirectory())
   new File(uploadPath).mkdirs();
   if(!new File(tempPath).isDirectory())
   new File(tempPath).mkdirs();
   try {
   DiskFileUpload fu = new DiskFileUpload();
//   设置最大文件尺寸，这里是4MB
   fu.setSizeMax(419430400);
//   设置缓冲区大小，这里是4kb
   fu.setSizeThreshold(4096);
//   设置临时目录：
   fu.setRepositoryPath(tempPath);
//   得到所有的文件：
   List fileItems = fu.parseRequest(request);
   Iterator i = fileItems.iterator();
//   依次处理每一个文件：
   while(i.hasNext()) {
   FileItem file = (FileItem)i.next();
//   获得文件名，这个文件名是用户上传时用户的绝对路径：
   String sourcefileName = file.getName();
   
   
   String t_name = sourcefileName.substring(path.lastIndexOf("\\") + 1);
   // 得到文件的扩展名(无扩展名时将得到全名)
   String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
 
   
   
   if(sourcefileName!=null&&sourcefileName.endsWith(".mp3")) {
//   在这里可以记录用户和文件信息,生成上传后的文件名
/*
   String destinationfileName=null;
   Random rd = new Random();
   Calendar time = Calendar.getInstance();
   destinationfileName=String.valueOf(time.get(Calendar.YEAR))
   + String.valueOf(time.get(Calendar.MONTH))
   + String.valueOf(time.get(Calendar.DAY_OF_MONTH))
   + String.valueOf(time.get(Calendar.HOUR_OF_DAY))
   + String.valueOf(time.get(Calendar.MINUTE))
   + String.valueOf(time.get(Calendar.SECOND))
   + String.valueOf(rd.nextInt(100)) + "."+t_ext;
   
   */
   
   File f=new File(uploadPath+t_name);
   file.write(f);
   

  ms+=sourcefileName+"成功上传！";
  //  out.print("<a href="+filePath+"upload/files/"+t_name+">查看"+"</a>");
   
   
   
            }
   }
   
   //返回错误信息
   
   
	 session=request.getSession();
	 session.setAttribute("ms",ms);  
	 response.sendRedirect("music.jsp");
   
   
//   跳转到上传成功提示页面
                   }catch(Exception e) {
                    //   可以跳转出错页面
                	   
                	   
                         ms+="上传失败请按顺序选择文件 --先选择前面的 再选择后面的";
                	    
                		 session=request.getSession();
                		 session.setAttribute("ms",ms);  
                		 response.sendRedirect("music.jsp");
                	   
                     }
  
	
	
  
		  }
		
	
	  }
   
   
  	
}	
	


