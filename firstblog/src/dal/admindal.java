package dal;

import java.sql.*;

import org.apache.commons.lang.StringEscapeUtils;

import model.admin;
import model.blog;
import utils.dbconstant;

public class admindal {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
//��ѯ�Ƿ����û� �ж��Ƿ��״�����	
public static int sumadmin(){
			
			
			
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
		           
		           String sumblogSql="select count(*) from  admin";
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
		
	
	
	//��¼
public ResultSet adminlogin(admin adm){
	
	
	   try{   
		  
      
		 Class.forName(driverClass);
   	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
         Statement stmt=con.createStatement();  	
		

          String sql="select * from  admin where uAccount='"+adm.getAccount()+"'and uPassword='"+adm.getPassword()+"'";        
          //sql = StringEscapeUtils.escapeSql(sql);  //��sqlע��
          
          ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
          return rs;
	    }catch(Exception ex)
	          {   

	                 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	                 return null;

	           } 

}  
	


//��������

public boolean resetpwd(admin adm){
	
	
	   try{   
		  boolean f=false;
   
		 Class.forName(driverClass);
	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
      Statement stmt=con.createStatement();  	
		

       String sql="select * from  admin where uAccount='"+adm.getAccount()+"'";
       ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ
       if(rs.next()){
    	   
    	   if(rs.getString("uZiploc").equals(adm.getQuestion())&&rs.getString("answer").equals(adm.getAnswer()))
    	   {
    		   
    		   String uppwdsql = "update admin set uPassword=\""+adm.getPassword()+"\"";

    	        
               
                        if(stmt.executeUpdate(uppwdsql)==1); //ִ�в�ѯ 
                     {f=true;}
                  
                           stmt.close();   

                         con.close();   
                          return f;
    	            }
    	   
               }else{
    	   
    	   f=false;
    	   
       }
       return f;
       
	    }catch(Exception ex)
	          {   

	                 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	                 return false;

	           } 

}  




public  boolean insertadmin(admin inadmin) {
    
    boolean f=false;


 try{   

	  //ʹ������  ��ȡ����   ��ȡ Statement
	  Class.forName(driverClass);
	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
     Statement stmt=con.createStatement();  	          
     String inadminSql="";
     
   
   	  
   	  inadminSql= "insert into admin(`uAccount`,`uPassword`,`uZiploc`,`uAnswer`) values(\'"+inadmin.getAccount()+"\',\'"+inadmin.getPassword()+"\',\'"+inadmin.getQuestion()+"\',\'"+inadmin.getAnswer()+"\')";
   	  
    
         
   //ִ�в���
     if(stmt.executeUpdate(inadminSql)==1)  
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







	
}
	
	
	
	


