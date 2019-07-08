<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	//分页
			$("#pageSelect").val('${sessionScope.categoryes.size}');	
	function pageSelect(currentPage,size){
		var url = "medicineManagerMan/"+currentPage+"/category.action";
			$(".b_main").load(url,{currentPage:currentPage,size:size});
	}
	//每页第几条记录
	function updateSize(select){
			var size =$(select).val();
			var url = "medicineManagerMan/"+1+"/category.action";
			$(".b_main").load(url,{currentPage:1,size:size});
	}
	function addBtn(){
		//添加
		
 		$(".addBtn").on("click",function(){
 			$("#categoryModal").modal('show');
 		});

 		$(".modal-footer .submitBtn").on("click",function(){
 			$("#categoryForm").attr("action","addCategory");
 			$("#categoryForm input:submit").trigger("click");
 		});
 		$("#categoryForm").ajaxForm(function(data){
 			$("#categoryModal").modal('hide');
 			alert(data);
 			$(".menu dd:contains('药品类别管理')").trigger("click");
 		});
	}
 	$(function(){

 		//批量删除
 		$(".optios .deleteBatch").on("click",function(){
 			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
 			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});
			$.post("deleteCategory",{ids:ids},function(data){
				$(".menu dd:contains('药品类别管理')").trigger("click");
				alert(data);
			});
		});
 	});
 	//删除
 	function deleteCategory(id){
 		$.post("deleteCategory",{id:id},function(data){
 			alert(data);
 			$(".menu dd:contains('药品类别管理')").trigger("click");
 		});
 	}
 	//修改
 	function updateCategory(id){
 		$.get("findCategory",{id:id},function(data){
 			console.log(data.description);
 			$("#categoryForm input[name='name']").val(data.name);
 			$("#categoryForm input[name='description']").val(data.description);
 			$("#categoryForm input[name='id']").val(data.id);
 			$("#categoryModal").modal('show');
 		});
 		$("#categoryModal .submitBtn").on("click",function(){
			$("#categoryForm").attr("action","updateCategory");
			$("#categoryForm input:submit").trigger("click");
		});
		$("#categoryForm").ajaxForm(function(data){
			$("categoryModal").modal('hide');
			alert(data);
			$(".menu dd:contains('药品类别管理')").trigger("click");
		});
 	}
 </script>
<div class="category">
	<div class="optios">
		<button class="addBtn" onclick="addBtn()">添加</button>
		<button class="deleteBatch">批量删除</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered">
			<thead>
				<tr>
					<th>请选择</th>
					<th>编号</th>
					<th>药品类别名称</th>
					<th>药品类别描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${sessionScope.categoryes.list }">
				<tr>
					<td><input type="checkbox" value="${category.id }" /></td>
					<td>${category.id }</td>
					<td>${category.name }</td>
					<td>${category.description }</td>
					<td><a href="javascript:void(0)"
						onclick="deleteCategory(${c.id})">删除</a> <a
						href="javascript:void(0)" onclick="updateCategory(1)">修改</a></td>
				</tr>
				</c:forEach>
				<%-- <tr>
					<td><input type="checkbox" value="" /></td>
					<td>2</td>
					<td>消炎止痛</td>
					<td>暂无描述</td>
					<td><a href="javascript:void(0)"
						onclick="deleteCategory(${c.id})">删除</a> <a
						href="javascript:void(0)" onclick="updateCategory(1)">修改</a></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>3</td>
					<td>妇科用药</td>
					<td>暂无描述</td>
					<td><a href="javascript:void(0)"
						onclick="deleteCategory(${c.id})">删除</a> <a
						href="javascript:void(0)" onclick="updateCategory(1)">修改</a></td>
				</tr> --%>
			</tbody>
		</table>
		<table class="footTable">
			<tr>
				<td colspan="5">共条${sessionScope.categoryes.total }记录 每页
				<select id="pageSelect" onchange="updateSize(this);">
					<option value="5">5
					<option value="10">10
					<option value="15">15
					<option value="20">20
				</select> 条 第${sessionScope.categoryes.pageNum}页 <a
					href="javascript:void(0)" onclick="pageSelect(1,${sessionScope.categoryes.size})">首页</a> 
					<c:choose>
						<c:when test="${sessionScope.categoryes.hasPreviousPage}">
							<a href="javascript:void(0)" onclick="pageSelect(${sessionScope.categoryes.prePage},${sessionScope.categoryes.size})">上一页</a>
						</c:when>
						<c:otherwise>
							<font color="#ABA8AB">上一页</font>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${sessionScope.categoryes.hasNextPage}">	
							<a href="javascript:void(0)" onclick="pageSelect(${sessionScope.categoryes.nextPage},${sessionScope.categoryes.size})">下一页</a>
						</c:when>
						<c:otherwise>	
							<font color="#ABA8AB">下一页</font>
						</c:otherwise>
					</c:choose>	
					<a href="javascript:void(0)" onclick="pageSelect(${sessionScope.categoryes.lastPage},${sessionScope.categoryes.size})">尾页</a>
				</td>
			</tr>
		</table>
	</div>
</div>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="categoryModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加药品类别</h4>
			</div>
			<div class="modal-body">
				<form action="" id="categoryForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">药品类别名称</td>
								<td><input type="text" name="name" /> <input type="hidden"
									name="id"></td>
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