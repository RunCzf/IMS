<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function(){
		//添加
		$(".optios .addBtn").on("click",function(){
			//当代及添加按钮时，先查出所有部门和角色，显示到模态框中的下拉列表中

			$.get("division/selectDept.action",{},function(data){

				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
					$("#deptSelect").append('<option value='+id+'>'+name+'</option>');
				}

			});
		$.get("division/selectRoles.action",{},function(data){

					for(var i=0;i<data.length;i++){
						var id = data[i].id;
						var name = data[i].name;
						/* var newOption = $('<option value='+id+'>'+name+'</option>') */
						$("#roleSelect").append('<option value='+id+'>'+name+'</option>');
					}

				});
		$("#userModal").modal('show');
		});
		//点击保存按钮
		$(".modal-footer .submitBtn").on("click",function(){
			//改变form表单提交的地址
			$("#userForm").attr("action","division/addUser.action");
			//模拟点击submit按钮
			$("#userForm input:submit").trigger("click");
		});
		$("#userForm").ajaxForm(function(data){
			alert(data);
			$("#userModal").modal('hide');
			$(".menu dd:contains('职工管理')").trigger("click");
		});
		//批量删除
		$(".deleteBatch").on("click",function(){
			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});

			$.post("deleteUser",{ids:ids},function(data){
				alert(data);
				$(".menu dd:contains('职工管理')").trigger("click");
			});
		});
	});

	//删除
	function deleteUser(id){
		$.post("deleteUser",{id:id},function(data){
			alert(data);
			$(".menu dd:contains('部门管理')").trigger("click");
		});
	}
	//修改
	function updateDept(id){
		//同dept.jsp中的修改，暂时省略...
	}
</script>
<div class="user">
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
					<th>员工号</th>
					<th>姓名</th>
					<th>所在部门</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>电话号码</th>
					<th>籍贯</th>
					<th>身份证号</th>
					<th>学历</th>
					<th>职称</th>
					<th>职位</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${sessionScope.users }">
				<tr>
					<td><input type="checkbox" value="${user.id }" /></td>
					<td>${user.id }</td>
					<td>${user.roleId }</td>
					<td>${user.name }</td>
					<td>${user.department.name }</td>
					<td>${user.gender }</td>
					<td><fmt:formatDate value="${user.birth }" pattern="yyyy-MM-dd"/></td>
					<td>${user.phone }</td>
					<td>${user.address }</td>
					<td>${user.card }</td>
					<td>${user.education }</td>
					<td>${user.position }</td>
					<td>${user.professional }</td>
					<td><a href="javascript:void(0)" onclick="deleteUser(id)">删除</a>
						<a href="javascript:void(0)" onclick="updateUser(id)">修改</a></td>
				</tr>
			</c:forEach>	
				<!-- <tr>
					<td><input type="checkbox" value="" /></td>
					<td>2</td>
					<td>17</td>
					<td>张传静</td>
					<td>妇科</td>
					<td>女</td>
					<td>1990/03/14</td>
					<td>17722222222</td>
					<td>昆山</td>
					<td>341225****3214</td>
					<td>本科</td>
					<td>二级</td>
					<td>妇科医技人员</td>
					<td><a href="javascript:void(0)" onclick="deleteUser()">删除</a>
						<a href="javascript:void(0)" onclick="updateUser()">修改</a></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>3</td>
					<td>17</td>
					<td>柴慧超</td>
					<td>妇科</td>
					<td>女</td>
					<td>1990/03/14</td>
					<td>17722222222</td>
					<td>昆山</td>
					<td>341225****3214</td>
					<td>本科</td>
					<td>二级</td>
					<td>护士</td>
					<td><a href="javascript:void(0)" onclick="deleteUser()">删除</a>
						<a href="javascript:void(0)" onclick="updateUser()">修改</a></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>4</td>
					<td>16</td>
					<td>莫西</td>
					<td>财务</td>
					<td>女</td>
					<td>1990/03/14</td>
					<td>17722222222</td>
					<td>昆山</td>
					<td>341225****3214</td>
					<td>本科</td>
					<td>二级</td>
					<td>收费人员</td>
					<td><a href="javascript:void(0)" onclick="deleteUser()">删除</a>
						<a href="javascript:void(0)" onclick="updateUser()">修改</a></td>
				</tr> -->
			</tbody>
		</table>
	</div>
</div>


<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="userModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加员工</h4>
			</div>
			<div class="modal-body">
				<form action="" id="userForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">姓名</td>
								<td><input type="text" name="name" /> <input type="hidden"
									name="id"></td>
							</tr>
							<tr>
								<td style="width: 80px">性别</td>
								<td><label for="male"> <input id="male"
										type="radio" name="gender" value="男" />男
								</label> <label for="female"> <input id="female" type="radio"
										name="gender" value="女">女
								</label></td>
							</tr>
							<tr>
								<td>电话号码</td>
								<td><input type="text" name="phone"></td>
							</tr>
							<tr>
								<td>身份证号</td>
								<td><input type="text" name="card"></td>
							</tr>
							<tr>
								<td>职称</td>
								<td><input type="text" name="position"></td>
							</tr>
							<tr>
								<td>家庭地址</td>
								<td><input type="text" name="address"></td>
							</tr>
							<tr>
								<td>所在部门</td>
								<td><select name="departmentId" id="deptSelect">
										<option value="">---请选择---</option>
								</select></td>
							</tr>
							<tr>
								<td>角色</td>
								<td><select name="roleId" id="roleSelect">
										<option value="">---请选择---</option>
								</select></td>
							</tr>
							<tr>
								<td>出生日期</td>
								<td><input type="text" name="birth"></td>
							</tr>
							<tr>
								<td>学历</td>
								<td><input type="text" name="education"></td>
							</tr>
							<tr>
								<td>职位</td>
								<td><input type="text" name="professional"></td>
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
