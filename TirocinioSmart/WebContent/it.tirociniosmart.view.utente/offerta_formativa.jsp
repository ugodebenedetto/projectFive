<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio;"%>
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
	<%@ include file="header.jsp"%>

	<!-- OFFERTA FORMATIVA -->
	<div class="wrap-slider">
		<div class="container page-container">
			<div class="page-content">
				<div class="page-title">
					<h1 style="color: #ffbf43">OFFERTA FORMATIVA</h1>
					<div class="breadcrumbs">
						<ul>
							<li style="color: #bfc5ca">Scegli la tua offerta</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Iconbox -->
	<section class="flat-row bg-theme pd-top-100 ">
	<div class="container">
		<div class="select-category">
			<div class="row">
				<div class="col-md-7">
					<div class="showing">
						<p>Tirocini disponibili X di Y</p>
						<!-- IMPLEMENTARE IL NUMERO DI CORSI DISPONIBILI -->
					</div>
				</div>
				<div class="col-md-5">
					<div class="select-sort">
						<div class="wrap-select">
							<select class="select-field all-select portfolio-filter">
								<option value="" data-filter=".all" class="active">Scegli
									la categoria</option>
								<option value="" data-filter=".bussiness">Sicurezza</option>
								<option value="" data-filter=".engin">Mobile
									Programming</option>
								<option value="" data-filter=".life">Algoritmi</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="dividers h30"></div>
	<!-- dividers h30 -->
	<% 	ArrayList<Tirocinio> tirocini = (ArrayList) session.getAttribute("tirocini");
		%>
	<div class="container">
	<% while(tirocini.listIterator().hasNext()){
					  int i = 0;
					  	%>
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">
					<!-- 1° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="login.jsp" style="padding: 10px 20px">INVIA
								RICHIESTA</a>
						</div>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
							</p>
						</div>
						<h3 class="entry-title">TITOLO: <%tirocini.get(i).getTitolo(); %></h3>
						<div class="entry-author">
							<p>
								<span>di TA: <% tirocini.get(i).getResponsabile().getCognome();
												tirocini.get(i).getResponsabile().getNome();%></span>
							</p>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"> <% tirocini.get(i).getNumPost(); %> </span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>
					<% i++; 
					} %>
					<!-- Cancellare il resto se corretto 1° -->
					<!-- 2° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="login.jsp" style="padding: 10px 20px">INVIA
								RICHIESTA</a>
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
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"> 100</span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>

					<!-- 3° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="login.jsp" style="padding: 10px 20px">INVIA
								RICHIESTA</a>
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
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"> 100</span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>

				</div>
				<div class="row">
					<div class="dividers h79"></div>
					<!-- dividers flat30 -->
				</div>
			</div>
			<!-- portfolio -->
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