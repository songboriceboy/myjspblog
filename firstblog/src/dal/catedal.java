package dal;



import java.sql.*;

import model.category;
import utils.dbconstant;

public class catedal {
	
	
	     String driverClass=dbconstant.getDriverclass();

	      String  url=dbconstant.getUrl();

          String dbUser = dbconstant.getDbuser();   

           String dbPwd = dbconstant.getDbpwd();  
  
	        Connection con = null;
	


	        
	        
	        
	      //��ҳ��ѯ���

public ResultSet selectcatepage(int pageSize,int pageNow){
	        	
	        	 
	        	try{   
	        		   
	        			//ʹ������  ��ȡ����   ��ȡ Statement
	        		   Class.forName(driverClass);                 
	                   Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	                   Statement stmt=con.createStatement();   
	                   
	                   ResultSet pageRs=stmt.executeQuery("select * from category order by cDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
	                     //ִ�в�ѯ          
	                   
	                  // stmt.close();   
	                   
	                  // con.close(); 
	                   return pageRs;
	                
	        	 }catch(Exception ex)
	             {   

	                    System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	                    return null;

	                } 
	        	
	        	
	        }	
	        
	        
	        
	        
	        
	        
	        
//��ѯ��������	        
	       
public int sumcate(){
	        	
	       	 
	        	try{   
	        		    int sum=0;
	        			//ʹ������  ��ȡ����   ��ȡ Statement
	        		   Class.forName(driverClass);                 
	                   Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
	                   Statement stmt=con.createStatement();   
	                   
	                   String sumcateSql="select count(*) from  category";
	                   ResultSet sumRs=stmt.executeQuery(sumcateSql); //ִ�в�ѯ 
	                   
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
	        
	        

// ɾ�����
public  boolean  deletcate(int id)
 {
	
	 boolean f=false;
	 
	 
	 try{   
		  
       
 
		//ʹ������  ��ȡ����   ��ȡ Statement
   	    Class.forName(driverClass);
   	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
         //Statement stmt=con.createStatement();  	 
         PreparedStatement   pstmt=null;
         
         con.setAutoCommit(false); 
         
         String deletecatenamesql="UPDATE blog SET bCatename=null,bCateid=null where bCateid='"+id+"'";
         pstmt=con.prepareStatement(deletecatenamesql);
         pstmt.executeUpdate();
         
         
        String deletecatesql="delete from category  where cId=\'"+id+"\'";
        pstmt=con.prepareStatement(deletecatesql);
        pstmt.executeUpdate();

        
        con.commit();
        pstmt.close();
        con.close();
        return true;

	 }catch(Exception ex)
            {   

         System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
          return false;

           } 
	 
	 
}	


	        
	
	
	//�������
public  boolean  updatecate(int id,String catename)
	 {
		
		 boolean f=false;
		 
		 
		 try{   
			  
           
     
			//ʹ������  ��ȡ����   ��ȡ Statement
       	    Class.forName(driverClass);
       	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  
             
             PreparedStatement   pstmt=null;
             
             con.setAutoCommit(false); 
             
           
            
             
            
            String updatecatesql = "update category set cName=\""+catename+"\",cDate=null"+" where cId ='"+id+"'";

            pstmt=con.prepareStatement(updatecatesql);
            pstmt.executeUpdate();
            
            String updatecatenamesql="UPDATE blog SET bCatename=\""+catename+"\" where bCateid='"+id+"'";
     
            pstmt=con.prepareStatement(updatecatenamesql);
            pstmt.executeUpdate();
            
            con.commit();
            pstmt.close();
            con.close();
            return true;
            
  
		 }catch(Exception ex)
                {   

             System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
              return false;

               } 
		 
		 
}	 
	
	
	

//���������1
public  boolean  addcateblogsum(int id)
 {
	
	 boolean f=false;
	 
	 
	 try{   
		  
       
 
		//ʹ������  ��ȡ����   ��ȡ Statement
   	    Class.forName(driverClass);
   	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
         Statement stmt=con.createStatement();  	 
        
        String sql = "update category set cBlogsum=cBlogsum+1 where cId ='"+id+"'";

    
        
        if(stmt.executeUpdate(sql)==1); //ִ�в�ѯ 
        {f=true;}
          
  stmt.close();   

  con.close();   
   return f;

	 }catch(Exception ex)
            {   

         System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
          return false;

           } 
	 
	 
}	 


//���������1
public  boolean  decateblogsum(int id)
{
	
	 boolean f=false;
	 
	 
	 try{   
		  
      

		//ʹ������  ��ȡ����   ��ȡ Statement
  	    Class.forName(driverClass);
  	     con = DriverManager.getConnection(url,dbUser,dbPwd); 
        Statement stmt=con.createStatement();  	 
       
       String sql = "update category set cBlogsum=cBlogsum-1 where cId ='"+id+"'";

   
       
       if(stmt.executeUpdate(sql)==1); //ִ�в�ѯ 
       {f=true;}
         
 stmt.close();   

 con.close();   
  return f;

	 }catch(Exception ex)
           {   

        System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
         return false;

          } 
	 
	 
}	 

	
	
	
	
//�������	
	
	
public boolean insertcate(category cate) {
	                 
		 
		
		 boolean f=false;
	  	          
	              try{   
	   
	                     
	             
	            	//ʹ������  ��ȡ����   ��ȡ Statement
	            	  Class.forName(driverClass);
	            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	                  Statement stmt=con.createStatement();  	 
	  
	                    
	                      
	                    String sql= "insert into category(`cName`,`cBlogsum`,`cDate`) values(\'"+cate.getName()+"\',\'"+cate.getBlogSum()+"\',null)";
	                   
	                  
	                      
	                      if(stmt.executeUpdate(sql)==1) //ִ�в�ѯ 
		                     {f=true;}
		                     stmt.close();   
		                      con.close(); 
		                   return f;
	   
	          
	                }catch(Exception ex)
	              {   
	   
	                   System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
	                    return false;
	   
	                } 

}
	 
	 
	 
	 
	 
	 
public  ResultSet searchcate()
{
		 
		 
		   try{   
			  
           
     
			//ʹ������  ��ȡ����   ��ȡ Statement
       	     Class.forName(driverClass);
       	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  	 

            String sql="select * from category";
             

            ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
           
              
      // stmt.close();   

      // con.close();   
       return rs;
  
		 }catch(Exception ex)
           {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
           return null;

            } 
		 
		 
}
	



//ͨ��id�������
public  ResultSet searchcatebyid(int id)
{
		 
		 
		   try{   
			  
           
     
			//ʹ������  ��ȡ����   ��ȡ Statement
       	     Class.forName(driverClass);
       	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
             Statement stmt=con.createStatement();  	 

            String sql="select * from category where cId='"+id+"'";
             

            ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
           
              
      // stmt.close();   

      // con.close();   
       return rs;
  
		 }catch(Exception ex)
           {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
           return null;

            } 
		 
		 
}


//ͨ�������������id
public  int searchidbycatename(String catename)
{
		 
		 
		   try{   
			  
         
   
			//ʹ������  ��ȡ����   ��ȡ Statement
     	     Class.forName(driverClass);
     	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
           Statement stmt=con.createStatement();  	 

          String sql="select * from category where cName='"+catename+"'";
           

          ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
          
          int cateid=0;
          
            if(rs.next())
            {
            	cateid=rs.getInt("cId");
            	
            }
    stmt.close();   

     con.close();   
     return cateid;

		 }catch(Exception ex)
         {   

          System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
         return 0;

          } 
		 
		 
}





//����Ƿ���ͬ�����
public  boolean hassamename(String catename)
{
		 boolean f=false;
		 
		   try{   
			  
       
 
			//ʹ������  ��ȡ����   ��ȡ Statement
   	     Class.forName(driverClass);
   	    con = DriverManager.getConnection(url,dbUser,dbPwd); 
         Statement stmt=con.createStatement();  	 

        String sql="select * from category where cName='"+catename+"'";
         

        ResultSet rs=stmt.executeQuery(sql); //ִ�в�ѯ 
        
        
          if(rs.next())
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
