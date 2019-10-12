<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>图表分析</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugin/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/macarons.js"></script>
    <script src="${pageContext.request.contextPath}/static/plugin/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">表格类型</label>
        <div class="layui-input-block">
            <input type="radio" name="type" value="0" title="柱状图" lay-filter="test" checked>
            <input type="radio" name="type" value="1" title="饼状图" lay-filter="test">
        </div>
    </div>
</form>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    layui.use(['layer', 'form', 'jquery'], function () {
        var $ = layui.jquery
            , layer = layui.layer
            , form = layui.form;
        var myChart = echarts.init(document.getElementById('main'), e_macarons);
        drawBar();
        form.on('radio(test)', function (data) {
            var type = data.value;
            if (type === '0')
                drawBar();
            else if (type === '1')
                drawPie();
        });
        form.render();
        function drawPie() {
            myChart.clear();
            myChart.showLoading();
            var data = [];
            $.ajax({
                url: '${pageContext.request.contextPath}/course/query_all',
                async: true,
                data: {},
                type: 'post',
                dataType: 'JSON',
                success: function (result) {
                    if (result)
                        for (var i = 0; i < result.length; i++) {
                            var obj=new Object();
                            obj.name=result[i].courseName;
                            obj.value=result[i].stuNum;
                            data[i]=obj;
                        }
                    myChart.setOption({        //加载数据图表
                        title : {
                            text: '选课情况',
                            subtext: '饼图',
                            x:'center'
                        },
                        tooltip : {
                            trigger: 'item',
                            formatter: "{b} <br/>{c} : {d} %"      //a 系列名称，b 数据项名称，c 数值，d 百分比
                        },
                        legend: {
                            orient : 'vertical',
                            x : 'left',
                            data:data.name
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
                                name:'选课人数',
                                type:'pie',
                                radius : '55%',//饼图的半径大小
                                center: ['50%', '60%'],//饼图的位置
                                data:data
                            }
                        ]
                    });
                    myChart.hideLoading();
                },
                error: function () {
                    layer.msg("图表请求数据失败", {
                        time: 1000,
                        end: function () {
                            myChart.hideLoading();
                        }
                    });
                }
            });
        }
        function drawBar() {
            myChart.clear();
            myChart.showLoading();
            var courseName = [];
            var stuNum = [];
            $.ajax({
                url: '${pageContext.request.contextPath}/course/query_all',
                async: true,
                data: {},
                type: 'post',
                dataType: 'JSON',
                success: function (result) {
                    if (result)
                        for (var i = 0; i < result.length; i++) {
                            courseName.push(result[i].courseName);
                            stuNum.push(result[i].stuNum);
                        }
                    myChart.setOption({
                        title : {
                            text: '选课情况',
                            subtext: '柱状图',
                            x:'center'
                        },
                        tooltip : {
                            trigger: 'item',
                            formatter: "{b} <br/>{c}"      //a 系列名称，b 数据项名称，c 数值，d 百分比
                        },
                        legend: {
                            orient : 'vertical',
                            x : 'left',
                            data:['选课人数']
                        },
                        xAxis: {
                            data: courseName
                        },
                        yAxis: {},
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {
                                    show: true,
                                    type: ['bar', 'funnel'],
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
                                name:'选课人数',
                                type:'bar',
                                center: ['50%', '60%'],//饼图的位置
                                data:stuNum
                            }
                        ]
                    });
                    myChart.hideLoading();
                },
                error: function () {
                    layer.msg("图表请求数据失败", {
                        time: 1000,
                        end: function () {
                            myChart.hideLoading();
                        }
                    });
                }
            });
        }
    });
</script>
</body>
</html>
