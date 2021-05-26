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
    <table class="table table-hover text-center">
        <tr>
            <th>秒杀商品</th>
            <th>姓名</th>
            <th>秒杀时间</th>
            <th>状态</th>

        </tr>
    <c:forEach items="${success}" var="data" varStatus="l">
        <tr>
            <td style="width: 400px">${data.item.name}</td>
            <td>${data.user.realName}</td>
            <td><fmt:formatDate value="${data.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td>已付款</td>


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