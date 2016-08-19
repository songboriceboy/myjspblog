package dal;
import java.sql.*;

import model.admin;
import utils.dbconstant;
public class commentreply {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	
	//插入回复
	
public  boolean insertcommentreply(String creply,int cmid) {
	    
	  boolean f=false;


		 try{   

			  //使用驱动  获取连接   获取 Statement
			  Class.forName(driverClass);
			  con = DriverManager.getConnection(url,dbUser,dbPwd); 
		     Statement stmt=con.createStatement();  	          
		  
		     
		   
		   	  
		   	  String incommentreply= "insert into commentreply(`creply`,`cmId`,`crDate`) values(\'"+creply+"\',\'"+cmid+"\',null)";
		   	  
		    
		         
		   //执行插入
		     if(stmt.executeUpdate(incommentreply)==1)  
		      {
		   	  
		   	  
		   	  f=true;
		      }
		         stmt.close();   
		         con.close(); 
		       return f;


		}catch(Exception ex)
		   {   

		           System.out.print("连接失败！！<br>"+ex.toString());   
		           return false;

		     }    

		 
	}






//根据评论id查询所有回复

public  ResultSet searchallreplybycmid(int cmid){
	 
	 try{   
		  
      

		//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
		 
   

       String commentreplysql="select * from commentreply where cmId='"+cmid+"'";                    

       ResultSet rs=stmt.executeQuery(commentreplysql); //执行查询 
      
         
 // stmt.close();   

 // con.close();   
  return rs;

	 }

catch(Exception ex)
{   

System.out.print("连接失败！！<br>"+ex.toString());   
return null;

} 
	 
	 
}














	

}
