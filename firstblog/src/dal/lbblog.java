package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.dbconstant;

public class lbblog {
	
	

	
	
	
	//���㲩������
public static int sumblog(){
		
		
		
		String driverClass=dbconstant.getDriverclass();

		 String  url=dbconstant.getUrl();

	    String dbUser = dbconstant.getDbuser();   

	    String dbPwd = dbconstant.getDbpwd();  
		
		
		 
		try{   
			    int sum=0;
				//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumblogSql="select count(*) from  blog";
	           ResultSet sumRs=stmt.executeQuery(sumblogSql); //ִ�в�ѯ 
	           
	           if(sumRs.next()){
	                 sum=sumRs.getInt(1);
	             }
	           
	           stmt.close();   
	           
	           con.close(); 
	           return sum;
	        
		 }catch(Exception ex)
	     {   

	            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	            return 0;

	        } 
		
		
	}
	
	
	
	
//��ѯ�����ֲ�����
	
public static ResultSet searchlbblog()
	 {
		
		String driverClass=dbconstant.getDriverclass();

		 String  url=dbconstant.getUrl();

	    String dbUser = dbconstant.getDbuser();   

	    String dbPwd = dbconstant.getDbpwd();  
			
		
		 
		 try{   
			  
			 
          
    
			 //ʹ������  ��ȡ����   ��ȡ Statement
       	    Class.forName(driverClass);
       	    Connection con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  

              int sumbg=sumblog();
           String sql="select * from blog limit 0,4";
            

           ResultSet lbrs=stmt.executeQuery(sql); //ִ�в�ѯ 
          
             
     // stmt.close();   

     // con.close();   
      return lbrs;
 
		 }
 
catch(Exception ex)
{   

System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
return null;

} 
		 
		 
	 }

}
