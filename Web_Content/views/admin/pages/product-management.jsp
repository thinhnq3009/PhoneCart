<%@page import="eco.phonecart.app.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets-admin/css/custom/product-management.css">
<div class="form">
	<form action="">
		<div class="row">
			<div class="col-md-3 col-9 pl-0 mb-3">
				<!-- <div class="input-group"> -->
				<input type="text" class="form-control input-focus"
					placeholder="Find product ..." aria-label="Find product ..."
					aria-describedby="basic-addon2">
				<!-- </div> -->
			</div>
			<div class="col-md-1 col-3 mb-3 p-0">
				<button class="btn btn-light w-100">Find</button>
			</div>

			<div class="col-md-6 mb-3"></div>

			<div class="col-md-2 col-xs-6 mb-3 position-relative">
				<button class="btn btn-success w-100" type="button"
					data-toggle="modal" data-target="#addProduct">
					<i class="mdi mdi-library-plus"></i> Add product
				</button>
			</div>
		</div>
		<!-- Table begin -->

		<div class="col-lg-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Products Management</h4>
					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Amount</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listProduct}" var="item">
									<!-- Start one row -->
									<tr>
										<td>
											<button class="btn btn-primary" type="button"
												data-toggle="collapse" data-target="#id_${item.idProduct}"
												aria-expanded="false" aria-controls="collapseExample">
												${item.idProduct}</button>
										</td>
										<td>${item.proName}</td>
										<td>
											<div class="progress">
												<div class="progress-bar bg-success" role="progressbar"
													style="width: ${(item.proQuantity - item.proSold)*100/item.proQuantity}%"
													aria-valuemin="0" aria-valuemax="100"></div>
											</div>
										</td>
										<td class="string-money">${item.proPrice}</td>
										<td>
											<button class="btn btn-warning updateProduct"
												idPro="${item.idProduct}" type="button" data-toggle="modal"
												data-target="#updatePro">
												<i class="mdi mdi-lead-pencil"></i>
											</button>
											<button class="btn btn-danger deleteProduct"
												idPro="${item.idProduct}" type="button" data-toggle="modal"
												data-target="#deletePro">
												<i class="mdi mdi-delete-forever"></i>
											</button>
										</td>
									</tr>

									<tr>
										<td colspan="5" class="row-hidden">
											<div class="collapse " id="id_${item.idProduct}">
												<div class="card card-body" style="display: block;">
													<div class="row">
														<div class="col-2 product-image">
															<img
																src="${pageContext.request.contextPath}${item.proImage}"
																alt="">
														</div>
														<div class="col-9">
															<div class="row">
																<div class="col-6">
																	<p>Name:</p>
																	<p>Category:</p>
																	<p>Company:</p>
																	<p>Color:</p>
																	<p>RAM/ROM:</p>
																	<p>Quantity:</p>
																	<p>Operating system:</p>
																</div>
																<div class="col-6">
																	<p>${item.proName}</p>
																	<p>${item.category.nameCategory}</p>
																	<p>${item.company.comName }</p>
																	<p>White</p>
																	<p>16GB/512GB</p>
																	<p>${(item.proQuantity - item.proSold) }/${item.proQuantity}
																		(Sold ${item.proSold})</p>
																	<p>IOS</p>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</td>
									</tr>
									<!-- End one row -->
								</c:forEach>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Table end -->
	</form>
</div>


