<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
    href="../bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
    href="../bootstrap/stylesheets/style.css">

<!-- Responsive -->
<link rel="stylesheet" type="text/css"
    href="../bootstrap/stylesheets/responsive.css">

<!-- REVOLUTION LAYERS STYLES -->
<link rel="stylesheet" type="text/css"
    href="../bootstrap/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
    href="../bootstrap/revolution/css/settings.css">

<!-- Favicon and touch icons  -->
<link href="../images/icon/icon.png" rel="shortcut icon">
</head>
<style>
	#title{
		color: gray;
	}
	#sub-title{
		color: gray;
	}
	.entry{
		height: 550 px ;
	} 
</style>
<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<%@ include file="header_tutor_accademico.jsp"%>		
	<!-- Aggiungere Codice da qui -->
	
	<div class="wrap-slider">
            <div class="container page-container">
                <div class="page-content">
                    <div class="page-title">
                        <h1 id="title">I Miei Tirocini</h1>
                    </div><!-- page-title -->
                </div>
            </div><!-- container -->
        </div><!-- wrap-slider -->
	
	<section class="flat-row bg-theme pd-top-100 authentication">
            <div class="container">
                <div class="select-category">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="showing">
                                <p>Mostra 1-9 di 3 Tirocini</p>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <div class="select-sort">
                                <div class="wrap-select">
                                    <select class="select-field all-select" >
                                        <option value="">Seleziona una categoria</option>
                                        <option value="">Sicurezza</option>
                                        <option value="">Intelligenza Artificiale</option>
                                        <option value="">Database</option>
                                        <option value="">Reti</option>
                                        <option value="">Algoritmi</option>
                                        <option value="">Altri</option>
                                    </select>
                               
                        </div>
                    </div>
                </div>
            </div>
	
	<div class="dividers h49">   
	 </div>
	
	
	  <div class="container">
                <div class="portfolio">
                    <div class="portfolio-wrap clearfix">
                        <div class="item">
                            <article class="entry">
                                <div class="featured-post">
                                    <a href="#"><img src="../img/images.jpg" alt="image"></a>
                                </div>
                                <div class="entry-post">
                                    <div class="entry-categories">
                                        <span><a href="#">Sicurezza</a></span>
                                    </div>
                                    <h3 class="entry-title"><a href="#">Ethical Hacking</a></h3>
                                    <div class="entry-author">
                                        <span>by <a href="account_tutor_accademico.jsp">Filomena Ferrucci</a></span>
                                    </div>
                                    <div class="entry-number">
                                        <div class="entry-price">
                                            Posti Disponibili:<span class="price"> 100</span>
                                        </div>
                                    </div>
                                </div><!-- entry-post -->
                            </article>
                        </div><!-- item -->
                         <div class="item">
                            <article class="entry">
                                <div class="featured-post">
                                    <a href="#"><img src="../img/chappie.jpg" alt="image"></a>
                                </div>
                                <div class="entry-post">
                                    <div class="entry-categories">
                                        <span><a href="#">Intelligenza Artificiale</a></span>
                                    </div>
                                    <h3 class="entry-title"><a href="#">Chappie</a></h3>
                                    <div class="entry-author">
                                        <span>by <a href="account_tutor_accademico.jsp">Filomena Ferrucci</a></span>
                                    </div>
                                    <div class="entry-number">
                                        <div class="entry-price">
                                            Posti Disponibili:<span class="price"> 10</span>
                                        </div>
                                    </div>
                                </div><!-- entry-post -->
                            </article>
                            </div>
                        <div class="item">
                            <article class="entry">
                                <div class="featured-post">
                                    <a href="#"><img src="../img/Genio-scientifico.jpg" alt="image"></a>
                                </div>
                                <div class="entry-post">
                                    <div class="entry-categories">
                                        <span><a href="#">Algoritmi</a></span>
                                    </div>
                                    <h3 class="entry-title"><a href="#">L'amore ai tempi dei numeri Primi</a></h3>
                                    <div class="entry-author">
                                        <span>by <a href="account_tutor_accademico.jsp">Filomena Ferrucci</a></span>
                                    </div>
                                    <div class="entry-number">
                                        <div class="entry-price">
                                            Posti Disponibili:<span class="price"> 20</span>
                                        </div>
                                    </div>
                                </div><!-- entry-post -->
                            </article>
                        </div><!-- item -->
                        <div class="dividers h49">   
           				 </div>
                    </div><!-- portfolio-wrap -->
                </div><!-- portfolio -->
            </div><!-- container-->
            
            
            
            
            
            
	<!-- A qui -->

	
	<!-- FOOTER -->
	<%@ include file="../footer.jsp"%>

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
