package servlet;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.photosrcoption;

public class Photosrcoptionupdate extends HttpServlet {
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
	

	  String ms="";
	
	String  weixinpicsrc="";
	 String  logopicsrc="";	
	String resumepicsrc="";

  
        
           
    //文件上传
    

    String path = req.getContextPath();

            req.setCharacterEncoding("UTF-8");
            res.setCharacterEncoding("UTF-8");
            res.setContentType("text/html;charset=UTF-8");
    //   图片上传路径
       String uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload/options/";
    //   图片临时上传路径
       String tempPath = req.getSession().getServletContext().getRealPath("/")+"upload/options/temp/";
    //   图片网络相对路径
       String filePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
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
       List fileItems = fu.parseRequest(req);
       Iterator i = fileItems.iterator();
    
       

       
       
  //   处理简历相片图片个文件：


       if(i.hasNext()){

             FileItem resumefile = (FileItem)i.next();
             //   获得文件名，这个文件名是用户上传时用户的绝对路径：
                String resumesourcefileName = resumefile.getName();
                
                
                String resumet_name = resumesourcefileName.substring(path.lastIndexOf("\\") + 1);
                // 得到文件的扩展名(无扩展名时将得到全名)
                String resumet_ext = resumet_name.substring(resumet_name.lastIndexOf(".") + 1);
              
                
                
                if(resumesourcefileName!=null&&(resumesourcefileName.endsWith(".jpg")||resumesourcefileName.endsWith(".png")||resumesourcefileName.endsWith(".bmp")||resumesourcefileName.endsWith(".gif"))) {
             //   在这里可以记录用户和文件信息,生成上传后的文件名

         
                              File resumef=new File(uploadPath+resumet_name);
                              resumefile.write(resumef);

                              String resumesfn=resumesourcefileName;
                              String resumefp=filePath+"upload/options/"+resumet_name;            
                              resumepicsrc=resumefp;
                                          
              
              }else{
             	 ms+="--简历相片图片文件出错，只能上传 *.jpg , *.gif, *.png, *.bmp";
                     }


       }else
       {
       ms+="--请选择简历相片图片";

       }
       

       
       
       
       
  //   处理微信图片个文件：
if(i.hasNext()){
       
       FileItem weixinfile = (FileItem)i.next();
    //   获得文件名，这个文件名是用户上传时用户的绝对路径：
       String weixinsourcefileName = weixinfile.getName();
       
       
       String weixint_name = weixinsourcefileName.substring(path.lastIndexOf("\\") + 1);
       // 得到文件的扩展名(无扩展名时将得到全名)
       String weiixnt_ext = weixint_name.substring(weixint_name.lastIndexOf(".") + 1);
     
       
       
       if(weixinsourcefileName!=null&&(weixinsourcefileName.endsWith(".jpg")||weixinsourcefileName.endsWith(".png")||weixinsourcefileName.endsWith(".bmp")||weixinsourcefileName.endsWith(".gif"))) {
                 //   在这里可以记录用户和文件信息,生成上传后的文件名


                File weixinf=new File(uploadPath+weixint_name);
                 weixinfile.write(weixinf);

                  String weixinsfn=weixinsourcefileName;
                  String weixinfp=filePath+"upload/options/"+weixint_name;
                  weixinpicsrc=weixinfp;
                                
       
       }else{
       ms+="--微信图片文件出错，只能上传 *.jpg , *.gif, *.png, *.bmp";
       }
       
}else{

ms+="--请选择微信图片";
}             
       
       
      
//   处理博客人logo图片个文件：
      

if(i.hasNext()){

      FileItem logofile = (FileItem)i.next();
      //   获得文件名，这个文件名是用户上传时用户的绝对路径：
         String logosourcefileName = logofile.getName();
         
         
         String logot_name = logosourcefileName.substring(path.lastIndexOf("\\") + 1);
         // 得到文件的扩展名(无扩展名时将得到全名)
         String logot_ext = logot_name.substring(logot_name.lastIndexOf(".") + 1);
       
         
         
         if(logosourcefileName!=null&&(logosourcefileName.endsWith(".jpg")||logosourcefileName.endsWith(".png")||logosourcefileName.endsWith(".bmp")||logosourcefileName.endsWith(".gif"))) {
      //   在这里可以记录用户和文件信息,生成上传后的文件名

  
                       File logof=new File(uploadPath+logot_name);
                       logofile.write(logof);

                       String logosfn=logosourcefileName;
                       String logofp=filePath+"upload/options/"+logot_name;            
                       logopicsrc=logofp;
                                   
       
       }else{
      	 ms+="--logo图片文件出错，只能上传 *.jpg , *.gif, *.png, *.bmp";
              }


}else
{
ms+="--请选择博客logo图片";

}
     







       
       }
           catch(Exception e) {
                            ms+=e.toString();
                      }
     
       
     
  
       
       
       

                               
              
          
       HttpSession session=req.getSession(false);  
		  if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        res.setHeader("Refresh","2;URL=login.jsp");
		  }
else{       
       
           
    
    
       if(weixinpicsrc!=""){
      	  
    	   photosrcoption.setWeixinpicsrc(weixinpicsrc);
      	  
        }
    
       if(logopicsrc!=""){
     	  
    	   photosrcoption.setLogopicsrc(logopicsrc);
     	  
       }
       
       
       
       if(resumepicsrc!=""){
    	   photosrcoption.setResumepicsrc(resumepicsrc);
     	  
       }
    
     
             
	
    
	
    //返回错误信息
    if(ms=="")
    {ms="所有设置正确"; }
    
	// session=req.getSession();
	// session.setAttribute("ms",ms);  
	// res.sendRedirect("photooption.jsp");
    
    
	  req.setAttribute("ms", ms);
 		RequestDispatcher rd=req.getRequestDispatcher("photooption.jsp");
 		rd.forward(req,res);
	}
	
}
		  

}
