<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/7
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    div .list-group-item:hover{
        background-color:#1c1e22;
    }

</style>
<body>

<div id="query" class="list-group col-md-4 col-sm-6">
    <c:forEach var="item" items="${map}" varStatus="status">
        <a href="javascript:queryItem('${item.key}','${status.index}');"
           class="list-group-item list-group-item-action" style="border: none">
                ${item.value}
        </a>
    </c:forEach>
</div>


<div id="queryContext" class="list-group col-md-8 col-sm-6">
</div>
</body>
<script>
</script>
</html>
