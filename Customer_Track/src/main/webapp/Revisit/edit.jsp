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



<form class="layui-form" lay-filter="myform" action="../Revisit"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>
 <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">回访名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入回访名" class="layui-input">
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
    <label class="layui-form-label">联系状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
  </div> <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">客户状态</label>
    <div class="layui-input-block">
      <select name="clientstatus" >
      </select>
    </div>
  </div> <div class="layui-inline">
    <label class="layui-form-label">意向状态</label>
    <div class="layui-input-block">
      <select name="purposestatus" >
      </select>
    </div>
  </div> <div class="layui-inline">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
    </div>
    </div>  <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">询问状况</label>
    <div class="layui-input-block">
      <input type="text" name="askinfo"  autocomplete="off" placeholder="请输入询问状况" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">跟进措施</label>
    <div class="layui-input-block">
      <input type="text" name="followinfo"  autocomplete="off" placeholder="请输入跟进措施" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">客户顾虑</label>
    <div class="layui-input-block">
      <input type="text" name="probleminfo"  autocomplete="off" placeholder="请输入客户顾虑" class="layui-input">
    </div>
  </div>
  </div>  <div class="layui-form-item">
     <div class="layui-inline">
    <label class="layui-form-label">状态名称</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  </div>  <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
    <textarea name="comments" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>     
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
	$.post("../Revisit/"+id,{_method:"get"}, function(json) {
		render('myform', json);
		getlist("../Revisit/getClientname",{},"[name=clientid]",json.clientid);
		getarray("../Revisit/getStatus",{},"[name=status]",json.status);
		getarray("../Revisit/getLinkstatus",{},"[name=linkstatus]",json.linkstatus);
		getarray("../Revisit/getClientstatus",{},"[name=clientstatus]",json.clientstatus);
		getarray("../Revisit/getPurposestatus",{},"[name=purposestatus]",json.purposestatus);
		getarray("../Revisit/getAssessstatus",{},"[name=assessstatus]",json.assessstatus);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Revisit/getClientname",{},"[name=clientid]",0);
	getarray("../Revisit/getStatus",{},"[name=status]",-1);
	getarray("../Revisit/getLinkstatus",{},"[name=linkstatus]",-1);
	getarray("../Revisit/getClientstatus",{},"[name=clientstatus]",-1);
	getarray("../Revisit/getPurposestatus",{},"[name=purposestatus]",-1);
	getarray("../Revisit/getAssessstatus",{},"[name=assessstatus]",-1);
}

</script>
</body>
</html>