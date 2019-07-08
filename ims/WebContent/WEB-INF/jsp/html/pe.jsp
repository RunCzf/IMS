<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>

	$(function(){
		//批量删除
		$(".deleteBatch").on("click",function(){
			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});

			$.post("deletepe",{ids:ids},function(data){
				alert(data);
				$(".menu dd:contains('辅助检查项目管理')").trigger("click");
			});
		});
	});

	//添加
	
	function addPe(){
		//点击添加模态框显示
		$("#peModal").modal('show');
		//点击模态框中的保存，模拟点击form表单的提交按钮
		$(".modal-footer .submitBtn").on("click",function(){
			var name=$.trim($("#name").val());
			var price=$.trim($("#price").val());
			var physicalexam={name:name,price:price};
			alert(name+","+price);
			$.ajax({
				url:"technician/addPhysicalexam.action",
				data:physicalexam,
				success:function(data){
				if(data=='success'){
					alert('添加成功'+data);
					$("#peModal").modal('hide');
						setTimeout(function(){
							$(".menu dd:contains('辅助检查项目管理')").trigger("click");
						},200);
					}else{
						alert('处理失败');	
					}
				},
			}); 
		}); 
		
		////////////////////////////////////////////////
		/* 方法二
		#用var name=$.trim($("#name").val())--> Id .是class
		$("#peForm").attr("action","technician/addPhysicalexam.action");
			$("#peForm input:submit").trigger("click");
		});
		$("#peForm").ajaxForm(function(data){
			alert(data=='success');
			if(data=='success'){
				$("#peModal").modal('hide');
				
				setTimeout(function(){
					$(".menu dd:contains('辅助检查项目管理')").trigger("click");
				},200);
			}else{
				alert('处理失败'+data);	
			}
		});   	 */
		//点击模态框中的取消按钮，模拟点击form表单的提交按钮
		/* $(".modal-footer .cancelBtn").on("click",function(){
			$(".menu dd:contains('辅助检查项目管理')").trigger("click");
		}); */
	}
	//删除
	function deletepe(id){
		$.post("technician/deletepe.action",{id:id},function(data){
			if(data='succces'){
				alert('删除成功:'+data);
				$(".menu dd:contains('辅助检查项目管理')").trigger("click");
			}else{
				alert('删除失败');
			}
		});
	}
	//修改
	function updateDept(id){
		//省略......
	}
</script>
<div class="pe">
	<div class="optios">
		<button class="addBtn" onclick="addPe()">添加</button>
		<button class="deleteBatch">批量删除</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered">
			<thead>
				<tr>
					<th>请选择</th>
					<th>编号</th>
					<th>检查项目</th>
					<th>检查费用</th>
					<th>操作</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="physicalexam" items="${sessionScope.physicalexams }">
					<tr>
						<td><input type="checkbox" value="${physicalexam.id}" /></td>
						<td>${physicalexam.id}</td>
						<td>${physicalexam.name}</td>
						<td>${physicalexam.price}</td>
						<td>
							<a href="javascript:void(0)" onclick="deletepe(${physicalexam.id})">删除</a> 
							<a href="javascript:void(0)" onclick="updatePe(1)">修改</a>
						</td>
					</tr>
				</c:forEach>
				<!-- <tr>
					<td>2</td>
					<td><input type="checkbox" value=""/></td>
					<td>胃镜</td>
					<td>120.0</td>
					<td>
						<a href="javascript:void(0)" onclick="">删除</a>
						<a href="javascript:void(0)" onclick="updatePe(1)">修改</a>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td><input type="checkbox" value=""/></td>
					<td>彩超</td>
					<td>65.0</td>
					<td>
						<a href="javascript:void(0)" onclick="">删除</a>
						<a href="javascript:void(0)" onclick="updatePe(1)">修改</a>
					</td>
				</tr> -->
			</tbody>

		</table>
	</div>
</div>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="peModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加部门</h4>
			</div>
			<div class="modal-body">
				<form action="" id="peForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">检查项目</td>
								<td><input type="hidden" name="id"> 
								<input type="text" name="name" id="name" /></td>
							</tr>
							<tr>
								<td style="width: 80px">检查费用</td>
								<td><input type="text" name="price" id="price"></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" style="display: none">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default cancelBtn" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary submitBtn">保存</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
