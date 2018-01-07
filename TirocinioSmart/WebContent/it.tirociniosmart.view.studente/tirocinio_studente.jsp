<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@page import="it.tirociniosmart.model.tirocinio.Tirocinio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");

			Tirocinio tirocinio = (Tirocinio) request.getSession().getAttribute("tirocinioStudente");
%>
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
	<section class="flat-row bg-theme pd-top-100 "> <%
   if (tirocinio != null) {
 %>
	<div class="container">
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">

					<!-- 1° -->
					<article class="entry">
					<div class="entry-post">
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span><%=tirocinio.getTipo() %></span>
							</p>
						</div>

						<h3 class="entry-title"><%=tirocinio.getNome()%></h3>
						<div class="entry-author">
							<p>
								<span>di <%=tirocinio.getTutor().getNome()%> <%=tirocinio.getTutor().getCognome()%></span>
							</p>
						</div>
					</div>
					<div class="entry-post"">
						<p style="margin-bottom: 2%"><%=tirocinio.getDescrizione()%></p>
					</div>
					</article>
				</div>

				<div class="row">
					<div class="dividers h79"></div>
					<!-- dividers flat30 -->
				</div>

				<!-- FORM INVIA FEEDBACK -->
				<form action="./InserisciFeedback" method="post">
					<div class="info-contact"
						style="text-align: center; margin: 0 auto; width: 60%;">
						<input type="hidden" name="id" value="<%=tirocinio.getId()%>">
						<input type="text" name="dataInvio" id="theDate"
							readonly="readonly"
							style="width: 40%; text-align: center; margin: 0 auto;">
						<p style="margin-top: 4%">Valutazione: (min = 0, max = 100)</p>
						<input type="text" name="valutazione" required="required"
							onblur="valutaIntero()" id="idValutazione"
							placeholder="valutazione" pattern="[0-9]{1,}"
							title="Inserisci solo numeri [Valori ammissibili: da 0 a 100]"
							maxlength="3"
							style="width: 40%; margin: 0 auto; padding-left: 2%">
						<textarea id="messages-contact" name="messages" tabindex="2"
							title="Inserisci almeno 10 caratteri" minlength="10"
							maxlenght="200" placeholder="Messages" required
							style="margin-top: 5%"></textarea>
						<input type="submit" name="dati" value="Invia"
							id="submitRichiesta" style="display: none"> <label
							for="submitRichiesta" class="flat-btn" style="padding: 10px 20px">
							INVIA FEEDBACK</label>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
	  } else {
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin: 0 auto; float: inherit;">
				<div class="info-error wrap-box pdtop65">
					<div class="title-section color-title left">
						<h1 class="title">
							<span class="color-orange">OPPS!</span> E QUANDO TI LAUREI?
						</h1>
						<div class="sub-title">Ci dispiace ma non sei iscritto ad un
							tirocinio</div>
					</div>
					<div class="wrap-btn">
						<a class="flat-btn bg-color style3" href="home_studente.jsp">RITORNA
							ALLA HOMEPAGE</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	  }
	%> </section>

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

	<script type="text/javascript">
		function valutaIntero() {    
			if (document.getElementById("idValutazione").value > 100) {
				alert("Inserire un numero minore o uguale a 100")
				document.getElementById("idValutazione").value = "";
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

		document.getElementById('theDate').value = today;
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