<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
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

<style type="text/css">
.index2 {
	width: 20%;
}

.my_table_studente1 td, th {
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
	color: white;
	background: #6f787f;
}

.flat-row {
	padding: 0px 0px 100px 0px;
}

#idModificaInformazioni {
	color: white;
}

a#idModificaInformazioni:hover {
	color: #ffbf43;
}

#idModificaInformazioni {
	float: right;
}

@media only screen and (max-device-width : 667px) {
	.index2 {
		width: 30%;
	}
	.my_table_studente {
		margin-left: 35%;
	}
}

@media only screen and (max-device-width : 442px) {
	#idModificaInformazioni {
		margin: 0 auto;
		text-align: center;
		display: block;
		float: none;
	}
	img#idModificaInformazioni {
		margin: 2% auto;
		display: grid;
		float: none;
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

	<!-- INFO ACCOUNT STUDENTE -->
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="authen-img" style="height: 20%">
					<table class="my_table_studente">
						<tr>
							<td><label><%=tutor.getNome()%> <%=tutor.getCognome()%></label></td>
						</tr>
						<tr>
							<td><label><%=tutor.getDataNascita()%></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;"><%=tutor.getCodiceDocente()%></label></td>
						</tr>
						<a href="#"><img class="index2" src="../img/profilo.png"
							alt="your_image"
							style="position: inherit; top: 0; border-radius: 50%; float: left;">
						</a>
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
					<table class="my_table_studente1"
						style="width: 98%; margin: 0 auto;">
						<tr>
							<th></th>
							<th><a href="modifica_info_tutor_accademico.jsp"
								id="idModificaInformazioni">MODIFICA INFORMAZIONI<img
									alt="modifica" src="../img/gear.png"
									style="width: 30px; height: 30px; margin: 0 20px 10px 10px;">
							</a></th>
						</tr>
						<tr>
							<td style="width: 40%"><label>EMAIL</label></td>
							<td><label><%=tutor.getEmail()%></label></td>
						</tr>
						<tr>
							<td><label>C.F.</label></td>
							<td><label><%=tutor.getCodiceFiscale()%></label></td>
						</tr>
						<tr>
							<td><label>DIPARTIMENTO</label></td>
							<td><label><%=tutor.getDipartimento()%></label></td>
						</tr>
						<tr>
							<td><label>LUOGO NASCITA.</label></td>
							<td><label><%=tutor.getLuogoNascita()%></label></td>
						</tr>
						<tr>
							<td><label>SESSO.</label></td>
							<td><label><%=tutor.getSesso()%></label></td>
						</tr>
						<tr>
							<td><label>RESIDENZA.</label></td>
							<td><label><%=tutor.getResidenza()%></label></td>
						</tr>
						<tr>
							<td><label>VIA.</label></td>
							<td><label><%=tutor.getVia()%></label></td>
						</tr>
						<tr>
							<td><label>TELEFONO.</label></td>
							<td><label><%=tutor.getTelefono()%></label></td>
						</tr>
					</table>
				</div>
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