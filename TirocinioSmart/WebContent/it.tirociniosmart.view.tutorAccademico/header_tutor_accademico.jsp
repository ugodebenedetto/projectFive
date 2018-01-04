<%@page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%

//codice di prova (DA CANCELLARE)

//TutorAccademico ta1 = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");

TutorAccademico ta = new TutorAccademico("email", "codicefiscale", "nome", "cognome",
				"luogodinascita", "01/02/02", "password", "m", "residenza", "via", 
				"telefono", "dipartimento", "coddocente");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Box header -->
	<div class="boxed position_form position_style3 ">
		<div class="wrap-header">
			<div class="top top-style3">
				<div class="container">
					<div class="row">
						<div class="col-md-8">
							<ul class="flat-information">
								<li>Lun - Ven: 8.00 - 18:00</li>
								<li><p>
										<span>Tel:</span> <%=ta.getTelefono()%>
									</p></li>
								<li><p>
										<span>E-mail:</span><%=ta.getEmail() %>
									<p></li>
							</ul>
						</div>
						<!-- col-md-8 -->
						<div class="col-md-4">
							<div class="wrap-flat">
								<ul class="flat-login-register">
									<li><a href="login.jsp">Login</a></li>
									<li><a href="registrazione.jsp">Registrazione</a></li>
									<li><a href="richiesta_supporto.jsp">Aiuto</a></li>
								</ul>
							</div>
							<!-- wrap-flat -->
						</div>
						<!-- col-md-4 -->
					</div>
					<!-- row -->
				</div>
				<!-- container -->
			</div>
			<!-- top -->
		</div>
	</div>

	<header id="header" class="header header-style3 styleheader">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="logo">
					<a href="http://www.di.unisa.it/"><img
						src="../img/dipStuSalernoInf.png" alt="dipInf"></a>
				</div>
				
				<div class="myHeaderClass">
					<!-- /logo -->
					<div class="flat-search">
						<ul>
							<li class="show-search"><a href="#"><i
									class="lnr lnr-magnifier"></i></a></li>
						</ul>
						<div class="btn-menu">
							<span></span>
						</div>
						<!-- //mobile menu button -->
					</div>
					<!-- /wrap-search -->
					<div class="wrap-nav">
						<nav id="mainnav" class="mainnav">
						<ul class="menu">
							<li><a href="home_tutor_accademico.jsp"
								title="">HOME</a></li>
							<li>
							<a href="i_miei_tirocini.jsp">I MIEI
									TIROCINI</a>
								<ul class="submenu">
									<li><a href="aggiungi_tirocinio.jsp">Aggiungi Tirocinio</a></li>
									<li class="menu"><a href="richieste_tirocinio_tutor_accademico.jsp">Richieste
											Tirocinio</a></li>
								</ul></li>
							<li>
							<a href="./VisualizzaInfoTirocini" title="">I MIEI
									TIROCINANTI</a>
							</li> 
							<li><a href="account_tutor_accademico.jsp" title="">IL MIO
									PROFILO</a></li>
						</ul>
						</nav>

						<div class="top-search">
							<form action="#" id="searchform-all" method="get">
								<div>
									<input type="text" id="s" class="sss" placeholder="Search...">
									<input type="submit" value="&#xf002;" id="searchsubmit">
								</div>
							</form>
						</div>
						<!-- /top-search -->
					</div>
					<!-- /wrap-nav -->
				</div>
			</div>
			<!-- /col-md-12 -->
		</div>
		<!-- /row -->
	</div>
	<!-- /container --> </header>
	<!-- /header -->

</body>
</html>