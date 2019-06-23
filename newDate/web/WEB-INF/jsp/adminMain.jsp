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
    .form-control:focus{
        border:none!important;   //设置为原来的颜色
        box-shadow:none!important;
    }

    .wrap-outer {
        margin-left: calc(100vw - 100%);
    }

</style>
<link rel="stylesheet" href="/css/bootscss.css">
<script src="/js/jquery-3.2.1.js"></script>
<script src="/js/bootstrap.js"></script>

<body class="container text-center bgcolor " >
<div class="">
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
                    <a class="navbar-brand" href="#">Admin</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id='activeLi' class="nav navbar-nav">
                        <li class="active" id="statistics"><a href="javascript:loadStatistics();">信息统计<span class="sr-only">(current)</span></a></li>
                        <li  id="taskList"><a href="javascript:taskList();">任务列表</a></li>

                        <%--begin666666666666666666666666666666666666666666666666666666666666--%>
                        <li>
                            <form id="selectForm" class="navbar-form navbar-left" role="search" onsubmit="return false;">
                                <div class="form-group btn-group" style="width: 22vw;">
                                    <input type="text" id="selectInput" class="form-control" style="border-radius: 0;width: 100%;border-right: 0;outline: none;" placeholder="Search">
                                </div><div class="form-group" style="position: relative">
                                <button id="selectBtn" type="button" style="border-radius: 0;border-left: none;border:0;outline: none;" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    请选择搜索方式 <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" style="min-width: 135px;margin: 0;border-radius: 0;background-color: #7a898661;border-top: 0;">
                                    <li><a style="padding-left: 12px;padding-right: 12px;" href="javascript:queryBySelect('按照执行人搜索','user_name')">按照执行人搜索<span class="caret"></span></a></li>
                                    <li><a style="padding-left: 12px;padding-right: 12px;" href="javascript:queryBySelect('按照患者名搜索','personname')">按照患者名搜索<span class="caret"></span></a></li>
                                    <li><a style="padding-left: 12px;padding-right: 12px;" href="javascript:queryBySelect('按照住院号搜索','ad_number')">按照住院号搜索<span class="caret"></span></a></li>

                                </ul>
                            </div>
                                <button type="submit" onclick="taskListBySelect()" style="border-radius: 0;outline: none;" class="btn btn-info">搜索
                                </button>
                            </form>
                        </li>
                        <%--end666666666666666666666666666666666666666666666666666666--%>

                        <%--  <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                              <ul class="dropdown-menu" role="menu">
                                  <li><a href="#">Action</a></li>
                                  <li><a href="#">Another action</a></li>
                                  <li><a href="#">Something else here</a></li>
                                  <li class="divider"></li>
                                  <li><a href="#">Separated link</a></li>
                                  <li class="divider"></li>
                                  <li><a href="#">One more separated link</a></li>
                              </ul>
                          </li>--%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/logout.form">退出登录</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div id="context" class="content" >
    </div>
</div>

</body>
<script>
    $(
            function () {
                loadStatistics();
            }
    );




    function loadStatistics() {
        $("#activeLi").children("li").removeClass("active");
        $("#statistics").addClass("active");
        $.post("/countTask.form",{},function(data){
            $("#context").html(data);
        })
    }



    function taskList(){
        $("#activeLi").children("li").removeClass("active");
        $("#taskList").addClass("active");
        $("#selectInput").val(null);
        $.post("/taskListForAdmin.form",{},function(val){
            $("#context").html(val);
        })
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
    function queryBySelect(text,name) {
        $("#selectBtn").text(text);
        $("#selectBtn").append("  <span class='caret'></span>");

        $("#selectInput").attr("name",name);


    }
    function taskListBySelect() {
        var array = $("#selectForm").serializeArray();
        $.post("/taskListForAdmin.form",array,function(val){
            $("#context").html(val);
        })
    }

    function goPage(pageIndex){
        var array = $("#selectForm").serializeArray();
        array.push({"name":"currentPage","value":pageIndex});
        $.post("/taskListForAdmin.form",array,function(val){
            $("#context").html(val);
        });
    }

    function queryByType(type) {
        $.post("/taskListForType.form",{"type":type},function(val){
            $("#context").html(val);
        });
    }
</script>
</html>