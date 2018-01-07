<%@ page import="it.tirociniosmart.model.utente.TutorAccademico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% 	TutorAccademico ta_header = (TutorAccademico) request.getSession().getAttribute("ta");
	if(ta_header==null){
	  ta_header=new TutorAccademico("MAIL","CODICEFISCALE","NOME","COGNOME","","","","","","","TELEFONO","","");
	}
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
@media only screen and (max-device-width : 479px) {
    #my_nav_bar {
        margin: 0 auto;
        padding: 0;
    }
}

@media only screen and (max-device-width : 767px) {
    #div_col-md-4 {
        padding: 10px;
    }
    #my_nav_bar a {
        font-size: 16px;
    }
}
</style>

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
                            <div class="wrap-flat" id="div_col-md-4">
                                <ul class="flat-login-register">
                                    <li id="my_nav_bar"><a href="../logout">Logout</a></li>
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
				
				<div class="myHeaderClass">
					<!-- /logo -->
					<div class="flat-search">
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
							<a href="./VisualizzaListaTirocini">I MIEI
									TIROCINI</a>
								<ul class="submenu">
									<li><a href="aggiungi_tirocinio.jsp">Aggiungi Tirocinio</a></li>
									<li class="menu"><a href="./VisualizzaRichiestaTirocinio">Richieste
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