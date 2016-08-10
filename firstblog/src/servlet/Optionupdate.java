package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.sql.*; 

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.option;

public class Optionupdate extends HttpServlet {
	
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		
		  String ms="";
		 String  weibourl="";
		 String  tweibourl="";
		// String  weixinpicsrc="";
		// String  logopicsrc="";	
		 int  pageSize=0;
		 String  blogname="关于青春的一些故事";
		String ICPLicensing="";
		
		
		

         if(req.getParameter("weibourl")!=""&&req.getParameter("weibourl").length()<100)
        { 
        	 weibourl=new String(req.getParameter("weibourl").getBytes("ISO-8859-1"),"UTF-8");
             }else{
                      ms+="--微博地址不正确";       
                 }
		 

         if(req.getParameter("tweibourl")!=""&&req.getParameter("tweibourl").length()<100)
        { 
        	 tweibourl=new String(req.getParameter("tweibourl").getBytes("ISO-8859-1"),"UTF-8");
             }else{
                      ms=ms+"--腾讯微博用户名不正确";       
                 }
         
 		 

          if(req.getParameter("pageSize")!=""&&req.getParameter("pageSize").length()<50)
         { 
        	  pageSize=Integer.parseInt(new String(req.getParameter("pageSize").getBytes("ISO-8859-1"),"UTF-8"));
              }else{
                       ms=ms+"--分页大小不正确";       
                  }
          

          if(req.getParameter("blogname")!=""&&req.getParameter("blogname").length()<100)
         { 
        	  blogname=new String(req.getParameter("blogname").getBytes("ISO-8859-1"),"UTF-8");
              }else{
                       ms=ms+"--博客名不正确";       
                  }
		
          if(req.getParameter("ICPLicensing")!=""&&req.getParameter("ICPLicensing").length()<200)
          { 
        	  ICPLicensing=new String(req.getParameter("ICPLicensing").getBytes("ISO-8859-1"),"UTF-8");
               }else{
                        ms=ms+"--备案不正确";       
                   }
          
          
 /*         
                 
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
	  
	  ms+="请选择微信图片";
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
	  ms+="请选择博客logo图片";
	  
  }
                              
             
             }
             catch(Exception e) {
            ms+=e.toString();
             }
           
             
           
          
          
          
          
          
             if(weixinpicsrc!=""){
           	  
           	  option.setWeixinpicsrc(weixinpicsrc);
           	  
             }
             
             
             
             if(logopicsrc!=""){
           	  option.setLogopicsrc(logopicsrc);
           	  
             }
          
   */       
           
          
          HttpSession session=req.getSession(false);  
		  if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        res.setHeader("Refresh","2;URL=login.jsp");
		  }
else{
          
		
          if(blogname!=""){
        	  
        	  option.setBlogname(blogname);
        	  
          }
          if(pageSize!=0){
        	  option.setPageSize(pageSize);
        	  
          }
          if(weibourl!=""){
        	  option.setWeibourl(weibourl);
        	  
          }
          if(tweibourl!=""){
        	  
        	  option.setTweibourl(tweibourl);
          }
          
          
		
          //返回错误信息
          if(ms=="")
          {ms="所有设置正确"; }
          
          
 		 session=req.getSession();
 		 session.setAttribute("ms",ms);  
 		 res.sendRedirect("option.jsp");
 		 
}
		  
		  
		  
          
	}	
	

}
