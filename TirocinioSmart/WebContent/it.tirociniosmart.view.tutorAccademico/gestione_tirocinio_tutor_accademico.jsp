<%@ page import="it.tirociniosmart.model.tirocinio.Tirocinio, it.tirociniosmart.model.utente.TutorAccademico" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</head>

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<%@ include file="header_tutor_accademico.jsp"%>

	<!-- AGGIUNGERE CODICE DA QUI -->
	<% 	Tirocinio t = (Tirocinio) request.getSession().getAttribute("tirocinio");
		if(t == null){
		TutorAccademico ta=new TutorAccademico("","","NOME","COGNOME","","","","","","","","","");
		t=new Tirocinio("NOME", "OBIETTIVI", "DESCRIZIONE", 0, ta, "SEDE", "TIPO", "RESPONSABILE");
		}
	%>
	<div class="wrap-slider">
            <div class="container page-container">
                <div class="page-content">
                    <div class="page-title">
                        <h1 style="color: #ffbf43"><%=t.getNome()%></h1>
                    </div><!-- page-title -->
                </div>
            </div><!-- container -->
        </div><!-- wrap-slider -->

        <!-- Details -->
        <section class="flat-row bg-theme pd-top-100 pd-bottom-no">
            <div class="container">
                <div class="row">
                    <div class="col-md-9 col-sm-8 wrap-reponsive">
                        <div class="wrap-course-details">
                            <div class="portfolio">
                                <article class="entry">
                                    <div class="entry-post">
                                        <div class="row">
                                            <div class="col-md-9">
                                                <div class="wrap-entry">
                                                    <div class="entry-categories">
                                                        <span><a href="#"><%=t.getTipo() %></a></span>
                                                    </div>
                                                    <h3 class="entry-title"><a href="#"><%=t.getNome()%></a></h3>
                                                    <div class="entry-author">
                                                        <span>by <a href="#"><%=t.getTutor().getNome()%><%=t.getTutor().getCognome() %></a></span>
                                                    </div>
                                                </div><!-- wrap-entry -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="dividers h58">
                                                    
                                                </div>
                                                <div class="entry-number">
                                                    <div class="entry-count">
                                                        NUMERO POSTI:<span class="count"> <%=t.getNumPost()%></span>
                                                    </div>
                                                    <div class="entry-price color-green">
                                                        DISPONIBILITA':<span class="price"> <%=t.getStato()%></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- entry-post -->
                                </article>
                               
                            </div>
                            <div class="course-text">
                                <h3 class="course-title-text">
                                   DESCRIZIONE TIROCINIO
                                </h3>
                                <p><%=t.getDescrizione() %></p>
                            </div>
                            <div class="course-testimonials">
                            </div>
                            <div class="course-text content2">
                                <h3 class="course-title-text">
                                    OBIETTIVI
                                </h3>
                                <p><%=t.getObiettivi() %></p>
                            </div>
                            <div class="course-text content2">
                                <h3 class="course-title-text">
                                    DOVE SI SVOLGE?
                                </h3>
                                <p><%=t.getSede() %></p>
                            </div>
                        </div>>
                    </div><!-- col-md-9 -->
                    <div class="col-md-3 col-sm-4 wrap-overflow">
                        <div class="sidebar">
                            <div class="widget widget-button">
                                <p class="button-free">DISPONIBILE</p>
                                <div class="wrap-btn">
                                    <a class="flat-btn" href="#">INVIA RICHIESTA</a>
                                </div>
                            </div>
                            <div class="widget widget-teacher">
                                <h3 class="widget-title">TUTOR ACCADEMICO</h3>
                                <div class="flat-teammember">
                                    <div class="team-image">
                                        <img alt="image" src="../img/fferrucci.jpg">
                                    </div>
                                    <div class="profile">
                                        <h6 class="name"><a href="#">FILOMENA FERRUCCI</a></h6>
                                    </div>
                                    <ul class="flat-socials">
                                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div><!-- flat-teammember -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
	<!-- A QUI -->

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