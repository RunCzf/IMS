<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		//批量删除
		$(".deleteBatch").on("click",function(){
			var ids = $(".dataTable input[type='checkbox']:checked").map(function(index,item){
				return $(item).val();
			}).get();
			jQuery.ajaxSetup({
				traditional:true// ids数组可以被后台接收到
			});

			$.post("deleteDrug",{ids:ids},function(data){
				alert(data);
				$(".menu dd:contains('医用药品信息管理')").trigger("click");
			});
		});

	});



	function addDrug(){
			$.get("findAllCategory",{},function(data){
				for(var i=0;i<data.length;i++){
					var name = data[i].name;
					var id = data[i].id;
					console.log("name",name);
					console.log("id",id);
					$("#categorySel").append('<option value='+id+'>'+name+'</option>');
				}
				$("#drugModal").modal('show');
			});
			$(".modal-footer .submitBtn").on("click",function(){
				$("#drugForm").attr("action","addDrug");
				$("#drugForm input:submit").trigger("click");
			});
			$("#drugForm").ajaxForm(function(data){
				$("#drugModal").modal("hide");
				alert(data);
				$(".menu dd:contains('医用药品信息管理')").trigger("click");
			});
	}
	//删除
	function deleteDrug(id){
		$.post("deleteDrug",{id:id},function(data){
			alert(data);
			$(".menu dd:contains('医用药品信息管理')").trigger("click");
		});

	}
	//修改
	function updateDrug(id){
		$.get("findAllCategory",{},function(data){
			for(var i=0;i<data.length;i++){
				var name = data[i].name;
				var id = data[i].id;
				console.log("name",name);
				console.log("id",id);
				$("#categorySel").append('<option value='+id+'>'+name+'</option>');
			}
		});
		$.get("findDrugById",{id:id},function(data){
			$("#drugForm input[name='name']").val(data.name);
			$("#drugForm input[name='id']").val(data.id);
			$("#drugForm input[name='barcode']").val(data.barcode);
			$("#drugForm input[name='description']").val(data.description);
			$("#drugForm input[name='dosageform']").val(data.dosageform);
			$("#drugForm input[name='specifications']").val(data.specifications);
			$("#drugForm input[name='prime_cost']").val(data.prime_cost);
			$("#drugForm input[name='price']").val(data.price);
			$("#drugForm input[name='inventory']").val(data.inventory);
			$("#drugForm input[name='minimum']").val(data.minimum);
			$("#drugForm input[name='unit']").val(data.unit);
			var f = $("#drugForm option[value='"+data.category.id+"']");
			f.attr("selected","selected");
			$("#drugModal").modal('show');
		});
		$(".modal-footer .submitBtn").on("click",function(){
			$("#drugForm").attr("action","updateDrug");
			$("#drugForm input:submit").trigger("click");
		});
		$("#drugForm").ajaxForm(function(data){
			$("#drugModal").modal('hide');
			alert(data);
			$(".menu dd:contains('医用药品信息管理')").trigger("click");
		});
	}
	//取药
	function medicineGetting(){
		var id = $(".dataTable input[type='checkbox']:checked").val();
		$.get("medicineManagerMan/selectDrugById.action",{id:id},function(data){
			$("#dForm input[name='name']").val(data.name);
			$("#dForm input[name='id']").val(data.id);

		});
		$("#dModal").modal('show');
		$("#dModal .submitBtn").on("click",function(){
			$("#dForm").attr("action","medicineManagerMan/medicineGetting.action");
			$("#dForm input:submit").trigger('click');
		});
		$("#dForm").ajaxForm(function(data){
			$("#dModal").modal('hide');
			setTimeout(function(){
			if(data=='success'){
				alert("取药成功"+data);
				$(".menu dd:contains('医用药品管理')").trigger("click");
			}else{
				alert(data);
			}
			},200);
		});
	}
	//入库
	function medicineStorge(){
		var id = $(".dataTable input[type='checkbox']:checked").val();
		$.get("selectDrugById",{id:id},function(data){
			$("#dForm input[name='name']").val(data.name);
			$("#dForm input[name='id']").val(data.id);

		});
		$("#dModal").modal('show');
		$("#dModal .submitBtn").on("click",function(){
			$("#dForm").attr("action","medicineStorge");
			$("#dForm input:submit").trigger('click');
		});
		$("#dForm").ajaxForm(function(data){
			$("#dModal").modal('hide');
			alert(data);
			$(".menu dd:contains('医用药品管理')").trigger("click");

		});
	}
</script>

