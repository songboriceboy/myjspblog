package dal;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

import utils.dbconstant;

public class hitsdal {
	
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

  String dbUser = dbconstant.getDbuser();   

  String dbPwd = dbconstant.getDbpwd();  
	
	 Connection con = null; 
	 
	 
	
public  int searchhits()
	 {
		 
		 
		ResultSet hitsrs=null;
		
		try{ 
		
		

		 
		  
        
			 //ʹ������  ��ȡ����   ��ȡ Statement
      	  Class.forName(driverClass);
      	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
          Statement stmt=con.createStatement();  	   

         String sql="select * from hits";
          

         hitsrs=stmt.executeQuery(sql); //ִ�в�ѯ 
       
          hitsrs.next();


		 }catch(Exception ex)
         {   

              System.out.print("����ʧ�ܣ���<br>"+ex.toString());   

             }
		
		
		
		int times=0;
		try {
			times = hitsrs.getInt("hTimes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return times;
	}
		 

	
	
	
	
public int prevtimes(String ndate){
		
		ResultSet prrs=null;

		int prtimes=0;
		 
		 Date date = new Date();  
			//�������ڸ�ʽ����ʽΪ��yyyy-MM-dd  
			SimpleDateFormat  SDF = new SimpleDateFormat("yyyy-MM-dd");  
			//��ʽ����ǰ����  
			String nowdate=SDF.format(date.getTime()); 
		 
		 
		 
		 try{   
			  
         
			
   
			 //ʹ������  ��ȡ����   ��ȡ Statement
       	    Class.forName(driverClass);
       	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  	   
          
          String sql = "select * from hits";

       

          prrs=stmt.executeQuery(sql);
          
           while(prrs.next())
           {
           	if(nowdate.equals(prrs.getString("hDate")))
           	{
           		if(prrs.previous());
           		{
           			try {
        				prtimes = prrs.getInt("hTimes");
        			} catch (SQLException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
           			return prtimes;
           			
           			}
           		
           	    }           	
           	
              }
          
		 
          }catch(Exception ex)
          {   

              System.out.print("����ʧ�ܣ���<br>"+ex.toString());   

           }     
		 
		 
			return 0;		
	}




}
	


