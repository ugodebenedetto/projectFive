<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Tirocinio Smart</title>

<meta name="author" content="Claudio Amato">

<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/style.css">

<!-- Responsive -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/responsive.css">

<!-- REVOLUTION LAYERS STYLES -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/revolution/css/settings.css">

<!-- Favicon and touch icons  -->
<link href="icon/icon.png" rel="shortcut icon">
</head>

<body>

	<!-- BOX HEADER -->
	<div class="boxed position_form position_style3 ">
		<div class="wrap-header">
			<div class="top top-style3">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<ul class="flat-information">
								<li>Lun - Ven: 8.00 - 18:00</li>
								<li><p>
										<span>Tel:</span> 089-96-96-00
									</p></li>
								<li><p>
										<span>E-mail:</span>ads@unisa.it
									<p></li>
							</ul>
						</div>
						<div class="col-md-4">
							<div class="wrap-flat">
								<ul class="flat-login-register">
									<li><a href="it.tirociniosmart.view.utente/login.jsp">Login</a></li>
									<li><a
										href="it.tirociniosmart.view.utente/registrazione.jsp">Registrazione</a></li>
									<li><a
										href="it.tirociniosmart.view.utente/richiesta_supporto.jsp">Help</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- TITOLO E ICONA -->
	<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="title-section">
				<img
					alt="Università degli Studi di Salerno, Dipartimento Informatica"
					src="img/dipStuSalernoInf.png" style="margin-bottom: 5%">
				<h1 class="title">TIROCINIO SMART</h1>
				<div class="sub-title">Team Project: Five</div>
				<a href="it.tirociniosmart.view.utente/homepage.jsp"><img alt="logo" src="img/index.png"></a>
			</div>
		</div>
	</div>
	</div>

	<!-- FORM REGISTRAZIONE --> 
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<!-- DESCRIZIONE LATERALE REGISTRAZIONE -->
			<div class="col-md-7 no-paddingright">
				<div class="wrap-register-right wrap-box pdtopleft">
					<div class="wrap-register-title">
						<div class="title-top">PRENOTA ADESSO IL TUO TIROCINIO</div>
						<div class="title-register">REGISTRATI ORA</div>
						<div class="sub-title-register">Crea un account e accedi
							immediatamente ai corsi online.</div>
					</div>
				</div>
			</div>

			<div class="col-md-5">

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
							<input type="text" id="email" name="email" value=""
								required="required" placeholder="esempio@studenti.unisa.it *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="password" value=""
								required="required" placeholder="Password *:">
						</p>
						<p class="wrap-input-name">
							<input type="text" id="name" name="confermaPassword" value=""
								required="required" placeholder="Conferma Password *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="codiceFiscale" value=""
								required="required" placeholder="C.F. *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="luogoNascita" value=""
								required="required" placeholder="Luogo di Nascita *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="dataNascita" value=""
								required="required"
								placeholder="Data di Nascita (gg/mm/aaaa) *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="sesso" value=""
								required="required" placeholder="Sesso *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="residenza" value=""
								required="required" placeholder="Residenza *:">
						</p>
						<p class="wrap-input-email">
							<input type="text" id="email" name="via" value=""
								required="required" placeholder="Via Roma, 125*:">
						</p>
						<p class="wrap-input-phone">
							<input type="text" id="phone" name="telefono" value=""
								required="required" placeholder="Telefono *:">
						</p>
						<div class="wrap-btn">
							<a class="flat-btn" href="#">REGISTRATI</a>
						</div>
					</div>
				</form>
			</div>
			<!-- DESCRIZIONE LATERALE REGISTRAZIONE -->
			<div class="col-md-7 no-paddingright">
				<div class="wrap-register-right wrap-box pdtopleft">
					<div class="wrap-register-title">
						<div class="title-top">OPPURE...</div>
						<div class="title-register">VAI ALLA HOMEPAGE</div>
						<div class="wrap-btn">
							<a class="flat-btn" href="it.tirociniosmart.view.utente/homepage.jsp">HOMEPAGE</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section> <!-- FOOTER --> <%@ include file="footer_index.jsp"%>

	<!-- Javascript --> <script type="text/javascript"
		src="bootstrap/javascript/jquery.min.js"></script> <script
		type="text/javascript" src="bootstrap/javascript/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/javascript/main.js"></script>
	<script type="text/javascript" src="bootstrap/javascript/countdown.js"></script>
	<script type="text/javascript"
		src="bootstrap/javascript/imagesloaded.min.js"></script> <script
		type="text/javascript"
		src="bootstrap/javascript/jquery.isotope.min.js"></script> <script
		type="text/javascript"
		src="bootstrap/javascript/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/javascript/owl.carousel.js"></script> <script
		type="text/javascript" src="bootstrap/javascript/jquery.easing.js"></script>
	<script type="text/javascript"
		src="bootstrap/javascript/jquery.flexslider.js"></script> <!-- Revolution Slider -->
	<script type="text/javascript"
		src="bootstrap/revolution/js/jquery.themepunch.tools.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript" src="bootstrap/revolution/js/slider.js"></script>

	<!-- SLIDER REVOLUTION 5.0 EXTENSIONS  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.migration.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>
</html>