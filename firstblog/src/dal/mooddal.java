package dal;
import java.sql.*;

import model.mood;
import utils.dbconstant;

public class mooddal {
	
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
	
	//��ѯ��������
public int summood(){
		
		 
		try{   
			    int sum=0;
				//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String summoodsql="select count(*) from  mood";
	           ResultSet sumRs=stmt.executeQuery(summoodsql); //ִ�в�ѯ 
	           
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
	
	

	//��ҳ��ѯ����


public ResultSet selectmoodpage(int pageSize,int pageNow){
		
		 
		try{   
			   
				//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           ResultSet moodRs=stmt.executeQuery("select * from mood order by moDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
	             //ִ�в�ѯ          
	           
	          // stmt.close();   
	           
	          // con.close(); 
	           return moodRs;
	        
		 }catch(Exception ex)
	     {   

	            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	            return null;

	        } 
		
		
	}
	
	
	
	
	
	
	//��������
 public  boolean insertmood(mood md) {
	                 
		           
		            boolean f=false;
	  	          
	              try{   
	   
	                     
	             
	            	  //ʹ������  ��ȡ����   ��ȡ Statement
	            	  Class.forName(driverClass);
	            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	                  Statement stmt=con.createStatement();  
	                    
	                      
	                    String inmoodsql= "insert into mood(`mopicsrc`,`moContent`,`moDate`) values(\'"+md.getPicSrc()+"\',\'"+md.getContent()+"\',"+"null)";
	                   
	                                        
	                      
	                     if(stmt.executeUpdate(inmoodsql)==1); 
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
	 

 
 
	 
public  ResultSet searchmood()
	 {
		 
		 
		 try{   
			  
           
     
            Class.forName("com.mysql.jdbc.Driver");

            String sql="select * from mood";
            
            Connection con = DriverManager.getConnection(url,dbUser,dbPwd);

           // out.print("������5����������");   

            Statement stmt=con.createStatement();   

            ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
           
              
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
