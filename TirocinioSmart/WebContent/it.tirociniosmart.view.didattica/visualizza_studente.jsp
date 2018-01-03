<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
  String nome = request.getParameter("nome");
  String cognome = request.getParameter("cognome");
  String matricola = request.getParameter("matricola");
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
    width: 20%;
}

.my_table_didattica td, th {
    border: 1px dashed #ffbf43;
    padding: 8px;
}

.my_table_didattica tr:nth-child(even) {
    background-color: #fff1d6;
}

.my_table_didattica tr:hover {
    background-color: #ddd;
}

.my_table_didattica th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    color: white;
    background: #ffbf43;
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

	<%@ include file="header_didattica.jsp"%>

	<!-- AGGIUNGERE CODICE DA QUI -->
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row col-md-6">
			<div style="margin-top: 10%;">
				<div class="authen-img" style="height: 20%">
					<div id="profilo">
						<a href="#"><img class="index2" src="../img/profilo.png"
                            alt="your_image"
                            style="position: inherit; top: 0; border-radius: 50%; float: left;">
						</a>
					</div>
					<table class="my_table_studente">
						<tr>
							<td><label><%=nome%> <%=cognome%></label></td>
						</tr>
						<tr>
							<td><label><%=data%></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;"><%=matricola%></label></td>
						</tr>
					</table>
				</div>
			</div>


		</div>


		<div class="row col-md-6" >
			<div style="margin-top: 10%;">
				<div class="authen-img" style="height: 20%">

					<table class="my_table_studente">
						<tr>
							<td><label>TIROCINIO: <%=nomeTirocinio%></label></td>
						</tr>
						<tr>
							<td><label>PROFESSORE: <%=tutor%></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;">STATO
									RICHIESTA: </label><label style="margin-top: 20px; color: #ffbf43">
									<%=stato%>
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

	<div class="container">
							<form action="./ValutaTirocinio" method="post"
								enctype="multipart/form-data">
								<div class="row" style="display: inline;">
									<!-- FILE -->
									<div class="col-md-6" style="margin-bottom: 10%;  margin-top: 5%;">
									<table class="my_table_didattica">
									   <th>  Progetto Formativo</th>
									  
									  <tr><td>  <input type="file" name="file1" id="inputFile"
										style="display: inline">  
										<input type="hidden"
										name="matricola" value=<%=matricola%>><input
										type="hidden" name="file" value="file1"></td></tr>
									
										 <th> Registro ore</th>
									 <tr><td> <input type="file" name="file2" id="inputFile"
										style="display: inline"> 
										<input type="hidden" name="matricola" value=<%=matricola%>></td></tr>
										
										
										<th>Valutazione</th>
									<tr><td><input	type="hidden" name="file" value="file2"> <input
										type="file" name="file3" id="inputFile"
										style="display: inline"> 
										<input type="hidden"
										name="matricola" value=<%=matricola%>><input
										type="hidden" name="file" value="file3"></td></tr>
										</table></div>
										
									<!-- UPLOAD -->
									<div class="col-md-6" style="margin-bottom: 10%;  margin-top: 5%;">
									<input type="submit" name="dati" value="Invia"
										id="submitUpload" style="display: none"<%if(!stato.equals("richiestaAccettata")){ %> disabled <%} %>> <label
										for="submitUpload" class="flat-btn bg-color" >UPLOAD</label>
										<br><br>
										(*)Caricare un file alla volta
										</div>
								</div>
							</form>
						
			
	</div>
	<!-- container-->

	<!-- A QUI -->

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>

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