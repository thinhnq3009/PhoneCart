<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Start header in layout folder -->                  
  <!-- navigation -->
<nav class="navbar py-lg-4 py-3 px-0 border-bottom navbar-menu">
  <div class="container-fluid">
    <div class="row w-100 align-items-center g-0 g-lg-3">
      <div class="col-xxl-8 col-lg-7">
        <div class="d-flex align-items-center ml-3">
          <c:if test="${empty sessionScope.userLogin}">
				<button class="navbar-toggler collapsed d-none d-lg-block"
					type="button" data-bs-toggle="offcanvas"
					data-bs-target="#navbar-default" aria-controls="navbar-default">
					<span class="icon-bar top-bar mt-0"></span> <span
						class="icon-bar middle-bar"></span> <span
						class="icon-bar bottom-bar"></span>
				</button>
			</c:if>
          <a class="navbar-brand d-none d-lg-block ms-4" href="${pageContext.request.contextPath}/Home">
            <img src="${pageContext.request.contextPath}/Assets/assets/images/logo/freshcart-logo.svg" alt="eCommerce HTML Template">

          </a>
          <div class="d-flex  w-100 ms-4 ">
            <form action="#" class="w-100 d-none d-lg-block">
              <div class="input-group ">
                <input class="form-control rounded-3" type="search"  id="searchInput" value="Header from layout">
                <span class="input-group-append">
					<button class="btn bg-white border border-start-0 ms-n10"
						type="button">
						<svg xmlns="http://www.w3.org/2000/svg" width="16"
							height="16" viewBox="0 0 24 24" fill="none"
							stroke="currentColor" stroke-width="2"
							stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-search">
	                    	<circle cx="11" cy="11" r="8"></circle>
	                      	<line x1="21" y1="21" x2="16.65" y2="16.65"></line>
	                    </svg>
					</button>
                </span>
            </div>
            </form>
          </div>
        </div>
        <div class="d-flex justify-content-between w-100 d-lg-none align-items-center">
          <button class="navbar-toggler collapsed " type="button" data-bs-toggle="offcanvas"
            data-bs-target="#navbar-default" aria-controls="navbar-default">
            <span class="icon-bar top-bar mt-0"></span>
            <span class="icon-bar middle-bar"></span>
            <span class="icon-bar bottom-bar"></span>
          </button>
          <a class="navbar-brand" href="../index.html">
            <img src="${pageContext.request.contextPath}/Assets/assets/images/logo/freshcart-logo.svg" alt="eCommerce HTML Template">
          </a>
          <div class="d-flex align-items-center lh-1">
            <div class="list-inline me-2">
            <c:choose>
            	<c:when test="${empty sessionScope.userLogin}">
              <div class="list-inline-item">
                <a href="#!" class="text-muted" data-bs-toggle="modal" data-bs-target="#userModal">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                    class="feather feather-user">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                    <circle cx="12" cy="7" r="4"></circle>
                  </svg>
                </a>
               </div>
               <div class="list-inline-item"  >
               	<a href="#!" class="text-muted"  data-bs-toggle="modal" data-bs-target="#userModal">Sign In</a>
               </div>
                </c:when>
               	<c:otherwise>
              <div class="list-inline-item">
                <a class="text-muted position-relative " data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
                  href="#offcanvasExample" role="button" aria-controls="offcanvasRight">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                    class="feather feather-shopping-bag">
                    <path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"></path>
                    <line x1="3" y1="6" x2="21" y2="6"></line>
                    <path d="M16 10a4 4 0 0 1-8 0"></path>
                  </svg>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-success">
                    4
                    <span class="visually-hidden">unread messages</span>
                  </span>
                </a>
              </div>
              </c:otherwise>
            </c:choose>
            </div>
            <!-- Button -->
          </div>
        </div>
      </div>

      <div class="col-xxl-4 col-lg-5 d-flex align-items-center justify-content-end ">
        <!-- Button trigger modal -->
        <div class="list-inline  d-lg-block d-none">
	
		<c:choose>
			<c:when test="${not empty sessionScope.userLogin }">
			<!-- N??t wish list start -->
          <div class="list-inline-item">
            <a href="#" class="text-muted position-relative">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                class="feather feather-heart">
                <path
                  d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z">
                </path>
              </svg>
              <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-success">
                5
                <span class="visually-hidden">unread messages</span>
              </span>
            </a></div>
			<!-- N??t wish list end -->
		   	<!-- N??t gi??? h??ng start -->
      	  <div class="list-inline-item">

            <a class="text-muted position-relative " data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
              href="#offcanvasExample" role="button" aria-controls="offcanvasRight">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                class="feather feather-shopping-bag">
                <path d="M6 2L3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4z"></path>
                <line x1="3" y1="6" x2="21" y2="6"></line>
                <path d="M16 10a4 4 0 0 1-8 0"></path>
              </svg>
              <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-success">
                6
                <span class="visually-hidden">unread messages</span>
              </span>
            </a>
          </div>
			<!-- N??t gi??? h??ng end -->
			
			<!-- Avata -->
			<div class="list-inline-item">
				<div class="d-flex align-items-center justify-content-end ms-5">
					<div class="d-lg-block d-none">${userLogin.accountName}</div>

					<div class="dropdown d-block">
						<a class="nav-link dropdown-toggle avata-user" href="#"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<div class="avata mx-3"
								style="width: 40px; height: 40px; border-radius: 50%; border: 2px solid #198754; position: relative; overflow: hidden;">
								<img
									src="${pageContext.request.contextPath}${userLogin.avata != null ? userLogin.avata : '/Assets/assets/images/png/default_avata.png'}"
									alt="" class=""
									style="object-fit: contain; height: 100%; width: 100%;">

							</div>
						</a>
						<ul class="dropdown-menu" data-bs-popper="static"
							style="right: 0 !important; left: unset;">
							<!-- <li><a class="dropdown-item" href="../index.html"></a></li> -->
							<li><a class="dropdown-item"
								href="../pages/index-2.html">Your account</a></li>
							<li><a class="dropdown-item"
								href="${pageContext.request.contextPath}/Account/Logout">Log out</a></li>

						</ul>
					</div>


				</div>
			</div>
			<!-- End avata -->
			
			</c:when>
			<c:otherwise>
         <!-- N??t ????ng nh???p start-->
          <div class="list-inline-item">

            <a href="#!" class="text-muted a-hover" data-bs-toggle="modal" data-bs-target="#userModal">
              <!-- <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none"
                stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                class="feather feather-user">
                <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
                <circle cx="12" cy="7" r="4"></circle>
              </svg> -->
              Sign In
            </a>
             
          </div>
          
          <div class="list-inline-item">
            <a href="${pageContext.request.contextPath}/Account/SignUp" class="text-muted a-hover" >Sign Up</a>
          </div>
			<!-- N???t ????ng nh???p end -->
			
			</c:otherwise>
		</c:choose>
        </div>
      </div>
    </div>
    <div class="offcanvas offcanvas-start p-4 w-xxl-20 w-lg-30" id="navbar-default">
      <div class="d-flex justify-content-between align-items-center mb-2 ">
        <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/Assets/assets/images/logo/freshcart-logo.svg" alt="eCommerce HTML Template"></a>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>

      <div class="d-block mb-2 pt-2">
        <a class="btn btn-primary w-100 d-flex justify-content-center align-items-center" data-bs-toggle="collapse"
          href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
          <span class="me-2"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24"
              fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"
              class="feather feather-grid">
              <rect x="3" y="3" width="7" height="7"></rect>
              <rect x="14" y="3" width="7" height="7"></rect>
              <rect x="14" y="14" width="7" height="7"></rect>
              <rect x="3" y="14" width="7" height="7"></rect>
            </svg></span> Categories
        </a>
        <div class="collapse mt-2" id="collapseExample">
          <div class="card card-body">
            <ul class="mb-0 list-unstyled">
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Smartphones</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Laptops</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Tablets</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Accessories</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Desktop accessories</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Second hand</a></li>
              <li><a class="dropdown-item" href="../pages/shop-grid.html">Orther</a></li>
            </ul>
          </div>
        </div>
      </div>
      <ul class="navbar-nav navbar-nav-offcanvac">
			<c:choose>
				<c:when test="${empty userLogin }">
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/Account/SignIn"> 
						Sign In 
					</a>
				</li>
	
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/Account/SignUp"> 
						Sign Up 
					</a>
				</li>
				</c:when>
				<c:otherwise>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/Account/SignIn"> 
						Your Account
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/Account/SignIn"> 
						Log out
					</a>
				</li>
				</c:otherwise>
			</c:choose>
		</ul>

    </div>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="userModal" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content p-4">
      <div class="modal-header border-0">
        <h5 class="modal-title fs-3 fw-bold" id="userModalLabel">Sign In</h5>

        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/Account/SignIn" method="post">
					<div class="mb-3">
						<label for="username-signin" class="form-label">Username</label> 
						<input name="username" type="text" class="form-control" id="username-signin" placeholder="Enter your username" required="">
					</div>
					
					<div class="mb-5">
						<label for="password-sign" class="form-label">Password</label> 
						<input name="password" type="password" class="form-control" id="password-sign" placeholder="Enter your password" required=""> 
						<small class="form-text">By Signup, you agree to our 
							<a href="#!">Terms of Service</a> & <a href="#!">Privacy Policy</a>
						</small>
					</div>

					<button type="submit" class="btn btn-primary w-100">Sign In</button>
				</form>
			</div>
			<div class="modal-footer border-0 justify-content-center">
        <div>Don't have an account? <a href="${pageContext.request.contextPath}/Account/SignUp"> Sign Up</a></div>
      </div>
    </div>
  </div>
