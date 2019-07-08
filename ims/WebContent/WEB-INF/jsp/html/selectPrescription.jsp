<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(function(){
		$("#selectPrescriptionModal").modal('show');
		$(".submitBtn").on("click",function(){
			$("#selectPrescriptionModal").modal('hide');
			var id = $(".modal-body input[name='id']").val();
			setTimeout(function(){
				$(".b_main").load("selectPrescription",{id:id});
			},100);
		});
	});
</script>
<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="selectPrescriptionModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">处方查询</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped table-bordered">
					<tbody>
						<tr>
							<td>患者流水号</td>
							<td><input type="text" name="id" /></td>
						</tr>

						<tr>
							<td>患者姓名</td>
							<td><input type="text" name="name"></td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default cancelBtn">取消</button>
				<button type="button" class="btn btn-primary submitBtn">查询</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>