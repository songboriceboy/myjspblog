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
	
	
//插入博客	
public  boolean insertblog(blog inblog) {
	                 
                     boolean f=false;
                     int bCateid=0;

		 
	              try{   
	   
	            	  //使用驱动  获取连接   获取 Statement
	            	  Class.forName(driverClass);
	            	  con = DriverManager.getConnection(url,dbUser,dbPwd); 
	                  Statement stmt=con.createStatement();  	          
	                  String inblogSql="";
	                  
	                  if(inblog.getCateName()==null)
	                  {
	                	  
	                	  inblogSql= "insert into blog(`bAuthor`,`bTitle`,`bContent`,`bPicsrc`,`bDate`,`bClicks`,`bComments`,`bIstj`,`bUid`) values('admin',\'"+inblog.getTitle()+"\',\'"+inblog.getContent()+"\',\'"+inblog.getPicSrc()+"\',null,0,0,1,1)";
	                	  
	                  }else{
	                  
	                  // 根据博文类别名   查询博文类别id
                      String cateSql="select * from category where cName='"+inblog.getCateName()+"'";
                      ResultSet cateRs=stmt.executeQuery(cateSql); 
                      cateRs.next();
                      bCateid=cateRs.getInt("cId");
	             
	               	                    
                      inblogSql= "insert into blog(`bAuthor`,`bCatename`,`bTitle`,`bContent`,`bPicsrc`,`bDate`,`bClicks`,`bComments`,`bIstj`,`bUid`,`bCateid`) values('admin',\'"+inblog.getCateName()+"\',\'"+inblog.getTitle()+"\',\'"+inblog.getContent()+"\',\'"+inblog.getPicSrc()+"\',null,0,0,1,1,"+bCateid+")";
	                   
	                  }                    
	                     
	                      
	                //执行插入
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
	   
	                        System.out.print("连接失败！！<br>"+ex.toString());   
	                        return false;
	   
	                  }    

}
	 




	//查询所有博客
public  ResultSet searchblog(){
		
		 
		 try{   
			  
           
			//使用驱动  获取连接   获取 Statement
			  Class.forName(driverClass);                 
              Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
              Statement stmt=con.createStatement();   

            
            
              String selectSql="select * from blog";  
              ResultSet blogRs=stmt.executeQuery(selectSql); //执行查询 
           
              
             //  stmt.close();   

              //  con.close();   
               return blogRs;
  
		 }catch(Exception ex)
                 {   

                     System.out.print("连接失败！！<br>"+ex.toString());   
                     return null;

                   } 
		 
}
	
	 
//判断博文是否分类

public int getblogcateid(int id){
	
	int blogcateid=0;
	 try{   
		  
         
			//使用驱动  获取连接   获取 Statement
			  Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   

         
         
           String Sql="select bCateid from blog where bId=\'"+id+"\'";  
           ResultSet blogRs=stmt.executeQuery(Sql); //执行查询 
        
           if(blogRs.next())
           {
        	   blogcateid=blogRs.getInt(1);
        	   stmt.close();   

               con.close();            
        	   
           }
           
           return blogcateid;
          
            

		 }catch(Exception ex)
              {   

                  System.out.print("连接失败！！<br>"+ex.toString());   
                  return 0;

                } 
		 
	
	
}






//判断博文类别是否空

public boolean cateisnull(int id){
	
	boolean f=false;
	 try{   
		  
       
			//使用驱动  获取连接   获取 Statement
			  Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   

       
       
         String Sql="select * from blog where bId=\'"+id+"\'";  
         ResultSet blogRs=stmt.executeQuery(Sql); //执行查询 
      
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

                System.out.print("连接失败！！<br>"+ex.toString());   
                return false;

              } 
		 
	
	
}






	 
//删除博客	 
		 
	 
public  boolean  deletblog(int id){
		 
		 boolean f=false;
		 try{   
			  
           
     
				//使用驱动  获取连接   获取 Statement
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

                  System.out.print("连接失败！！<br>"+ex.toString());   
                  return false;

             } 
		 	 
		 
}
	

//更新博客	 
public  boolean  updateblog(blog upblog)
	 {
		 
		 
		 
		 boolean f=false;
		 
		 
		 try{   
			  
           
     

				//使用驱动  获取连接   获取 Statement
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
            
           

            
            
            if(stmt.executeUpdate(upSql)==1); //执行更新 
            {
            	f=true;
            }
              
                stmt.close();   

               con.close();   
             return f;
  
		 }catch(Exception ex)
                {   

                     System.out.print("连接失败！！<br>"+ex.toString());   
                    return false;

                 } 
		 
}


