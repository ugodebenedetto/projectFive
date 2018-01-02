<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
  String nome = request.getParameter("nome");
  String cognome = request.getParameter("cognome");
  String matricola =request.getParameter("matricola");
  String data = request.getParameter("data");
  String nomeTirocinio = request.getParameter("nomeT");
  String tutor = request.getParameter("tutor");
  String stato = request.getParameter("stato");
  
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
.index2 {
	width: 25%;
}

.my_table_studente {
	margin-left: 35%;
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

	<%@ include file="header_didattica.jsp"%>

	<!-- AGGIUNGERE CODICE DA QUI -->
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row col-md-6"
			style="border-right: 1px solid #ffbf43; height: 300px; top: -100px;">
			<div style="margin-top: 10%;">
				<div class="authen-img" style="height: 20%">
					<div id="profilo">
						<a href="#"><img class="index2" src="../images/aboutus/1.jpg"
							alt="your_image"
							style="position: relative; top: -20px; border-radius: 50%; float: left;">
						</a>
					</div>
					<table class="my_table_studente">
						<tr>
							<td><label><%=nome %> <%=cognome %></label></td>
						</tr>
						<tr>
							<td><label><%=data %></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;"><%=matricola %></label></td>
						</tr>
					</table>
				</div>
			</div>


		</div>


		<div class="row col-md-6" style="height: 300px; top: -100px;">
			<div style="margin-top: 10%;">
				<div class="authen-img" style="height: 20%">

					<table class="my_table_studente">
						<tr>
							<td><label>TIROCINIO: <%=nomeTirocinio %></label></td>
						</tr>
						<tr>
							<td><label>PROFESSORE: <%=tutor %></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;">STATO RICHIESTA: </label><label style="margin-top: 20px; color: #ffbf43"> <%=stato %>
							</label></td>

						</tr>


					</table>
				</div>

				<div></div>
			</div>
		</div>
	</div>
	</section>

	<!-- Gestione moduli -->
	<table class="my_table_studente">
		<tr>
			<td>
				<div class="wrap-btn">
					<input type="file" id="img" name="image" value=""
						required="required" placeholder="">
				</div>
			</td>
			<td><div class="wrap-btn">
					<button class="flat-btn" type="button">Carica</button>
				</div></td>
		</tr>
	</table>
	<div class="container">
		<div class="table-body">
			<table class="table">
				<thead>
					<tr>
						<th>NOME FILE</th>
						<th></th>


					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Progetto formativo</td>
						<td>
							<div class="wrap-btn">
								<a class="flat-btn" href="visualizza_studente.jsp"
									style="padding: 10px 20px">Scarica</a>
							</div>
						</td>

					</tr>
					<tr>
						<td>Registro Ore</td>
						<td>
							<div class="wrap-btn">
								<a class="flat-btn" href="visualizza_studente.jsp"
									style="padding: 10px 20px">Scarica</a>
							</div>
						</td>

					</tr>
					<tr>
						<td>Progetto formativo firmato</td>
						<td>
							<div class="wrap-btn">
								<a class="flat-btn" href="visualizza_studente.jsp"
									style="padding: 10px 20px">Scarica</a>
							</div>
						</td>

					</tr>
					<tr>
						<td>Registro Ore firamto</td>
						<td>
							<div class="wrap-btn">
								<a class="flat-btn" href="visualizza_studente.jsp"
									style="padding: 10px 20px">Scarica</a>
							</div>
						</td>

					</tr>
					<tr>
						<td>Valutazione</td>
						<td>
							<div class="wrap-btn">
								<a class="flat-btn" href="visualizza_studente.jsp"
									style="padding: 10px 20px">Scarica</a>
							</div>
						</td>

					</tr>

				</tbody>
			</table>
		</div>
	</div>
	<!-- container-->

	<!-- A QUI -->

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>

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