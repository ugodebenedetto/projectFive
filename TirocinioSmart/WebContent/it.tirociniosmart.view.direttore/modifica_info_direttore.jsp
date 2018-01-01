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
<link href="${pageContext.request.contextPath}/images/icon/icon.png" rel="shortcut icon">

<style type="text/css">
.index2 {
    width: 20%;
    float: left;
    margin-right: 10%;
}

.my_table_studente {
    margin-left: 25%;
}

.my_table_studente th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
}

.my_table_studente td {
    padding: 8px;
}

.my_table_studente1 td {
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
    background-color: #4CAF50;
    color: white;
}

.flat-row {
    padding: 0px 0px 100px 0px;
}

@media only screen and (max-device-width : 667px) {
    .index2 {
        width: 70%;
        float: none;
        display: block;
        margin: 0 auto 15% auto;
    }
    .my_table_studente {
        margin: 0 auto;
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

	<%@ include file="header_direttore.jsp"%>

	<!-- AGGIUNGERE CODICE DA QUI -->
	<section
        class="flat-row bg-theme pd-top-100 pd-bottom-94 authentication">
    <div class="container">
        <div class="row">
            <div class="col-md-6" style="width: 100%">
                <div class="authen-img" style="height: 20%">
                    <table class="my_table_studente">
                        <tr>
                            <td><label>NOME</label></td>
                            <td><input type="text" id="name" name="nome" value=""
                                maxlength="20" min="3" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>COGNOME</label></td>
                            <td><input type="text" id="name" name="cognome" value=""
                                maxlength="20" min="3" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>DATA DI NASCITA</label></td>
                            <td><input type="date" id="name" name="dataNascita" value=""
                                required="required"></td>
                        </tr>
                        
                        <a href="#"><img class="index2" src="../images/aboutus/1.jpg"
                            alt="your_image"
                            style="position: inherit; top: 0; border-radius: 50%;"> </a>
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
                    <table class="my_table_studente1" style="width: 100%">
                        <tr>
                            <td style="width: 40%"><label>EMAIL</label></td>
                            <td><input type="email" id="email" name="email" value=""
                                maxlength="20" min="3" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>C.F.</label></td>
                            <td><input type="text" id="name" name="codiceFiscale"
                                value="" maxlength="16" min="16" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>LUOGO NASCITA.</label></td>
                            <td><input type="text" id="name" name="luogoNascita"
                                value="" maxlength="40" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>SESSO.</label></td>
                            <td><input type="radio" id="M" name="sesso" value="Maschio"
                                required="required" checked="checked"> <label for="M">Maschio</label>
                                <input type="radio" id="F" name="sesso" value="Femmina"
                                required="required" style="margin-left: 5%"> <label
                                for="F">Femmina</label></td>
                        </tr>
                        <tr>
                            <td><label>RESIDENZA.</label></td>
                            <td><input type="text" id="name" name="residenza" value=""
                                maxlength="40" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>VIA.</label></td>
                            <td><input type="text" id="name" name="via" value=""
                                maxlength="40" required="required"></td>
                        </tr>
                        <tr>
                            <td><label>TELEFONO.</label></td>
                            <td><input type="text" id="phone" name="telefono" value=""
                                maxlength="10" min="10" required="required"></td>
                        </tr>
                    </table>
                    <!-- COMPILARE LA FORM -->
                    <form method="POST">
                        <div class="wrap-btn" style="display: grid;">
                            <input type="submit" name="dati" value="Invia"
                                id="submitRegistration" style="display: none"> <label
                                for="submitRegistration" class="flat-btn"
                                style="margin: 5% auto 0 auto;">MODIFICA</label>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </section>
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