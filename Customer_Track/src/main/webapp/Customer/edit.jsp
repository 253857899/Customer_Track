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



<form class="layui-form" lay-filter="myform" action="../Customer"> 
<c:if test="${param.id!=null}">
<input type="hidden" name="id" value="${param.id }">
<input type="hidden" name="_method" value="put">
</c:if>
 <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">客户姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name"  autocomplete="off" placeholder="请输入客户姓名" class="layui-input">
    </div>
  </div>
     <div class="layui-inline">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <select name="sex" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input type="text" name="tel"  autocomplete="off" placeholder="请输入电话" class="layui-input">
    </div>
  </div>
  </div> <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">QQ</label>
    <div class="layui-input-block">
      <input type="text" name="qq"  autocomplete="off" placeholder="请输入QQ" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">邮箱</label>
    <div class="layui-input-block">
      <input type="text" name="email"  autocomplete="off" placeholder="请输入email" class="layui-input">
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">额外信息</label>
    <div class="layui-input-block">
      <input type="text" name="infos"  autocomplete="off" placeholder="请输入额外信息" class="layui-input">
    </div>
  </div>
  </div> <div class="layui-form-item">
     <div class="layui-inline">
    <label class="layui-form-label">联系状态</label>
    <div class="layui-input-block">
      <select name="linkstatus" >
      </select>
    </div>
  </div>
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
  </div> 
  </div> <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">评估状态</label>
    <div class="layui-input-block">
      <select name="assessstatus" >
      </select>
    </div>
  </div> <div class="layui-inline">
    <label class="layui-form-label">处理状态</label>
    <div class="layui-input-block">
      <select name="execstatus" >
      </select>
    </div>
  </div>
    <div class="layui-inline">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" >
      </select>
    </div>
  </div>
  </div> <div class="layui-form-item">
   <div class="layui-inline">
    <label class="layui-form-label">客户类型</label>
    <div class="layui-input-block">
      <select name="clienttypeid" >
      </select>
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">处理人员</label>
    <div class="layui-input-block">
    	<input type="hidden" name="operatorids">
		<input type="text" name="operatornames" readonly="readonly" autocomplete="off" placeholder="请输入" class="layui-input" id="demo">   
    </div>
  </div>
  <div class="layui-inline">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <select name="createoperatorid" >
      </select>
    </div>
  </div>
  </div> <div class="layui-form-item">
  <div class="layui-inline">
    <label class="layui-form-label">客户来源</label>
    <div class="layui-input-block">
      <select name="srcid" >
      </select>
    </div>
  </div>
   <div class="layui-inline">
    <label class="layui-form-label">回访次数</label>
    <div class="layui-input-block">
      <input type="text" name="count"  autocomplete="off" placeholder="请输入回访次数" class="layui-input">
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
	$("[name=operatorids]").val(NEWJSON1.join(","));
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
	$.post("../Customer/"+id,{_method:"get"}, function(json) {
		render('myform', json);
		getlist("../Customer/getCreateoperatorname",{},"[name=createoperatorid]",json.createoperatorid);
		getlist("../Customer/getTypename",{},"[name=clienttypeid]",json.clienttypeid);
		getlist("../Customer/getSrcname",{},"[name=srcid]",json.srcid);
		getarray("../Customer/getStatus",{},"[name=status]",json.status);
		getarray("../Customer/getSex",{},"[name=sex]",json.sex);
		getarray("../Customer/getLinkstatus",{},"[name=linkstatus]",json.linkstatus);
		getarray("../Customer/getClientstatus",{},"[name=clientstatus]",json.clientstatus);
		getarray("../Customer/getPurposestatus",{},"[name=purposestatus]",json.purposestatus);
		getarray("../Customer/getAssessstatus",{},"[name=assessstatus]",json.assessstatus);
		getarray("../Customer/getExecstatus",{},"[name=execstatus]",json.execstatus);
	},"json");
	
}
if(id.length>0){
	init();
}else{
	getlist("../Customer/getCreateoperatorname",{},"[name=createoperatorid]",0);
	getlist("../Customer/getTypename",{},"[name=clienttypeid]",0);
	getlist("../Customer/getSrcname",{},"[name=srcid]",0);
	getarray("../Customer/getStatus",{},"[name=status]",-1);
	getarray("../Customer/getSex",{},"[name=sex]",-1);
	getarray("../Customer/getLinkstatus",{},"[name=linkstatus]",-1);
	getarray("../Customer/getClientstatus",{},"[name=clientstatus]",-1);
	getarray("../Customer/getPurposestatus",{},"[name=purposestatus]",-1);
	getarray("../Customer/getAssessstatus",{},"[name=assessstatus]",-1);
	getarray("../Customer/getExecstatus",{},"[name=execstatus]",-1);
}

</script>
</body>
</html>