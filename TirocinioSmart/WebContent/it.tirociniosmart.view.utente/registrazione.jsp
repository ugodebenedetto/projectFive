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
	href="../bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
	href="../bootstrap/stylesheets/style.css">

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

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<!-- HEADER -->
	<%@ include file="header.jsp"%>

	<!-- RADIO BUTTON REGISTRAZIONE Studente o TutorAccademico -->
	<div class="div_Radio_Register">
		<p class="my_wrap-input-name">
			<input type="radio" id="Studente" name="attore" value="Studente"
				required="required" checked="checked"> <label for="Studente">Studente</label>
		</p>
		<p class="my_wrap-input-name">
			<input type="radio" id="TA" name="attore" value="TutorAccademico"
				required="required"> <label for="TA">TutorAccademico</label>
		</p>
	</div>


	<!-- FORM REGISTRAZIONE -->
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<div class="col-md-5" style="float: none; margin: 0 auto;">
				<!-- Compilare i campi della form -->
				<form action="" method="POST" id="form-register"
					class="form-register">
					<div class="form-register-title">
						<h3 class="register-title">
							CREA UN ACCOUNT<br> <i class="wrap-box ispace7"></i>ADESSO!
						</h3>
					</div>
					<div class="info-register">
						<p class="wrap-input-name">
							<input type="text" id="name" name="nome" value=""
								required="required" placeholder="Nome *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="cognome" value=""
								required="required" placeholder="Cognome *:">
						</p>
						<p class="wrap-input-email">
							<input type="email" id="email" name="email" value=""
								required="required" placeholder="esempio@studenti.unisa.it *:">
						</p>
						<p class="wrap-input-name">
							<input type="password" id="name" name="password" value=""
								required="required" placeholder="Password *:">
						</p>
						<p class="wrap-input-name">
							<input type="password" id="name" name="confermaPassword" value=""
								required="required" placeholder="Conferma Password *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="codiceFiscale" value=""
								required="required" placeholder="C.F. *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="luogoNascita" value=""
								required="required" placeholder="Luogo di Nascita *:">
						</p>
						<p class="wrap-input-name">
							<input type="date" id="name" name="dataNascita" value=""
								required="required"
								placeholder="Data di Nascita (gg/mm/aaaa) *:">
						</p>
						<div class="div_my_wrap-input-name"
							style="margin: 35px auto 25px auto">
							<p>Sesso:</p>
							<div class="radio_div"
								style="display: inline; vertical-align: middle;">
								<p class="my_wrap-input-name">
									<input type="radio" id="M" name="sesso" value="Maschio"
										required="required" checked="checked"> <label for="M">Maschio</label>
								</p>
								<p class="my_wrap-input-name">
									<input type="radio" id="F" name="sesso" value="Femmina"
										required="required"> <label for="F">Femmina</label>
								</p>
							</div>
						</div>
						<p class="wrap-input-name">
							<input type="text" id="name" name="residenza" value=""
								required="required" placeholder="Residenza *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="via" value=""
								required="required" placeholder="Via Roma, 125*:">
						</p>
						<p class="wrap-input-phone">
							<input type="text" id="phone" name="telefono" value=""
								required="required" placeholder="Telefono *:">
						</p>
						<div class="div_my_wrap-input-name" style="display: grid">
							<p class="my_wrap-input-name" style="margin-bottom: 20px">
								<input type="checkbox" id="trattamento_dati" name="privati"
									value="" required="required"> <label
									for="trattamento_dati" style="display: inline;">
									Acconsento al trattamento dei dati privati</label>
							</p>
							<p class="my_wrap-input-name" style="margin-bottom: 5%">
								<input type="checkbox" id="120CFU" name="CFU" value=""
									required="required"> <label for="120CFU"
									style="display: inline;"> Confermo di avere più di 120
									CFU</label>
							</p>
						</div>
						<div class="wrap-btn">
							<a class="flat-btn" href="#">REGISTRATI</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

	<!-- FOOTER -->
	<%@ include file="../footer.jsp"%>

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