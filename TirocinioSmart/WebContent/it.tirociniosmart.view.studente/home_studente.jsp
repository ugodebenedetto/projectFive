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

<style type="text/css">
#divFlip {
	margin-bottom: 230px;
}

.box-content p {
	font-size: 14px;
}

@media only screen and (max-device-width : 479px) {
	#divFlip {
		margin-bottom: 0;
	}
}
</style>

</head>

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<!-- HEADER -->
	<%@ include file="header_studente.jsp"%>

	<!-- HOMEPAGE -->
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="authen-img"
					style="height: 0px; margin-bottom: 250px; text-align: center;">
					<a href="../index.jsp"> <img src="../img/index.png" alt="image">
					</a>
				</div>
			</div>
			<div class="col-md-6">
				<div class="authen-text wrap-box pdtopleft-style2">
					<div class="authen-title">
						<div class="sub-authen">BENVENUTO IN</div>
						<div class="title-text-authen">TIROCINIO SMART</div>
					</div>
					<p>La piattaforma che ti aiuta a trovare tutte le informazioni
						che ti sono necessarie per prepararti ad affrontare una fantastica
						esperienza formativa come il Tirocinio. Qui troverai tutto quello
						che il Dipartimento Di Informatica ti offre senza sprecare il tuo
						tempo e perderti negli Uffici dei Professori. Speriamo di aiutarti
						al meglio. Che il viaggio abbia inizio!</p>
				</div>
				<!-- authen-text -->
			</div>
		</div>
		<!-- row -->
		<div class="row">
			<div class="dividers h98"></div>
		</div>
	</div>
	<div class="container">
		<div class="row">

			<!-- PRIMO BLOCCO ICONE FLIP -->
			<div id="divFlip">
				<div class="col-md-3 col-sm-6">
					<div class="iconbox">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/sebastiano.jpg);">
							</div>
							<div class="box-title">Sebastiano Caruso</div>
						</div>
						<div class="box-content">
							<p>""</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-green">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/claudio.jpg);">
							</div>
							<div class="box-title">Claudio Amato</div>
						</div>
						<div class="box-content">
							<p>
								Oggi <span id="citazione"></span> sei ancora uno studente
								universitario, domani potresti essere un dottore. Auguri!
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-cyan">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/clara.jpg);">
							</div>
							<div class="box-title">Clara Monaco</div>
						</div>
						<div class="box-content">
							<p>
								The idea is to keep the discussions<br>going after class
								ends.
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-green">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/luca.jpg);">
							</div>
							<div class="box-title">Luca Nastri</div>
						</div>
						<div class="box-content">
							<p>
								The idea is to keep the discussions<br>going after class
								ends.
							</p>
						</div>
					</div>
				</div>

			</div>

			<!-- SECONDO BLOCCO ICONE FLIP -->
			<div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-blue">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/armando.jpg);">
							</div>
							<div class="box-title">Armando Ferrara</div>
						</div>
						<div class="box-content">
							<p>
								The idea is to keep the discussions<br>going after class
								ends.
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-green">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/davide.jpg);">
							</div>
							<div class="box-title">Davide Crescenzi</div>
						</div>
						<div class="box-content">
							<p>
								The idea is to keep the discussions<br>going after class
								ends.
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox icon-green">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/ugo.jpg);">
							</div>
							<div class="box-title">Ugo Maria De Benedetto</div>
						</div>
						<div class="box-content">
							<p>
								The idea is to keep the discussions<br>going after class
								ends.
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6">
					<div class="iconbox">
						<div class="box-header">
							<div class="box-icon"
								style="background-image: url(../img/our_photo/martina.jpg);">
							</div>
							<div class="box-title">Martina Esposito</div>
						</div>
						<div class="box-content">
							<p>""</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- container --> </section>

	<!-- Popular-iconbox2 -->
	<section class="flat-row pd-top-93"
		style="padding-top: 10%; padding-bottom: 10%">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="title-section color-title">
					<h1 class="title">
						I <span class="color-orange">TIROCINI</span> PIÙ POPOLARI
					</h1>
				</div>
			</div>
			<!-- col-md-12 -->
		</div>
		<!-- row -->
		<div class="row">
			<div class="dividers h23"></div>
		</div>
	</div>
	<!-- container -->

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/sicurezza.png" alt="image">
								</div>
								<div class="box-title">SICUREZZA</div>
							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style bg-blue ">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/reti.png" alt="image">
								</div>
								<div class="box-title">RETI</div>
							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style bg-cyan">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/sistemi_operativi.png" alt="image">
								</div>
								<div class="box-title">SISTEMI OPERATIVI</div>
							</div>
						</div>
					</div>

					<!-- dividers -->
					<div class="dividers"></div>
					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style bg-red">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/algoritmi.png" alt="image">
								</div>
								<div class="box-title">ALGORITMI</div>
							</div>
						</div>
					</div>

					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style bg-green ">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/db.png" alt="image">
								</div>
								<div class="box-title">DATABASE</div>
							</div>
						</div>
					</div>


					<div class="col-md-4 col-sm-6">
						<div class="iconbox bg-style bg-violet ">
							<div class="box-header">
								<div class="box-icon">
									<img src="../img/iconbox/mobile.png" alt="image">
								</div>
								<div class="box-title">WEB & MOBILE</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- no-paddingright -->
			<div class="col-md-6">
				<div class="about-us style2 wrap-box pdleft">
					<h2 class="title-about-us">SHUNRYU SUZUKI</h2>
					<div class="text-about-us">
						<p>
							"Nella mente del novizio ci sono molte possibilità, ma nella
							mente dell'esperto ve ne sono poche." <br>
						</p>
					</div>
					<div class="course-about-us">
						<p>
							TIROCINI DISPONIBILI:<br> <strong> 35</strong>
						</p>
					</div>
					<div class="button-style">
						<div class="wrap-btn">
							<a class="flat-btn" href="offerta_formativa.jsp">VISUALIZZA
								L'OFFERTA</a>
						</div>
					</div>
				</div>
				<!-- About-us -->
			</div>
			<!-- col-md-6 -->
		</div>
		<!-- row -->
	</div>
	<!-- Container --> </section>

	<!-- toggle-testimonials -->
	<section class="flat-row bg-theme">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<div class="question-toggle">
					<div class="title-section color-title left">
						<h1 class="title">
							PERCHÉ <span class="color-orange">SCEGLIERE </span>NOI?
						</h1>
					</div>
					<div class="flat-accordion">
						<!-- flat-toggle -->
						<div class="flat-toggle">
							<h6 class="toggle-title">
								VELOCIZZA LA RICHIESTA DEL TIROCINIO <span></span>
							</h6>
							<div class="toggle-content">
								<p>Il mondo sta cambiando, sempre più smart, sempre più
									tecnologico. Ecco la svolta per la scelta del tirocinio. Fallo
									comodamente da casa tua, senza perderti nei meandri dei
									corridoi universitari!</p>
							</div>
						</div>
						<!-- flat-toggle -->
						<div class="flat-toggle">
							<h6 class="toggle-title">
								STAY TUNED <span></span>
							</h6>
							<div class="toggle-content">
								<p>Quante volte hai sentito tuoi amici lamentarsi di non
									essere a conoscenza di un tirocinio figo?! Beh, con noi questo
									non succederà. Qui potrai visualizzare tutte le strade a tua
									disposizione, scegliendo quella che più ti piace!</p>
							</div>
						</div>
						<!-- flat-toggle -->
					</div>
					<!-- flat-accordion -->
				</div>
				<!-- question-toggle -->
			</div>
			<!-- col-md-6 -->
			<div class="col-md-6 col-sm-6">
				<div class="wrap-student">
					<div class="title-section color-title left">
						<h1 class="title">
							GLI UTENTI <span class="color-orange">DICONO: </span>
						</h1>
					</div>
					<div class="flat-testimonials style2 owl-carousel wrap-box pdtop"
						data-item="1" data-nav="true" data-auto="true">
						<div class="testimonial">
							<div class="testimonial-content">
								<p>
									<i class="wrap-box ispace10"></i>MOLTO INTUITIVO<i
										class="fa fa-quote-right"></i> <br> Appena registrato mi
									si è aperto un mondo di possibilità qualche click e si invia
									facilmente una richiesta per un tirocinio. FONDAMENTALE!
									E'quello che ci voleva!
								</p>
							</div>
							<div class="wrap-testimonial">
								<div class="testimonial-author">
									<div class="author-img">
										<img src="../img/our_photo/sebastiano.jpg" alt="image">
									</div>
									<div class="athor-info">
										<span class="author-name">Sebastiano Caruso</span><br>
									</div>
								</div>
							</div>
							<!-- wrap-testimonial -->
						</div>
						<!-- testimonial -->

						<!-- testimonial 2 -->
						<div class="testimonial">
							<div class="testimonial-content">
								<p>
									<i class="wrap-box ispace10"></i>FINALMENTE!<i
										class="fa fa-quote-right"></i> <br> Ora posso accogliere
									i miei tirocinanti direttamente da casa, e posso comunicarvi
									tramite uno strumento al passo con i tempi! Bravi ragazzi
								</p>
							</div>
							<div class="wrap-testimonial">
								<div class="testimonial-author">
									<div class="author-img">
										<img src="../img/fferrucci.jpg" alt="image">
									</div>
									<div class="athor-info">
										<span class="author-name">Filomena Ferrucci</span><br>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>

	<!-- Javascript -->

	<!-- SCRIPT NAVBAR-->
	<script>
		var url = document.URL.split("/"); //replace string with location.href
		var navLinks = document.getElementsByClassName("mainnav")[0]
				.getElementsByTagName("a");
		//naturally you could use something other than the <nav> element
		var i = 0;
		var currentPage = url[url.length - 1];
		for (i; i < navLinks.length; i++) {
			var lb = navLinks[i].href.split("/");
			if (lb[lb.length - 1] == currentPage) {
				var comeVuoiTu = navLinks[i];
				comeVuoiTu.style.color = "#ffbf43";
			}
		}
	</script>

	<!-- OTTIENI IL GIORNO CORRENTE -->
	<script type="text/javascript">
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //Gennaio è 0!
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}
		today = dd + '/' + mm + '/' + yyyy;

		document.getElementById('citazione').innerHTML = today;
	</script>

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