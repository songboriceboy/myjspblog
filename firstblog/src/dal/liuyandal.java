package dal;
import java.sql.*;

import model.liuyan;
import utils.dbconstant;

public class liuyandal {
	
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;

	
	//��ѯ��������
	
public int sumliuyan(){
		
		 
		try{   
			    int sum=0;
				//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
	           
	           String sumliuyansql="select count(*) from  liuyan";
	           ResultSet sumRs=stmt.executeQuery(sumliuyansql); //ִ�в�ѯ 
	           
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


public ResultSet selectliuyanpage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet liuyanRs=stmt.executeQuery("select * from liuyan order by lDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return liuyanRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}




	//��������
	
public  boolean insertliuyan(liuyan ly) {
	                 
		 boolean f=false;
		 
	  	          
	              try{   
	   
	                     
	             
	            	//ʹ������  ��ȡ����   ��ȡ Statement
	   			   Class.forName(driverClass);                 
	   	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	   	           Statement stmt=con.createStatement(); 
	  
	                    
	                      
	                    String sql= "insert into liuyan(`lUser`,`lEmail`,`lContent`,`lPicsrc`,`lDate`) values(\'"+ly.getUserName()+"\',\'"+ly.getUserEmail()+"\',\'"+ly.getMessage()+"\',\'"+ly.getPicSrc()+"\',null)";
	                   
	                     System.out.print(sql);
	                                          
	                      
	                      if(stmt.executeUpdate(sql)==1) //ִ�в�ѯ 
		                     {
	                    	  f=true;
		                     }
		                     stmt.close();   
		                      con.close(); 
		                   return f;   
	   
	          
	       }
	          
	 catch(Exception ex)
	 {   
	   
	 System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	 return false;
	   
	 } 

	 }
	 
	 



public  ResultSet searchliuyan(){
		 		 
		 try{   
			  
           
     
			//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	           Statement stmt=con.createStatement();   
			 
        

            String liuyansql="select * from liuyan";                     

            ResultSet rs=stmt.executeQuery(liuyansql); //ִ�в�ѯ 
           
              
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


