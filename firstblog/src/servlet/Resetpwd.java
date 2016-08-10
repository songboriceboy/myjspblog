package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import utils.regx;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.admin;
import utils.MD5;
import dal.admindal;

public class Resetpwd extends HttpServlet {
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		
		
		   String account="";
		  String question="";
		  String answer="";
		  String password="";
		
		String ms="";
		
		 HttpSession session=req.getSession(false);  
		  if(session!=null){  
			  res.setHeader("Refresh","2;URL=admin.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login!=null){    
		        
		        res.setHeader("Refresh","2;URL=admin.jsp");
		  }else{
		  
		  
		  
		if(req.getParameter("account")!=""&&req.getParameter("account").length()<50&&regx.isUsername(req.getParameter("account")))
		{ 
		account=new String(req.getParameter("account").getBytes("ISO-8859-1"),"UTF-8");
		}else{
			ms+="--�˺Ų���ȷ";       
		  }




		if(req.getParameter("question")!=""&&req.getParameter("question").length()<100)
		{ 
			question=new String(req.getParameter("question").getBytes("ISO-8859-1"),"UTF-8");
		}else{
			
			ms+="--���ⲻ��ȷ"; 
		}
		


		if(req.getParameter("answer")!=""&&req.getParameter("answer").length()<100)
		{
			answer=new String(req.getParameter("answer").getBytes("ISO-8859-1"),"UTF-8");
		}
		else{
		ms+="--�ش���ȷ";        
		  }
		      

		if(req.getParameter("password")!=""&&regx.IsPassword(req.getParameter("password")))
		{
			password=new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		}
		else{
		ms+="--���벻��ȷ";        
		  }

		
		if(req.getParameter("spassword")!=""&&regx.IsPassword(req.getParameter("spassword")))
		{
			password=new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		}
		else{
		ms+="--ȷ�����벻��ȷ";        
		  }
		
		if(req.getParameter("password")!=req.getParameter("spassword"))
		{
			ms+="--�������벻һ��";
		}
		
		
		
		
		password=MD5.stringMD5(password);
		admin adm=new admin(account,password,question,answer);
		admindal admdal=new admindal();
		if(admdal.resetpwd(adm))
		{
			            ms="���óɹ� ���¼";
			            session=req.getSession();
			            session.setAttribute("ms",ms);
						res.sendRedirect("login.jsp"); 
		}
		else{
			    ms+="--����ʧ��";
			    session=req.getSession();
	            session.setAttribute("ms",ms);
				res.sendRedirect("resetpwd.jsp"); 
			         
		}
		
		
		
		
		
		  }	
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
