<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>管理员后台</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <form action="${ctx}/item/findBySql" id="listform" method="post">
        <div class="padding border-bottom">
            <ul class="search" style="padding-left: 10px;">
                <li>
                    <a class="button border-main icon-plus-square-o" href="${ctx}/seckill/add">添加秒杀</a>
                </li><li>


                <a href="${ctx}/seckill/successKill"  class="button border-main icon-search">秒杀成功详情</a>
            </li>

            </ul>
        </div>
    </form>
    <table class="table table-hover text-center">
        <tr>
            <th>秒杀名称</th>
            <th>商品主图</th>
            <th>商品原价</th>
            <th>秒杀价格</th>
            <th>秒杀时间</th>
            <th>结束时间</th>
            <th>操作</th>
        </tr>
    <c:forEach items="${seckillList}" var="data" varStatus="l">
        <tr>
            <td>${data.name}</td>
            <td><img src="${data.item.url1}" alt="" style="width: 100px;height: 100px;"></td>

            <td>${data.item.price}</td>
            <td>${data.price}</td>
            <td><fmt:formatDate value="${data.startTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td><fmt:formatDate value="${data.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td>
                <a class="button border-red" href="${ctx}/seckill/delete?seckillId=${data.seckillId}"><span class="icon-trash-o">下架</span> </a>
            </td>

        </tr>
    </c:forEach>
        </table>
</div>
<script>
    function changeSearch(){
        $("#listform").submit();
    }
</script>
</body>

</html>