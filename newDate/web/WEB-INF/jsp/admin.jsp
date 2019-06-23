<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: huhui
  Date: 2017/12/10
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="col-md-6">
    <div id="main" style="width: 100%;height: 70vh;" ></div>
    <div >
       一共完成${total}个任务<br>
       <c:forEach var="item" items="${map}">
           <div class="col-md-6">
                   ${item.key.user_name}完成${item.value}个任务
           </div>
       </c:forEach>
   </div>
</div>
<div class="col-md-6">
    <div id="optionChart" style="width: 100%;height: 70vh"></div>
    <a href="javascript:queryByType(1);">妊娠期糖尿病:${diabetesHC}人&nbsp;</a>
    <a href="javascript:queryByType(2);">妊娠期高血压:${hypertensionHC}人&nbsp;</a>
    <a href="javascript:queryByType(3);">妊娠期糖尿病和高血压:${bothHC}人&nbsp;</a>
    普通:${healthHC}人
</div>
<script src="/js/echarts.js">
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title : {
            text: '任务完成情况',
//           subtext: '纯属虚构',
            x:'center',
            textStyle:{
                color:'rgba(255,255,250,0.6)'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:[
            <c:forEach var="item" items="${map}">
            '${item.key.user_name}',
            </c:forEach>
            ],
            textStyle:{
                color:'auto'
            }



            <%--${map.keySet()}--%>//['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                <c:forEach var="item" items="${map}">
                    {value:${item.value},name:'${item.key.user_name}'},
                </c:forEach>
                    /*{value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}*/
                ]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);



    var optionChart = echarts.init(document.getElementById('optionChart'));
    optionForChart = {
        color: ['#c23531','#123','#226','#666'],
        title:{
            text: '患者和普通人人数',
            x:'center',
            textStyle:{
                color:'rgba(255,255,250,0.6)'
            }
        },
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : ['妊娠期糖尿病','妊娠期高血压','妊娠期糖尿病和高血压','普通人'],
                axisTick: {
                    alignWithLabel: true
                },
                axisLine:{
                    lineStyle:{
                        color:'white'
                    }
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLine:{
                    lineStyle:{
                        color:'white'
                    }
                }
            }

        ],

        series : [
            {
                name:'直接访问',
                type:'bar',
                barWidth: '60%',
                data:[${diabetesHC},${hypertensionHC},${bothHC},${healthHC}]
            }
        ]
    };



    optionChart.setOption(optionForChart);

</script>

</body>
</html>
