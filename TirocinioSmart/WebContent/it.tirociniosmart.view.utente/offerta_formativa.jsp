<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio"%>
<%@page import="java.util.ArrayList"%>
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

	<div class="dividers h30">
		<!-- dividers h30 -->
	</div>

	<!-- LISTA DEI TIROCINI -->

	<div class="container">
	<%
	int i=0; int y=0;
	ArrayList<Tirocinio> tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirocini");
	if (tirocini!=null) {
		for (Tirocinio t : tirocini) {
	%>
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">
					<article class="entry">
					<div class="entry-post" id="my_id">
						<!-- QUA CI VA L'ID DELL'TIROCINIO IN "ID" -->
						<div class="wrap-btn">
							<a class="flat-btn" href="login.jsp" style="padding: 10px 20px">INVIA
								RICHIESTA</a>
						</div>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span><%=t.getTipo()%></span>
								<!-- QUI CI VA IL BEAN.GETTIPO() PENSO-->
							</p>
						</div>
						<h3 class="entry-title"></h3>
						<div class="entry-author">
							<p>
								<span>di <%=t.getTutor().getNome()%><%=t.getTutor().getCognome()%> </span>
							</p>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"><%=t.getNumPost()%></span>
							</div>
						</div>
					</div>
					<div class="entry-post" id="my_id1" style="display: none;">
						<!-- INSERIRE L'ID DEL TIROCINO CHE SI DIFFERENZIA DA QUELLO DI SOPRA VEDERE JS-->
						<p style="margin-bottom: 2%"><%=t.getDescrizione()%></p>
					</div>
					</article>
				</div>

				<!-- DIVIDER -->
				<div class="row">
					<div class="dividers h79"></div>
					<!-- dividers flat30 -->
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- FOOTER -->
    <%@ include file="../footer_folder/footer.jsp"%>

	<!-- Javascript -->
	
	<!-- AJAX VISUALIZZA INFO TIROCINI -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
		
	</script>
	<script>
		$(document).ready(function() {
			$("#my_id").click(function() {
				$("#my_id1").show(2000);
			});
		});
	</script>

    <!-- SCRIPT NAVBAR-->
    <script>
        var url = document.URL.split("/"); //replace string with location.href
        var navLinks = document.getElementsByClassName("mainnav")[0].getElementsByTagName("a");
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