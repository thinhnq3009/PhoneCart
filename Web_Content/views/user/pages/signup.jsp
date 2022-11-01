<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>

  <title>FreshCart - eCommerce HTML Template</title>
  <!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="FreshCart is a beautiful eCommerce HTML template specially designed for multipurpose shops & online stores selling products. Most Loved by Developers to build a store website easily.">
<meta content="Codescandy" name="author" />


<!-- Favicon icon-->
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/Assets/assets/images/favicon/favicon.ico">



<!-- Libs CSS -->
<link href="${pageContext.request.contextPath}/Assets/assets/libs/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/feather-webfont/dist/feather-icons.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/slick-carousel/slick/slick.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/slick-carousel/slick/slick-theme.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/simplebar/dist/simplebar.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/nouislider/dist/nouislider.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Assets/assets/libs/tiny-slider/dist/tiny-slider.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/Assets/assets/libs/dropzone/dist/min/dropzone.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/Assets/assets/libs/prismjs/themes/prism-okaidia.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets/css/theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/assets/css/sign-up.css">
</head>

<body>

	<jsp:include page="/views/layout/user/header.jsp"/>
 
  <main>
  <!-- section -->
  
  <section class="my-lg-14 my-8">
    <!-- container -->
    <div class="container">
      <!-- row -->
      <div class="row justify-content-center align-items-center">
        <div class="col-12 col-md-6 col-lg-4 order-lg-1 order-2">
          <!-- img -->
          <img src="${pageContext.request.contextPath}/Assets/assets/images/svg-graphics/signup-g.svg" alt="" class="img-fluid">
        </div>
        <!-- col -->
        <div class="col-12 col-md-6 offset-lg-1 col-lg-4 order-lg-2 order-1">
          <div class="mb-lg-9 mb-5">
            <h1 class="mb-1 h2 fw-bold">Register</h1>
            <p>Welcome to PhoneCart !  Please register to continue.</p>
          </div>
          <!-- form -->
          <form method="post" action="${pageContext.request.contextPath}/Account/SignUp" id="form-signup">
            <div class="row g-3">
        	    <!-- col -->
              <div class="col-12">
                <!-- input --><input type="text" class="form-control" placeholder="Username" aria-label="Username" name="username" id="username"
                  required>
              </div>
              <!-- col -->
              <div class="col-12">
                <!-- input --><input type="text" class="form-control" placeholder="Your name" aria-label="Your name" name="accountName"
                  required>
              </div>
              <div class="col-12">

                <!-- input --><input type="email" class="form-control" id="email" placeholder="Email" required name="email">
              </div>
               <div class="col-12">

                <!-- input --><input type="number" class="form-control" id="phone-number" placeholder="Phone number" name="phoneNumber" max="9999999999" required>
              </div>
              <div class="col-12">

                <!-- input --><input type="password" class="form-control" id="inputPassword4" placeholder="Password" name="password"
                  required>
              </div>
              <!-- btn -->
              <div class="col-12 d-grid"> <button type="submit" class="btn btn-primary" id="btn-submit" >Register</button>
              </div>

              <!-- text -->
              <p><small>By continuing, you agree to our <a href="#!"> Terms of Service</a> & <a href="#!">Privacy
                    Policy</a></small></p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
  </main>


	<jsp:include page="/views/layout/user/footer.jsp"/>



  <!-- Javascript-->
  <!-- Libs JS -->
<script src="${pageContext.request.contextPath}/Assets/assets/libs/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/jquery-countdown/dist/jquery.countdown.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/slick-carousel/slick/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/simplebar/dist/simplebar.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/nouislider/dist/nouislider.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/wnumb/wNumb.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/rater-js/index.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/prismjs/prism.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/prismjs/components/prism-scss.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/prismjs/plugins/toolbar/prism-toolbar.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/prismjs/plugins/copy-to-clipboard/prism-copy-to-clipboard.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/tiny-slider/dist/min/tiny-slider.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/dropzone/dist/min/dropzone.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/flatpickr/dist/flatpickr.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/libs/inputmask/dist/jquery.inputmask.min.js"></script>
<!-- Theme JS -->
<script src="${pageContext.request.contextPath}/Assets/assets/js/theme.min.js"></script>
<script src="${pageContext.request.contextPath}/Assets/assets/js/custom/ValidateData.js"></script>
  <!-- choose one -->



</body>

</html>