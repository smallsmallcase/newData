<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/7
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>taskList</title>
</head>
<body>
<div style="min-height: 445px">
    <table class="table table-striped table-hover table-bordered" >
        <thead class="thead-dark">
        <tr>
            <th>序号</th>
            <th>住院号</th>
            <th>姓名</th>
            <th>是否完成</th>
            <th>完成进度</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${mapList==null || mapList.size() == 0}">
            <tr>
                <td colspan="4">你还没有完成任何任务</td>
            </tr>
        </c:if>
        <c:forEach items="${mapList}" var="item" varStatus="status">
            <tr >
                <td>${status.index}</td>
                <td class="center"><span class="center">${item.ad_number}</span></td>
                <td class="center"><span class="center">${item.personname}</span></td>
                <td>
                    <a href="javascript:loadUnfinished(${item.task_id});">
                        <c:if test="${item.finish == 1}">已完成</c:if>
                        <c:if test="${item.finish == 0}">未完成</c:if>
                </td>
                <td>${item.percent}%</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div <c:if test="${totalPage ==1 }">style="display: none;" </c:if>>
    <ul class="pagination pagination-lg">
        <li class="page-item <c:if test="${currentPage == 1}">disabled</c:if>">
            <a class="page-link"
               href="javascript:<c:if test="${currentPage >1}">goPageForType(${currentPage-1})</c:if>;">&laquo;</a>
        </li>
        <c:if test="${currentPage-2>0}">
            <li class="page-item ">
                <a class="page-link" href="javascript:goPageForType(${currentPage-2});">${currentPage-2}</a>
            </li>
        </c:if>
        <c:if test="${currentPage-1>0}">
            <li class="page-item ">
                <a class="page-link" href="javascript:goPageForType(${currentPage-1});">${currentPage-1}</a>
            </li>
        </c:if>
        <li class="page-item active">
            <a class="page-link" href="#">${currentPage}</a>
        </li>
        <c:if test="${currentPage+1<=totalPage}">
            <li class="page-item ">
                <a class="page-link" href="javascript:goPageForType(${currentPage+1});">${currentPage+1}</a>
            </li>
        </c:if>
        <c:if test="${currentPage+2<=totalPage}">
            <li class="page-item ">
                <a class="page-link" href="javascript:goPageForType(${currentPage+2});">${currentPage+2}</a>
            </li>
        </c:if>
        <li class="page-item <c:if test="${currentPage == totalPage}">disabled</c:if>">
            <a class="page-link"
               href="javascript:<c:if test="${currentPage < totalPage}">goPageForType(${currentPage+1})</c:if>;">&raquo;</a>
        </li>
    </ul>
</div>
<div class="well">
    <h4 class="display-3">总记录数:${totalCount} 总页数:${totalPage}</h4>

</div>
</body>
<script>

    function loadUnfinished(task_id){
        $.post("/loadUnfinished.form",{"task_id":task_id},function (data) {
            if ("admin" == data){
                $.post("/queryInfo.form",{},function (data) {
                    $("#context").html(data);
                    queryItem("BasicInformation",0);
                })
            }else{
                window.location.href="/loadTask.form";
            }
        })
    }

    function goPageForType(pageIndex) {
        $.post("/taskListForType.form",{"currentPage":pageIndex,"type":${type}},function(val){
            $("#context").html(val);
        });
    }
</script>
</html>
