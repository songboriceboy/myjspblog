package servlet;

import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpSession;


import  java.util.regex.Matcher;
import  java.util.regex.Pattern;

import  dal.liuyandal;
import  dal.notificationdal;
import  model.liuyan;
import  model.notification;

import java.io.IOException;

 



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Liuyan extends HttpServlet {
	

	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //ȡ�ñ�����
         
		
		
		String authcode="";
                   
       
if(req.getParameter("authcode")!="")
     {
            authcode=req.getParameter("authcode");
            
      }

String code="";
HttpSession session = req.getSession(false); 
if (session != null)
{     
	code= session.getAttribute("code").toString();
}  
if(code.equals(authcode))          
{  

  String Name="";
  String Email="";
  String Message="";
  String Picsrc="";
  
  
if(req.getParameter("name")!=""&&req.getParameter("name").length()<50)
{ 
Name=new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--��������ȷ";       
  }


boolean flag = false;
String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
Pattern regex = Pattern.compile(check);
Matcher matcher = regex.matcher(req.getParameter("email"));
flag = matcher.matches();

if(req.getParameter("email")!=""&&req.getParameter("email").length()<50&&flag)
{

	Email=new String(req.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--���䲻��ȷ";     
  }


if(req.getParameter("message")!=""&&req.getParameter("message").length()<500)
{
     Message=new String(req.getParameter("message").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--���ݲ���ȷ";        
  }
      


if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<500)
{
     Picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
}
else{
ms+="--ͼƬ��ַ����ȷ";        
  }


 


notification noti=new notification("����",Name,Message);

notificationdal notidal=new notificationdal();


          if(notidal.insertnoti(noti))
         {
              liuyandal lydal=new liuyandal();
              liuyan ly=new liuyan(Name, Email, Message,Picsrc);

               if(lydal.insertliuyan(ly))
               {
            	   ms="���Գɹ�";
            		session=req.getSession();
            		 session.setAttribute("ms",ms);
            		res.sendRedirect("liuyan.jsp");
               }else{
            	   
            	   ms=" ����ʧ��";
            		session=req.getSession();
            		 session.setAttribute("ms",ms);
            		res.sendRedirect("liuyan.jsp");
               }
               
               
            	   
         }else{
        	 
        	 ms="����ʧ��";
        		session=req.getSession();
        		 session.setAttribute("ms",ms);
        		res.sendRedirect("liuyan.jsp");
        	 
         }
          
          

}else
{
	
	ms="��֤�벻��ȷ ����ʧ��";
	session=req.getSession();
	 session.setAttribute("ms",ms);
	res.sendRedirect("liuyan.jsp");

}
        

      
         
} 
	

}
