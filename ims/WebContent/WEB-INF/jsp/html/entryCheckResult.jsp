<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(function(){
		$("#entryCheckResultModal").modal('show');
		/*$.get("findAllPE",{},function(data){
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				$("#peSelect").append('<option value='+id+'>'+name+'</option>');
			}
			$("#entryCheckResultModal").modal('show');
		});*/

		$("#peSelect").change(function(){
			$("#peSelect option:selected").each(function(){
				var id = $(this).val();
			$.get("technician/findPeById.action",{id:id},function(data){
				$("input[name='cost']").val(data.price);
			});
			});
		});
		$("#patientId").keyup(function(){
			/* $(this).val() */
			var id=$("#patientId").val();
			$.get("technician/findpatientById.action",{id:id},function(data){
				if(data==''){
					alert("没有该流水号");
				}else{
					$("input[name='patientName']").val(data.name);
				}
			});
			
		});
		$(".modal-footer .submitBtn").on("click",function(){
			$("#entryCheckResultForm").attr("action","technician/insertPhysicalexam.action");
			$("#entryCheckResultForm input:submit").trigger('click');
		});
		$("#entryCheckResultForm").ajaxForm(function(data){
			$("#entryCheckResultModal").modal('hide');
		});
	});

</script>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="entryCheckResultModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">录入检查</h4>
			</div>
			<div class="modal-body">
				<form action="saveCheckResult" id="entryCheckResultForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">患者流水号</td>
								<td><input type="text" name="patientId" id="patientId"/></td>
							</tr>

							<tr>
								<td>患者姓名</td>
								<td><input type="text" name="patientName"></td>
							</tr>
							<tr>
								<td>检查项目</td>
								<td><select name="physicalId" id="peSelect">
										<option value="">---请选择---</option>
										<c:forEach var="physicalexam" items="${sessionScope.physicalexams }">
											<option value="${physicalexam.id }">${physicalexam.name }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>价格</td>
								<td><input type="text" name="cost"></td>
							</tr>
							<tr>
								<td>检查结果</td>
								<td><textarea rows="" cols="" name="physicalExamResult">

							</textarea></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" style="display: none">
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default cancelBtn" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary submitBtn">录入</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>