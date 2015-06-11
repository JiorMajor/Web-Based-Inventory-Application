<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Usage Detail</title>
</head>
<body>
	<div class="container main">
		<div class="row">		
			<center><h1>Enter Usage Detail</h1></center>
			<form action="">
			
				<div class="form-group row">
						
					<div class="col-lg-4">
					</div>
					<div class="col-lg-2">
					<label>Customer:</label> 
							   <select class="selectpicker form-control" style="clear:both;">
							    <option>Mustard</option>
							    <option>Ketchup</option>
							    <option>Relish</option>
							  </select>						
					</div>
					
					<div class="col-lg-2">
						<label>Vehicle No:</label> 
							   <select class="selectpicker form-control" style="clear:both;">
							    <option>Mustard</option>
							    <option>Ketchup</option>
							    <option>Relish</option>
							  </select>				 
											  					
					</div>
				</div>				
			</form>
		</div>
		<hr>
		
		<div class="row">
			<div class="col-lg-3">
				<label>Part No</label>
				<select class="selectpicker form-control" style="clear:both;">
				<option>Mustard</option>
				<option>Ketchup</option>
				<option>Relish</option>
				</select>	
			</div>
			
			<div class="col-lg-3">
				<label>Color</label>
				<select class="selectpicker form-control" style="clear:both;">
				<option>Mustard</option>
				<option>Ketchup</option>
				<option>Relish</option>
				</select>	
			</div>
			
			<div class="col-lg-3">
				<label>Dimension</label>
				<select class="selectpicker form-control" style="clear:both;">
				<option>Mustard</option>
				<option>Ketchup</option>
				<option>Relish</option>
				</select>	
			</div>
			
			<div class="col-lg-3">
				<label>Qty</label>			
				<input type="number"  class="form-control" style="width:100%;"/>
			</div>
			
		</div>
		
		<div class="row">	
			<div class="col-lg-12">
				 <input type="Submit" class="btn btn-primary button" value="Save" />	
			 <input type="Submit" class="btn btn-primary button" value="Add New" style="margin-right:20px;" />
			</div>
			
		</div>
	</div>

</body>
</html>