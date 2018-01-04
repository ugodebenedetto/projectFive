<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Scanner" %>
<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page import="it.tirociniosmart.model.tirocinio.RichiestaTirocinio" %>
<%@ page import="it.tirociniosmart.model.tirocinio.Tirocinio" %>
<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
//codice di prova

ArrayList<RichiestaTirocinio> richieste1 = (ArrayList<RichiestaTirocinio>) request.getSession().getAttribute("richieste");

ArrayList<RichiestaTirocinio> richieste = new ArrayList<RichiestaTirocinio>();

Studente studente = new Studente("abcd@mail.com", "0514103275", "mario", 
	"rossi", "roma","01/01/95", "password", "aa", "roma", "boh",
	"cellulare", "0514103275", "Tipo");

TutorAccademico ta1 = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");

TutorAccademico ta = new TutorAccademico("email", "codicefiscale", "nome", "cognome",
	"luogodinascita", "01/02/02", "password", "m", "residenza", "via", 
	"telefono", "dipartimento", "coddocente");


Tirocinio tirocinio = new Tirocinio("TirocinioNome", "descrizione", 10, ta);

RichiestaTirocinio r1 = new RichiestaTirocinio("Rifiutata", "datarichiesta", "datarisposta", studente, tirocinio);
RichiestaTirocinio r2 = new RichiestaTirocinio("InFaseDiApprovazione", "datarichiesta2", "datarisposta2", studente, tirocinio);
richieste.add(r1);
richieste.add(r2);

%>

<%
String stato[] = new String[richieste.size()];
String dataRichiesta[] = new String[richieste.size()];
String dataRisposta[] = new String[richieste.size()];
						
//codice relativo al richiedente
String email[] = new String[richieste.size()];;
						
						
//codice relativo al tirocinio
String titolo[] = new String[richieste.size()];
String descrizione[] = new String[richieste.size()];
int numPost[] = new int[richieste.size()];

//abbiamo solo bisogno del tutor accademico nella sessione


//DICHIARAZIONE VARIABILI


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<%@ include file="header_tutor_accademico.jsp"%>

	<!-- OFFERTA FORMATIVA -->
	<div class="wrap-slider">
		<div class="container page-container">
			<div class="page-content">
				<div class="page-title">
					<h1 style="color: #ffbf43">Richieste Per I Miei Tirocini</h1>
					<div class="breadcrumbs">
						<ul>
							<li style="color: #bfc5ca">Ecco le richieste per te!</li>
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
						<p>Richieste X di Y</p>
						<!-- IMPLEMENTARE IL NUMERO DI CORSI DISPONIBILI -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="dividers h30"></div>
	<!-- dividers h30 -->

	<div class="container">
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">
					<% 
					int i=0;
					for (RichiestaTirocinio r : richieste) {
					%>
					<!-- 1° -->
					<%
						//Codice relativo alla richiesta
						stato[i] = r.getStato();
						dataRichiesta[i] = r.getDataRichiesta();
						dataRisposta[i] = r.getDataRisposta();
						
						//codice relativo al richiedente
						email[i] = r.getRichiedente().getEmail();
						
						
						//codice relativo al tirocinio
						titolo[i] = r.getTirocinio().getTitolo();
						descrizione[i] = r.getTirocinio().getDescrizione();
						numPost[i] = r.getTirocinio().getNumPost();
						//abbiamo solo bisogno del tutor accademico nella sessione
						
					%>
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="./ValutaRichiestaTirocinio?stato=<%=stato[i]%>&dataric=<%=dataRichiesta[i]%>
							&datarisp=<%=dataRisposta[i]%>&email=<%=email[i]%>&titolo=<%=titolo[i]%>
							&descrizione=<%=descrizione[i]%>&numpost=<%=numPost[i]%>&return=true" style="padding: 10px 20px">Accetta</a>
						</div>
						<div class="dividers h3"></div>
						<div class="wrap-btn">
							<a class="flat-btn" href="./ValutaRichiestaTirocinio?stato=<%=stato[i]%>&dataric=<%=dataRichiesta[i]%>
							&datarisp=<%=dataRisposta[i]%>&email=<%=email[i]%>&return=false" style="padding: 10px 20px">Rifiuta</a>
						</div>
						<!-- DA TESTARE -->
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
							</p>
						</div>
						<h3 class="entry-title"><%=r.getTirocinio().getTitolo()%></h3>
						<div class="entry-author">
							<p>
								<a href="#"> <span>di <%=r.getRichiedente().getNome()%> 
								<%=r.getRichiedente().getCognome()%></span> </a>
							</p>
						</div>
					</div>
					<!-- entry-post --> </article>
					<%
					i++;
					}
					%>
					<!-- Sebastiano per ora teniamole queste altre due, ma sono statiche e non servono -->
					<!-- 2° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="#" style="padding: 10px 20px">Accetta</a>
						</div>
						<div class="dividers h3"></div>
						<div class="wrap-btn">
							<a class="flat-btn" href="#" style="padding: 10px 20px">Rifiuta</a>
						</div>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
							</p>
						</div>
						<h3 class="entry-title">TITOLO</h3>
						<div class="entry-author">
							<p>
								<a href="#"> <span>di Nome Cognome (Richiedente)</span> </a>
							</p>
						</div>
					</div>
					<!-- entry-post --> </article>
					
					
					<!-- 3° -->
						<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<a class="flat-btn" href="#" style="padding: 10px 20px">Accetta</a>
						</div>
						<div class="dividers h3"></div>
						<div class="wrap-btn">
							<a class="flat-btn" href="#" style="padding: 10px 20px">Rifiuta</a>
						</div>
						<div class="entry-categories">
							<p style="color: #ffbf43">
								<span>CATEGORIA</span>
							</p>
						</div>
						<h3 class="entry-title">TITOLO</h3>
						<div class="entry-author">
							<p>
								<a href="#"> <span>di Nome Cognome (Richiedente)</span> </a>
							</p>
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
</body>

</html>