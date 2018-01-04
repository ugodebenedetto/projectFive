<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");
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
.index2 {
	width: 20%;
	float: left;
	margin-right: 10%;
}

.my_table_studente {
	margin-left: 25%;
}

.my_table_studente th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
}

.my_table_studente td {
	padding: 8px;
}

.my_table_studente1 td {
	border: 1px dashed #ffbf43;
	padding: 8px;
}

.my_table_studente1 tr:nth-child(even) {
	background-color: #fff1d6;
}

.my_table_studente1 tr:hover {
	background-color: #ddd;
}

.my_table_studente1 th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

.flat-row {
	padding: 0px 0px 100px 0px;
}

@media only screen and (max-device-width : 667px) {
	.index2 {
		width: 70%;
		float: none;
		display: block;
		margin: 0 auto 15% auto;
	}
	.my_table_studente {
		margin: 0 auto;
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

	<!-- AGGIUNGERE CODICE DA QUI -->
    <form action="../it.tirociniosmart.view.utente/modificaInformazioni" method="get">
	
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="width: 100%">
				<div class="authen-img" style="height: 20%">
					<table class="my_table_studente">
						<tr>
							<td><label>NOME</label></td>
							<td><input type="text" id="name" name="nome" maxlength="20"
								min="3"
								placeholder="<%=studente.getNome()%>"></td>
						</tr>
						<tr>
							<td><label>COGNOME</label></td>
							<td><input type="text" id="name" name="cognome"
								maxlength="20" min="3"
								placeholder="<%=studente.getCognome()%>"></td>
						</tr>
						<tr>
							<td><label>DATA DI NASCITA</label></td>
							<td><input type="date" id="name" name="dataNascita"
								placeholder="<%=studente.getDataNascita()%>"></td>
						</tr>
						<a href="#"><img class="index2" src="../img/profilo.png"
							alt="your_image"
							style="position: inherit; top: 0; border-radius: 50%;"> </a>
					</table>
				</div>
			</div>
		</div>
	</div>
	</section>

	<section class="flat-row bg-theme flat-contact">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="subscribe-contact wrap-box pdfull">
						<table class="my_table_studente1" style="width: 100%">
							<tr>
								<td style="width: 40%"><label>EMAIL</label></td>
								<td><input type="email" id="email" name="email"
									maxlength="40" min="23" readonly="readonly"
									value="<%=studente.getEmail()%>"></td>
							</tr>
							<tr>
								<td><label>C.F.</label></td>
								<td><input type="text" id="name" name="codiceFiscale"
									maxlength="16" min="16"
									placeholder="<%=studente.getCodiceFiscale()%>"></td>
							</tr>
							<tr>
								<td><label>LUOGO NASCITA.</label></td>
								<td><input type="text" id="name" name="luogoNascita"
									value="" maxlength="40"
									placeholder="<%=studente.getLuogoNascita()%>"></td>
							</tr>
							<tr>
								<td><label>SESSO.</label></td>
								<%
								  if (studente.getSesso().equals("maschio")) {
								%>
								<td><input type="radio" id="M" name="sesso" value="Maschio"
									checked="checked"> <label for="M">Maschio</label>
									<input type="radio" id="F" name="sesso" value="Femmina"
									style="margin-left: 5%"> <label
									for="F">Femmina</label></td>
								<%
								  } else {
								%>
								<td><input type="radio" id="M" name="sesso" value="Maschio"> 
								    <label for="M">Maschio</label> <input
									type="radio" id="F" name="sesso" value="Femmina"
									style="margin-left: 5%" checked="checked">
									<label for="F">Femmina</label></td>
								<%
								  }
								%>
							</tr>
							<tr>
								<td><label>RESIDENZA.</label></td>
								<td><input type="text" id="name" name="residenza"
									maxlength="40"
									placeholder="<%=studente.getResidenza()%>"></td>
							</tr>
							<tr>
								<td><label>VIA.</label></td>
								<td><input type="text" id="name" name="via" maxlength="40"
									placeholder="<%=studente.getVia()%>"></td>
							</tr>
							<tr>
								<td><label>TELEFONO.</label></td>
								<td><input type="text" id="phone" name="telefono"
									maxlength="10" min="10"
									placeholder="<%=studente.getTelefono()%>"></td>
							</tr>
						</table>

						<div class="wrap-btn" style="display: grid;">
							<input type="submit" name="dati" value="Invia"
								id="submitRegistration" style="display: none"> <label
								for="submitRegistration" class="flat-btn"
								style="margin: 5% auto 0 auto;">MODIFICA</label>
						</div>
				</div>
			</div>
		</div>
	</div>
	</section>
    </form>
	
	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>

	<!-- Javascript -->

	<!-- SCRIPT NAVBAR-->
	<script>
		var url = "http://localhost/IsProjectClaudio/it.tirociniosmart.view.studente/info_account_studente.jsp"
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

	<!-- SCRIPT CONTROLLO CAMPI FORM -->
	<script type="text/javascript">
		function Modulo() {
			// Variabili associate ai campi del modulo
			var password = document.modulo.password.value;
			var confermaPassword = document.modulo.confermaPassword.value;
			var nascita = document.modulo.nascita.value;
			var telefono = document.modulo.telefono.value;
			var email = document.modulo.email.value;
			var tipoLaurea = document.modulo.laurea.value;
			var matricola = document.modulo.matricola.value;

			// Espressione regolare dell'email
			var email_reg_studente = "@studenti.unisa.it";
			var email_reg_tutorAccademico = "@unisa.it";
			var email_length = email.length;
			var last_index_email = email.lastIndexOf("@");

			//Verifica l'uguaglianza tra i campi PASSWORD e CONFERMA PASSWORD
			if (password != conferma) {
				alert("La password confermata � diversa da quella scelta, controllare.");
				document.modulo.conferma.value = "";
				document.modulo.conferma.focus();
				return false;
			}
			//Controllo sulla matricola
			else if ((isNaN(matricola)) || x.substring(0, 1) == "-"
					|| x.substring(0, 1) == " ") {
				alert("Il campo Matricola � numerico ed obbligatorio.");
				document.modulo.matricola.value = "";
				document.modulo.matricola.focus();
				return false;
			}
			//Controllo sulla scelta del tipo di laurea
			else if (tipoLaurea == "Tipo di laurea") {
				alert("Inserire un tipo di laurea");
				document.modulo.laurea.focus();
				return false;
			}
			//Effettua il controllo sul campo DATA DI NASCITA
			else if (document.modulo.nascita.value.substring(2, 3) != "/"
					|| document.modulo.nascita.value.substring(5, 6) != "/"
					|| isNaN(document.modulo.nascita.value.substring(0, 2))
					|| isNaN(document.modulo.nascita.value.substring(3, 5))
					|| isNaN(document.modulo.nascita.value.substring(6, 10))) {
				alert("Inserire nascita in formato gg/mm/aaaa");
				document.modulo.nascita.value = "";
				document.modulo.nascita.focus();
				return false;
			} else if (document.modulo.nascita.value.substring(0, 2) > 31) {
				alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
				document.modulo.nascita.select();
				return false;
			} else if (document.modulo.nascita.value.substring(3, 5) > 12) {
				alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
				document.modulo.nascita.value = "";
				document.modulo.nascita.focus();
				return false;
			} else if (document.modulo.nascita.value.substring(6, 10) < 1900) {
				alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
				document.modulo.nascita.value = "";
				document.modulo.nascita.focus();
				return false;
			} else if (document.modulo.nascita.value.substring(6, 10) > 1999) {
				alert("Impossibile utilizzare un valore superiore all'anno 1999");
				document.modulo.nascita.value = "";
				document.modulo.nascita.focus();
				return false;
			}
			//Effettua il controllo sul campo TELEFONO
			else if ((isNaN(telefono)) || x.substring(0, 1) == "-"
					|| x.substring(0, 1) == " ") {
				alert("Il campo Telefono � numerico ed obbligatorio.");
				document.modulo.telefono.value = "";
				document.modulo.telefono.focus();
				return false;
			} else if (!email_reg_studente != email.substring(last_index_email,
					email_length)
					|| email_reg_tutorAccademico != email.substring(
							last_index_email, email_length)) {
				alert("Inserire un indirizzo email corretto.");
				document.modulo.email.select();
				return false;
			} else {
				document.modulo.action = "./registrazione";
				document.modulo.submit();
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