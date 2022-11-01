<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets-admin/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets-admin/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets-admin/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets-admin/css/my-style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/Assets/assets-admin/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller ">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg bg-gd-drak">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                <h3 class="card-title text-left mb-4">Admin login</h3>
                <form action="${pageContext.request.contextPath}/Admin/SignIn" method="post">
                  <div class="form-group">
                    <label>Username or email <code>*</code></label>
                    <input type="text" class="form-control p_input input-focus" name="username">
                  </div>
                  <div class="form-group">
                    <label>Password <code>*</code></label>
                    <input type="password" class="form-control p_input input-focus" name="password">
                  </div>
                  <div class="form-group row">
                    <div class="form-check form-check-success col-md-6">
                      <label class="form-check-label">
                        <input type="checkbox" class="form-check-input " name="remember" value="remember"> Remember me </label>
                    </div>
                    <div class="form-check form-check-success col-md-6 text-right">
                    	<a href="#" class="forgot-pass">Forgot password</a>
                    </div>
                    
                    <div class="text-center">
                    	<code>${sessionScope.errorMessage}</code>
                    </div>
                    
                    <% session.removeAttribute("errorMessage");%>
                    
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn w-100">Login</button>
                  </div>
                  </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/js/off-canvas.js"></script>
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/js/hoverable-collapse.js"></script>
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/js/misc.js"></script>
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/js/settings.js"></script>
    <script src="${pageContext.request.contextPath}/Assets/assets-admin/js/todolist.js"></script>
    <!-- endinject -->
  </body>
</html>