//类别空 改为空
public  boolean  updateblogcatenulltonull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
         
   

				//使用驱动  获取连接   获取 Statement
			 Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           String upSql="";
           
           if(upblog.getCateName()==null)
           {
        	   upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bContent=\""+upblog.getContent()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";    	           	 
          	         	 
           }
         
          
         

          
          
          if(stmt.executeUpdate(upSql)==1); //执行更新 
          {
          	f=true;
          }
            
              stmt.close();   

             con.close();   
           return f;

		 }catch(Exception ex)
              {   

                   System.out.print("连接失败！！<br>"+ex.toString());   
                  return false;

               } 
		 
}



//类别空 改为非空
public  boolean  updateblogcatenulltonotnull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//使用驱动  获取连接   获取 Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
        if(upblog.getCateName()!=null){
        	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=\""+upblog.getCateId()+"\",bContent=\""+upblog.getContent()+"\",bCatename=\""+upblog.getCateName()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
         }
        
        
        
        if(stmt.executeUpdate(upSql)==1); //执行更新 
        {
        	f=true;
        }
          
            stmt.close();   

           con.close();   
         return f;

		 }catch(Exception ex)
            {   

                 System.out.print("连接失败！！<br>"+ex.toString());   
                return false;

             } 
		 
}






//类别非空 改为空
public  boolean  updateblogcatenotnulltonull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//使用驱动  获取连接   获取 Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
         if(upblog.getCateName()==null)
         {
  	           	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=null,bCatename=null,bContent=\""+upblog.getContent()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
        	 
        	 
         }
        
       

        
        
        if(stmt.executeUpdate(upSql)==1); //执行更新 
        {
        	f=true;
        }
          
            stmt.close();   

           con.close();   
         return f;

		 }catch(Exception ex)
            {   

                 System.out.print("连接失败！！<br>"+ex.toString());   
                return false;

             } 
		 
}







//类别非空 改为非空
public  boolean  updateblogcatenotnulltonotnull(blog upblog)
	 {
		 		 
		 boolean f=false;
		 
		 
		 try{   
			  
       
 

				//使用驱动  获取连接   获取 Statement
			 Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String upSql="";
         
         if(upblog.getCateName()!=null)
         {
      	       	 
        	 upSql = "update blog set bTitle=\""+upblog.getTitle()+"\",bCateid=\""+upblog.getCateId()+"\",bContent=\""+upblog.getContent()+"\",bCatename=\""+upblog.getCateName()+"\",bPicsrc=\""+upblog.getPicSrc()+"\" where bId ='"+upblog.getId()+"'";
         }
        
       

        
        
        if(stmt.executeUpdate(upSql)==1); //执行更新 
        {
        	f=true;
        }
          
            stmt.close();   

           con.close();   
         return f;

		 }catch(Exception ex)
            {   

                 System.out.print("连接失败！！<br>"+ex.toString());   
                return false;

             } 
		 
}







//计算博客总数
public int sumblog(){
	
	 
	try{   
		    int sum=0;
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           String sumblogSql="select count(*) from  blog";
           ResultSet sumRs=stmt.executeQuery(sumblogSql); //执行查询 
           
           if(sumRs.next()){
                 sum=sumRs.getInt(1);
             }
           
           stmt.close();   
           
           con.close(); 
           return sum;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return 0;

        } 
	
	
}


//分页查询博客

public ResultSet selectblogpage(int pageSize,int pageNow){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet pageRs=stmt.executeQuery("select * from blog order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize);
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return pageRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}




//根据类别id分页查询博客

public ResultSet selectblogpagebycateid(int cateid,int pageSize,int pageNow){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         String sql="select * from blog  where bCateid="+cateid+" order by bDate DESC LIMIT "+pageSize*(pageNow-1)+","+pageSize;
         
         ResultSet pageRs=stmt.executeQuery(sql);
           //执行查询          
         
        // stmt.close();   
         
        // con.close(); 
         return pageRs;
      
	 }catch(Exception ex)
   {   

          System.out.print("连接失败！！<br>"+ex.toString());   
          return null;

      } 
	
	
}




//分页查询博客

