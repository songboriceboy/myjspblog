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
         
        
        
 
//   ͼƬ�ϴ�·��
   String uploadPath =request.getSession().getServletContext().getRealPath("/")+"upload/musics/";
//   ͼƬ��ʱ�ϴ�·��
   String tempPath = request.getSession().getServletContext().getRealPath("/")+"upload/musics/temp/";
//   ͼƬ�������·��
   String filePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
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
   List fileItems = fu.parseRequest(request);
   Iterator i = fileItems.iterator();
//   ���δ���ÿһ���ļ���
   while(i.hasNext()) {
   FileItem file = (FileItem)i.next();
//   ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
   String sourcefileName = file.getName();
   
   
   String t_name = sourcefileName.substring(path.lastIndexOf("\\") + 1);
   // �õ��ļ�����չ��(����չ��ʱ���õ�ȫ��)
   String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
 
   
   
   if(sourcefileName!=null&&sourcefileName.endsWith(".mp3")) {
//   ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���
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
   

  ms+=sourcefileName+"�ɹ��ϴ���";
  //  out.print("<a href="+filePath+"upload/files/"+t_name+">�鿴"+"</a>");
   
   
   
            }
   }
   
   //���ش�����Ϣ
   
   
	 session=request.getSession();
	 session.setAttribute("ms",ms);  
	 response.sendRedirect("music.jsp");
   
   
//   ��ת���ϴ��ɹ���ʾҳ��
                   }catch(Exception e) {
                    //   ������ת����ҳ��
                	   
                	   
                         ms+="�ϴ�ʧ���밴˳��ѡ���ļ� --��ѡ��ǰ��� ��ѡ������";
                	    
                		 session=request.getSession();
                		 session.setAttribute("ms",ms);  
                		 response.sendRedirect("music.jsp");
                	   
                     }
  
	
	
  
		  }
		
	
	  }
   
   
  	
}	
	


