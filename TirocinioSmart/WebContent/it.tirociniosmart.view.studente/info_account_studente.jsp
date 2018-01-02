<%@page import="java.io.File"%>
<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  Studente studente1 = (Studente) request.getSession().getAttribute("currentSessionUser");

  Studente studente =
      new Studente("email@email.it", "05121034657", "nome", "cognome", "luogoNascita", "12/12/12",
          "password", "si", "residenza", "via", "telefono", "0512103457", "tipoLaurea");
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
	<%@ include file="header_studente.jsp"%>

	<!-- INFO ACCOUNT STUDENTE -->
	<section
		class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="authen-img" style="height: 20%">
					<table class="my_table_studente">
						<tr>
							<td><label><%=studente.getNome()%> <%=studente.getCognome()%></label></td>
						</tr>
						<tr>
							<td><label><%=studente.getDataNascita()%></label></td>
						</tr>
						<tr>
							<td><label style="margin-top: 20px;"><%=studente.getMatricola()%></label></td>
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
							<th><a href="modifica_account_studente.jsp"
								id="idModificaInformazioni">MODIFICA INFORMAZIONI<img
									alt="modifica" src="../img/gear.png"
									style="width: 30px; height: 30px; margin: 0 20px 10px 10px;">
							</a></th>
						</tr>
						<tr>
							<td style="width: 40%"><label>EMAIL</label></td>
							<td><label><%=studente.getEmail()%></label></td>
						</tr>
						<tr>
							<td><label>C.F.</label></td>
							<td><label><%=studente.getCodiceFiscale()%></label></td>
						</tr>
						<tr>
							<td><label>TIPO DI LAUREA.</label></td>
							<td><label><%=studente.getTipoLaurea()%></label></td>
						</tr>
						<tr>
							<td><label>LUOGO NASCITA.</label></td>
							<td><label><%=studente.getLuogoNascita()%></label></td>
						</tr>
						<tr>
							<td><label>SESSO.</label></td>
							<td><label><%=studente.getSesso()%></label></td>
						</tr>
						<tr>
							<td><label>RESIDENZA.</label></td>
							<td><label><%=studente.getResidenza()%></label></td>
						</tr>
						<tr>
							<td><label>VIA.</label></td>
							<td><label><%=studente.getVia()%></label></td>
						</tr>
						<tr>
							<td><label>TELEFONO.</label></td>
							<td><label><%=studente.getTelefono()%></label></td>
						</tr>
					</table>
				</div>


				<!-- GESTIONE MODULI PER UGO -->
				<%
      String URL_WORKSPACE =
          "/Users/ugodebenedetto/eclipse-workspace/IsProjectClaudioLocale10/WebContent/UsersFiles/files/";
      String pathFile =
          URL_WORKSPACE + studente.getMatricola();
      boolean flag = false;
      boolean flag1 = false;
      boolean flag2 = false;
      boolean flag3 = false;

      File cartella = new File(pathFile);
      File[] list = cartella.listFiles();
      if(list!= null){
        flag = true;
        for(File f: list){
          if(f.getName().equals("Progetto Formativo.pdf")){
            flag1 = true;
          }
          if(f.getName().equals("Registro Ore.pdf")){
            flag2 = true;
          }
          if(f.getName().equals("Valutazione.pdf")){
            flag3 = true;
          }
        }
      }
       
    %>
				<div class="subscribe-contact wrap-box pdfull"
					style="padding-top: 10px;">
					<table class="my_table_studente1"
						style="width: 98%; margin: 0 auto;">
						<thead>
							<tr>
								<th style="padding: 8px;">NOME FILE</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Progetto formativo</td>
								<td style="text-align: center;">
									<div class="wrap-btn">
										<a class="flat-btn"  <%if (flag && flag1){ %>href="${pageContext.request.contextPath}/UsersFiles/files/<%=studente.getMatricola() %>/Progetto Formativo.pdf" target="about_blank" <%} else { %> href="#"<%} %>
											style="padding: 10px 20px">Scarica</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>Registro Ore</td>
								<td style="text-align: center;">
									<div class="wrap-btn">
                                        <a class="flat-btn"  <%if (flag && flag2){ %>href="${pageContext.request.contextPath}/UsersFiles/files/<%=studente.getMatricola() %>/Registro Ore.pdf" target="about_blank" <%} else { %> href="#"<%} %>
											style="padding: 10px 20px">Scarica</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>Valutazione</td>
								<td style="text-align: center;">
									<div class="wrap-btn">
                                        <a class="flat-btn"  <%if (flag && flag3){ %>href="${pageContext.request.contextPath}/UsersFiles/files/<%=studente.getMatricola() %>/Valutazione.pdf" target="about_blank" <%} else { %> href="#"<%} %>
											style="padding: 10px 20px">Scarica</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</section>

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