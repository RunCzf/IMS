<%@page import="java.text.SimpleDateFormat"%>
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

</script>
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
			<tbody>
				<c:forEach var="userPatient" items="${sessionScope.userPatients }">
					<tr>
						<td><input type="checkbox" value="" /></td>
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

