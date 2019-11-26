<%@ page import="com.sayboard.domain.Mage" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/19
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>主页面</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<table width="500" border="0" align="center">
  <tr>
    <td height="34">
      <font size="4"><b><a href="${pageContext.request.contextPath}/fabu.jsp">发布信息</a></b></font> &nbsp;
      &nbsp; &nbsp; <a href="${pageContext.request.contextPath}/LogoutServlet"><b><font size="4"> 退出系统</font></b></a>
    </td>
  </tr>
  <tr>
    <td height="32" valign="bottom"><font size="4"><b>留言信息:</b></font></td>
  </tr>

  <tr>
    <td>
      <table width="100%" border="1" bordercolor="#3399CC" cellspacing="1">
        <tr align="center">
          <td width="65">发送人</td>
          <td width="95" align="center">发送时间</td>
          <td width="65">接收人</td>
          <td width="230">信息内容</td>
          <td width="40">删除</td>
        </tr>
        <tr>
          <td align="center">周兴池</td>
          <td align="center">2005-01-23</td>
          <td align="center">所有人</td>
          <td >今晚不加班,一起去Happy!</td>
          <td align="center"><a href="${pageContext.request.contextPath}/main.jsp">
            <img src="${pageContext.request.contextPath}/trash.gif"></img></a></td>
        </tr>
        <tr>
          <td align="center">林轻侠</td>
          <td align="center">2005-01-24</td>
          <td align="center">张三丰</td>
          <td >发薪水啦, 快还钱!</td>
          <td align="center"><a href="${pageContext.request.contextPath}/main.jsp"><img src="${pageContext.request.contextPath}/trash.gif"></img></a></td>
        </tr>

        <tr>
          <td align="center">李逍遥</td>
          <td align="center">2005-01-26</td>
          <td align="center">张三丰</td>
          <td >今晚8点半野猪林,不见不散!</td>
          <td align="center"><a href="${pageContext.request.contextPath}/main.jsp">
            <img src="${pageContext.request.contextPath}/trash.gif"></img>
          </a></td>
        </tr>
        <%
           Mage mage = new Mage();
           pageContext.setAttribute("mage",mage);
        %>
        <tr>
          <td align="center">${mage.sendname}</td>
          <td align="center">${mage.time}</td>
          <td align="center">${mage.acceptname}</td>
          <td >${mage.say}</td>
          <td align="center"><a href="${pageContext.request.contextPath}/main.jsp">
            <img src="${pageContext.request.contextPath}/trash.gif"></img>
          </a></td>
        </tr>

      </table>
      <p>&nbsp;</p>
    </td>
  </tr>
  <tr>
    <td>
      <p>&nbsp;</p>
    </td>
  </tr>
</table>
</body>
</html>

