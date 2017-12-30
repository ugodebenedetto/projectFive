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
.wrap-btn {
	float: right;
}

@media only screen and (max-device-width : 667px) {
	.wrap-btn {
		float: none;
		margin-bottom: 20px;
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

	<!-- TIROCINIO STUDENTE -->
	<section class="flat-row bg-theme pd-top-100 ">
	<div class="container">
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">

					<!-- 1° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="area_condivisa_studente.jsp"
								style="padding: 10px 20px">AREA CONDIVISA</a>
						</div>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
							</p>
						</div>
						<h3 class="entry-title">TITOLO</h3>
						<div class="entry-author">
							<p>
								<span>di Nome Cognome</span>
							</p>
						</div>
					</div>
					<div class="entry-post"">
						<p style="margin-bottom: 2%">Lunga descrizione dell'offerta
							formativa</p>
					</div>
					</article>
				</div>

				<div class="row">
					<div class="dividers h79"></div>
					<!-- dividers flat30 -->
				</div>

				<!-- FORM INVIA FEEDBACK -->
				<form action="./inviaFeedbackStudente" method="post">
					<div class="info-contact"
						style="text-align: center; margin: 0 auto; width: 60%;">
						<input type="hidden" name="id" required="required" value="ID">
						<!-- NEL VALUE CI VA IL BEAN.GETID() -->
						<input type="text" name="dataInvio" id="theDate"
							required="required" readonly="readonly"
							style="width: 40%; text-align: center; margin: 0 auto;">
						<p style="margin-top: 4%">Valutazione: (min = 1, max = 100)</p>
						<input type="text" name="valutazione" required="required"
							placeholder="valutazione" min="1" maxlength="3"
							style="width: 40%; margin: 0 auto; padding-left: 2%">
						<textarea id="messages-contact" name="messages" tabindex="2"
							min="10" maxlenght="200" placeholder="Messages" required style="margin-top: 5%"></textarea>
						<input type="submit" name="dati" value="Invia"
							id="submitRichiesta" style="display: none"> <label
							for="submitRichiesta" class="flat-btn" style="padding: 10px 20px">
							INVIA FEEDBACK</label>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

	<!-- FOOTER -->
	<%@ include file="../footer.jsp"%>

	<!-- Javascript -->

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

		document.getElementById('theDate').value = today;
	</script>

	<!-- SCRIPT CONTROLLO CAMPI FORM -->
	<script type="text/javascript">
		function Modulo() {
			// Variabili associate ai campi del modulo
			var val = document.modulo.valutazione.value;

			//Effettua il controllo sul campo VALUTAZIONE
			if ((isNaN(val)) || val.substring(0, 1) == "-"
					|| val.substring(0, 1) == " ") {
				alert("Il campo Valutazione è numerico");
				document.modulo.telefono.value = "1";
				document.modulo.telefono.focus();
				return false;
			}
			if (val > 100 || val < 1) {
				alert("Il campo Valutazione va oltre il margine prestabilito");
				document.modulo.telefono.value = "1";
				document.modulo.telefono.focus();
				return false;
			} else {
				document.modulo.action = "./inviaFeedbackStudente";
				document.modulo.submit();
			}
		}
	</script>

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