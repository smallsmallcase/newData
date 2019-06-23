<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/4
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cfy</title>
</head>
<body>
    <form action="/save.form" name="cfy">
        <input  name="className" value="Cfy">
        <label>id<input name="cf_id" value="${cfy.cf_id}"></label>
        <label>basic_id<input name="basic_id" value="${cfy.basic_id}"></label>
        <label>c_fanying_danbai<input name="c_fanying_danbai" value="${cfy.c_fanying_danbai}"></label>
        <label>c_time<input name="c_time" value="${cfy.c_time}"></label>
        <label><button name="" type="submit">提交</button></label>
    </form>

</body>
</html>
