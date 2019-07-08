<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%= basePath %>">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>XXX管理系统</title>
<!-- jquery基础库 -->
<script type="text/javascript" src="static/jquery-3.3.1.min.js"></script>
<!-- jquery表单异步提交库 -->
<script type="text/javascript" src="static/jquery.form.min.js"></script>
<!-- bootstrap js -->
<script type="text/javascript"
	src="static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!-- bootstrap css -->
<link rel="stylesheet"
	href="static/bootstrap-3.3.7/css/bootstrap.min.css">
<!-- font-awesome -->
<link rel="stylesheet"
	href="static/font-awesome-4.7.0/css/font-awesome.css">
<!-- 自定义JS -->
<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = '${msg}';
		if(msg != null && msg != "") {
			alert(msg);
		}
	});
	</script>
<c:remove var="msg" scope="session" />
<!-- 自定义CSS -->
<link rel="stylesheet" href="static/css/layout.css">
</head>
<body>
	<div class="b_container">
		<!-- 头部开始 -->
		<div class="b_header">
			<div class="logo">
				<i class="fa fa-hospital-o"></i> 医院管理系统
			</div>
			<div class="loginInfo">欢迎您:[${sessionScope.user.name}]</div>
		</div>
		<!-- 头部结束 -->
		<!-- 内容区开始 -->
		<div class="b_content">
			<div class="b_left">
				<dl class="menu">
					<c:if test="${user.roleId==1}">
						<dt>
							<i class="fa fw fa-user-o"></i><a href="#">角色1：医生</a>
						</dt>
						<dd url='user/nodealPatient.action?userId=${sessionScope.user.id}'>
							<a href="javascript:void(0);">科室未处理病人</a>
						</dd>
						<dd url='user/dealedPatient.action?userId=${sessionScope.user.id}'>
							<a href="javascript:void(0);">已处理挂号病人</a>
						</dd>
						<dd url='user/prescription.action'>
							<a href="javascript:void(0);">开处方</a>
						</dd>
						<dd url='user/selectPrescription.action'>
							<a href="javascript:void(0);">处方查询</a>
						</dd>
						<dd url='user/check.action'>
							<a href="javascript:void(0);">开检查</a>
						</dd>
						<dd url='user/selectCheck.action'>
							<a href="javascript:void(0);">检查查询</a>
						</dd>
						<dd url='user/diagnosis.action'>
							<a href="javascript:void(0);">诊断病人</a>
						</dd>
						<dd url='html/MedicalRecordSelect.html'>
							<a href="javascript:void(0);">病例档案查询</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==2}">
						<dt>
							<i class="fa fw fa-ambulance"></i><a href="#">角色2：医技人员</a>
						</dt>
						<dd url='technician/pe.action'>
							<a href="javascript:void(0);">辅助检查项目管理</a>
						</dd>
						<dd url='technician/entryCheckResult.action'>
							<a href="javascript:void(0);">录入检查结果</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==3}">
						<dt>
							<i class="fa fw fa-plus-square"></i><a href="#">角色3：护士</a>
						</dt>
						<dd url='nurse/MedicalRecordSelect.action'>
							<a href="javascript:void(0);">病例档案查询</a>
						</dd>
						<dd url='nurse/selectPrescription.action'>
							<a href="javascript:void(0);">处方查询</a>
						</dd>
						<dd url='nurse/selectCheck.action'>
							<a href="javascript:void(0);">检查查询</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==4}">
						<dt>
							<i class="fa fw fa-hand-o-right"></i><a href="#">角色4：导医</a>
						</dt>
						<dd url='guideDoctor/patient.action'>
							<a href="javascript:void(0);">病人基本信息管理</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==5}">
						<dt>
							<i class="fa fw fa-cny"></i><a href="#">角色5：门诊收费员</a>
						</dt>
						<dd url='outpatient/register.action'>
							<a href="javascript:void(0);">门诊挂号</a>
						</dd>
						<!-- <dd url=''><a href="#">建立病例档案</a></dd>
					<dd url=''><a href="#">病例档案查询</a></dd> -->
						<dd url='outpatient/dealcard.action'>
							<a href="javascript:void(0);">就诊卡充值退费</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==6}">
						<dt>
							<i class="fa fw fa-pencil"></i><a href="#">角色6：药房管理员</a>
						</dt>
						<dd url='medicineManagerMan/1/category.action'>
							<a href="javascript:void(0);">药品类别管理</a>
						</dd>
						<dd url='medicineManagerMan/drug.action'>
							<a href="javascript:void(0);">医用药品管理</a>
						</dd>
					</c:if>
					<c:if test="${user.roleId==7}">
						<dt>
							<i class="fa fw fa-address-book-o"></i><a href="#">角色7：字典维护人员</a>
						</dt>
						<dd url='division/1/dept.action'>
							<a href="javascript:void(0);">部门管理</a>
						</dd>
						<dd url='division/user.action'>
							<a href="javascript:void(0);">职工管理</a>
						</dd>
						<!-- <dd url='toFindAllCategory?currentPage=1&size=5'><a href="#">药品类别管理</a></dd>
					<dd url='toDrug'><a href="#">医用药品信息管理</a></dd> -->
						<dd url='technician/pe.acction'>
							<a href="javascript:void(0);">辅助检查项目管理</a>
						</dd>
					</c:if>
				</dl>
			</div>
			<div class="b_right">
				<div class="b_tip">></div>
				<!-- 动态内容区 -->
				<div class="b_main">
					<!--内容区  -->

				</div>
			</div>
		</div>
		<!-- 内容区结束 -->
		<!-- 底部开始 -->
		<div class="b_footer">版权所有：杰普软件科技有限公司</div>
		<!-- 底部结束 -->
	</div>
</body>