<%@ page language="java" 
import="java.util.*" 
import="java.io.File"
pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="java.io.*"%>   
  
<%@ page import="java.util.*"%>   
  
<%@ page import="java.sql.*"%>   

<%@ page import="utils.gettime"%>

<%@ page import="java.util.Date"%>   
  
<%@ page import="java.text.DateFormat"%>   

<%@ page import="java.text.SimpleDateFormat"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>风云的个人简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style type="text/css">
	ul.imglist{ margin:0 auto; width:1000px; overflow:hidden} 
    ul.imglist li{ float:left; padding:4px 8px; width:300px} 
    ul.imglist li img{ display:block; width:300px; height:300px} 
    ul.imglist li span{ display:block; width:100%; height:30px; line-height:30px; background:#F6F6F6} 	
   </style>

  </head>
  
  <body bgcolor="#CCFFCC" lang=ZH-CN link=blue vlink=blue style='tab-interval:21.0pt'topmargin=4>
  
  
  
  
 
 <% 
 
 
gettime gt=new gettime();

 if (application.getAttribute("count") == null) { 
        application.setAttribute("count", new Integer(0)); 
    } 
    Integer count = (Integer) application.getAttribute("count"); 
    application 
            .setAttribute("count", new Integer(count.intValue() + 1)); 
    count = (Integer) application.getAttribute("count"); 
 
 
 Date current_date = new Date();  
	//设置日期格式化样式为：yyyy-MM-dd  
	SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	//格式化当前日期  
	String ndate=SimpleDateFormat.format(current_date.getTime()); 
	
 gt.updatetimes(count.intValue(),ndate);
 
 
   
     %> 



<form action="" method="post">
  
  
<center><h1> <input type="text" name="h1" size="35" value="风云的个人简历(网页版)"> </h1></center>
<hr size=6 color=orange width=60% align="center">
<center><pre><input type="text" name="h1" size="50" value="制作人：软件学院  风云  学号：09123  编号：30"></pre></center>
 <center><pre><input type="text" name="h1" value="（个人博客：风云）"></pre></center>
<table cellspacing="0.9" border="1" align=center style='font-size:10.0pt'box="3">
  <th bgcolor="#99CC33" colspan="7" style='width=520pt;text-align:center;line-height:35pt;color:#CC0000' align="center"><font size="+4"><i><big><input type="text" name="h1" value="风云的个人简历"></big></i></font></th>
  <tr>
    <th bgcolor=#FDEBDF style='width=55pt;height=25pt'>姓名：</th>
    <td style='width=55pt'><input type="text" name="h1" value="风云"></td>
    <th bgcolor=#FDEBDF style='width=50pt'>出生日期:</th>
    <td style='width=55pt'><input type="text" name="h1" value="1991-04-23"></td>
    <th bgcolor=#FDEBDF style='width=50pt'>姓别：</th>
    <td style='width=40pt'><input type="text" name="h1" value="男"></td>
    <th rowspan="6"><img src="images/01.jpg"   style='width=180pt;height=130pt'></th>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF style=' height=25pt'>身份证：</th>
    <td><input type="text" name="h1" value="43042xxxxxxxxxxxxxxxxx"></td>
    <th bgcolor=#FDEBDF>户口：</th>
    <td><input type="text" name="h1" value="湖南·衡阳"></td>
    <th bgcolor=#FDEBDF>婚姻状况：</th>
    <td><input type="text" name="h1" value="未婚"></td>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF style='height=25pt'>目前月薪：</th>
    <td><input type="text" name="h1" value="2500～3600"></td>
    <th bgcolor=#FDEBDF>视力：</th>
    <td><input type="text" name="h1" value="近视"></td>
    <th bgcolor=#FDEBDF>身高：</th>
    <td><input type="text" name="h1" value="173cm"></td>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF style='height=25pt'>联系电话：</th>
    <td><input type="text" name="h1" value="15116457972"></td>
    <th bgcolor=#FDEBDF>电子邮箱：</th>
    <td ><a href="2890408644@qq.com"><input type="text" name="h1" value="2890408644@qq.com"></a></td>
    <th bgcolor=#FDEBDF>个人主页：</th>
    <
    <td><a href="http://blog.csdn.net/judyge"></a><input type="text" size="35" name="h1" value="http://blog.csdn.net/judyge"></td>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF style='height=25pt'>目前所在地：</th>
    <td ><input type="text" name="h1" value="广东省广州市"></td>
    <th bgcolor=#FDEBDF style='height=25pt'>通讯地址：</th>
    <td><input type="text" size="35" name="h1" value="广东省广州市（510320）"></td>
    <th bgcolor=#FDEBDF>工作时间：</th>
    <td><input type="text" name="h1" value="2010年"></td>
  </tr>
  <tr> </tr>

  <tr>
    <th bgcolor=#FDEBDF>专业实践经历</th>
    <td colspan="6"><p>
      <pre>
<textarea rows="7" cols="80">

</textarea>
 *2009年5月  个人博客 （jsp）【独立项目】 发博文 简历 相册 留言互动
 *2009年7月  阅读器（android）【独立项目】 阅读电子书功能
 *2009年7月  贪食蛇（android）【独立项目】 实现贪食蛇游戏功能
 </pre>
        </p></td>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF style='height=25pt'>外语水平：</th>
    <td colspan="6">外语语种：
      &nbsp;   &nbsp; <input type="text" name="h1" value="英语"> 掌握程度： &nbsp;       &nbsp;   <input type="text" name="h1" value="一般">口语能力：     &nbsp;   &nbsp; <input type="text" name="h1" value="一般"> 考级：<input type="text" name="h1" value="六级"></td>
  </tr>
  <tr>
    <th bgcolor=#FDEBDF>所获奖励和证书</th>
    <td colspan="6"><p>
      <pre>
  <textarea rows="7" cols="80">

</textarea>
 2009年10月 入党优秀高培成员
 2008年10月 院级优秀团员


      </pre>
        <p></p>
  </tr>
  <tr>
    <th colspan="7" bgcolor="#FF6633"style='width=520pt;text-align:center;line-height:25pt;color:#CC0000'><font size="+3">教育背景</font></th>
  </tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>教育经历：</th>
    <td colspan="6"><p>
      <pre>
<textarea rows="7" cols="80">

</textarea>
 *2005年9月-2008年6月  衡阳县第二中学
 
 ······
 </pre></td>
  </tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>主修课程：</th>
    <td colspan="6"><p>
 <textarea rows="7" cols="80">

</textarea>
 <br>《C语言程序设计》、《数据结构》、《SQL 2005数据库》、
 </br>《ADO.net GUI应用程序开发》、《WEB应用程序开发》、
      《C#程序设计》、<br>《java 程序设计》、《UML与软件工程》、《网络通信技术与原理》等
  
    </td>
  </tr>
   <tr>
    <th colspan="7"  bgcolor="#FF6633" style='width=520pt;text-align:center;line-height:25pt;color:#CC0000'><font size="+3">社会实践</font></th>
  </tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>社会实践经历：</th>
    <td colspan="6">
 <pre>
 <textarea rows="7" cols="80">

</textarea>
 *2009年9月-2010年10月：软件学院计算机协会会长
 

</pre></td>
</tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>自我评价：</th>
    <td colspan="6"><p>
      <pre>
  <textarea rows="7" cols="80">

</textarea>
      ◎活泼开朗、乐观向上、待人热情、兴趣广泛、适应力强、上手快
      ◎ 勤奋好学、脚踏实地、认真负责、坚毅不拔、吃苦耐劳、勇于迎接新挑战。
      ◎ 人性格开朗、诚实稳重、热情大方、待人真诚
      ◎ 自信而不轻狂,执着而不任意,内敛而不随意.工作认真负责，积极主动，能吃苦耐劳
      ◎ 有较强的组织能力、沟通能力、实际动手能力和团体协作精神，对不同的工作环境有很好的适应能力
  
  </pre>
        <p></p>
    <td>
  </tr>
  <tr>
    <th  bgcolor="#FF6633" colspan="7" style='width=520pt;text-align:center;line-height:25pt;color:#CC0000'><font size="+3">求职意向</font></th>
  </tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>工作地点：</th>
    <td colspan="6"><input type="text" size="50" name="h1" value="北京、上海、深圳、广州、杭州"></td>
  </tr>
  <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>求职意向：</th>
    <td colspan="6"><input type="text" size="50" name="h1" value="高级程序员/网站开发/软件测试/项目经理"></td>
  </tr>
    <tr>
    <th style='height=25pt' bgcolor=#FDEBDF>薪资要求：</th>
    <td colspan="6"><input type="text" size="50" name="h1" value="2500-4500 RMB/月"></td>
  </tr>
</table>
<br>
<br>

</form>

 <table bgcolor="#0066FF" width="100%" ><th ><font color="#FF6600" size="+2">
 中北大学软件学院&nbsp;&nbsp;<br>
 软件开发班&nbsp;风云&nbsp;学号：0925033504&nbsp;编号：30<br>
 联系我&nbsp;QQ：2890408644&nbsp;E-mail：<a href="2890408644@qq">2890408644@qq.com</a><br>
 版权所有&nbsp;&nbsp;&nbsp;&nbsp;侵权不究</font></th>
 </table>
 
</body>
</html>