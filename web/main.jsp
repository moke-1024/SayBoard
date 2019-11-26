<%@ page import="com.sayboard.domain.Mage" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
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
        <%
           ArrayList<Mage> mages = new ArrayList();
           mages = (ArrayList) session.getAttribute("mages");
           if (mages != null){
               Iterator<Mage> mage = mages.iterator();
               while (mage.hasNext()){
                   Mage ms = mage.next();
        %>
        <tr>
          <td align="center"><%= ms.getSendname().toString()%></td>
          <td align="center"><%= ms.getTime().toString() %></td>
          <td align="center"><%= ms.getAcceptname()%></td>
          <td ><%= ms.getSay()%></td>
          <td align="center"><a href="${pageContext.request.contextPath}/main.jsp">
            <img src="${pageContext.request.contextPath}/trash.gif" name="<%=ms.getId()%>"></img>
          </a></td>
        </tr>
          <%
              }
           }
          %>

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

