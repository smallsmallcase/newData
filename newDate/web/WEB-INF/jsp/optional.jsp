<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/7
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    a{
        text-decoration: none!important;
    }
    li.list-group-item:hover
    {
        background-color:#1c1e22;
    }
    /*.font-info{
        font-size: 20px!important;
        font-weight: 100!important;
        font-family: -webkit-body;
    }*/
    .modal-bg{
       /* background-color:rgba(80, 80, 80,0.8)!important;*/
        top: 22px;
    }
</style>
<body>
<%--<div class="list-group">
    <a href="#" class="list-group-item list-group-item-action active">
        Cras justo odio
    </a>
    <a href="#" class="list-group-item list-group-item-action">Dapibus ac facilisis in
    </a>
    <a href="#" class="list-group-item list-group-item-action disabled">Morbi leo risus
    </a>
</div>--%>

<div class="bs-component">
    <ul class="list-group">
        <a type="button" href="javascript:tableOptional(12)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期血常规</li></a>
        <a type="button" href="javascript:tableOptional(13)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期大生化</li></a>
        <a type="button" href="javascript:tableOptional(11)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期甲功</li></a>
        <a type="button" href="javascript:tableOptional(14)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期尿常规</li></a>
        <a type="button" href="javascript:tableOptional(15)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期凝血常规</li></a>
        <a type="button" href="javascript:tableOptional(16)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期铁蛋白检测</li></a>
        <a type="button" href="javascript:tableOptional(17)"><li class="list-group-item d-flex justify-content-between align-items-center">孕期病毒八项检查</li></a>
        <a type="button" href="javascript:tableOptional(18)"><li class="list-group-item d-flex justify-content-between align-items-center">C反应蛋白</li></a>
        <a type="button" href="javascript:tableOptional(19)"><li class="list-group-item d-flex justify-content-between align-items-center">B超</li></a>
        <a type="button" href="javascript:tableOptional(20)"><li class="list-group-item d-flex justify-content-between align-items-center">其他</li></a>
        <a type="button" href="javascript:finishTask();"><li class="list-group-item list-group-item-action" style="margin-top: 40px">结束当前任务</li></a>
    </ul>
</div>


<div id="newTask" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content modal-bg">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">恭喜你完成了一个任务,是否开启一个新任务?</h4>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary font-info"  onclick="window.location.href = '/loadNew.form';">是</button>
                <button type="button" class="btn btn-primary font-info"  data-toggle="modal" data-target="#newTask">否</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script>
    function finishTask() {
        $.post('/taskFinish.form',{},function() {
            $("#newTask").modal('show');
        });

    }
</script>
</html>
