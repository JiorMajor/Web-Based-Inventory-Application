<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
</head>
<body>
	<div class="container main">
		<div class="row">
			<center><h1>Add New Product</h1></center>
			
			<div class="col-md-8 col-md-push-4 ">
				<form action="/InventoryWebSA40Team6/AddPrdServlet" method="post">
								
				<c:if test="${origin==\"true\"}">
					<h4 class="success"><span class="glyphicon glyphicon-ok" style="margin-right:10px;"></span>Product data is successfully saved!</h3>
				</c:if>
				<c:if test="${origin==\"false\"}">
					<h3 style="color:red">Student data cannot be saved!</h3>
				</c:if>
				<div class="form-group row">
					<div class="col-md-3">
					<label>Part Name:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="partname" required value=""/>
					</div>				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Unit Price:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="price" required value=""/>
					</div>				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Description:</label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="des"  value=""/>
					</div>				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Color:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="color" required value="" />
					</div>				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Dimension:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="dim" required value="" />
					</div>
				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Category:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					
					 <select class="selectpicker form-control" required style="clear:both;" name="cat">
					 	<c:forEach var="category" items="${catlist}">
					 		<option value="${category}">${category}</option>							
						</c:forEach>						    	
					</select>	
					</div>				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Manufacture Name:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<select class="selectpicker form-control" required style="clear:both;" name="man">					
					 	<c:forEach var="manufacturername" items="${mlist}">					 	
					 		<option value="${manufacturername}">${manufacturername}</option>							
						</c:forEach>										    	
					</select>	
					</div>
				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Reorder Level:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<select class="selectpicker form-control" required style="clear:both;" name="reorder">
					 	<option value="1">1</option>
					 	<option value="2">2</option>
					 	<option value="3">3</option>
					</select>	
					</div>
				
				</div>
						
				<div class="form-group row">
					<div class="col-md-3">
					<label>Total Qty:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="total" required value=""/>
					</div>
				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Min Reorder Qty:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<input type="text" class="form-control" name="reqty" required value=""/>
					</div>
				
				</div>
				
				<div class="form-group row">
					<div class="col-md-3">
					<label>Shelf Location:<span style="color:red; font-weight:bold;font-size:18px;">*</span></label>
					</div>	
					
					<div class="col-md-4">
					<select class="selectpicker form-control" required style="clear:both;" name="loc">
					 	<c:forEach var="shelflocation" items="${slocation}">
					 		<option value="${shelflocation}">${shelflocation}</option>							
						</c:forEach>										    	
					</select>	
					</div>
				
				</div>
				<input type="submit" class="btn btn-primary" value="Add">
				<input type="reset" class="btn btn-primary" value="Reset">
				
				</form>	
				
			</div>
		</div>
	</div>

</body>
</html>