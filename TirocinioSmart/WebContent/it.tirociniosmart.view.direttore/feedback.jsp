<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<%@ include file="header_direttore.jsp"%>
   
</head>
<%@ page language="java" import="java.sql.*,java.util.*"%>
<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>


	<!-- AGGIUNGERE CODICE DA QUI -->
	<!-- Quality-->
	 <div class="container">
        <div class="row ">
            <div class="col-md-12">
                <div class="title-section color-title">
                    <h1 class="title">
                        ANDAMENTO <span class="color-orange">TIROCINI</span> 
                    </h1>
                    
                    <section class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
          
                      <!-- Feedback-->
                      <div class="container">
                       <div class="row col-md-12"  style="height: 300px; top: -100px">
                        <div style="margin-top: 10%;">
                            <div class="authen-img" style="height: 20%;margin: 0 10% 0 10%;text-align:  -webkit-center;">
                
                                 <table class="my_table_studente">
                                     <tr>
                                        <td style="font-size:50px"><p><b class="color-orange">100%</b></p> 
                                        </td>
                                        </tr>     
                                  </table>
                                  <div class="authen-img" style="margin-top:10%">
                                <!-- <img src="../images/smile_triste.png"  alt="your_image" style="width:20%">-->
                                 <img src="../images/smile_felice.png"  alt="your_image" style="width:20%">
                                 </div>
                                  
                            </div>
                            
                
                        <div>
                     
                     </div>
            </div>          
     </div>
                    
                    </div>
                    </section>
   </div>
  </div>
 </div>
	<!-- A QUI -->

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