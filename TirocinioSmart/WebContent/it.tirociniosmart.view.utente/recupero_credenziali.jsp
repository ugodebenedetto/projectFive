<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tirocinio Smart</title>

<meta name="author" content="Claudio Amato">

<!-- Mobile Specific Metas -->
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap  -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/bootstrap/stylesheets/style.css">

<!-- Responsive -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/bootstrap/stylesheets/responsive.css">

<!-- REVOLUTION LAYERS STYLES -->
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/bootstrap/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/bootstrap/revolution/css/settings.css">

<!-- Favicon and touch icons  -->
<link href="${pageContext.request.contextPath}/images/icon/icon.png" rel="shortcut icon">
</head>

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

    <!-- HEADER -->
	<%@ include file="header.jsp"%>

	<!-- RECUPERO CREDENZIALI FORM -->
    <section class="flat-row pd-80 flat-register">
    <div class="container">
        <div class="row">
            <div class="col-md-5" style="float: none; margin: 0 auto;">
                <!-- Compilare i campi della form -->
                <form action="" method="POST" id="form-register"
                    class="form-register">
                    <div class="form-register-title">
                        <h3 class="register-title">RECUPERO CREDENZIALI</h3>
                    </div>
                    <div class="info-register">
                        <p class="wrap-input-email">
                            <input type="email" id="email" name="email" value="" maxlength="20" min="3"
                                required="required" placeholder="esempio@studenti.unisa.it *:">
                        </p>
                        <div class="wrap-btn">
                            <input type="submit" name="dati" value="Invia" id="submitCredenziali" style="display: none"> 
                            <label for="submitCredenziali" class="flat-btn" style="margin: 0 auto">INVIA</label>      
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </section>

	<!-- FOOTER -->
    <%@ include file="../footer_folder/footer.jsp"%>

    <!-- Javascript -->
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/bootstrap.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/main.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/countdown.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/imagesloaded.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.isotope.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/owl.carousel.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.easing.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.flexslider.js"></script>

    <!-- Revolution Slider -->
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/jquery.themepunch.tools.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/jquery.themepunch.revolution.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/slider.js"></script>

    <!-- SLIDER REVOLUTION 5.0 EXTENSIONS  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.actions.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.migration.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>

</html>