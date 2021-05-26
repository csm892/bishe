<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <style>
        * {
            margin:0px;
            padding:0px;
        }
        #benner {
            width:1200px;
            height:490px;
            margin-top:10px;overflow: hidden;margin-left: 230px;
        }
        #benner .imga {
            display:none;
            width:966px;
            height:490px
        }

        #benner .img .active {
            display:block;
        }
        #benner .title {
            width:;
            height:16px;
            background-color:rgba(226,226,226,0.6);
            border-radius:30px;
            margin-top:-35px;
            float:left;
            margin-left:40%;
            margin-right:40%;
            padding:6px 0px 0px 10px;
            position:relative;
        }
        #benner .title .nr {
            list-style:none;
            width:10px;
            height:10px;
            background:#fff;
            border-radius:10px;
            float:left;
            margin-right:10px;
            margin-bottom:0px;
        }
        #benner .title .active {
            background:#db192a;
        }
    </style>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>
    <%@include file="/common/utop.jsp"%>
<!--导航条-->
<div class="width100" style="height: 45px;background: #dd4545;margin-top: 40px;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;">
        <!--列表导航-->
        <div class="left_yh Selected" style="width: 230px;height: 45px;" id="hiddenShow">
            <!--头部的图标-->
            <img src="${ctx}/resource/user/images/cd.png" class="left_yh" style="margin-left: 24px;" alt="">
            <span class="block_yh left_yh fff" style="height: 45px;line-height: 44px;margin-left: 10px;">分类</span>
            <!--导航展开部分-->
            <div class="downSlide">

                <c:forEach items="${lbs}" var="data" varStatus="l">

                    <div class="n1Nav">
                        <font>${data.father.name}</font>
                        <img src="${ctx}/resource/user/images/jt.png" alt="">
                        <div class="n2Nav">
                            <div class="n3Nav">

                                <c:forEach items="${data.childrens}" var="child" varStatus="ll">
                                    <a href="${ctx}/item/shoplist?categoryIdTwo=${child.id}">${child.name}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/news/list">公告</a>
            <a href="${ctx}/message/add">留言</a>
        </div>
    </div>
</div>
<!--轮动广告-->
<div class="width1200 center_yh hidden_yh" style="position: relative;z-index:80;">

        <div id="benner">
            <div class="img">
                <a href="${ctx}/item/shoplist">

                <img src="https://imgcps.jd.com/ling4/7125373/5Li65L2g5o6o6I2Q/57K-6YCJ5aW954mp/p-5bd8253082acdd181d02fa7f/9c79f419/cr/s/q.jpg" class="imga active">
                </a>
                <a href="http://localhost:83/test1_war_exploded/item/view?id=44">
                    <img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d8471a80a7dea49a3889386c16ebdc12.jpg?w=2452&h=920" class="imga">

                </a>
                <a href="http://localhost:83/test1_war_exploded/item/view?id=74">
                    <img src="https://img.alicdn.com/imgextra/i1/2435538353/O1CN01VMafoF2BZj0gfW3Cm_!!2435538353.jpg_430x430q90.jpg" class="imga">
                </a>
            </div>
            <ul class="title">
                <li class="nr active"></li>
                <li class="nr"></li>
                <li class="nr"></li>

            </ul>
        </div>

    <!-- <div class="example2" style="width: 1200px;height: 490px;overflow: hidden;margin-left: 230px;">
        <ul>
            <li><img src="${ctx}/resource/images/a.webp" alt=""></li>
            <a href="${ctx}/item/shoplist">
            <li>

                <img src="https://imgcps.jd.com/ling4/7125373/5Li65L2g5o6o6I2Q/57K-6YCJ5aW954mp/p-5bd8253082acdd181d02fa7f/9c79f419/cr/s/q.jpg" alt="">

            </li>
            </a>
            <a href="http://localhost:83/test1_war_exploded/item/view?id=44">
            <li>
                <img src="https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d8471a80a7dea49a3889386c16ebdc12.jpg?w=2452&h=920" alt="">
            </li>
            </a>


        </ul>
    </div>-->
    <script>
        $(function () {
            $(".example2").luara({width:"966",height:"490",interval:3000,selected:"seleted",deriction:"left"});
        });
    </script>
