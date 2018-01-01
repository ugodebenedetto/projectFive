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

    <%@ include file="header_studente.jsp"%>

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
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">

                    <!-- DAVIDE VEDI TU CHE FARE CON QUESTE 6 LILNEE E ANCHE PI� IN BASSO C'E' L'ELSE-->
					<%
					  //if (request.getSession().getAttribute("currentSessionUser") == null) {
					%>
					
					<%
					  //} else if (request.getSession().getAttribute("currentSessionUser") instanceof Studente) {
					%>

					<!-- ELSE IF SESSION == STUDENTE --- DA IMPLEMENTARE -->
					<article class="entry">
					<div class="entry-post" id="my_id">
						<!-- QUA CI VA L'ID DELL'TIROCINIO IN "ID" -->
						<form action="./inviaRichiestaTirocinio" method="post"
							id="form-login">
							<div class="wrap-btn">
								<input type="hidden" name="id" required="required" value="ID">
								<!-- NEL VALUE CI VA IL BEAN.GETID() -->
								<input type="hidden" name="stato" required="required"
									value="STATO">
								<!-- NEL VALUE CI VA IL BEAN.GETSTATO() -->
								<input type="hidden" name="dataInvio" required="required"
									value="DATAINVIO">
								<!-- NEL VALUE CI VA IL BEAN.DATAINVIO() -->
								<input type="hidden" name="dataAccetazione" required="required"
									value="DATAACCETTAZIONE">
								<!-- NEL VALUE CI VA IL BEAN.DATAACCETAZIONE() -->
								<input type="submit" name="dati" value="Invia"
									id="submitRichiesta" style="display: none"> <label
									for="submitRichiesta" class="flat-btn"
									style="padding: 10px 20px"> INVIA RICHIESTA</label>
							</div>
						</form>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
								<!-- QUI CI VA IL BEAN.GETTIPO() -->
							</p>
						</div>
						<h3 class="entry-title"></h3>
						<!-- QUI CI VA IL TITOLO -->
						<div class="entry-author">
							<p>
								<span>di </span>
								<!-- QUI CI VA IL RESPONSABILE() -->
							</p>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								POSTI DIPONIBILI: <span class="count"></span>
								<!-- QUI CI VA IL NUMPOSTI() -->
							</div>
						</div>
					</div>
					<div class="entry-post" id="my_id1" style="display: none;">
						<!-- INSERIRE L'ID DEL TIROCINO CHE SI DIFFERENZIA DA QUELLO DI SOPRA  VEDERE JS-->
						<p style="margin-bottom: 2%">Lunga descrizione dell'offerta
							formativa</p>
					</div>
					</article>
					<%
					  //} else { 
								// response.sendError(403, "Davide con calma ahahah");
								//}
					%>
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
	<%@ include file="../footer.jsp"%>

	<!-- Javascript -->
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