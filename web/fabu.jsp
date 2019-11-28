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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
        var formObj={
            "fcheckData":function(){
                return this.fcheckNull("textfield","接收人不能为空");
            },
            "fcheckNull":function(name,msg1){
                var tag = $("input[name='"+name+"']").val();
                $("input[name='"+name+"']").nextAll("span").text("");
                if(tag == ""){
                    $("input[name='"+name+"']").nextAll("span").text(msg1);
                    return false;
                }
                return true;
            }
        };
        $(function () {
            $("input[name='textfield']").blur(function () {
                var flag = formObj.fcheckNull("textfield","接收人不能为空");
                var textfield = $("input[name='textfield']").val();
                if (flag){
                    $("#textfield_span").load("${pageContext.request.contextPath}/AjaxCheckisNullServlet",{"textfield":textfield});
                }
            });
        });
    </script>
</head>

<body bgcolor="#FFFFFF" text="#000000">
<table width="331" border="0" align="center">
  <tr>
    <td height="34"><font size="4"><b> <a href="${pageContext.request.contextPath}/main.jsp">返回主页</a></b></font> &nbsp;
      &nbsp; &nbsp; <a href="${pageContext.request.contextPath}/LogoutServlet">
            <b><font size="4"> 退出系统</font></b>
        </a>
    </td>
  </tr>
  <tr>
    <td height="32" valign="bottom"><font size="4"><b>信息发送:</b></font></td>
  </tr>
  <form action="${pageContext.request.contextPath}/FabuServlet" method="post" onsubmit="return formObj.fcheckData()">
    <tr>
      <td>
        <table width="280" border="1" bordercolor="#3399cc" cellspacing="1">
          <tr>
            <td width="86" align="right">接收人:</td>
            <td width="160">
              <input type="text" name="textfield">
                <span id="textfield_span"></span>
            </td>
          </tr>
          <tr valign="top">
            <td width="86" align="right">信息内容:</td>
            <td width="160">
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
