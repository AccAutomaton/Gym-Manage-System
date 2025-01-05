<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/echarts.min.js"></script>
<head>
    <title>收入统计图</title>
</head>
<body background="${pageContext.request.contextPath}/static/HTmoban/images/tongji4.png">
<div class="panel panel-default">
    <div class="panel-body" style="width:400px; display: inline-block">
        <select id="xuan" class="form-control" oninput="cha()" style="width:200px; margin-right: 10px; float: left">
            <option value="1">柱状图</option>
            <option value="2">饼状图</option>
            <option value="3">折线图</option>
        </select>
    </div>
    <div id="main" style="width: 1100px;height:550px;"/>
</div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    function cha() {
        var a = $("#xuan").val();
        if (a == 1) {
            option = {
                title: {
                    text: '2024年每月收入统计'
                },
                tooltip: {},
                legend: {
                    data: ['金额']
                },
                xAxis: {
                    data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    axisLabel: {
                        interval: 0
                    }
                },
                yAxis: {},
                series: [{
                    name: '金额',
                    type: 'bar',
                    data: []
                }]
            };
            myChart.setOption(option);
            $.post('${pageContext.request.contextPath}/cz/tongji', {}, function (data) {
                myChart.setOption({
                    xAxis: {
                        data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                    },
                    series: [{
                        name: '金额',
                        data: data
                    }]
                });
            });
        } else if (a == 2) {
            option = {
                title: {
                    text: '2024年每月收入统计',
                    subtext: '',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {
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
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                series: [
                    {
                        name: '',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [],
                        itemStyle: {
                            normal: {
                                label: {
                                    show: function (value) {
                                        if (value == 0.00) return false;
                                    }(),
                                    formatter: '{b} : {c} ({d}%)'
                                },
                                labelLine: {
                                    show: function (value) {
                                        if (value == 0.00) return false;
                                    }()
                                }
                            }
                        }
                    }
                ]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/cz/tongji",
                cache: false,
                dataType: "json",
                success: function (result) {
                    var names = ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"];
                    var nums = [];
                    $.each(result, function (key, values) {
                        var obj = new Object();
                        obj.name = names[key];
                        obj.value = values;
                        nums.push(obj);
                    });
                    myChart.setOption({
                        legend: {
                            data: names
                        },
                        series: {
                            name: ['金额'],
                            data: nums
                        }
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("查询失败");
                }
            });
        } else if (a == 3) {
            option = {
                title: {
                    text: '2024年每月收入统计'
                },
                xAxis: {
                    type: 'category',
                    axisLabel: {
                        interval: 0
                    },
                    data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    data: [],
                    type: 'line'
                }]
            };

            myChart.setOption(option);
            $.post('${pageContext.request.contextPath}/cz/tongji', {}, function (data) {
                myChart.setOption({
                    xAxis: {
                        data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
                    },
                    series: [{
                        data: data
                    }]
                });
            });
        }
    }

    var option = null;
    option = {
        title: {
            text: '2024年每月收入统计'
        },
        tooltip: {},
        legend: {
            data: ['金额']
        },
        xAxis: {
            data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            axisLabel: {
                interval: 0
            }
        },
        yAxis: {},
        series: [{
            name: '金额',
            type: 'bar',
            data: []
        }]
    };

    myChart.setOption(option);
    $.post('${pageContext.request.contextPath}/cz/tongji', {}, function (data) {
        myChart.setOption({
            xAxis: {
                data: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"]
            },
            series: [{
                name: '金额',
                data: data
            }]
        });
    });
</script>
</body>
</html>
