<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/19
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>发布页面</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<table width="331" border="0" align="center">
  <tr>
    <td height="34"><font size="4"><b> <a href="<%=request.getContextPath()%>/main.jsp">返回主页</a></b></font> &nbsp;
      &nbsp; &nbsp; <a href="<%=request.getContextPath()%>/LogoutServlet"><b><font size="4"> 退出系统</font></b></a></td>
  </tr>
  <tr>
    <td height="32" valign="bottom"><font size="4"><b>信息发送:</b></font></td>
  </tr>
  <form action="main.jsp">
    <tr>
      <td>
        <table width="308" border="1" bordercolor="#3399cc" cellspacing="1">
          <tr>
            <td width="86" align="right">接收人:</td>
            <td width="209">
              <input type="text" name="textfield">
            </td>
          </tr>
          <tr valign="top">
            <td width="86" align="right">信息内容:</td>
            <td width="209">
              <textarea name="textfield2"></textarea>
            </td>
          </tr>
          <tr align="center">
            <td colspan="2">
              <input type="submit" name="oper" value=" 发  送 ">
              <input type="reset" name="reset" value=" 复  位 ">
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </form>
  <tr>
    <td>&nbsp; </td>
  </tr>
</table>
</body>
</html>
