
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
<div>
    <form action="${ctx}/doPay" method="post">
        订单号：<input type="text" name="WIDout_trade_no" required><br/>
        订单名称：<input type="text" name="WIDsubject" required><br/>
        付款金额：<input type="text" name="WIDtotal_amount" required><br/>
        WIDbody：<input type="text" name="WIDbody"><br/>
        <input type="submit" value="下单"> <input type="reset" value="重置">
    </form>
</div>

</html>
