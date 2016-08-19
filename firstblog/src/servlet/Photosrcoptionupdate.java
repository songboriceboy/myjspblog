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
    
       

       
       
  //   ���������ƬͼƬ���ļ���


       if(i.hasNext()){

             FileItem resumefile = (FileItem)i.next();
             //   ����ļ���������ļ������û��ϴ�ʱ�û��ľ���·����
                String resumesourcefileName = resumefile.getName();
                
                
                String resumet_name = resumesourcefileName.substring(path.lastIndexOf("\\") + 1);
                // �õ��ļ�����չ��(����չ��ʱ���õ�ȫ��)
                String resumet_ext = resumet_name.substring(resumet_name.lastIndexOf(".") + 1);
              
                
                
                if(resumesourcefileName!=null&&(resumesourcefileName.endsWith(".jpg")||resumesourcefileName.endsWith(".png")||resumesourcefileName.endsWith(".bmp")||resumesourcefileName.endsWith(".gif"))) {
             //   ��������Լ�¼�û����ļ���Ϣ,�����ϴ�����ļ���

         
                              File resumef=new File(uploadPath+resumet_name);
                              resumefile.write(resumef);

                              String resumesfn=resumesourcefileName;
                              String resumefp=filePath+"upload/options/"+resumet_name;            
                              resumepicsrc=resumefp;
                                          
              
              }else{
             	 ms+="--������ƬͼƬ�ļ�����ֻ���ϴ� *.jpg , *.gif, *.png, *.bmp";
                     }


       }else
       {
       ms+="--��ѡ�������ƬͼƬ";

       }
       

       
       
       
       
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

ms+="--��ѡ��΢��ͼƬ";
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
ms+="--��ѡ�񲩿�logoͼƬ";

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
    
     
             
	
    
	
    //���ش�����Ϣ
    if(ms=="")
    {ms="����������ȷ"; }
    
	// session=req.getSession();
	// session.setAttribute("ms",ms);  
	// res.sendRedirect("photooption.jsp");
    
    
	  req.setAttribute("ms", ms);
 		RequestDispatcher rd=req.getRequestDispatcher("photooption.jsp");
 		rd.forward(req,res);
	}
	
}
		  

}
