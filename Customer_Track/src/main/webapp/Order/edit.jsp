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
<script type="text/javascript" src="../X-admin/js/tableSelect.js"></script>

<title></title>
</head>
<body>
<style>
.layui-input{width:250px;}
.layui-input-block {
    width: 250px;
}
</style>



<form class="layui-form" lay-filter="myform" action="../Order"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>

<div class="layui-form-item">

  <div class="layui-inline">
    <label class="layui-form-label">合同名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入合同名" class="layui-input">
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
      <label class="layui-form-label">业绩日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test2" name="compdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    </div>   <div class="layui-form-item">
<div class="layui-inline">
      <label class="layui-form-label">合同日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test3" name="orderdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    
<div class="layui-inline">
      <label class="layui-form-label">起始日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test4" name="startdate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
<div class="layui-inline">
      <label class="layui-form-label">截至日期</label>
      <div class="layui-input-block">
        <input class="layui-input" id="test5" name="enddate" type="text" placeholder="yyyy-MM-dd" >
      </div>
    </div>
    </div>  <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="operatorid" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">合同条款</label>
    <div class="layui-input-block">
      <input type="text" name="info"  autocomplete="off" placeholder="请输入合同条款" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">合同文件</label>
    <div class="layui-input-block">
      <input type="text" name="files"  autocomplete="off" placeholder="请输入合同文件" class="layui-input">
    </div>
  </div>
  </div>  <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">业绩人员</label>
    <div class="layui-input-block">
    	<input type="hidden" name="compoperatorids">
		<input type="text" name="operatornames" readonly="readonly" autocomplete="off" placeholder="请输入" class="layui-input" id="demo">   
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">业绩权重</label>
    <div class="layui-input-block">
      <input type="text" name="compweight"  autocomplete="off" placeholder="请输入业绩权重" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  </div>  <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">总金额</label>
    <div class="layui-input-block">
      <input type="text" name="amount"  autocomplete="off" placeholder="请输入总金额" class="layui-input">
    </div>
  </div>
  </div> <div class="layui-form-item">
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

var tableSelect = layui.tableSelect;
tableSelect.render({
	elem: '#demo',	//定义输入框input对象
	checkedKey: 'id' ,//表格的唯一建值，非常重要，影响到选中状态 必填
	searchKey: 'txt',	//搜索输入框的name值 默认keyword
	searchPlaceholder: '搜索',	//搜索输入框的提示文字 默认关键词搜索
	table: {	//定义表格参数，与LAYUI的TABLE模块一致，只是无需再定义表格elem
		url:'../Operator',
		height:200,
		cols: [[
			{type: "checkbox"},
            {field: 'name', width: 100, title: '姓名'},
            {field: 'tel', width: 180, title: '电话'},
            {field: 'groupname', width: 100, title: '组名'},
            {field: 'power_name', width: 100, title: '职务'}
		]],
		parseData:function(res){
			return{

				"count":res.count,
				"code":res.code,
				"msg":res.msg,
				data:res.list
			}
		}
	},
	done: function (elem, data) {
	//选择完后的回调，包含2个返回值 elem:返回之前input对象；data:表格返回的选中的数据 []
	//拿到data[]后 就按照业务需求做想做的事情啦~比如加个隐藏域放ID...
	var NEWJSON = []
	var NEWJSON1 = []
	layui.each(data.data,function(index,item){
		NEWJSON.push(item.name)
		NEWJSON1.push(item.id)
	})
	elem.val(NEWJSON.join(","))
	$("[name=compoperatorids]").val(NEWJSON1.join(","));
	}
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
	$.post("../Order/"+id,{_method:"get"}, function(json) {
		render('myform', json);
		getlist("../Order/getClientname",{},"[name=clientid]",json.clientid);
		getlist("../Order/getUsername",{},"[name=operatorid]",json.operatorid);
		getarray("../Order/getStatus",{},"[name=status]",json.status);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Order/getClientname",{},"[name=clientid]",0);
	getlist("../Order/getUsername",{},"[name=operatorid]",0);
	getarray("../Order/getStatus",{},"[name=status]",-1);
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
	  laydate.render({
		    elem: '#test3'
		    ,trigger: 'click'
		  });
	  laydate.render({
		    elem: '#test4'
		    ,trigger: 'click'
		  });
	  laydate.render({
		    elem: '#test5'
		    ,trigger: 'click'
		  });
});
</script>
</body>
</html>