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
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
  <script type="text/javascript">
      var formObj={
          "checkData":function(){
              var canSub = true;
              canSub = this.checkNull("empName","用户名不能为空!") && canSub;
              canSub = this.checkNull("password","密码不能为空!")&& canSub;
               return canSub;
          },
          "checkNull":function(name,msg){
              var tag = $("input[name='"+name+"']").val();
              $("input[name='"+name+"']").nextAll("span").text("");
              if(tag == ""){
                $("input[name='"+name+"']").nextAll("span").text(msg);
                return false;
              }
              return true;
          }
      };
      $(function () {
          $("input[name='empName']").blur(function () {
              var flag = formObj.checkNull("empName","用户名不能为空!");
              var empName = $("input[name='empName']").val();
              if (flag){
                  $("#empName_span").load("${pageContext.request.contextPath}/AjaxCheckisNullServlet",{"empName":empName});
              }
          });
          $("input[name='password']").blur(function () {
              formObj.checkNull("password","密码不能为空!");
          });
      });
  </script>
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>&nbsp;</p>
<form action="${pageContext.request.contextPath}/RegistServlet" method="post" onsubmit=" return formObj.checkData()">
  <table width="258" border="1" align="center" cellspacing="1" bordercolor="#3399CC">
    <tr align="center">
      <td colspan="2" height="59">
        <font size="6">
          <b><font color="#330099" size="5">留言板用户注册</font></b>
        </font>
      </td>
    </tr>
    <tr>
      <td width="96" align="right">姓名:</td>
      <td width="154">
        <input type="text" name="empName" size="15" >
        <span id="empName_span"></span>
      </td>
    </tr>
    <tr>
      <td width="96" align="right">口令:</td>
      <td width="154">
        <input type="text" name="password" size="15">
        <span></span>
      </td>
    </tr>
    <tr align="center">
      <td colspan="2">
        <input type="submit" name="oper" value=" 注  册 ">
        <input type="reset" name="reset" value=" 复  位 ">
        <a href="${pageContext.request.contextPath}/">跳出</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>

