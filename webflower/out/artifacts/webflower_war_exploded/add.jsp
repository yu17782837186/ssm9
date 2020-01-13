<%--
  Created by IntelliJ IDEA.
  User: HASEE
  Date: 2019/11/20
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        //页面加载完成后执行
        //相当于: window.onload=function(){}   $(document).ready(function(){});
        $(function(){
            $("form").submit(function(){
                //表单选择器,    :input标签type属性值
                if($(":text:eq(0)").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()==""){
                    alert("请填写完整信息");
                    //阻止默认行为
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<form action="insert" method="post">
    <table border="1px">
        <tr>
            <td colspan="2" style="text-align: center;font-size: 30px;font-weight: bold">
                花卉信息
            </td>
        </tr>
        <tr>
            <td><b>花卉名称：</b></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>花卉价格：</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>原产地：</td>
            <td><input type="text" name="production"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/><input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
