<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  ArrayList<Tirocinio> tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirociniTutor");
			int i = Integer.parseInt(request.getParameter("indice"));
			Tirocinio tirocinio = tirocini.get(i);
			request.getSession().setAttribute("tirocinioModifica", tirocinio);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="../img/index.png">

<title>Tirocinio Smart</title>

<meta name="author" content="Sebastiano Caruso">

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
<style>
label {
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


	<!-- FORM MODIFICA -->
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<div class="col-md-5" style="float: none; margin: 0 auto;">
				<!-- Compilare i campi della form -->
				<form action="./ModificaTirocinio" method="POST" id="form-register"
					class="form-register">
					<div class="form-register-title">
						<h3 class="register-title">
							Modifica il Tirocinio <br>
						</h3>
					</div>
					<div class="info-register">

						<p class="wrap-input-name">
							<label for="nam">Nome </label><input type="text" id="nam"
								name="nome" pattern="[A-Za-z\s]{5,}" maxlength="30"
								title="Inserisci minimo 5 lettere"
								value="<%=tirocinio.getNome()%>">
						</p>
						<br>
						<p class="wrap-input-name">
							<label for="obi">Obiettivi </label> <input type="text" id="obi"
								name="Obiettivi" value="<%=tirocinio.getObiettivi()%>"
								title="Inserisci minimo 15 caratteri" pattern=".{15,}"
								maxlength="300">
							<!-- OBIETTIVI NON ESISTENTI -->
						</p>
						<p class="wrap-input-name">
							<label for="des">Descrizione </label> <input type="text" id="des"
								name="Descrizione" value="<%=tirocinio.getDescrizione()%>"
								title="Inserisci minimo 15 caratteri" pattern=".{15,}"
								maxlength="300">
						</p>
						<p class="wrap-input-name">
							<label for="tip">Tipo </label> <input type="text" id="des"
								name="Tipo" value="<%=tirocinio.getTipo()%>"
								title="Inserisci minimo 3 caratteri" pattern=".{3,}"
								maxlength="30">
						</p>
						<p class="wrap-input-name">
							<label for="sed">Sede </label> <input type="text" id="sed"
								name="Sede" value="<%=tirocinio.getSede()%>"
								title="Inserisci minimo 3 caratteri" pattern=".{3,}"
								maxlength="30">
						</p>
						<p class="wrap-input-name">
							<label for="res">Responsabile </label> <input type="text"
								id="res" name="Responsabile"
								value="<%=tirocinio.getResponsabile()%>"
								title="Inserisci minimo 3 lettere" pattern="[A-Za-z\s]{3,}"
								maxlength="30">
						</p>
						<p class="wrap-input-name">
							<label for="num">Numero Posti *</label> <input type="number"
								id="num" name="Numero Posti" min="0" step="1" max="50"
								value="<%=tirocinio.getNumPost()%>"> <span>*
								Inserire 0 per rendere il tirocinio non disponibile</span>
						</p>
						<div class="div_my_wrap-input-name" style="display: grid"></div>
						<div class="wrap-btn" style="display: grid;">
							<input type="submit" name="dati" value="Invia"
								id="submitRegistration" style="display: none"> <label
								for="submitRegistration" class="flat-btn"
								style="margin: 0 auto 5% auto">Modifica</label>
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
	<script type="text/javascript">
		jQuery(document).ready(function() {
			$('.header .logo').find('img').attr({
				src : '../img/dipStuSalernoInf.png',
				width : 'auto',
				height : 'auto'
			});
		});
	</script>
</body>

</html>