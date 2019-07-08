<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<base href="<%= basePath %>">
<script>
	$(function(){


		$(".addBtn").on("click",function(){
			var ids = $("#tableData input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get(); 
			alert(ids.length);
			for(var i=0;i<ids.length;i++){
				alert(ids[i]);
			}
			
			/* var inputs = $("#tableData input[type='checkbox']:checked");
			alert(inputs.length);
			for(var i=0;i<inputs.length;i++){
				alert(inputs[i].value);
			} */
			$.ajax({
				url:"user/dispose.action",
				data:{
					ids:ids	
				},
				success:function(data){
				if(data=='success'){
					$(".menu dd:contains('诊断病人')").trigger("click");
					alert(data); 
					}else{
						alert('处理失败'+data);	
					}
				},
				error:function(data){
					alert('开处方错误'+data);
				},
			});
			
			
			/* 方法二 jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});
			$.get("user/dispose.action",{ids:ids},function(data){
				if(data=='success'){
				$(".menu dd:contains('诊断病人')").trigger("click");
				alert(data); 
				}else{
					alert('处理失败'+data);	
				}
			}); */
		});
	});
</script>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg){
		alert(msg);
	}
</script>
<c:remove var="msg" scope="session" />
<div class="register">
	<div class="optios">
		<button class="addBtn">处理病人</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered"
			id="tableData">
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
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach var="userPatient" items="${sessionScope.userPatients }">
					<tr>
						<td><input type="checkbox" value="${userPatient.id }" /></td>
						<td>${userPatient.id }</td>
						<td>${userPatient.patient.name}</td>
						<td>${sessionScope.department.name}</td>
						<td>${sessionScope.user.name}</td>
						<td>${userPatient.price }</td>
						<td>${userPatient.date }</td>
						<td>${userPatient.status }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>

