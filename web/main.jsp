<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/19
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
  <title>主页面</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<table width="550" border="0" align="center">
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
          <td width="105" align="center">发送时间</td>
          <td width="65">接收人</td>
          <td width="300">信息内容</td>
          <td width="40">删除</td>
        </tr>
        <%
           List mages = (List) session.getAttribute("mages");
           pageContext.setAttribute("mages",mages);
        %>
          <c:forEach items="${mages}" var="ms">
              <tr>
                  <td align="center">${ms.sendname}</td>
                  <td align="center">${ms.time}</td>
                  <td align="center">${ms.acceptname}</td>
                  <td >${ms.say}</td>
                  <td align="center">
                      <a href="${pageContext.request.contextPath}/DeleteServlet?id=${ms.id}">
                          <img src="${pageContext.request.contextPath}/trash.gif">
                          <${pageContext.request.contextPath}/img>
                      </a>
                  </td>
              </tr>
          </c:forEach>

</body>
</html>

