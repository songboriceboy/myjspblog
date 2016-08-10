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
		 String  blogname="�����ഺ��һЩ����";
		String ICPLicensing="";
		
		
		

         if(req.getParameter("weibourl")!=""&&req.getParameter("weibourl").length()<100)
        { 
        	 weibourl=new String(req.getParameter("weibourl").getBytes("ISO-8859-1"),"UTF-8");
             }else{
                      ms+="--΢����ַ����ȷ";       
                 }
		 

         if(req.getParameter("tweibourl")!=""&&req.getParameter("tweibourl").length()<100)
        { 
        	 tweibourl=new String(req.getParameter("tweibourl").getBytes("ISO-8859-1"),"UTF-8");
             }else{
                      ms=ms+"--��Ѷ΢���û�������ȷ";       
                 }
         
 		 

          if(req.getParameter("pageSize")!=""&&req.getParameter("pageSize").length()<50)
         { 
        	  pageSize=Integer.parseInt(new String(req.getParameter("pageSize").getBytes("ISO-8859-1"),"UTF-8"));
              }else{
                       ms=ms+"--��ҳ��С����ȷ";       
                  }
          

          if(req.getParameter("blogname")!=""&&req.getParameter("blogname").length()<100)
         { 
        	  blogname=new String(req.getParameter("blogname").getBytes("ISO-8859-1"),"UTF-8");
              }else{
                       ms=ms+"--����������ȷ";       
                  }
		
          if(req.getParameter("ICPLicensing")!=""&&req.getParameter("ICPLicensing").length()<200)
          { 
        	  ICPLicensing=new String(req.getParameter("ICPLicensing").getBytes("ISO-8859-1"),"UTF-8");
               }else{
                        ms=ms+"--��������ȷ";       
                   }
          
          
 /*         
                 
          //�ļ��ϴ�
          

          String path = req.getContextPath();

                  req.setCharacterEncoding("UTF-8");
                  res.setCharacterEncoding("UTF-8");
                  res.setContentType("text/html;charset=UTF-8");
          //   ͼƬ�ϴ�·��
             String uploadPath =req.getSession().getServletContext().getRealPath("/")+"upload/options/";
          //   ͼƬ��ʱ�ϴ�·��
             String tempPath = req.getSession().getServletContext().getRealPath("/")+"upload/options/temp/";
          //   ͼƬ�������·��
             String filePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
          //   �ļ��в����ھ��Զ�������
             if(!new File(uploadPath).isDirectory())
             new File(uploadPath).mkdirs();
             if(!new File(tempPath).isDirectory())
             new File(tempPath).mkdirs();
             try {
             DiskFileUpload fu = new DiskFileUpload();
          //   ��������ļ��ߴ磬������4MB
             fu.setSizeMax(419430400);
          //   ���û�������С��������4kb
             fu.setSizeThreshold(4096);
          //   ������ʱĿ¼��
             fu.setRepositoryPath(tempPath);
          //   �õ����е��ļ���
             List fileItems = fu.parseRequest(req);
             Iterator i = fileItems.iterator();
          
             
             
             
             
        //   ����΢��ͼƬ���ļ���
  if(i.hasNext()){
             
             FileItem weixinfile = (FileItem)i.next();
          //   ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
             String weixinsourcefileName = weixinfile.getName();
             
             
             String weixint_name = weixinsourcefileName.substring(path.lastIndexOf("\\") + 1);
             // �õ��ļ�����չ��(����չ��ʱ���õ�ȫ��)
             String weiixnt_ext = weixint_name.substring(weixint_name.lastIndexOf(".") + 1);
           
             
             
             if(weixinsourcefileName!=null&&(weixinsourcefileName.endsWith(".jpg")||weixinsourcefileName.endsWith(".png")||weixinsourcefileName.endsWith(".bmp")||weixinsourcefileName.endsWith(".gif"))) {
                       //   ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���

      
                      File weixinf=new File(uploadPath+weixint_name);
                       weixinfile.write(weixinf);

                        String weixinsfn=weixinsourcefileName;
                        String weixinfp=filePath+"upload/options/"+weixint_name;
                        weixinpicsrc=weixinfp;
                                      
             
             }else{
             ms+="--΢��ͼƬ�ļ�����ֻ���ϴ� *.jpg , *.gif, *.png, *.bmp";
             }
             
  }else{
	  
	  ms+="��ѡ��΢��ͼƬ";
  }             
             
             
            
 //   ��������logoͼƬ���ļ���
            
	 
  if(i.hasNext()){
  
            FileItem logofile = (FileItem)i.next();
            //   ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
               String logosourcefileName = logofile.getName();
               
               
               String logot_name = logosourcefileName.substring(path.lastIndexOf("\\") + 1);
               // �õ��ļ�����չ��(����չ��ʱ���õ�ȫ��)
               String logot_ext = logot_name.substring(logot_name.lastIndexOf(".") + 1);
             
               
               
               if(logosourcefileName!=null&&(logosourcefileName.endsWith(".jpg")||logosourcefileName.endsWith(".png")||logosourcefileName.endsWith(".bmp")||logosourcefileName.endsWith(".gif"))) {
            //   ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���

        
                             File logof=new File(uploadPath+logot_name);
                             logofile.write(logof);

                             String logosfn=logosourcefileName;
                             String logofp=filePath+"upload/options/"+logot_name;            
                             logopicsrc=logofp;
                                         
             
             }else{
            	 ms+="--logoͼƬ�ļ�����ֻ���ϴ� *.jpg , *.gif, *.png, *.bmp";
                    }
 
  
  }else
  {
	  ms+="��ѡ�񲩿�logoͼƬ";
	  
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
          
          
		
          //���ش�����Ϣ
          if(ms=="")
          {ms="����������ȷ"; }
          
          
 		 session=req.getSession();
 		 session.setAttribute("ms",ms);  
 		 res.sendRedirect("option.jsp");
 		 
}
		  
		  
		  
          
	}	
	

}
