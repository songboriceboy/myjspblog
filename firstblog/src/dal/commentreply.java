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
	
	//����ظ�
	
public  boolean insertcommentreply(String creply,int cmid) {
	    
	  boolean f=false;


		 try{   

			  //ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);
			  con = DriverManager.getConnection(url,dbUser,dbPwd); 
		     Statement stmt=con.createStatement();  	          
		  
		     
		   
		   	  
		   	  String incommentreply= "insert into commentreply(`creply`,`cmId`,`crDate`) values(\'"+creply+"\',\'"+cmid+"\',null)";
		   	  
		    
		         
		   //ִ�в���
		     if(stmt.executeUpdate(incommentreply)==1)  
		      {
		   	  
		   	  
		   	  f=true;
		      }
		         stmt.close();   
		         con.close(); 
		       return f;


		}catch(Exception ex)
		   {   

		           System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
		           return false;

		     }    

		 
	}






//��������id��ѯ���лظ�

public  ResultSet searchallreplybycmid(int cmid){
	 
	 try{   
		  
      

		//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
		 
   

       String commentreplysql="select * from commentreply where cmId='"+cmid+"'";                    

       ResultSet rs=stmt.executeQuery(commentreplysql); //ִ�в�ѯ 
      
         
 // stmt.close();   

 // con.close();   
  return rs;

	 }

catch(Exception ex)
{   

System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
return null;

} 
	 
	 
}














	

}
