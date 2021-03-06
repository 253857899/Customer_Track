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
<a class="layui-btn layui-btn-xs" lay-event="edit">分配人员</a>
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
				url : '../Customer_pool' //数据接口
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
					title : '客户名称',
					width : 120
				}, {
					field : 'sex_name',
					title : '性别',
					width : 100
				}, {
					field : 'tel',
					title : '电话',
					width : 120
				}, {
					field : 'qq',
					title : 'QQ',
					width : 100
				}, {
					field : 'email',
					title : '邮箱',
					width : 130
				}, {
					field : 'infos',
					title : '额外信息',
					width : 130
				}, {
					field : 'linkstatus_name',
					title : '联系状态',
					width : 120
				}, {
					field : 'clientstatus_name',
					title : '客户状态',
					width : 120
				}, {
					field : 'purposestatus_name',
					title : '意向状态',
					width : 120
				}, {
					field : 'assessstatus_name',
					title : '评估状态',
					width : 120
				}, {
					field : 'execstatus_name',
					title : '处理状态',
					width : 120
				}, {
					field : 'status_name',
					title : '状态',
					width : 100
				}, {
					field : 'typename',
					title : '客户类型',
					width : 120
				}, {
					field : 'createoperatorname',
					title : '创建人',
					width : 140
				}, {
					field : 'createdate',
					title : '创建时间',
					width : 140
				}, {
					field : 'srcname',
					title : '客户来源',
					width : 140
				}, {
					field : 'count',
					title : '回访次数',
					width : 140
				}, {
					field : 'comments',
					title : '备注',
					width : 140
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 100,
					align : 'center'
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
				if(obj.event === 'edit'){
					openFrame('edit.jsp?id='+data.id,"分配人员",['600px','60%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				}
			});
		});
	</script>
</body>
</html>