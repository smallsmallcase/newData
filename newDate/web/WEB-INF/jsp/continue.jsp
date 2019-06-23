<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/7
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="" name="form" method="post" id="form" onsubmit="return false;">
    <button onclick="lastOne()">继续上一个未完成任务</button>
    <button onclick="newOne()">新建一个任务</button>
</form>
</body>
<script>
    function lastOne() {
        var form = document.getElementById("form");
        form.action="/loadTask.form";
        form.submit();
    }

    function newOne() {
        <%session.removeAttribute("task_id");%>
        window.location.href="/view.form?path=main";
    }
</script>
</html>
