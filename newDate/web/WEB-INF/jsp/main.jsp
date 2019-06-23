<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/7
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="wrap-outer">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
</head>
<style>
    .bgcolor{
        background-color: #272b30;
    }
    .prm{
        background-color: #272b30!important;
        border: 0!important;
        padding-left: 0!important;
        padding-right: 0!important;
    }
    .wrap-outer {
        margin-left: calc(100vw - 100%);
    }



</style>
<link rel="stylesheet" href="/css/bootscss.css">
<script src="/js/jquery-3.2.1.js"></script>
<script src="/js/bootstrap.js"></script>
<body class="container text-center bgcolor">

<div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Member</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id='activeLi' class="nav navbar-nav">
                    <li class="active" id="basicInfo"><a href="javascript:basicInfo();">基础信息 <span class="sr-only">(current)</span></a></li>

                    <!--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">化验单 <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="javascript:tableOptional(0)">孕期甲功</a></li>
                            <li><a href="javascript:tableOptional(1)">孕期血常规</a></li>
                            <li><a href="javascript:tableOptional(2)">孕期大生化</a></li>
                            <li><a href="javascript:tableOptional(3)">孕期尿常规</a></li>
                            <li><a href="javascript:tableOptional(4)">孕期凝血常规</a></li>
                            <li><a href="javascript:tableOptional(5)">孕期铁蛋白检测</a></li>
                            <li><a href="javascript:tableOptional(6)">孕期病毒八项检查</a></li>
                            <li><a href="javascript:tableOptional(7)">C反应蛋白</a></li>
                            <li><a href="javascript:tableOptional(8)">B超</a></li>
                            <li><a href="javascript:tableOptional(9)">其他</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>-->
                    <li  id="taskList"><a href="javascript:taskList();">任务列表</a></li>
                    <li id="queryInfo"><a href="javascript:queryInfo()">查询</a></li>
                </ul>
                <!--  <form class="navbar-form navbar-left" role="search">
                      <div class="form-group">
                          <input type="text" class="form-control" placeholder="Search">
                      </div>
                      <button type="submit" class="btn btn-default">Submit</button>
                  </form>-->

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout.form">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>



<div id="context" >
    <form id="form">
        <input name="index" type="hidden" value="${index}">
    </form>
</div>

<!--<div class="well">

</div>-->

</body>
<script>
    $(
            function () {

                getForm();

                $("#btn").click(
                        submitForm
                );

            }
    );
    function basicInfo() {
        $("#activeLi").children("li").removeClass("active");
        $("#basicInfo").addClass("active");
        var task_id = <%=session.getAttribute("task_id")%>;
        if(task_id == null || task_id == ''|| task_id == 0){
            getForm();
        }else{
            window.location.href="/loadTask.form";
        }
    }
    function taskList(){
        $("#activeLi").children("li").removeClass("active");
        $("#taskList").addClass("active");
        $.post("/taskList.form",{},function(val){
            $("#context").html(val);
        })
    }
    function submitForm() {
        var data = $("#context").children("#form").serializeArray();
        $.post("/save.form",data,function(val) {
            console.log(val);
            if (val == "finished"){
                $.post("/view.form?path=optional",{},function(data,status){
                    $("#context").html(data)
                });
            }
            var index = $("input[name='index']");
            $(index).val(Number($(index).val())+1);
            console.log($(index).val());
            getForm();
        });
    }
    function getForm(){
        var val = $("#context").children("#form").serializeArray();
        $.post("/checkBox.form",val,function(data,status){
            $("#context").html(data)
        });
    }

    function tableOptional(index){
        var basic_id = $("input[name='basic_id']").val();
        $.post("/checkBox.form",{"basic_id":basic_id,"index":index,"table_type":"optional"},function(data,status){
            $("#context").html(data)
        });
    }
    
    function queryInfo() {
        $("#activeLi").children("li").removeClass("active");
        $("#queryInfo").addClass("active");
       $.post("/queryInfo.form",{},function(data){
           $("#context").html(data);
           queryItem("BasicInformation",0);
       })

    }
    function queryItem(className,index){

        $("#query").children("a").removeClass("active");
        $("#query a").eq(index).addClass("active");

        $.post('/query.form',{'className':className},function(val){
            $("#queryContext").html(val);
        })

    }
    function update(formId) {
        var val = $("#context").find("#"+formId).serializeArray();
        $.post("/update.form",val,function(data){
            $("#queryContext").html(data);
            $("#info").fadeIn();
            setTimeout("$('#info').fadeOut()",500);
        })
    }
    function dele(formId) {
        var val = $("#context").find("#"+formId).serializeArray();
        $.post("/deleteOne.form",val,function(data){
            $("#queryContext").html(data);
           /* $("#info").fadeIn();
            setTimeout("$('#info').fadeOut()",500);*/
        })
    }

    function goPage(pageIndex){
        $.post("/taskList.form",{"currentPage":pageIndex},function(val){
            $("#context").html(val);
        });
    }
</script>
</html>