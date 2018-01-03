<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% 

//codice di prova (DA CANCELLARE)

//TutorAccademico ta1 = (TutorAccademico) request.getSession().getAttribute("tutoraccademico");

TutorAccademico ta = new TutorAccademico("email", "codicefiscale", "nome", "cognome",
				"luogodinascita", "01/02/02", "password", "m", "residenza", "via", 
				"telefono", "dipartimento", "coddocente");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tirocinio Smart</title>

<meta name="author" content="Sebastiano Caruso">

<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap  -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/stylesheets/style.css">

<!-- Responsive -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/stylesheets/responsive.css">

<!-- REVOLUTION LAYERS STYLES -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/revolution/css/settings.css">

<!-- Favicon and touch icons  -->
<link href="../images/icon/icon.png" rel="shortcut icon">
</head>
<style>
	label{
		float: left;
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
	<%@ include file="header_tutor_accademico.jsp"%>


	<!-- FORM REGISTRAZIONE -->
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<div class="col-md-5" style="float: none; margin: 0 auto;">
				<!-- Compilare i campi della form -->
				<form action="./InserisciTirocinio" method="POST" id="form-register"
					class="form-register">
					<div class="form-register-title">
						<h3 class="register-title">
							Aggiungi un Tirocinio <br>
						</h3>
					</div>
					<div class="info-register">
						<p class="wrap-input-name">
							<label for="nam">Nome </label><input type="text" id="nam" name="nome" value="" maxlength="40" min="3"
								required="required" placeholder="">
						</p>
						<br>
						<p class="wrap-input-name">
							<label for="obi">Obiettivi </label> <input type="text" id="obi" name="Obiettivi" value=""
								required="required" placeholder="" maxlength="2000" min="5">
						</p>
						<p class="wrap-input-name">
							<label for="des">Descrizione </label> <input type="text" id="des" name="Descrizione" value=""
								required="required" placeholder=" " maxlength="2000" min="5">
						</p>
						<p class="wrap-input-name">
							<label for="num">Numero Posti</label> <input type="text" id="num" name="Numero Posti" value="" required="required" placeholder="0">
							</p>
						</div>
						<div class="div_my_wrap-input-name" style="display: grid">
						</div>
						<div class="wrap-btn" style="display: grid;">
							<input type="submit" name="dati" value="Invia" id="submitRegistration" style="display: none"> 
							<label for="submitRegistration"	class="flat-btn" style="margin: 0 auto 5% auto">INVIA</label> 
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
		src="../bootstrap/javascript/jquery.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="../bootstrap/javascript/main.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/countdown.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/imagesloaded.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/jquery.isotope.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/owl.carousel.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/jquery.easing.js"></script>
	<script type="text/javascript"
		src="../bootstrap/javascript/jquery.flexslider.js"></script>

	<!-- Revolution Slider -->
	<script type="text/javascript"
		src="../bootstrap/revolution/js/jquery.themepunch.tools.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/slider.js"></script>

	<!-- SLIDER REVOLUTION 5.0 EXTENSIONS  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.migration.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script type="text/javascript"
		src="../bootstrap/revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>

</html>