</div>
<!--秒杀商品-->
    <div>

    </div>

    <div class="width1200 center_yh hidden_yh">
        <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545; margin-top: 20px;">
            <font class="left_yh font20">秒杀</font>

            <div style="float:right;">
                <a href="${ctx}/item/shoplist" style="color:red;">更多>
                </a>
            </div>

        </div>
        <div class="width100 hidden_yh" style="height: 480px;">
           <div>
               <img src="https://cdn.pinduoduo.com/upload/home/img/index/seckill_v2.jpg" style="height: 200;width: 1170px">
           </div>
            <div class="normalPic">
                <c:forEach items="${seckillList}" var="data" varStatus="l">
                    <a href="${ctx}/seckill/view?id=${data.item.id}">

                        <font class="left_yh red font16">秒杀价</font>
                        <img src="${data.item.url1}" width="105" height="118" alt="" style="margin:0 auto">

                        <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.item.name}</h3>
                        <font class="right_yh red font16">仅剩余${data.number}件</font>
                        <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                            <font class="left_yh red font16">￥${data.price}</font>
                            <font class="right_yh font14" style="color: grey">
                                原价:￥${data.item.price}

                            </font>
                        </p>


                    </a>
                </c:forEach>
            </div>
        </div>
    </div>


    <!--折扣商品-->
    <div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545; margin-top: 20px;">
        <font class="left_yh font20">折扣大促销</font>

      <div style="float:right;">
          <a href="${ctx}/item/shoplist" style="color:red;">更多>
          </a>
      </div>

    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${zks}" var="data" varStatus="l">
                <a href="${ctx}/item/view?id=${data.id}">


                    <img src="${data.url1}" width="105" height="118" alt="" style="margin:0 auto">
                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.name}</h3>

                    <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                        <font class="left_yh red font16">￥${data.price}</font>
                        <c:if test="${data.zk!=null}">
                           <font class="right_yh font14" style="color: red">
                                    ${data.zk}
                                <span style="color: grey">折</span>
                            </font>
                        </c:if>
                    </p>
                </a>
            </c:forEach>
        </div>
    </div>
</div>

<!--热门商品-->
<div class="width1200 center_yh hidden_yh">
    <div class="width100" style="height: 45px;line-height: 45px;border-bottom: 2px solid #dd4545; margin-top: 20px;">
        <font class="left_yh font20">热门商品</font>

        <div style="float:right;">
            <a href="${ctx}/item/shoplist" style="color:red;">更多>
            </a>
        </div>

    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${rxs}" var="data" varStatus="l">
                <a href="${ctx}/item/view?id=${data.id}">
                    <img src="${data.url1}" width="105" height="118" alt="" style="margin:0 auto">

                    <h3 class="yihang c_33 font14 font100" style="padding-left: 10px;padding-right: 10px;">${data.name}</h3>

                    <p class="center_yh block_yh hidden_yh" style="width: 202px;">
                        <font class="left_yh red font16">￥${data.price}</font>
                        <c:if test="${data.zk!=null}">
                            <font class="right_yh font14" style="color: grey">
                                    ${data.gmNum}人购买

                            </font>
                        </c:if>
                    </p>

                </a>
            </c:forEach>
        </div>
    </div>
</div>
    <%@include file="/common/ufooter.jsp"%>
</body>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<!--首页轮播-->
<script>

    window.onload = function() {
        benner('#benner', '.nr', '.imga')

        function benner(parent, controller, mod) {

            var num = 0;
            var controller = $(controller);
            var mod = $(mod);
            var benner = $(parent);
            var autoPlayTime = 2500;
            var imgNum = mod.length - 1;
            var auto;

            autoPlay();
            //根据传进来的名字获取这个名字所对应的对象
            function $(name) {
                if (name[0] == '#') {
                    return document.getElementById(name.substr(1));
                } else if (name[0] == '.') {
                    return document.getElementsByClassName(name.substr(1));
                } else {
                    return document.getElementsByTagName(name);
                }
            }

            //实现鼠标划过圆点,变化图片的效果
            //function change(controller, mod){
            //遍历控制器,绑定鼠标划过事件
            for (var i = 0; i < controller.length; i++) {
                //给控制器加个索引,并把i值赋值给索引
                controller[i].index = i;
                //给所有的控制器都加划过事件
                controller[i].onmouseover = function() {
                    for (var j = 0; j < controller.length; j++) {
                        //将所有控制器改为默认样式
                        controller[j].className = 'nr';
                    }
                    //改变所选的控制器样式
                    this.className = 'nr active';
                    //将模型改为默认样式
                    for (var x = 0; x < mod.length; x++) {
                        mod[x].className = 'imga';
                    }
                    //改变所选控制器对应的模型的样式
                    mod[this.index].className = 'imga active';
                }
            }
            //}
            //绑定鼠标移入,暂停播放图片
            benner.onmouseover = function() {
                clearInterval(auto);
            }
            //绑定鼠标离开,继续播放
            benner.onmouseleave = function() {
                autoPlay();
            }
            //指定播放那个图片
            function play(num) {
                for (var j = 0; j < controller.length; j++) {
                    controller[j].className = 'nr';
                }
                controller[num].className = 'nr active';
                for (var x = 0; x < mod.length; x++) {
                    mod[x].className = 'imga';
                }
                mod[num].className = 'imga active';
            }
            //自动播放
            function autoPlay() {
                auto = setInterval(function() {
                    if (num > imgNum) {
                        num = 0;
                    }
                    play(num);
                    num++;
                }, autoPlayTime)
            }
        }

    }
</script>
</html>



















