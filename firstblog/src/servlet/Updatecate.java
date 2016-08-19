package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.blogdal;
import dal.catedal;

public class Updatecate extends HttpServlet{
	
	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //取得表单数据
         
		
		int cateid=Integer.parseInt(req.getParameter("cateid"));


  String catename="";
  
 
  
  HttpSession session=req.getSession(false);  
  if(session==null){  
	  res.setHeader("Refresh","2;URL=login.jsp");
       
  }  
  
  String login =(String)session.getAttribute("Login");
  if(login==null){    
        
        res.setHeader("Refresh","2;URL=login.jsp");
  }else{
  
  
  
  
  
if(req.getParameter("catename")!=""&&req.getParameter("catename").length()<50)
{ 
	catename=new String(req.getParameter("catename").getBytes("ISO-8859-1"),"UTF-8");
}else{
	ms+="--类别标题不正确";       
  }





catedal ctdal=new catedal();   
if(catename!=""&&!ctdal.hassamename(catename)){
	

blogdal bgdal=new blogdal();

if(ctdal.updatecate(cateid,catename))
{
	
		ms="成功更新类别";
		//session=req.getSession();
		// session.setAttribute("ms",ms);
	//res.sendRedirect("catelist.jsp");
		
             req.setAttribute("ms", ms);
     		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
     		rd.forward(req,res);
		
}
	else{
		
		ms+="更新类别失败";
		//session=req.getSession();
		// session.setAttribute("ms",ms);
	//res.sendRedirect("catelist.jsp");
		
             req.setAttribute("ms", ms);
     		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
     		rd.forward(req,res);
		
	}
}

else
{
ms+="更新类别失败";
//session=req.getSession();
// session.setAttribute("ms",ms);
//res.sendRedirect("catelist.jsp");

     req.setAttribute("ms", ms);
		RequestDispatcher rd=req.getRequestDispatcher("catelist.jsp");
		rd.forward(req,res);

}    
	
  
  } 
        
        
         
    }   

	

	
  
  
}
