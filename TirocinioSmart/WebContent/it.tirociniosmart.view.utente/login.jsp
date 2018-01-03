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
<link href="${pageContext.request.contextPath}/images/icon/icon.png"
	rel="shortcut icon">
</head>

<style type="text/css">
.div_Radio_Register {
	margin-top: 10%;
}

@media only screen and (max-device-width : 700px) {
	.div_Radio_Register {
		display: grid;
	}
	.div_Radio_Register p{
        padding: 10px;
    }
}
</style>

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<!-- HEADER -->
	<%@ include file="header.jsp"%>

	<!-- LOGIN -->
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<div class="col-md-5"
				style="float: none; margin: 0 auto; text-align: center; width: 80%;">
				<!-- Compilare i campi della form -->
				<form action="./Login" method="post" id="form-login"
					class="form-register">
					<!-- HO CAMBIATO L'ID DELLA FORM -->
					<div class="form-register-title">
						<h3 class="register-title">LOGIN</h3>
					</div>

					<!-- RADIO BUTTON Login Studente TutorAccademico Didattica-->
					<div class="div_Radio_Register">
						<p class="my_wrap-input-name">
							<input type="radio" id="Studente" name="tipo" value="studente"
								required="required" checked="checked"> <label
								for="Studente">Studente</label>
						</p>
						<p class="my_wrap-input-name">
							<input type="radio" id="TA" name="tipo" value="tutorAccademico"
								required="required"> <label for="TA">TutorAccademico</label>
						</p>
						<p class="my_wrap-input-name">
							<input type="radio" id="Didattica" name="tipo" value="didattica"
								required="required"> <label for="Didattica">Didattica</label>
						</p>
					</div>

					<div class="info-register">
						<p class="wrap-input-email">
							<input type="email" id="email" name="email" required="required"
								placeholder="esempio@studenti.unisa.it *:" autofocus>
						</p>
						<p class="wrap-input-phone">
							<input type="password" id="phone" name="password"
								required="required" placeholder="Password *:">
						</p>
						<div class="wrap-btn">
							<input type="submit" name="dati" value="Invia" id="submitLogin"
								style="display: none"> <label for="submitLogin"
								class="flat-btn" style="margin: 0 auto">ACCEDI</label>
						</div>
						<div class="my_login_a">
							<a href="registrazione.jsp" class="linklogin">Non sei ancora
								registrato?</a> <a href="recupero_credenziali.jsp" class="linklogin"
								style="display: none;">Password Dimenticata?</a>
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