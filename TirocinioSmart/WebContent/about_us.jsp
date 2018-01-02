<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Tirocinio Smart</title>

<meta name="author" content="Clara Monaco">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<!-- BOX HEADER -->
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
						<div class="col-md-4">
							<div class="wrap-flat">
								<ul class="flat-login-register">
									<li><a href="it.tirociniosmart.view.utente/login.jsp">Login</a></li>
									<li><a
										href="it.tirociniosmart.view.utente/registrazione.jsp">Registrazione</a></li>

									<!-- E' A PRIORITA' BASSA ... SE C'E' TEMPO LA SI IMPLEMENTA -->
									<!-- <li><a href="richiesta_supporto.jsp">Aiuto</a></li> -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- TITOLO E ICONA -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="title-section">
					<img
						alt="Università degli Studi di Salerno, Dipartimento Informatica"
						src="img/dipStuSalernoInf.png" style="margin-bottom: 5%">
					<h1 class="title">TIROCINIO SMART</h1>
					<div class="sub-title" style="color:#ffbf43">Team Project: Five</div>
					<a href="it.tirociniosmart.view.utente/homepage.jsp"><img
						alt="logo" src="img/index.png"></a>
				</div>
			</div>
			
			<div class="about-us style2 wrap-box pdleft">
                               <h1 class="title" style="color:#ffbf43" >
                        ABOUT <span  >US</span> 
                    </h1>
                                <div class="text-about-us">
                                    <p>Il nostro team &egrave; stato incaricato di progettare e sviluppare un progetto volto a migliorare la raccolta,
                                     la condivisione e la gestione delle informazioni relative alle diverse opportunit&agrave; di tirocini per gli studenti e a monitorare tutto il percorso burocratico e formativo del tirocinio del singolo studente. 
                                    
                                    </p>
                                    <p>Quindi il sistema che vogliamo offrire ha come scopo quello di creare per la prima volta una sezione dedicata al processo dei Tirocini.
Ci proponiamo di fornire uno strumento per supportare e promuovere le attivit&agrave; di tirocinio,
 assicurando che tutti gli stakeholder coinvolti interagiscono in modo semplice ed efficiente,
  riducendo il personale necessario e allo stesso tempo evitare che gli studenti ritardino i propri tempi di laurea. 
  </p>
                                </div>
                                
                            </div><!-- About-us -->
		</div>
	</div>

	<!-- FOOTER -->
    <%@ include file="footer_folder/footer_index.jsp"%>

	<!-- Javascript -->
    <script type="text/javascript" src="bootstrap/javascript/jquery.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/javascript/main.js"></script>
    <script type="text/javascript" src="bootstrap/javascript/countdown.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/imagesloaded.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/jquery.isotope.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/owl.carousel.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/jquery.easing.js"></script>
    <script type="text/javascript"
        src="bootstrap/javascript/jquery.flexslider.js"></script>
    <!-- Revolution Slider -->
    <script type="text/javascript"
        src="bootstrap/revolution/js/jquery.themepunch.tools.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/jquery.themepunch.revolution.min.js"></script>
    <script type="text/javascript" src="bootstrap/revolution/js/slider.js"></script>

    <!-- SLIDER REVOLUTION 5.0 EXTENSIONS  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.actions.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.migration.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
    <script type="text/javascript"
        src="bootstrap/revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>
</html>