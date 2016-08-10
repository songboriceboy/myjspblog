package servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.admin;
import dal.admindal;
import utils.dbconstant;
import utils.dbutils;

public class Blogsetting extends HttpServlet {
	
	
	
	
	String ms="";
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
        //ȡ�ñ�����
         
		if(admindal.sumadmin()!=0){

			res.sendRedirect("login.jsp");

			}
		
		  
              //���ݿ���ز���
                          String dburl="";
                          String dbname="";
                          String dbuser="";
                          String dbpwd="";
                          String sdbpwd="";
                //���͹�����ز���          
                          String account="";
                          String question="";
                          String answer="";
                          String password="";
                          String spassword="";
                          
                          
                         

                         if(req.getParameter("dburl")!=""&&req.getParameter("dburl").length()<100)
                        { 
                        	 dburl=new String(req.getParameter("dburl").getBytes("ISO-8859-1"),"UTF-8");
                         }else{
  	                           ms+="--���ݿ��ַ����ȷ";       
                               }
  
  
  
	                    if(req.getParameter("dbname")!=""&&req.getParameter("dbname").length()<50)
	                   { 
	                    	dbname=new String(req.getParameter("dbname").getBytes("ISO-8859-1"),"UTF-8");
	                        }else{
	  	                           ms+="--���ݿ�������ȷ";       
	                            }


	   
	                    

	                    if(req.getParameter("dbuser")!=""&&req.getParameter("dbuser").length()<50)
	                   { 
	                    	dbuser=new String(req.getParameter("dbuser").getBytes("ISO-8859-1"),"UTF-8");
	                        }else{
	  	                           ms+="--���ݿ����û�������ȷ";       
	                            }
	                    
	          
	                    
	                    

	                    if(req.getParameter("dbpwd")!=""&&req.getParameter("dbpwd").length()<50)
	                   { 
	                    	dbpwd=new String(req.getParameter("dbpwd").getBytes("ISO-8859-1"),"UTF-8");
	                        }else{
	  	                           ms+="--���ݿ����벻��ȷ";       
	                            }
	                    
	          
	                    if(req.getParameter("sdbpwd")!=""&&req.getParameter("sdbpwd").length()<50)
		                   { 
		                    	sdbpwd=new String(req.getParameter("sdbpwd").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--ȷ�����ݿ����벻��ȷ";       
		                            }
	                    
	                    
	                    if(req.getParameter("account")!=""&&req.getParameter("account").length()<50)
		                   { 
		                    	account=new String(req.getParameter("account").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--���͹���Ա����ȷ";       
		                            }
	                    
	                    
	                    if(req.getParameter("question")!=""&&req.getParameter("question").length()<100)
		                   { 
		                    	question=new String(req.getParameter("question").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--���͹���Ա���ⲻ��ȷ";       
		                            }
	                    
	                    if(req.getParameter("answer")!=""&&req.getParameter("answer").length()<100)
		                   { 
		                    	answer=new String(req.getParameter("answer").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--���͹���Ա����ش���ȷ";       
		                            }
	                    
	                    if(req.getParameter("password")!=""&&req.getParameter("password").length()<50)
		                   { 
		                    	password=new String(req.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--���͹���Ա���벻��ȷ";       
		                            }
	                    
	                    if(req.getParameter("spassword")!=""&&req.getParameter("spassword").length()<50)
		                   { 
		                    	spassword=new String(req.getParameter("spassword").getBytes("ISO-8859-1"),"UTF-8");
		                        }else{
		  	                           ms+="--���͹���Աȷ�����벻��ȷ";    
		                            }
	         
	                    
	                    
	                    
	                    
if(dburl!=""&&dbname!=""&&dbuser!=""&&dbpwd!=""&&sdbpwd!="")   
{	    	
	    	
	     if(sdbpwd.equals(dbpwd))
	     {
	                   
	                   
	                   Connection cc=dbutils.getConnection(dburl,dbname,dbuser,dbpwd);  
	                   
	                   try {
						if(!cc.isClosed())  {
							   dbconstant.setUrl(dburl+dbname);
						       dbconstant.setDbuser(dbuser);
						       dbconstant.setDbpwd(dbpwd);
						   }
						  } catch (SQLException e) {
						        // TODO Auto-generated catch block
						         e.printStackTrace();
					       }
	       }
	               
	     
}	     
	         


if(account!=""&&password!=""&&question!=""&&answer!=""&&spassword!="")
{	
	
	     if(spassword.equals(password))
	     {	    	 
	    	 admin inadm=new admin(account,password,question,answer);
	    	 admindal admdal=new admindal();
	    	 admdal.insertadmin(inadm);
	    	 	    	 
	     }
	     

}


	     
	           
   }   
	  


}

	
	
	


