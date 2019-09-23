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
</script>
	<script type="text/html" id="toolbarDemo">
	<div>
      <a>合同明细</a>
    </div>
</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : '../Orderdetails' //数据接口
				,
				where:{
					_method:"get"
				},
				toolbar : '#toolbarDemo',
				page : false //开启分页
				,
				cols : [ [ //表头
				{
					field : 'productname',
					title : '产品名称',
					width : 120
				}, {
					field : 'count',
					title : '数量',
					width : 100
				}, {
					field : 'amount',
					title : '总金额',
					width : 120
				}, {
					field : 'desc',
					title : '折扣金额',
					width : 120
				}, {
					field : 'comments',
					title : '备注',
					width : 120
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
					openFrame('edit.jsp?id='+data.id,"修改",['350px','65%']);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'search') {
					var txt = $(event.target).prev().find("input").val();
					reload('demo',{txt : txt});
				} else if(obj.event === 'add'){
					openFrame("edit.jsp","新增",['350px','65%']);
				}
			});

		});
	</script>
</body>
</html>