</div>

<c:if test="${not empty sessionScope.userLogin }" > 

<!-- Your Cart -->
<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
  <div class="offcanvas-header border-bottom">
    <div class="text-start">
      <h5 id="offcanvasRightLabel" class="mb-0 fs-4">Your Cart</h5>
      <small>Location in 382480</small>
    </div>
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">

    <div class="">
      <!-- alert -->
      <c:if test="${not empty errorMessage }"> 
      <div class="alert alert-danger p-2" role="alert">
        ${errorMessage}
      </div>
      </c:if>
       <c:forEach items="${cartItems}" var="item">
      <ul class="list-group list-group-flush">
        <!-- list group -->
        <li class="list-group-item py-3 ps-0">
          <!-- row -->
          <div class="row align-items-center">
            <div class="col-3 col-md-2">
              <!-- img --> 
              <img src="${pageContext.request.contextPath}${item.product.proImage}" alt="Ecommerce"
                class="img-fluid"></div>
            <div class="col-4 col-md-6 col-lg-5">
              <!-- title -->
              <a href="../pages/shop-single.html" class="text-inherit">
                <h6 class="mb-0" > ${item.product.proName } </h6>
              </a>
              <span><small class="text-muted">250g</small></span>
              <!-- text -->
              <div class="mt-2 small lh-1"> <a href="#!" class="text-decoration-none text-inherit"> <span
                    class="me-1 align-text-bottom">
                    <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none"
                      stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                      class="feather feather-trash-2 text-success">
                      <polyline points="3 6 5 6 21 6"></polyline>
                      <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2">
                      </path>
                      <line x1="10" y1="11" x2="10" y2="17"></line>
                      <line x1="14" y1="11" x2="14" y2="17"></line>
                    </svg></span><span class="text-muted">Remove</span></a></div>
            </div>
            <!-- input group -->
            <div class="col-3 col-md-3 col-lg-3">
              <!-- input -->
              <!-- input -->
                  <div class="input-group input-spinner  ">
                    <input type="button" value="-" class="button-minus  btn  btn-sm " data-field="quantity">
                    <input type="number" step="1" max="10" value="1" name="quantity" class="quantity-field form-control-sm form-input   ">
                    <input type="button" value="+" class="button-plus btn btn-sm " data-field="quantity">
                  </div>
            </div>
            <!-- price -->
            <div class="col-2 text-lg-end text-start text-md-end col-md-2">
              <span class="fw-bold text-danger string-money">${item.product.proPrice }</span>
              <div class="text-decoration-line-through text-muted small string-money">${item.product.proPrice + 100000}</div>
            </div>
          </div>
      </ul>
      </c:forEach>
      
      <!-- btn -->
      <div class="d-flex justify-content-between mt-4">
        <a href="#!" class="btn btn-primary">Continue Shopping</a>
        <a href="#!" class="btn btn-dark">Update Cart</a>
      </div>

    </div>
  </div>
</div>

</c:if>
<!-- End header in layout folder -->

 