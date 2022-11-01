<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


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
          <img src="${pageContext.request.contextPath}/Assets/assets/images/svg-graphics/fp-g.svg" alt="" class="img-fluid">
        </div>
        <div class="col-12 col-md-6 offset-lg-1 col-lg-4 order-lg-2 order-1 d-flex align-items-center">
          <div>
            <div class="mb-lg-9 mb-5">
              <!-- heading -->
              <h1 class="mb-2 h2 fw-bold">Forgot your password?</h1>
              <p>Please enter the email address associated with your account and We will email you a link to reset your
                password.</p>
            </div>
            <!-- form -->
            <form method="post" action="${pageContext.request.contextPath}/Account/reset-password">
              <!-- row -->
              <div class="row g-3">
               <!-- col -->
                <div class="col-12">
                  <!-- input -->
                  <input type="text" name="username" class="form-control" id="username" placeholder="Username" required>
                </div>

					<!-- Error Message -->
					<c:if test ='${ not empty sessionScope.errorMessage }'>
        			 <div class="alert alert-danger text-center">
        			 	${sessionScope.errorMessage}
        			 </div>
        			 <%session.removeAttribute("errorMessage");%>
      				</c:if> 

										<!-- Success Message -->
					<c:if test ='${ not empty sessionScope.successMessage }'>
        			 <div class="alert alert-success text-center">
        			 	${sessionScope.successMessage}
        			 </div>
        			 <%session.removeAttribute("successMessage");%>
      				</c:if> 

<!-- btn -->
                <div class="col-12 d-grid gap-2"> <button type="submit" class="btn btn-primary" id="submit">Reset Password</button>
                  <a href="signup.html" class="btn btn-light">Back</a>
                </div>


              </div>
            </form>
          </div>
        </div>
      </div>
    </div>


  </section>
</main>


<jsp:include page="/views/layout/user/footer.jsp"/>



   <!-- Footer -->
 
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
  <!-- choose one -->

	<script>
		$('#submit').click(function() {
			if (!$('#username').val()) return
			$('#username').addClass('loading');
		});
	</script>

</body>

</html>