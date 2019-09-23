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
.layui-input{width:200px;}
</style>


 
<form class="layui-form" lay-filter="myform" action="../Group"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>
	<div class="layui-form-item">
    <label class="layui-form-label">组编号</label>
    <div class="layui-input-block">
      <input type="text" name="id" <c:if test="${param.id!=null}">disabled="disabled"</c:if> autocomplete="off" placeholder="请输入组编号" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">组名称</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入组名" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
    </div>
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

/* function getlist(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].departmentname+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function getlist1(url,data,selector,def_id){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(json[i].id==def_id) ss="selected='selected'";
			s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].powername+"</option>"))
		}
		layui.form.render('select');
	},"json");
}*/

function init(){
	$.post("../Group/"+id,{_method:"get"}, function(json) {
		render('myform', json);
	},"json");
	
}
if(id.length>0){
	init();
}else{

} 

</script>
</body>
</html>