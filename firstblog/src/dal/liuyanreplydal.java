package dal;

import java.sql.*;

import model.admin;
import utils.dbconstant;
public class liuyanreplydal {
	
	 String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
  
	Connection con = null;
	
	//����ظ�
	
	public  boolean insertliuyanreply(String lreply,int lyid) {
	    
	    boolean f=false;


	 try{   

		  //ʹ������  ��ȡ����   ��ȡ Statement
		  Class.forName(driverClass);
		  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	     Statement stmt=con.createStatement();  	          
	  
	     
	   
	   	  
	   	  String inliuyanreplySql= "insert into liuyanreply(`lreply`,`lyId`,`lrDate`) values(\'"+lreply+"\',\'"+lyid+"\',null)";
	   	  
	    
	         
	   //ִ�в���
	     if(stmt.executeUpdate(inliuyanreplySql)==1)  
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

	public  ResultSet searchallreplybycmid(int lyid){
		 
		 try{   
			  
	      

			//ʹ������  ��ȡ����   ��ȡ Statement
			   Class.forName(driverClass);                 
	          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	          Statement stmt=con.createStatement();   
			 
	   

	       String liuyanreplysql="select * from liuyanreply where lyId='"+lyid+"'";                    

	       ResultSet rs=stmt.executeQuery(liuyanreplysql); //ִ�в�ѯ 
	      
	         
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
