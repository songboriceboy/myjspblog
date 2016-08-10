package dal;


import java.sql.*;
import model.blog;

import utils.dbconstant;


public class blogdal {
	
	
	String driverClass=dbconstant.getDriverclass();

	 String  url=dbconstant.getUrl();

   String dbUser = dbconstant.getDbuser();   

   String dbPwd = dbconstant.getDbpwd();  
   
	Connection con = null;
	
	
//���벩��	
public  boolean insertblog(blog inblog) {
	                 
                     boolean f=false;
                     int bCateid=0;

		 
	              try{   
	   
	            	  //ʹ������  ��ȡ����   ��ȡ Statement
	            	  Class.forName(driverClass);
	            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	                  Statement stmt=con.createStatement();  	          
	                  String inblogSql="";
	                  
	                  if(inblog.getCateName()==null)
	                  {
	                	  
	                	  inblogSql= "insert into blog(`bAuthor`,`bTitle`,`bContent`,`bPicsrc`,`bDate`,`bClicks`,`bComments`,`bIstj`,`bUid`) values('admin',\'"+inblog.getTitle()+"\',\'"+inblog.getContent()+"\',\'"+inblog.getPicSrc()+"\',null,0,0,1,1)";
	                	  
	                  }else{
	                  
	                  // ���ݲ��������   ��ѯ�������id
                      String cateSql="select * from category where cName='"+inblog.getCateName()+"'";
                      ResultSet cateRs=stmt.executeQuery(cateSql); 
                      cateRs.next();
                      bCateid=cateRs.getInt("cId");
	             
	               	                    
                      inblogSql= "insert into blog(`bAuthor`,`bCatename`,`bTitle`,`bContent`,`bPicsrc`,`bDate`,`bClicks`,`bComments`,`bIstj`,`bUid`,`bCateid`) values('admin',\'"+inblog.getCateName()+"\',\'"+inblog.getTitle()+"\',\'"+inblog.getContent()+"\',\'"+inblog.getPicSrc()+"\',null,0,0,1,1,"+bCateid+")";
	                   
	                  }                    
	                     
	                      
	                //ִ�в���
	                  if(stmt.executeUpdate(inblogSql)==1)  
	                   {
	                	  
	                	  /*
	                	  if(bCateid!=0)
	                	  {
	                	  String updatecatesql="update category set cBlogsum=cBlogsum+1  where  cId='"+bCateid+"'";
	                	  stmt.executeUpdate(updatecatesql);
	                	  }
	                	  */
	                	  
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
	 




	//��ѯ���в���
public  ResultSet searchblog(){
		
		 
		 try{   
			  
           
			//ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);                 
              Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
              Statement stmt=con.createStatement();   

            
            
              String selectSql="select * from blog";  
              ResultSet blogRs=stmt.executeQuery(selectSql); //ִ�в�ѯ 
           
              
             //  stmt.close();   

              //  con.close();   
               return blogRs;
  
		 }catch(Exception ex)
                 {   

                     System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                     return null;

                   } 
		 
}
	
	 
//�жϲ����Ƿ����

public int getblogcateid(int id){
	
	int blogcateid=0;
	 try{   
		  
         
			//ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   

         
         
           String Sql="select bCateid from blog where bId=\'"+id+"\'";  
           ResultSet blogRs=stmt.executeQuery(Sql); //ִ�в�ѯ 
        
           if(blogRs.next())
           {
        	   blogcateid=blogRs.getInt(1);
        	   stmt.close();   

               con.close();            
        	   
           }
           
           return blogcateid;
          
            

		 }catch(Exception ex)
              {   

                  System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
                  return 0;

                } 
		 
	
	
}






//�жϲ�������Ƿ��

public boolean cateisnull(int id){
	
	boolean f=false;
	 try{   
		  
       
			//ʹ������  ��ȡ����   ��ȡ Statement
			  Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   

       
       
         String Sql="select * from blog where bId=\'"+id+"\'";  
         ResultSet blogRs=stmt.executeQuery(Sql); //ִ�в�ѯ 
      
         if(blogRs.next())
         {
        	 if(blogRs.getString("bCatename")==null)
        	 {
      	         f=true;
      	             
        	 }
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






	 
//ɾ������	 
		 
	 
public  boolean  deletblog(int id){
		 
		 boolean f=false;
		 try{   
			  
           
     
				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
             Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
             Statement stmt=con.createStatement();   
            
            
            
            String deSql="delete from  blog where bId='"+id+"'";
            
  
            
            if(stmt.executeUpdate(deSql)==1){
            	
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
	

//���²���	 
public  boolean  updateblog(blog upblog)
	 {
		 
		 
		 
		 boolean f=false;
		 
		 
		 try{   
			  
           
     

				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
             Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
             Statement stmt=con.createStatement();   
             String upSql="";
             
             if(upblog.getCateName()==null)
             {
            	          	           	 
            	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bContent=\""+upblog.getContent()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
            	 
            	 
             }else{
            	 
            	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=\""+upblog.getCateId()+"\",bContent=\""+upblog.getContent()+"\",bCatename=\""+upblog.getCateName()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
             }
            
           

            
            
            if(stmt.executeUpdate(upSql)==1); //ִ�и��� 
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


//���� ��Ϊ��
public  boolean  updateblogcatenulltonull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
         
   

				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           String upSql="";
           
           if(upblog.getCateName()==null)
           {
        	   upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bContent=\""+upblog.getContent()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";    	           	 
          	         	 
           }
         
          
         

          
          
          if(stmt.executeUpdate(upSql)==1); //ִ�и��� 
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



//���� ��Ϊ�ǿ�
public  boolean  updateblogcatenulltonotnull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
        if(upblog.getCateName()!=null){
        	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=\""+upblog.getCateId()+"\",bContent=\""+upblog.getContent()+"\",bCatename=\""+upblog.getCateName()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
         }
        
        
        
        if(stmt.executeUpdate(upSql)==1); //ִ�и��� 
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






//���ǿ� ��Ϊ��
public  boolean  updateblogcatenotnulltonull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
         if(upblog.getCateName()==null)
         {
  	           	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=null,bCatename=null,bContent=\""+upblog.getContent()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
        	 
        	 
         }
        
       

        
        
        if(stmt.executeUpdate(upSql)==1); //ִ�и��� 
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







//���ǿ� ��Ϊ�ǿ�
public  boolean  updateblogcatenotnulltonotnull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//ʹ������  ��ȡ����   ��ȡ Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
         if(upblog.getCateName()!=null)
         {
      	       	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=\""+upblog.getCateId()+"\",bContent=\""+upblog.getContent()+"\",bCatename=\""+upblog.getCateName()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
         }
        
       

        
        
        if(stmt.executeUpdate(upSql)==1); //ִ�и��� 
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







//���㲩������
public int sumblog(){
	
	 
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


//��ҳ��ѯ����

public ResultSet selectblogpage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet pageRs=stmt.executeQuery("select * from blog order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
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




//�������id��ҳ��ѯ����

public ResultSet selectblogpagebycateid(int cateid,int pageSize,int pageNow){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String sql="select * from blog  where bCateid="+cateid+" order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
         
         ResultSet pageRs=stmt.executeQuery(sql);
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




//��ҳ��ѯ����

public ResultSet selectblogpagebysql(String sql,int pageSize,int pageNow){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         ResultSet pageRs=stmt.executeQuery(sql);
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







//���ݵ��������ѯ����

public ResultSet selectblogbyclick(){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet clickRs=stmt.executeQuery("select * from  blog order by bClicks DESC  limit 0,10");
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return clickRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}




//��������ʱ���ѯ
public ResultSet selectblogbydate(){
	
	 
	try{   
		  
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet dateRs=stmt.executeQuery("select * from  blog order by bDate DESC limit 0,10");
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return dateRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}


// ����վ���Ƽ���ѯ

public ResultSet selectblogbytj(){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet tjRs=stmt.executeQuery("select * from  blog  where bIstj='1' order by bDate DESC limit 0,10");
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return tjRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}






//����id��ѯ����


public ResultSet selectblogbyid(int id){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet tjRs=stmt.executeQuery("select * from  blog where bId='"+id+"'");
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return tjRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}










//���²��͵������
public boolean updateblogclick(int id){
	
	 boolean f=false;
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           String clicksql="UPDATE blog SET bClicks = bClicks+1 where bId='"+id+"'";
           
           if(stmt.executeUpdate(clicksql)==1);
           {f=true;}
             //ִ�в�ѯ          
           
           stmt.close();   
           
           con.close(); 
           return f;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return false;

        } 
	
	
}




//���²������۴���

public boolean updateblogcomment(int id){
	
	 boolean f=false;
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
          
          String commentsql="UPDATE blog SET bComments=bComments+1 where bId='"+id+"'";
          
          if(stmt.executeUpdate(commentsql)==1);
          {f=true;}
            //ִ�в�ѯ          
          
          stmt.close();   
          
          con.close(); 
          return f;
       
	 }catch(Exception ex)
    {   

           System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
           return false;

       } 
	
	
}






//�������id���������
public boolean updateblogcatenamebycateid(int id,String catename){
	
	 boolean f=false;
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         String updatecatenamesql="UPDATE blog SET bCatename=\""+catename+"\" where bCateid='"+id+"'";
         
         if(stmt.executeUpdate(updatecatenamesql)==1);
         {f=true;}
           //ִ�в�ѯ          
         
         stmt.close();   
         
         con.close(); 
         return f;
      
	 }catch(Exception ex)
   {   

          System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
          return false;

      } 
	
	
}






//ɾ����� ���ò������Ϊ��
public boolean deletblogcate(int id){
	
	 boolean f=false;
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
       Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
       Statement stmt=con.createStatement();   
       
       String updatecatenamesql="UPDATE blog SET bCatename=null,bCateid=null where bCateid='"+id+"'";
       
       if(stmt.executeUpdate(updatecatenamesql)==1);
       {f=true;}
         //ִ�в�ѯ          
       
       stmt.close();   
       
       con.close(); 
       return f;
    
	 }catch(Exception ex)
 {   

        System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
        return false;

    } 
	
	
}











//ͨ����������Ҳ���
public ResultSet selectblogbycatename(String catename){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet Rs=stmt.executeQuery("select * from blog where bCatename='"+catename+"'");
             //ִ�в�ѯ          
           
          // stmt.close();   
           
          // con.close(); 
           return Rs;
        
	 }catch(Exception ex)
     {   

            System.out.print("����ʧ�ܣ���<br>"+ex.toString());   
            return null;

        } 
	
	
}




//����id��ѯ����


public int searchcateidbyblogid(int id){
	
	 
	try{   
		   
			//ʹ������  ��ȡ����   ��ȡ Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         ResultSet Rs=stmt.executeQuery("select * from  blog where bId='"+id+"'");
           //ִ�в�ѯ         
         int cateid=0;
         if(Rs.next())
         {
        	 cateid=Rs.getInt("bCateid");
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






	 

}