<div class="drug">
	<div class="optios">
		<button class="addBtn" onclick="addDrug()">添加</button>
		<button class="deleteBatch">批量删除</button>
		<button class="medicineGetting" onclick="medicineGetting()">取药</button>
		<button class="storge" onclick="medicineStorge()">入库</button>
	</div>
	<div class="data">
		<table class="dataTable table table-striped table-bordered">
			<thead>
				<tr>
					<th>请选择</th>
					<th>编号</th>
					<th>名称</th>
					<th>药品类别</th>
					<th>条形码</th>
					<th>剂型</th>
					<th>规格</th>
					<th>单位</th>
					<th>进货价</th>
					<th>零售价</th>
					<th>库存量</th>
					<th>库存下限</th>
					<th>简介</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="drug" items="${sessionScope.drugs }">
				<tr>
					<td><input type="checkbox" value="${drug.id}" /></td>
					<td>${drug.id}</td>
					<td>${drug.name}</td>
					<td>${drug.category.name}</td>
					<td>${drug.barcode}</td>
					<td>${drug.dosageform}</td>
					<td>${drug.specifications}</td>
					<td>${drug.unit}</td>
					<td>${drug.primeCost}</td>
					<td>${drug.price}</td>
					<td>${drug.inventory}</td>
					<td>${drug.minimum}</td>
					<td>${drug.description}</td>
					<td><a href="javascript:void(0)" onclick="deleteDrug(${d.id})">删除</a>
						<a href="javascript:void(0)" onclick="updateDrug(1)">修改</a></td>
				</tr>
				</c:forEach>
				<%-- <tr>
					<td><input type="checkbox" value="" /></td>
					<td>2</td>
					<td>克咳胶囊</td>
					<td>感冒发热</td>
					<td>6923959408694</td>
					<td>胶囊剂</td>
					<td>0.3g*12粒</td>
					<td>盒</td>
					<td>5.5</td>
					<td>4.0</td>
					<td>140</td>
					<td>20</td>
					<td>【商品名称】克咳胶囊(运动员慎用)</td>
					<td><a href="javascript:void(0)" onclick="deleteDrug(${d.id})">删除</a>
						<a href="javascript:void(0)" onclick="updateDrug(1)">修改</a></td>
				</tr>
				<tr>
					<td><input type="checkbox" value="" /></td>
					<td>3</td>
					<td>克咳胶囊</td>
					<td>感冒发热</td>
					<td>6923959408694</td>
					<td>胶囊剂</td>
					<td>0.3g*12粒</td>
					<td>盒</td>
					<td>5.5</td>
					<td>4.0</td>
					<td>140</td>
					<td>20</td>
					<td>【商品名称】克咳胶囊(运动员慎用)</td>
					<td><a href="javascript:void(0)" onclick="deleteDrug(${d.id})">删除</a>
						<a href="javascript:void(0)" onclick="updateDrug(1)">修改</a></td>
				</tr> --%>
			</tbody>
		</table>
	</div>
</div>

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="drugModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">添加药品</h4>
			</div>
			<div class="modal-body">
				<form action="" id="drugForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">药品名称</td>
								<td><input type="text" name="name" /> <input type="hidden"
									name="id"></td>
							</tr>
							<tr>
								<td style="width: 80px">请输入条形码</td>
								<td><input type="text" name="barcode"></td>
							</tr>
							<tr>
								<td>药品描述</td>
								<td><input type="text" name="description"></td>
							</tr>
							<tr>
								<td>药剂</td>
								<td><input type="text" name="dosageform"></td>
							</tr>
							<tr>
								<td>规格</td>
								<td><input type="text" name="specifications"></td>
							</tr>
							<tr>
								<td>药品单位</td>
								<td><input type="text" name="unit"></td>
							</tr>
							<tr>
								<td>所属类别</td>
								<td><select name="category.id" id="categorySel">
										<option value="">---请选择---</option>
								</select></td>
							</tr>
							<tr>
								<td>进货价</td>
								<td><input type="text" name="prime_cost"></td>
							</tr>
							<tr>
								<td>出售价</td>
								<td><input type="text" name="price"></td>
							</tr>
							<tr>
								<td>库存量</td>
								<td><input type="text" name="inventory"></td>
							</tr>
							<tr>
								<td>库存下限</td>
								<td><input type="text" name="minimum"></td>
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

<!-- 模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="dModal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">取药</h4>
			</div>
			<div class="modal-body">
				<form action="" id="dForm">
					<table>
						<tbody>
							<tr>
								<td style="width: 80px">药品名称</td>
								<td><input type="text" name="name" /> <input type="hidden"
									name="id"></td>
							</tr>
							<tr>
								<td style="width: 80px">取除数量</td>
								<td><input type="text" name="inventory"></td>
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

