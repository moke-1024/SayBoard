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
  <title>登录界面</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<form action="<%=request.getContextPath()%>/LoginServlet" method="POST">
  <table width="258" border="1" align="center" cellspacing="1" bordercolor="#3399CC">
    <tr align="center">
      <td colspan="2" height="59"><font size="6"><b><font color="#330099" size="5">开发部内部留言板</font></b></font></td>
    </tr>

    <tr>
      <td width="96" align="right">姓名:</td>
      <td width="154">
        <span class="tdx" colspan="5" style="color: red;text-align: center">
          <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
        <input type="text" name="empName" size="15">
      </td>
    </tr>
    <tr>
      <td width="96" align="right">口令:</td>
      <td width="154">
        <input type="text" name="password" size="15">
      </td>
    </tr>
    <tr align="center">
      <td colspan="2">
        <input type="submit" name="oper" value=" 登  录 ">
        <input type="reset" name="reset" value=" 复  位 ">
        <a href="<%=request.getContextPath()%>/regist.jsp">注册</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>