public ResultSet selectblogpagebysql(String sql,int pageSize,int pageNow){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         ResultSet pageRs=stmt.executeQuery(sql);
           //执行查询          
         
        // stmt.close();   
         
        // con.close(); 
         return pageRs;
      
	 }catch(Exception ex)
   {   

          System.out.print("连接失败！！<br>"+ex.toString());   
          return null;

      } 
	
	
}







//根据点击次数查询博客

public ResultSet selectblogbyclick(){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet clickRs=stmt.executeQuery("select * from  blog order by bClicks DESC  limit 0,10");
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return clickRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}




//根据最新时间查询
public ResultSet selectblogbydate(){
	
	 
	try{   
		  
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet dateRs=stmt.executeQuery("select * from  blog order by bDate DESC limit 0,10");
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return dateRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}


// 根据站长推荐查询

public ResultSet selectblogbytj(){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet tjRs=stmt.executeQuery("select * from  blog  where bIstj='1' order by bDate DESC limit 0,10");
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return tjRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}






//根据id查询博文


public ResultSet selectblogbyid(int id){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet tjRs=stmt.executeQuery("select * from  blog where bId='"+id+"'");
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return tjRs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}










//更新博客点击次数
public boolean updateblogclick(int id){
	
	 boolean f=false;
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           String clicksql="UPDATE blog SET bClicks = bClicks+1 where bId='"+id+"'";
           
           if(stmt.executeUpdate(clicksql)==1);
           {f=true;}
             //执行查询          
           
           stmt.close();   
           
           con.close(); 
           return f;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return false;

        } 
	
	
}




//更新博客评论次数

public boolean updateblogcomment(int id){
	
	 boolean f=false;
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
          Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
          Statement stmt=con.createStatement();   
          
          String commentsql="UPDATE blog SET bComments=bComments+1 where bId='"+id+"'";
          
          if(stmt.executeUpdate(commentsql)==1);
          {f=true;}
            //执行查询          
          
          stmt.close();   
          
          con.close(); 
          return f;
       
	 }catch(Exception ex)
    {   

           System.out.print("连接失败！！<br>"+ex.toString());   
           return false;

       } 
	
	
}






//根据类别id更新类别名
public boolean updateblogcatenamebycateid(int id,String catename){
	
	 boolean f=false;
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         String updatecatenamesql="UPDATE blog SET bCatename=\""+catename+"\" where bCateid='"+id+"'";
         
         if(stmt.executeUpdate(updatecatenamesql)==1);
         {f=true;}
           //执行查询          
         
         stmt.close();   
         
         con.close(); 
         return f;
      
	 }catch(Exception ex)
   {   

          System.out.print("连接失败！！<br>"+ex.toString());   
          return false;

      } 
	
	
}






//删除类别 设置博客类别为空
public boolean deletblogcate(int id){
	
	 boolean f=false;
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
       Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
       Statement stmt=con.createStatement();   
       
       String updatecatenamesql="UPDATE blog SET bCatename=null,bCateid=null where bCateid='"+id+"'";
       
       if(stmt.executeUpdate(updatecatenamesql)==1);
       {f=true;}
         //执行查询          
       
       stmt.close();   
       
       con.close(); 
       return f;
    
	 }catch(Exception ex)
 {   

        System.out.print("连接失败！！<br>"+ex.toString());   
        return false;

    } 
	
	
}











//通过类别名查找博客
public ResultSet selectblogbycatename(String catename){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
           Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
           Statement stmt=con.createStatement();   
           
           ResultSet Rs=stmt.executeQuery("select * from blog where bCatename='"+catename+"'");
             //执行查询          
           
          // stmt.close();   
           
          // con.close(); 
           return Rs;
        
	 }catch(Exception ex)
     {   

            System.out.print("连接失败！！<br>"+ex.toString());   
            return null;

        } 
	
	
}




//根据id查询博文


public int searchcateidbyblogid(int id){
	
	 
	try{   
		   
			//使用驱动  获取连接   获取 Statement
		   Class.forName(driverClass);                 
         Connection con = DriverManager.getConnection(url,dbUser,dbPwd);
         Statement stmt=con.createStatement();   
         
         ResultSet Rs=stmt.executeQuery("select * from  blog where bId='"+id+"'");
           //执行查询         
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

          System.out.print("连接失败！！<br>"+ex.toString());   
          return 0;

      } 
	
	
}






	 

}
