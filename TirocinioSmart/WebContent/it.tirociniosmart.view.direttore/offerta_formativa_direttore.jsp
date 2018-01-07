<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
  HashMap<Integer, Tirocinio> tirocini = (HashMap<Integer, Tirocinio>) request.getSession()
					.getAttribute("tirocini");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tirocinio Smart</title>

<meta name="author" content="Clara Monaco">

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

#wrap-btn_didattica {
	display: none;
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
	<%@ include file="header_direttore.jsp"%>

	<div class="wrap-slider">
		<div class="container page-container">
			<div class="page-content">
				<div class="page-title">
					<h1 style="color: #ffbf43">OFFERTA FORMATIVA</h1>
					<div class="breadcrumbs">
						<ul>
							<li style="color: #bfc5ca">Ecco la nostra offerta</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%
	  if (tirocini != null) {
	%>
	<section class="flat-row bg-theme pd-top-100 "> <%
   Iterator<Entry<Integer, Tirocinio>> it = tirocini.entrySet().iterator();
 				while (it.hasNext()) {
 					Map.Entry pair = (Map.Entry) it.next();
 					Tirocinio t = (Tirocinio) pair.getValue();
 %> <!-- LISTA DEI TIROCINI -->
	<div class="container">
		<div class="row">

			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">
					<article class="entry">
					<div class="entry-post" onclick="mostra(<%=t.getId()%>)">
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span><%=t.getTipo()%></span>
							</p>
						</div>
						<h3 class="entry-title"><%=t.getNome()%></h3>
						<div class="entry-author">
							<p>
								<span>di <%=t.getTutor().getCognome()%> <%=t.getTutor().getNome()%>
								</span>
							</p>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"><%=t.getNumPost()%>
								</span>
							</div>
						</div>
					</div>
					<div class="entry-post" id="<%=t.getId()%>" style="display: none;">
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

	<!-- MOSTRA DESCRIZIONI --> <script>
            function mostra(l_id) {
                var qui = document.getElementById(l_id);
                qui.style.display = "block";
            }
        </script> <%
   }
 %> </section>
	<%
	  } else {
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
							<span class="color-orange">NON CI SONO ANCORA TIROCINI
								DISPONIBILI</span>
						</h1>
					</div>
					<div class="wrap-btn" style="float: inherit;">
						<a class="flat-btn bg-color style3" href="home_studente.jsp">Torna
							alla home</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<%
	  }
	%>

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>
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