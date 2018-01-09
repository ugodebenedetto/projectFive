<%@ page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  ArrayList<Studente> studenti = (ArrayList<Studente>) request.getSession().getAttribute("studenti");

			TutorAccademico tutor = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
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
#title {
	color: gray;
}

#sub-title {
	color: gray;
}

.entry {
	height: 550 px;
}
</style>
<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<%@ include file="header_tutor_accademico.jsp"%>
	<!-- Aggiungere Codice da qui -->

	<div class="wrap-slider">
		<div class="container page-container">
			<div class="page-content">
				<div class="page-title">
					<h1 id="title">I Miei Tirocinanti</h1>
				</div>
				<!-- page-title -->
			</div>
		</div>
		<!-- container -->
	</div>
	<!-- wrap-slider -->

	<%
	  if (studenti.size() == 0) {
	%>
	<section class="flat-row bg-theme pd-top-121 flat-error">
	<div class="container">
		<div class="row">
			<div class="col-md-6"
				style="float: inherit; text-align: center; margin: 0 auto;">
				<div class="info-error wrap-box pdtop65">
					<div class="title-section color-title left"
						style="text-align: center;">
						<h1 class="title">
							<span class="color-orange">NON CI SONO TIROCINANTI</span>
						</h1>
					</div>
					<div class="wrap-btn" style="float: inherit;">
						<a class="flat-btn bg-color style3"
							href="home_tutor_accademico.jsp">Torna alla home</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<%
	  }
	%>

	<%
	  if (studenti != null) {
					for (Studente s : studenti) {
	%>
	<section class="flat-row bg-theme pd-top-100 authentication">
	<div class="container">
		<div class="portfolio">
			<div class="portfolio-wrap clearfix">

				<div class="item">

					<article class="entry">
					<div class="entry-post">
						<div class="entry-categories">
							<span><%=s.getNome()%> <%=s.getCognome()%> (<%=s.getMatricola()%>)</span>
						</div>
						<h3 class="entry-title"></h3>
						<div class="entry-author">
							<span>by <%=tutor.getNome()%> <%=tutor.getCognome()%></span>
						</div>
						<div class="entry-number">
							<div class="entry-price">
								<a href="mailto:<%=s.getEmail()%>"> Invia E-mail</a>
							</div>
						</div>
					</div>
					</article>
				</div>

				<div class="dividers h49"></div>
			</div>
		</div>
	</div>
	</section>
	<%
	  }
				}
	%>
	<!-- container-->
	<!-- A qui -->

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>

	<!-- Javascript -->
	<!-- SCRIPT NAVBAR-->
	<script>
		var url = "http://localhost/IsProjectClaudio/it.tirociniosmart.view.tutorAccademico/VisualizzaInfoTirocini"
				.split("/");
		//replace string with location.href
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
		src="../bootstrap/javascript/bootstrap.min.js">
		
	</script>
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
