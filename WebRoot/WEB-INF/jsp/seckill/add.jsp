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
    <script language="javascript" type="text/javascript" src="${ctx}/resource/js/My97DatePicker/WdatePicker.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/resource/ueditor/ueditor.all.min.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o">新增秒杀商品</span> </strong>
    </div>
    <div class="body-content">
        <form action="${ctx}/seckill/exAdd" method="post" class="form-x" >
            <div class="form-group">
                <div class="label"><label>秒杀名称：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入秒杀名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>秒杀商品：</label></div>
                <div class="field">
                    <select name="seckillId" class="input w50">
                        <c:forEach items="${items}" var="data" varStatus="l">
                            <option value="${data.id}">${data.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>


            <div class="form-group">
                <div class="label"><label>秒杀价：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="price" data-validate="required:请输入商品秒杀价" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>秒杀数量：</label></div>
                <div class="field">
                    <input type="text" class="input w50" name="number" data-validate="required:请输入商品秒杀数量" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>秒杀开始时间：</label></div>
                <div class="field">
                    <input name="startTime" class="Wdate" type="datetime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss' })"style="width: 200px">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label>秒杀结束时间：</label></div>
                <div class="field">
                    <input name="endTime"  class="Wdate" type="datetime" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width: 200px">
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label"></div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script >

</script>
</body>

</html>