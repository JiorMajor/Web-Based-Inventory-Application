<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Enquiry Transaction History</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-11 col-sm-8 col-xs-8">
			<h4 class="lead">Enquiry Transaction History</h4>
				<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal">Advanced Search</button>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="gridsystemModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="gridsystemModalLabel">Advanced Search</h4>
							</div>
							<div class="modal-body">
								<div class="container-fluid">
									<div class="row">
									<div class="col-md-12">
									<div class="col-md-4"><input type="text" class="form-control" placeholder="Name" name="name"/></div>
									<div class="col-md-4"><input type="text" class="form-control" placeholder="Manufacturer" name="manu"/></div>
									<div class="col-md-4"><input type="number" class="form-control" placeholder="333$" name="price"/></div>
									</div>
									</div>
									<hr />
									<div class="row">
									<div class="col-md-12">
									<div class="col-md-4"><input type="text" class="form-control" placeholder="Re-Order Level" name="rorder"/></div>
									<div class="col-md-4"><input type="text" class="form-control" placeholder="Shelf Location" name="shelf"/></div>
									<div class="col-md-4"><input type="text" class="form-control" placeholder="color" name="color"/></div>
									</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Search</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<div class="row"><br><br></div>
	<div class="row">
		<div class="col-md-1">
		</div>
		<div class="col-md-10">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>Customer ID</th>
							<th>Customer Name</th>
							<th>Vehicle ID</th>
							<th>Used Parts Qty</th>
							<th>Issued Date</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>12</td>
							<td>Suria</td>
							<td>SG2213</td>
							<td>23</td>
							<td>10-Jun-2015</td>
						</tr>
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
					<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				</ul>
			</nav>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>
</body>
</html>