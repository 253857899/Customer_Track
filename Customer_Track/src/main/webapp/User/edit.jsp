<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../X-admin/lib/layui/layui.all.js"></script>
<script src="../X-admin/js/jquery-2.2.4.min.js" ></script>
<script type="text/javascript" src="../X-admin/js/my.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:250px;}
.layui-input-block {
    width: 250px;
</style>



<form class="layui-form" lay-filter="myform" action="../Operator"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>

<div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入用户名" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">密码</label>
    <div class="layui-input-block">
      <input type="text" name="pass"  autocomplete="off" placeholder="请输入密码" class="layui-input">
    </div>
  </div>
    </div><div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">手机号</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入手机号" class="layui-input">
    </div>
  </div>
     <div class="layui-inline">
    <label class="layui-form-label">组类型</label>
    <div class="layui-input-block">
      <select name="groupid" >
      </select>
    </div>
  </div>
    </div><div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">职务类型</label>
    <div class="layui-input-block">
      <select name="power" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">状态类型</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
    </div>
   <div class="layui-form-item" style="text-align:center">
    
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
   
  </div>
</form>

<script type="text/javascript">
var id="${param.id}";
layui.use(['form',], function(){
	  var form = layui.form;
	 
	  
	  form.on('submit(demo1)', function(data){
		 $.post($("form").attr("action"), data.field, function(json) {
			  closeFrame();
			  parent.fresh('demo');
			}, "json");
		    
		    return false;
		  });
});

function getlist(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].name+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function init(){
	$.post("../Operator/"+id,{_method:"get"}, function(json) {
		render('myform', json);
		getarray("../Operator/getStatus",{},"[name=status]",json.status);
		getlist("../Operator/getGroup",{},"[name=groupid]",json.groupid);
		getarray("../Operator/getPower",{},"[name=power]",json.power);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getarray("../Operator/getStatus",{},"[name=status]",-1);
	getlist("../Operator/getGroup",{},"[name=groupid]",0);
	getarray("../Operator/getPower",{},"[name=power]",-1);
}

</script>
</body>
</html>