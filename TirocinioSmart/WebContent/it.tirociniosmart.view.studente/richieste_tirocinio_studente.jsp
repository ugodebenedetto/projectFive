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

<style type="text/css">
.wrap-btn {
	float: right;
}

@media only screen and (max-device-width : 667px) {
	.wrap-btn {
		float: none;
		margin-bottom: 20px;
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

	<!-- RICHIESTE TIROCINIO -->
	<section class="flat-row bg-theme pd-top-100 ">
	<div class="container">
		<div class="row">
			<div
				class="col-md-9 col-sm-8 portfolio-reponsive portfolio-reponsive2"
				style="width: 100%">
				<div class="portfolio style4">

					<!-- 1° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
							<!-- IMPLEMENTARE LA FORM -->
							<form id="formCancellaRichiesta" method="post" action="">
								<div class="wrap-btn">
									<input type="submit" name="dati" value="Invia"
										id="submitCancellaRichiesta" style="display: none"> <label
										for="submitCancellaRichiesta" class="flat-btn"
										style="margin: 0 auto; padding: 10px 20px;">CANCELLA RICHIESTA</label>
								</div>
							</form>
						</div>
						<div class="entry-categories">
							<span><a href="#">CATEGORIA</a></span>
						</div>
						<h3 class="entry-title">
							<a href="#">TITOLO</a>
						</h3>
						<div class="entry-author">
							<span>di <a href="#">Nome Cognome</a></span>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								RICHIESTA: <span class="count"> x/100</span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>

					<!-- 2° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
                            <!-- IMPLEMENTARE LA FORM -->
                            <form id="formCancellaRichiesta" method="post" action="">
                                <div class="wrap-btn">
                                    <input type="submit" name="dati" value="Invia"
                                        id="submitCancellaRichiesta" style="display: none"> <label
                                        for="submitCancellaRichiesta" class="flat-btn"
                                        style="margin: 0 auto; padding: 10px 20px;">CANCELLA RICHIESTA</label>
                                </div>
                            </form>
						</div>
						<div class="entry-categories">
							<span><a href="#">CATEGORIA</a></span>
						</div>
						<h3 class="entry-title">
							<a href="#">TITOLO</a>
						</h3>
						<div class="entry-author">
							<span>di <a href="#">Nome Cognome</a></span>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								RICHIESTA: <span class="count"> y/150</span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>

					<!-- 3° -->
					<article class="entry">
					<div class="entry-post">
						<div class="wrap-btn">
                            <!-- IMPLEMENTARE LA FORM -->
                            <form id="formCancellaRichiesta" method="post" action="">
                                <div class="wrap-btn">
                                    <input type="submit" name="dati" value="Invia"
                                        id="submitCancellaRichiesta" style="display: none"> <label
                                        for="submitCancellaRichiesta" class="flat-btn"
                                        style="margin: 0 auto; padding: 10px 20px;">CANCELLA RICHIESTA</label>
                                </div>
                            </form>
						</div>
						<div class="entry-categories">
							<span><a href="#">CATEGORIA</a></span>
						</div>
						<h3 class="entry-title">
							<a href="#">TITOLO</a>
						</h3>
						<div class="entry-author">
							<span>di <a href="#">Nome Cognome</a></span>
						</div>
						<div class="entry-number">
							<div class="entry-count">
								RICHIESTA: <span class="count"> z/180</span>
								<!-- INSERIRE NUMERO POSTI DISPONIBILI -->
							</div>
						</div>
					</div>
					<!-- entry-post --> </article>

				</div>
				<div class="row">
					<div class="dividers h79"></div>
					<!-- dividers flat30 -->
				</div>
			</div>
			<!-- portfolio -->
		</div>
	</div>
	</section>

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