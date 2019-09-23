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



<form class="layui-form" lay-filter="myform" action="../Reserved"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>
 <div class="layui-form-item">
    <div class="layui-inline">
    <label class="layui-form-label">回访名</label>
    <div class="layui-input-block">
      <select name="revisitid" >
      </select>
    </div>
  </div>
     <div class="layui-inline">
    <label class="layui-form-label">客户名</label>
    <div class="layui-input-block">
      <select name="clientid" >
      </select>
    </div>
  </div>
    <div class="layui-inline">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="operatorid" >
      </select>
    </div>
  </div>
  </div>  <div class="layui-form-item">
  <div class="layui-inline">
      <label class="layui-form-label">预约日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test2" name="date" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    <div class="layui-inline">
    <label class="layui-form-label">预约处理人</label>
    <div class="layui-input-block">
      <select name="execoperatorid" >
      </select>
    </div>
  </div> 
       <div class="layui-inline">
    <label class="layui-form-label">预约类型</label>
    <div class="layui-input-block">
      <select name="type" >
      </select>
    </div>
  </div> 
  </div>   <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
     <div class="layui-inline">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
      <select name="execstatus" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">处理结果</label>
    <div class="layui-input-block">
      <input type="text" name="result"  autocomplete="off" placeholder="请输入处理结果" class="layui-input">
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
	$.post("../Reserved/"+id,{_method:"get"}, function(json) {
		render('myform', json);
		getlist("../Reserved/getClientname",{},"[name=clientid]",json.clientid);
		getlist("../Reserved/getRevisitname",{},"[name=revisitid]",json.revisitid);
		getlist("../Reserved/getUsername",{},"[name=operatorid]",json.operatorid);
		getlist("../Reserved/getExecoperatorname",{},"[name=execoperatorid]",json.execoperatorid);
		getarray("../Reserved/getStatus",{},"[name=status]",json.status);
		getarray("../Reserved/getType",{},"[name=type]",json.type);
		getarray("../Reserved/getExecstatus",{},"[name=execstatus]",json.execstatus);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Reserved/getClientname",{},"[name=clientid]",0);
	getlist("../Reserved/getRevisitname",{},"[name=revisitid]",0);
	getlist("../Reserved/getUsername",{},"[name=operatorid]",0);
	getlist("../Reserved/getExecoperatorname",{},"[name=execoperatorid]",0);
	getarray("../Reserved/getStatus",{},"[name=status]",-1);
	getarray("../Reserved/getType",{},"[name=type]",-1);
	getarray("../Reserved/getExecstatus",{},"[name=execstatus]",-1);
}
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	    ,trigger: 'click'
	  });
	  laydate.render({
		    elem: '#test2'
		    ,trigger: 'click'
		  });
});
</script>
</body>
</html>