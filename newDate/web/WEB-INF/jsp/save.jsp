<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/5
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    /*input:-webkit-autofill { -webkit-box-shadow: 0 0 0 1000px white inset !important; }*/
</style>
<body>
<h1 class="them">${tag}</h1>
<form id="form" class="form-horizontal" action="/save.form">
    <input type="hidden" name="className" value="${type}">
    <input type="hidden" name="index" value="${index}">
    <c:forEach var="item" items="${map}">
        <div class="form-group">
            <label class="col-sm-3 control-label">${item.value}</label>
            <div class="col-sm-6">
                <input  name="${item.key}" class="form-control" >
            </div>
        </div>
        <%--<label class="">${item.value}<input name="${item.key}"></label><br/>--%>
    </c:forEach>
    <div class="form-group">
        <label class="col-sm-3 control-label">完成进度</label>
        <div class="col-sm-6" style="vertical-align: middle;">
            <div class="prm form-control" >
                <div class=" progress progress-striped active">
                    <div class="progress-bar progress-bar-warning" style="width: ${percent}%"></div>
                </div>
            </div>
        </div>
    </div>
    <%-- <button>提交</button>--%>
</form>
<button type="button" onclick="submitForm();" id="btn" class="btn btn-default ">提交</button>
</body>
</html>