<!-- Modal -->
<div class="modal fade" id="updatePro" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-container" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="col-12 grid-margin">
					<div class="card">
						<div class="card-body">
							<h2 class="card-title">Update product</h2>
							<form class="form-sample" id="update-product"
								action="${pageContext.request.contextPath}/Product/Update"
								method="post" enctype="multipart/form-data">
								<!-- <p class="card-description"> Personal info </p> -->
								<input type="text" name="idProduct" class="d-none" />
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Name product</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="proName">
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Category</label>
											<div class="col-sm-9">
												<select class="form-control" name="category" id="">
													<c:forEach items="${listCategory}" var="item">
														<option value="${item.idCategory }">${item.nameCategory}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Company</label>
											<div class="col-sm-9">
												<select class="form-control" name="company">
													<c:forEach items="${listCompany}" var="com">
														<option value="${com.idCompany }">${com.comName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Color</label>
											<div class="col-sm-9">
												<select class="form-control" name="color" id="">
													<option value="Red">Red</option>
													<option value="Blue">Blue</option>
													<option value="Black">Black</option>
													<option value="White">White</option>
													<option value="Gold">Gold</option>
													<option value="Green">Green</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">RAM</label>
											<div class="col-sm-9">
												<select class="form-control" name="RAM">
													<option value="8GB">2GB</option>
													<option value="8GB">4GB</option>
													<option value="8GB">8GB</option>
													<option value="16GB">16GB</option>
													<option value="32GB">32GB</option>
													<option value="64GB">64GB</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">ROM</label>
											<div class="col-sm-9">
												<select class="form-control" name="ROM" id="">
													<option value="8GB">8GB</option>
													<option value="16GB">16GB</option>
													<option value="32GB">32GB</option>
													<option value="64GB">64GB</option>
													<option value="128GB">128GB</option>
													<option value="256GB">256GB</option>
													<option value="512GB">512GB</option>
													<option value="1TB">1TB</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Quantity</label>
											<div class="col-sm-9">
												<input class="form-control" name="proQuantity" type="number"
													min="1" step="1">
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Price</label>
											<div class="col-sm-9">
												<input class="form-control" name="proPrice" type="number"
													min="1000" step="1000">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-3">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Image</label>
											<div class="col-sm-9">
												<input name="proImage" type="file" class="form-control"
													id="proImage" divShow="#image_update"
													accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*">
											</div>
										</div>

										<div class="row product-image">
											<div class="col-sm-3"></div>
											<div class="col-sm-9 product-image">
												<img class="pro" id="image_update" src="" alt="">
											</div>
										</div>

									</div>
									<div class="col-md-6 mb-3">
										<div class="form-group row textarea-control">
											<label class="col-sm-3 col-form-label">Description</label>
											<div class="col-sm-9">
												<textarea class="form-control" name="proDescrible" id=""
													cols="30" rows="10"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-9 col-sm-6 col-0"></div>
									<div class="col-md-3 col-sm-6 col-12">
										<div class="form-group row">
											<div class="col-md-4">
												<button type="button" data-toggle="modal"
													data-target="#updatePro" class="btn btn-danger w-100 mb-3">Close</button>
											</div>
											<div class="col-md-4">
												<button type="button" class="btn btn-warning w-100 mb-3"
													id="clear-form">Clear</button>
											</div>
											<div class="col-md-4">
												<button class="btn btn-success w-100 mb-3">Save</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade" id="deletePro" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-container" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="col-12 grid-margin">
					<div class="card">
						<div class="card-body">
							<h2 class="card-title">Do you want delete <span class="title_delete">this product</span></h2>
							<div class="card card-body">
								<div class="row mb-3">
									<div class="col-md-6 col-12 product-image mb-3">
										<img id="image_delete"
											src="/PhoneCartShop/ProductImage/679e868d2968ed36b479.jpg"
											alt="">
									</div>
									<div class="col-md-6 col-12">
										<div class="row mb-3">
											<div class="col-12 row">
												<div class="col-6">
													<p>Name:</p>
												</div>
												<div class="col-6">
													<p class="proName"></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Price:</p>
												</div>
												<div class="col-6">
													<p class="proPrice"></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Category:</p>
												</div>
												<div class="col-6">
													<p class="category"></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Company:</p>
												</div>
												<div class="col-6">
													<p class="company"></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Color:</p>
												</div>
												<div class="col-6">
													<p class=""></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>RAM/ROM:</p>
												</div>
												<div class="col-6">
													<p class=""></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Quantity:</p>
												</div>
												<div class="col-6">
													<p class="proQuantity"></p>
												</div>
											</div>
											<div class="col-12 row">
												<div class="col-6">
													<p>Operating system:</p>
												</div>
												<div class="col-6">
													<p class=""></p>
												</div>
											</div>
										</div>
								</div>

								<div class="row">
									<div class="col-md-8"></div>
									<div class="col-md-2  col-6">
										<button type="button" data-toggle="modal"
										data-target="#deletePro" class="btn btn-danger w-100">Cancel</button>
									</div>
									<div class="col-md-2  col-6">
										<form method="post" action="${pageContext.request.contextPath}/Product/Delete">
											<input type="hidden" name="id" id="idPro_delete"/>
											<button class="btn w-100 btn-success">Ok</button>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>


<!-- Modal insert new product -->
<div class="modal fade" id="addProduct" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLongTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-container" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="col-12 grid-margin">
					<div class="card">
						<div class="card-body">
							<h2 class="card-title">Create new product</h2>
							<form class="form-sample" id="create-product"
								action="${pageContext.request.contextPath}/Product/Add"
								method="post" enctype="multipart/form-data">
								<!-- <p class="card-description"> Personal info </p> -->
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Name product</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="proName">
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Category</label>
											<div class="col-sm-9">
												<select class="form-control" name="category" id="">
													<c:forEach items="${listCategory}" var="item">
														<option value="${item.idCategory }">${item.nameCategory}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Company</label>
											<div class="col-sm-9">
												<select class="form-control" name="company">
													<c:forEach items="${listCompany}" var="com">
														<option value="${com.idCompany }">${com.comName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Color</label>
											<div class="col-sm-9">
												<select class="form-control" name="color" id="">
													<option value="Red">Red</option>
													<option value="Blue">Blue</option>
													<option value="Black">Black</option>
													<option value="White">White</option>
													<option value="Gold">Gold</option>
													<option value="Green">Green</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">RAM</label>
											<div class="col-sm-9">
												<select class="form-control" name="RAM">
													<option value="8GB">2GB</option>
													<option value="8GB">4GB</option>
													<option value="8GB">8GB</option>
													<option value="16GB">16GB</option>
													<option value="32GB">32GB</option>
													<option value="64GB">64GB</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">ROM</label>
											<div class="col-sm-9">
												<select class="form-control" name="ROM" id="">
													<option value="8GB">8GB</option>
													<option value="16GB">16GB</option>
													<option value="32GB">32GB</option>
													<option value="64GB">64GB</option>
													<option value="128GB">128GB</option>
													<option value="256GB">256GB</option>
													<option value="512GB">512GB</option>
													<option value="1TB">1TB</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Quantity</label>
											<div class="col-sm-9">
												<input class="form-control" name="proQuantity" type="number"
													min="1" step="1">
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Price</label>
											<div class="col-sm-9">
												<input class="form-control" name="proPrice" type="number"
													min="1000" step="1">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-3">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label">Image</label>
											<div class="col-sm-9">
												<input name="proImage" type="file" class="form-control"
													id="proImage" divShow="#image_create"
													accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|image/*">
											</div>
										</div>

										<div class="row product-image">
											<div class="col-sm-3"></div>
											<div class="col-sm-9 product-image">
												<img class="pro" id="image_create" src="" alt="">
											</div>
										</div>

									</div>
									<div class="col-md-6 mb-3">
										<div class="form-group row textarea-control">
											<label class="col-sm-3 col-form-label">Description</label>
											<div class="col-sm-9">
												<textarea class="form-control" name="proDescrible" id=""
													cols="30" rows="10"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-9 col-sm-6 col-0"></div>
									<div class="col-md-3 col-sm-6 col-12">
										<div class="form-group row">
											<div class="col-md-4">
												<button type="button" data-toggle="modal"
													data-target="#addProduct" class="btn btn-danger w-100 mb-3">Close</button>
											</div>
											<div class="col-md-4">
												<button type="button" class="btn btn-warning w-100 mb-3"
													id="clear-form">Clear</button>
											</div>
											<div class="col-md-4">
												<button class="btn btn-success w-100 mb-3">Save</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%-- JavaScript --%>

<script>
	
</script>

<script
	src="${pageContext.request.contextPath}/Assets/assets-admin/js/custom/product-management.js"></script>
<%-- JavaScript --%>