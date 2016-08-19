package servlet;

import javax.servlet.http.HttpServlet;






import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.mooddal;
import model.mood;

public class Addmood extends HttpServlet{
	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //取得表单数据
         
		
		HttpSession session=req.getSession(false);  
		  if(session==null){  
			  res.setHeader("Refresh","2;URL=login.jsp");
		       
		  }  
		  
		  String login =(String)session.getAttribute("Login");
		  if(login==null){    
		        
		        res.setHeader("Refresh","2;URL=login.jsp");
		  }else
		 {
		  

                          String picsrc="";
                          String mood="";

                         if(req.getParameter("picsrc")!=""&&req.getParameter("picsrc").length()<5000)
                        { 
	                           picsrc=new String(req.getParameter("picsrc").getBytes("ISO-8859-1"),"UTF-8");
                         }else{
  	                           ms+="--图片地址不正确";       
                               }
  
  
  
	                    if(req.getParameter("mood")!=""&&req.getParameter("mood").length()<5000)
	                   { 
	                           	mood=new String(req.getParameter("mood").getBytes("ISO-8859-1"),"UTF-8");
	                        }else{
	  	                           ms+="--心情不正确";       
	                            }


	   
	              if(picsrc!=""&&mood!="")
	              {
	  	
	                   mooddal mddal=new mooddal();
	                   mood  md=new mood(mood,picsrc);
	  
	                   if(mddal.insertmood(md))
	                  { 
	                         ms="成功添加心情";
	                     // res.sendRedirect("moodlist.jsp");
	                    //  session=req.getSession();
	             		// session.setAttribute("ms",ms);
	                         req.setAttribute("ms", ms);
	                 		RequestDispatcher rd=req.getRequestDispatcher("moodlist.jsp");
	                 		rd.forward(req,res);
	                   }
	                    else
	                 {
	                    ms+="添加心情失败";
	                    // res.sendRedirect("moodlist.jsp");
	                    //  session=req.getSession();
	             		// session.setAttribute("ms",ms);
	                         req.setAttribute("ms", ms);
	                 		RequestDispatcher rd=req.getRequestDispatcher("moodlist.jsp");
	                 		rd.forward(req,res);
	                 }    
	            
	              }else{
	            	  ms+="添加心情失败";
	            	  // res.sendRedirect("moodlist.jsp");
	                    //  session=req.getSession();
	             		// session.setAttribute("ms",ms);
	                         req.setAttribute("ms", ms);
	                 		RequestDispatcher rd=req.getRequestDispatcher("moodlist.jsp");
	                 		rd.forward(req,res);
	              }
	          
	          
	           
	       }   
	  
   
	 }
	
	
}
	
	
	
	
	
