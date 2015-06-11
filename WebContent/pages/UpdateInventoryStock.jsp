<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory Stock</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<div class="col-md-11 col-sm-8 col-xs-8">
				<center>
					<h1>Maintain Inventory Stock</h1>
				</center>
				<button type="button" class="btn btn-primary pull-right"
					data-toggle="modal" data-target="#myModal">Advanced Search</button>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="gridsystemModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="gridsystemModalLabel">Advanced
									Search</h4>
							</div>
							<div class="modal-body">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-4">
												<input type="text" class="form-control" placeholder="Name"
													name="name" />
											</div>
											<div class="col-md-4">
												<input type="text" class="form-control"
													placeholder="Manufacturer" name="manu" />
											</div>
											<div class="col-md-4">
												<input type="number" class="form-control" placeholder="333$"
													name="price" />
											</div>
										</div>
									</div>
									<hr />
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-4">
												<input type="text" class="form-control"
													placeholder="Re-Order Level" name="rorder" />
											</div>
											<div class="col-md-4">
												<input type="text" class="form-control"
													placeholder="Shelf Location" name="shelf" />
											</div>
											<div class="col-md-4">
												<input type="text" class="form-control" placeholder="color"
													name="color" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Search</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<div class="row">
		<br> <br>
		<div class="col-md-4"></div>
		<div class="col-md-4">
		<c:if test="${success==\"true\"}">
			<h5 class="alert alert-success" style="text-align:center;">
				<span class="glyphicon glyphicon-ok" style="margin-right: 10px;"></span>Product data is successfully updated!
				</h5>
		</c:if>
		<c:if test="${success==\"false\"}">
			<h5 class="alert alert-danger" style="text-align:center;">Product cannot be updated!</h5>
		</c:if>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-2">

			<c:forEach var="category" items="${catlist}">
				<a
					href="/InventoryWebSA40Team6/categoryfilter?categoryname=${category}"
					onclick="$(this).closest('form').submit()" id="categoryname"
					class="list-group-item" style="text-align: center;">${category}</a>
			</c:forEach>

		</div>
		<div class="col-md-8">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>PartNo.</th>
							<th>PartName</th>
							<th>Reorder Level</th>
							<th>Min Reorder Quantity</th>
							<th>Total Quantity</th>
							<th>Available Quantity</th>
							<th>Damaged Quantity</th>
							<th>Save</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="pslist" items="${productlist}" varStatus="count">
							<tr>
							<form action="/InventoryWebSA40Team6/udinventory" method="post" name="form-${count.index}">
								<td style="text-align: center;">${count.index+1}</td>
								<td style="text-align: center;">${pslist.partNo}</td>
								<td style="text-align: center;">${pslist.partName}</td>
								<td style="text-align: center;">${pslist.reorderlvl}</td>
								<td style="text-align: center;">${pslist.minOrderQty}</td>
								<td style="text-align: center;">
								<input type="number" id="total" class="form-control" name="total" value="${pslist.totalQty}" />
								</td>
								<td style="text-align: center;">${pslist.totalQty-pslist.damagedQty}</td>
								<td style="text-align: center;">
								<input type="number" class="form-control" id="damaged" value="${pslist.damagedQty}" name="damaged"/>
								</td>
								<input type="hidden" name="available" value="${pslist.availableQty}"/>
								<input type="hidden" name="partNo"  value="${pslist.partNo}"/>
								<td style="text-align: center;">
<%-- 								<c:url var="udurl"
										scope="page" value="/udinventory">
										<c:param name="partNo" value="${pslist.partNo}"/>
										<c:param name="available" value="${pslist.availableQty}"></c:param>
										<c:param name="total" value="${param.totalqty}"></c:param>
										<c:param name="damaged" value="${param.damagedqty}"></c:param>
									</c:url> 
									<a href=${udurl}><span
										class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span></a> --%>
									
									<input type="submit" class="btn btn-primary" value="Update" />

								</td>
								</form>
							</tr>
							
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<div class="row">
		<div class="col-md-11">
			<nav class="pull-right">
			<ul class="pagination pull-right">
				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
			</ul>
			</nav>
		</div>
		<div class="col-md-1"></div>
	</div>
	</div>
</body>
</html>