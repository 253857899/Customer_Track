<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="../X-admin/lib/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../X-admin/lib/layui/layui.all.js"></script>
<script src="../X-admin/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../X-admin/js/my.js"></script>
<title></title>
<style type="text/css">
.input {
	font-size: 16px; width : 200px;
	height: 30px;
	margin-top: -10px;
	margin-right: 10px;
	width: 200px;
}

.layui-form-select{width:200px;
}
</style>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
<a class="layui-btn layui-btn-xs" lay-event="detail">明细</a>
</script>
	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <div class="layui-input-inline">
      <input type="text" name="txt" lay-verify="title"  autocomplete="off" placeholder="请输入名称" class="layui-input input">
    </div>
    <button class="layui-btn layui-btn-sm" lay-event="search">查询</button>
  </div>
</script>

	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '../Order' //数据接口
				,
				where:{
					_method:"get"
				},
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'name',
					title : '合同名',
					width : 120
				}, {
					field : 'clientname',
					title : '客户名',
					width : 120
				}, {
					field : 'createdate',
					title : '创建日期',
					width : 120
				}, {
					field : 'compdate',
					title : '业绩日期',
					width : 120
				}, {
					field : 'orderdate',
					title : '合同日期',
					width : 120
				}, {
					field : 'startdate',
					title : '开始日期',
					width : 120
				}, {
					field : 'enddate',
					title : '截至日期',
					width : 120
				}, {
					field : 'username',
					title : '创建人',
					width : 100
				}, {
					field : 'info',
					title : '合同条款',
					width : 100
				}, {
					field : 'files',
					title : '合同文件',
					width : 100
				}, {
					field : 'operatornames',
					title : '业绩人员',
					width : 100
				}, {
					field : 'compweight',
					title : '业绩权重',
					width : 100
				}, {
					field : 'status_name',
					title : '状态',
					width : 100
				}, {
					field : 'amount',
					title : '总金额',
					width : 100
				}, {
					field : 'comments',
					title : '备注',
					width : 100
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性
					
					myconfirm("刪除？",function(){
						$.post("../Order/"+data.id, {_method:"DELETE"}, 
								function(json) {
							if(json.status!=1) console.log("");
							else{
								obj.del();
							}
							layer.close(layer.index);
								}, "json");
					});
				}else if(obj.event === 'edit'){
					openFrame('edit.jsp?id='+data.id,"修改",['640px','75%']);
				}else if(obj.event === 'detail'){
					openFrame('../Orderdetails/index_search.jsp?oderid='+data.id,"明细表",['690px','85%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else if(obj.event === 'add'){
					openFrame("edit.jsp","新增",['640px','75%']);
				}
			});

		});
	</script>
</body>
</html>