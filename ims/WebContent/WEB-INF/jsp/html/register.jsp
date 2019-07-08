<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	//添加
	function addRegister(){
		$.get("selectDept",{},function(data){
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				$("#deptSelect").append('<option value='+id+'>'+name+'</option>');
			}
		});
		$("#registerModal").modal('show');
		$("#deptSelect").change(function(){
			$("#deptSelect option:selected").each(function(){
				var id = $(this).val();
			$.get("findUserWithDeptByDeptId",{id:id},function(data){
				var selection = document.getElementById("userSelect");
				selection.innerHTML = "";
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
					$("#userSelect").append('<option value='+id+'>'+name+'</option>');
				}
			});
			});
		});

		$(".modal-footer .submitBtn").on("click",function(){
			$("#registerForm").attr("action","addUP");
			$("#registerForm input:submit").trigger("click");
		});
		$("#registerForm").ajaxForm(function(data){
			$("#registerModal").modal("hide");
			alert(data);
			$(".menu dd:contains('门诊挂号')").trigger("click");
		});
	}
	$(function(){
		//批量删除
 		$(".optios .deleteBatch").on("click",function(){
 			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
 			console.log(ids);
			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});
			$.post("deleteRegister",{ids:ids},function(data){
				alert(data);
				$(".menu dd:contains('门诊挂号')").trigger("click");
			});
		});

	});
	//删除
	function deleteRegister(id){
		$.post("deleteRegister",{id:id},function(data){
			alert(data);
			$(".menu dd:contains('门诊挂号')").trigger("click");
		});
	}
	//修改
	/*
		$("#registerForm input[name='patient.id']").val(data.patient.id);
			$("#registerForm input[name='name']").val(data.patient.name);
			$("#registerForm input[name='price']").val(data.price);
			$("#registerForm input[name='date']").val(data.date);
			var radio1 = $("#registerForm input[value='未处理']");
			var radio2 = $("#registerForm input[value='已处理']");
			if(data.status=='未处理'){
				radio1.attr("checked","checked");
			}else{
				radio2.attr("checked","checked");
			}
	*/
	function updateRegister(id){
		$(".modal-title").text("修改挂号");
		$.get("selectDept",{},function(data){
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				$("#deptSelect").append('<option value='+id+'>'+name+'</option>');
			}

		});

		$("#deptSelect").change(function(){
			$("#deptSelect option:selected").each(function(){
				var id = $(this).val();
			$.get("findUserWithDeptByDeptId",{id:id},function(data){
				var selection = document.getElementById("userSelect");
				selection.innerHTML = "";
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var name = data[i].name;
					$("#userSelect").append('<option value='+id+'>'+name+'</option>');
				}
			});
			});
		});
		$.get("findUserPatientWithDeptId",{id:id},function(data){
			$("#registerForm input[name='patient.id']").val(data.patient.id);
			$("#registerForm input[name='name']").val(data.patient.name);
			$("#registerForm input[name='price']").val(data.price);
			$("#registerForm input[name='date']").val(data.date);
			var radio1 = $("#registerForm input[value='未处理']");
			var radio2 = $("#registerForm input[value='已处理']");
			if(data.status=='未处理'){
				radio1.attr("checked","checked");
			}else{
				radio2.attr("checked","checked");
			}
		});
		$("#registerModal").modal('show');

	}
</script>
<div class="register">
	<div class="optios">
		<button class="addBtn" onclick="addRegister()">添加</button>
		<button class="deleteBatch">批量删除</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered">
			<thead>
				<tr>
					<th>请选择</th>
					<th>患者流水号</th>
					<th>病人姓名</th>
					<th>部门名称</th>
					<th>所属医生</th>
					<th>挂号费</th>
					<th>挂号日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>1</td>
					<td>张三</td>
					<td>眼科</td>
					<td>张医生</td>
					<td>5.0</td>
					<td>2018-03-27</td>
					<td>未处理</td>
					</td>
					<td><a href="javascript:void(0)"
						onclick="deleteRegister(${pu.id})">删除</a> <a
						href="javascript:void(0)" onclick="updateRegister(${pu.id})">修改</a>
					</td>
				</tr>
			</tbody>
		</table>

	</div>
</div>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="registerModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加挂号</h4>
			</div>
			<div class="modal-body">
				<form action="" id="registerForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">患者流水号</td>
								<td><input type="text" name="patient.id" /></td>
							</tr>
							<tr>
								<td style="width: 80px">病人姓名</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td>部门</td>
								<td><select name="deptid" id="deptSelect">
										<option value="">---请选择---</option>
								</select></td>
							</tr>
							<tr>
								<td>所属医生</td>
								<td><select name="user.id" id="userSelect">
										<option value="">请选择</option>
								</select></td>
							</tr>
							<tr>
								<td>挂号费</td>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<td>挂号日期</td>
								<td><input type="text" name="date"></td>

							</tr>
							<tr>
								<td>状态</td>
								<td><label for="no"> <input id="no" name="status"
										type="radio" value="未处理">未处理
								</label> <label for="yes"> <input id="yes" name="status"
										type="radio" value="已处理">已处理
								</label></td>
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
