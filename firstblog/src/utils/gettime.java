package utils;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar; 
import java.io.*; 
import java.util.*; 
import java.sql.*;

import utils.dbconstant;

public class gettime {
	
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

    String dbUser = dbconstant.getDbuser();   

    String dbPwd = dbconstant.getDbpwd();  
	
	
	Connection con = null;
	
	//�������ڶ���  
	

	 Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
	 int year = c.get(Calendar.YEAR);
	 int month = c.get(Calendar.MONTH);
	 int date = c.get(Calendar.DATE);
	 int hour = c.get(Calendar.HOUR_OF_DAY);
	 int minute = c.get(Calendar.MINUTE);
	 int second = c.get(Calendar.SECOND); 
	 

	 
	public boolean updatetimes(int count,String ndate)
	{

		 boolean f=false;
		 
		 
		 try{   
			  
			 
			 //ʹ������  ��ȡ����   ��ȡ Statement
       	    Class.forName(driverClass);
       	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement(); 
          
			String datesql="select * from hits";
    
           
           String upsql = "update hits set hTimes=\""+count+"\"  where hDate ='"+ndate+"'";

           
         

           ResultSet rs=stmt.executeQuery(datesql);
           
            while(rs.next())
            {
            	if(ndate.equals(rs.getString("hDate")))
            	{
            		 if(stmt.executeUpdate(upsql)==1); //ִ�в�ѯ 
                     {
                     f=true;
                     stmt.close();   

                     con.close();
                     return f;
                     }
            	}           	
            	stmt.close();   

                con.close();
            }
           
            
           
            
            String insql= "insert into hits(`hTimes`,`hDate`) values(\'"+count+"\',\'"+ndate+"\')";
                                   	                               
            if(stmt.executeUpdate(insql)==1) //ִ�в�ѯ 
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
	
	
	
	
	
}
