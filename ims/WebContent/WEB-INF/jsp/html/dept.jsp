<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(function(){
		//添加
		$(".addBtn").on("click",function(){
			//点击添加模态框显示
			$("#deptModal").modal('show');
			//点击模态框中的保存，模拟点击form表单的提交按钮
			$(".modal-footer .submitBtn").on("click",function(){
				$("#deptForm").attr("action","addDepartment");
				$("#deptForm input:submit").trigger("click");
			});
			$("#deptForm").ajaxForm(function(data){
				$("#deptModal").modal('hide');
				alert(data);
				$(".menu dd:contains('部门管理')").trigger("click");
			});
		});

		//批量删除
		$(".deleteBatch").on("click",function(){
			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});

			$.post("deleteDept",{ids:ids},function(data){
				alert(data);
				$(".menu dd:contains('部门管理')").trigger("click");
			});
		});
	});
	//删除
	function deleteDept(id){
		$.post("deleteDept",{id:id},function(data){
			alert(data);
			$(".menu dd:contains('部门管理')").trigger("click");
		});
	}
	//修改
	function updateDept(id){
		//先查出对应的本门显示到模态框中
		$.get("findDepartmentByid",{id:id},function(data){
			$("#deptForm input[name='name']").val(data.name);
			$("#deptForm input[name='id']").val(data.id);
			$("#deptForm input[name='description']").val(data.description);
			var radio1 = $("#deptForm input[value='是']");
			var radio2 = $("#deptForm input[value='否']");
			if(data.status=='是'){
				radio1.attr("checked","checked");
			}
			$(".modal-header .modal-title").text("修改部门");
			$("#deptModal").modal('show');
		});
		$("#deptModal .submitBtn").on("click",function(){
			$("#deptForm").attr("action","updateDept");
			$("#deptForm input:submit").trigger("click");
		});
		$("#deptForm").ajaxForm(function(data){
			$("#deptModal").modal('hide');
			alert(data);
			$(".menu dd:contains('部门管理')").trigger("click");
		});
	}
	//分页
	function pageSelect(curPage,size){
		var url = "toDepartmentManager";
		$(".b_main").load(url,{curPage:curPage,size:size});
	}

</script>
<div class="dept">
	<div class="optios">
		<button class="addBtn">添加</button>
		<button class="deleteBatch">批量删除</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered">
			<thead>
				<tr>
					<th>请选择</th>
					<th>编号</th>
					<th>部门名称</th>
					<th>是否可以挂号</th>
					<th>部门描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="department" items="${sessionScope.departmentess.list }">
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>${department.id}</td>
					<td>${department.name}</td>
					<td>${department.status}</td>
					<td>${department.description}</td>
					<td><a href="javascript:void(0)" onclick="">删除</a> <a
						href="javascript:void(0)" onclick="">修改</a></td>
				</tr>
				</c:forEach>
				<!-- <tr>
					<td><input type="checkbox" value="" /></td>
					<td>2</td>
					<td>耳鼻喉科</td>
					<td>负责诊断耳鼻喉方面的疾病</td>
					<td>否</td>
					<td><a href="javascript:void(0)" onclick="">删除</a> <a
						href="javascript:void(0)" onclick="">修改</a></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>3</td>
					<td>内科</td>
					<td>心血管内科 内分泌</td>
					<td>否</td>
					<td><a href="javascript:void(0)" onclick="">删除</a> <a
						href="javascript:void(0)" onclick="">修改</a></td>
				</tr> -->
			</tbody>
		</table>
		<table class="footTable">
			<tr>
				<td colspan="5">共条 记录 每页 条 第 页 <a href="javascript:void(0)"
					onclick="pageSelect(attr1,attr2)">首页</a> <a
					href="javascript:void(0)" onclick="pageSelect(attr1,attr2)">上一页</a>
					<font color="#ABA8AB">上一页</font> <a href="javascript:void(0)"
					onclick="pageSelect(attr1,attr2)">下一页</a> <font color="#ABA8AB">下一页</font>
					<a href="javascript:void(0)" onclick="pageSelect(attr1,attr2)">尾页</a>
				</td>
			</tr>

		</table>
	</div>
</div>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="deptModal">
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
				<form action="" id="deptForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">部门名称</td>
								<td><input type="text" name="name" /> <input type="hidden"
									name="id"></td>
							</tr>
							<tr>
								<td style="width: 80px">是否可挂号</td>
								<td><label for="yes"> <input id="yes" type="radio"
										name="status" value="是" />是
								</label> <label for="no"> <input id="no" type="radio"
										name="status" value="否">否
								</label></td>
							</tr>
							<tr>
								<td>描述</td>
								<td><input type="text" name="description"></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" style="display: none">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default cancelBtn">取消</button>
				<button type="button" class="btn btn-primary submitBtn">保存</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
