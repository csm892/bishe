<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcdn.net/ajax/libs/jquery-countdown/2.1.0/css/jquery.countdown.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>


    <title>首页</title>

    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>


</head>
<body>
    <%@include file="/common/utop.jsp"%>

<!--导航条-->
<div class="width100" style="height: 45px;background: #dd4545;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/news/list">公告</a>
            <a href="${ctx}/message/add">留言</a>
        </div>
    </div>
</div>

<div class="width1200 center_yh hidden_yh font14" style="height: 40px;line-height: 40px;">
    <span>当前位置：</span><a href="${ctx}/login/uIndex" class="c_66">首页</a>
    ><a href="#" class="c_66">商品列表</a>
    ><a href="#" class="c_66">详情</a>
</div>
<div class="width1198 center_yh" style="height: 420px;">
    <div class="left_yh" style="width: 350px;height: 420px;">
        <input type="hidden" id="id" value="${obj.id}">
        <div id="preview">
            <div>
                <img src="${obj.url1}" alt="" height="350" width="350">
            </div>
            <div id=spec-list" style="margin-top: 5px;">
                <ul class="list-h">
                    <!--<li><img src="${obj.url2}" height="80" width="80"></li>
                   <li><img src="${obj.url3}" height="80" width="80"></li>
                    <li><img src="${obj.url4}" height="80" width="80"></li>
                    <li><img src="${obj.url5}" height="80" width="80"></li>-->
                </ul>
            </div>
        </div>
    </div>
    <div class="left_yh" style="width: 486px;height: 420px;margin-left: 42px;">
        <h3 class="font20 font100">${obj.name}</h3>
        <p class="font16 c_66" style="margin-top:25px;">
            <font style="margin-right: 20px;">秒杀价：</font>
            <font class="red font20" id="price">
                ￥ ${seckill.price}
            </font>
        </p>
        <c:if test="${obj.zk!=null}">
            <p class="font16 c_66" style="margin-top:25px;">
                <font style="margin-right: 20px;">原价：</font>
                <font>
                    ￥${obj.price}
                    <span style="color: red"></span>
                </font>
            </p>
        </c:if>
        <p class="font16 c_66 likeColor" style="margin-top: 25px;">
            <font style="margin-right: 20px;">剩余：</font>

            <font class="font14 " style="margin-left: 20px;color: black">${seckill.number}件</font>

        </p>
        <div class="container" style="width: 600px">
            <div class="panel panel-default text-center">

                <div class="panel-body">
                    <h2 class="text-danger">
                        <!-- 显示time图标 -->
                        <span class="glyphicon glyphicon-time"></span>
                        <!-- 展示倒计时 -->
                        <span class="glyphicon" id="seckill-box"></span>
                    </h2>
                </div>
            </div>
        </div>

        <div class="buyFor">
            <!-- 秒杀区域


            <a href="javascript:void(0)" class="addCar">加入购物车</a>-->
        </div>

    </div>

    <!-- 登录弹出层， 输入电话 -->
    <div id="killPhoneModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title text-center">
                        <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                    </h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-8 col-xs-offset-2">
                            <input type="text" name="killPhone" id="killPhoneKey"
                                   placeholder="填写手机号" class="form-control" />
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <!-- 验证信息 -->
                    <span id="killPhoneMessage" class="glyphicon"></span>
                    <button type="button" id="killPhoneBtn" class="btn btn-success">
                        <span class="glyphicon glyphicon-phone"></span>
                        Submit
                    </button>
                </div>
            </div>
        </div>
    </div>


</div>
    <div class="width1200 hidden_yh center_yh" style="margin-top: 40px;">
        <div class="right_yh" style="width: 1200px;">
            <div class="hidden_yh" id="spXqpj">
                <a href="javascript:void(0)" class="on">商品详情</a>
                <a href="javascript:void(0)">商品评价</a>
            </div>
            <div class="width100 hidden_yh">
                <div id="spDetail">
                    ${obj.ms}
                </div>
                <div id="spPj">
                    <div class="width100 hidden_yh" style="padding-bottom: 20px;border-bottom: 1px dashed #ddd; margin-bottom: 10px;">
                        <c:forEach items="${obj.pls}" var="data" varStatus="l">
                            <div style="width: 790px;float: right;overflow:hidden;margin-top: 20px;">
                                <img src="${ctx}/resource/user/images/x.jpg" style="width: 40px;height: 40px;border-radius: 50%;float: left;border:1px solid #ddd;margin-top: 20px;margin-right: 30px;">
                                <h3 class="font16 c_33 font100" style="color: red;font-weight: bold;">${data.user.userName}</h3>
                                <p class="font14 c_99" style="margin-top: 6px;">
                                    <fmt:formatDate value="${data.addTime}" pattern="yyyy-MM-dd"/>
                                </p>
                                <p class="font16 c_33" style="margin-top: 6px;">
                                        ${data.content}
                                </p>
                                <div class="width100 hidden_yh" style="padding-bottom: 20px; border-bottom: 1px dashed #ddd;margin-bottom: 10px;">
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
    $("#spXqpj a").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
    });
    $("#spXqpj a").eq(0).click(function () {
        $("#spDetail").css({display:"block"}).siblings().css({display:"none"});
    });
    $("#spXqpj a").eq(1).click(function () {
        $("#spPj").css({display:"block"}).siblings().css({display:"none"});
    });

    $(function () {
    $(".addCar").click(function () {
        var id = $("#id").val();
        var num = $("#t_a").val();
        $.ajax({
            type:"POST",
            url:"${ctx}/car/exAdd?itemId="+id+"&num="+num,
            success:function (result) {
                var re = result;
                if(re.res == 0){
                    alert("请登录");
                    window.location.href="${ctx}/login/uLogin";
                }else {
                    window.location.href="${ctx}/car/findBySql";
                }
            }
        });
    });
});
</script>
<%@include file="/common/ufooter.jsp"%>
</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.4.0/js/bootstrap.min.js"></script>

<%--使用cnd获取公共js http://www.bootcdn.cn/--%>
<%--jQuery cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown倒计时插件--%>
<!-- jquery-countdown 倒计时插件<script src="https://cdn.bootcss.com/jquery-countdown/2.2.0/jquery.countdown.min.js"></script>
 -->
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.countdown/2.2.0/jquery.countdown.min.js"></script><!-- 开始编写交互逻辑-->


<script src="${ctx}/resource/script/seckill.js"></script>
<script type="text/javascript">

    $(function() {

    seckill.detail.init({
        seckillId : '${seckill.seckillId}',
        startTime : '${seckill.startTime.time}',
        endTime : '${seckill.endTime.time}'
    });







        //主要用于存放交互逻辑的js代码
//javascript模块化


    });

</script>

</html>



















