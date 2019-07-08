<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>

	$(function(){
		$("#checkModal").modal('show');
		/*$.get("findAllPE",{},function(data){
			for(var i=0;i<data.length;i++){
				var id = data[i].id;
				var name = data[i].name;
				$("#peSelect").append('<option value='+id+'>'+name+'</option>');
			}
			$("#checkModal").modal('show');
		});*/

		$("#peSelect").change(function(){
			$("#peSelect option:selected").each(function(){
				var id = $(this).val();
			$.get("findPeById",{id:id},function(data){
				$("input[name='physicalExam.price']").val(data.price);
			});
			});
		});
		$(".modal-footer .submitBtn").on("click",function(){
			$("#checkForm input:submit").trigger('click');
		});
		$("#checkForm").ajaxForm(function(data){
			$("#checkModal").modal('hide');
			alert(data);
		});
	});
 </script>
<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="checkModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">开检查</h4>
			</div>
			<div class="modal-body">
				<form action="addPP" id="checkForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">患者流水号</td>
								<td><input type="text" name="patientid" /></td>
							</tr>

							<tr>
								<td>患者姓名</td>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<td>检查项目</td>
								<td><select name="physicalExam.id" id="peSelect">
										<option value="">---请选择---</option>
								</select></td>
							</tr>
							<tr>
								<td>价格</td>
								<td><input type="text" name="physicalExam.price"></td>
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