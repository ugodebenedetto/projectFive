<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
										<span>Tel:</span> 089-96-96-00
									</p></li>
								<li><p>
										<span>E-mail:</span>ads@unisa.it
									<p></li>
							</ul>
						</div>
						<!-- col-md-8 -->
						<div class="col-md-4">
							<div class="wrap-flat">
								<ul class="flat-login-register">
									<li><a href="../logout">Logout</a></li>
									
									<!-- E' A PRIORITA' BASSA ... SE C'E' TEMPO LA SI IMPLEMENTA -->
									
                                    <!-- <li><a href="../it.tirociniosmart.view.utente/richiesta_supporto.jsp">Aiuto</a></li> --> 
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
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
				<!-- MY DIV -->
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
							<li class="active"><a href="home_studente.jsp" title="">HOME</a></li>
							<li><a href="offerta_formativa_studente.jsp" title="">OFFERTA
									FORMATIVA</a></li>
							<li><a href="tirocinio_studente.jsp" title="">IL TUO
									TIROCINIO</a>
								<ul class="submenu">
									<li><a href="richieste_tirocinio_studente.jsp">Visualizza
											Richieste</a></li>
									<li><a href="visualizza_moduli.jsp">Gestione Moduli</a></li>
								</ul></li>
							<li><a href="info_account_studente.jsp" title="">IL MIO
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
					</div>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- /header -->

</body>
</html>