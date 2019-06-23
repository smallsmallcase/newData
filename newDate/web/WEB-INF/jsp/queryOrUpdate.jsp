<%@ page import="static com.njupt.service.util.DataMapService.tableOptionalList" %>
<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/5
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    input {
        width: 100%;
        color: rgb(200, 200, 200);
        background-color: rgba(100, 100, 100, 0);
        border: none;
        outline: none;
        height: 24.8px;
    }

</style>
<body>
<h1>${tag}</h1>
<c:forEach items="${list}" var="valueObj" varStatus="status">
    <form id="form${status.index}"
          <c:if test="${status.index>0}">style="display: none"</c:if>
          action="/update.form" autocomplete="off" onsubmit="return false;">
        <input type="hidden" name="className" value="${type}">
        <input type="hidden" name="${primaryKey}" value="${valueObj[primaryKey]}">
        <table class="table table-striped table-hover table-bordered">
            <tbody>
            <c:forEach var="item" items="${map}">
                <tr>
                    <td class="text-center"><span>${item.value}</span></td>
                    <td><input name="${item.key}" value="${valueObj[item.key]}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

            <%--   <table class="table table-striped table-hover ">
                   <tbody>
           <c:forEach var="item" items="${map}">
                   <tr class="active">
                       <td><span>${item.value}</span></td>
                       <td> <input name="${item.key}" value="${valueObj[item.key]}"></td>
                   </tr>
           </c:forEach>
                   </tbody>
               </table>--%>
        <button class="btn btn-default" style="border-radius: 0;color: rgb(200, 200, 200);outline: none;"
                onclick="update('form${status.index}');">修改信息
        </button>
        <% pageContext.setAttribute("tableOptionalList", tableOptionalList);%>
        <c:if test="${fn:contains(tableOptionalList,type)}">
            <button class="btn btn-default" style="border-radius: 0;color: rgb(200, 200, 200);outline: none;"
                    onclick="dele('form${status.index}');">删除信息
            </button>
        </c:if>
        <span id="info" style="display: none;color:#3a9a3a;position: absolute;left: 90%">修改成功!</span>
    </form>
</c:forEach>

<div id="index-foot">
    <c:if test="${list.size()>1}">
        <c:forEach items="${list}" var="valueObj" varStatus="status">
            <button class="btn <c:if test="${status.index == 0}">active</c:if> btn-default"
                    onclick="display(${status.index})">${status.index+1}</button>
        </c:forEach>
    </c:if>
</div>

</body>
<script>
    function display(index) {
        $("#queryContext").find("form").hide();
        $("#form" + index).show();
        $("#index-foot").find("button").removeClass("active");
        $("#index-foot").find("button").eq(index).addClass("active");
    }
</script>
</html>
