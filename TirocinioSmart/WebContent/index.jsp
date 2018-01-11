<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="img/index.png">

<meta charset="utf-8">
<title>Tirocinio Smart</title>

<meta name="author" content="Claudio Amato">

<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap  -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/bootstrap.css">

<!-- Theme Style -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/style.css">

<!-- Responsive -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/stylesheets/responsive.css">

<!-- REVOLUTION LAYERS STYLES -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="bootstrap/revolution/css/settings.css">

<!-- Favicon and touch icons  -->
<link href="icon/icon.png" rel="shortcut icon">

<style type="text/css">
@media only screen and (max-device-width : 402px) {
	.div_Radio_Register {
		display: grid;
	}
	.div_Radio_Register>.my_wrap-input-name {
		padding-bottom: 10px;
	}
	.wrap-btn>.flat-btn {
		padding: 10px;
	}
	p.my_wrap-input-name {
		padding: 0px;
	}
}

@media only screen and (max-device-width : 375px) {
	#div_my_wrap-input-name_sex {
		display: grid;
		text-align: center;
	}
	.div_my_wrap-input-name>.radio_div>.my_wrap-input-name {
		padding: 0 10px;
	}
	.div_my_wrap-input-name>.my_wrap-input-name {
		font-size: 12px;
	}
}
</style>

</head>

<body>

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
					<div class="sub-title">Team Project: Five</div>
					<a href="it.tirociniosmart.view.utente/homepage.jsp"><img
						alt="logo" src="img/index.png"></a>
				</div>
			</div>
		</div>
	</div>

	<!-- CORPO DELL'INDEX -->
	<section class="flat-row pd-80 flat-register">
	<div class="container">
		<div class="row">
			<!-- DESCRIZIONE LATERALE REGISTRAZIONE -->
			<div class="col-md-7 no-paddingright">
				<div class="wrap-register-right wrap-box pdtopleft">
					<div class="wrap-register-title">
						<div class="title-top">PRENOTA ADESSO IL TUO TIROCINIO</div>
						<div class="title-register">REGISTRATI ORA</div>
						<div class="sub-title-register">Crea un account e accedi
							immediatamente ai corsi online.</div>
					</div>
				</div>
			</div>

			<div class="col-md-5">

				<!-- RADIO BUTTON REGISTRAZIONE Studente o TutorAccademico -->
				<div class="div_Radio_Register" style="margin-bottom: 10%">
					<p class="my_wrap-input-name">
						<input type="radio" id="Studente" name="tipo" value="studente"
							required="required" checked="checked"> <label
							for="Studente">Studente</label>
					</p>
					<p class="my_wrap-input-name">
						<input type="radio" id="TA" name="tipo" value="tutorAccademico"
							required="required"> <label for="TA">TutorAccademico</label>
					</p>
				</div>

				<!-- DIV REGISTRAZIONE DI STUDENTE -->
				<div id="divRegistrazioneStudente">

					<!-- FORM REGISTRAZIONE STUDENTE -->
					<form action="./it.tirociniosmart.view.utente/Registrazione"
						method="post" id="form-register" name="modulo"
						class="form-register">
						<div class="form-register-title">
							<h3 class="register-title">
								CREA UN ACCOUNT<br> <i class="wrap-box ispace7"></i>STUDENTE
							</h3>
						</div>
						<div class="info-register">
							<input type="hidden" name="tipo" value="studente">
							<div class="info-register">
								<input type="hidden" name="tipo" value="studente">
								<p class="wrap-input-name">
									<input type="text" id="nome" name="nome" maxlength="20"
										pattern="[A-Za-z\s]{3,}" title="Inserisci minimo 3 lettere"
										required="required" placeholder="Nome *:">
								</p>
								<p class="wrap-input-name">
									<input type="text" id="name" name="cognome" maxlength="20"
										pattern="[A-Za-z\s]{3,}" title="Inserire minimo 3 lettere"
										required="required" placeholder="Cognome *:">
								</p>
								<p class="wrap-input-name">
									<input type="text" id="name" name="matricola" maxlength="10"
										pattern="[0-9]{10}"
										title="Inserisci correttamente la matricola"
										required="required" placeholder="Matricola *:">
								</p>
								<p class="wrap-input-name">
									<select name="tipoLaurea" required="required">
										<option value="" selected="selected" disabled="disabled">Tipo
											di laurea</option>
										<option value="triennale">Triennale</option>
									</select>
								</p>
								<p class="wrap-input-email">
									<input type="text" id="emailS" name="email"
										onkeyup="validateEmail()" pattern="[A-Za-z0-9._-]{5,}"
										title="Inserire minimo 5 caratteri [Caratteri accettati: A-Z, a-z, 0-9, ._-]"
										maxlength="40" required="required"
										placeholder="prefisso e-mail *:">
								</p>
								<p class="wrap-input-name">
									<input type="password" id="name" name="password"
										pattern="[A-Za-z0-9._-]{8,}"
										title="Inserire minimo 8 caratteri [Caratteri accettati: A-Z, a-z, 0-9, ._-]"
										required="required" maxlength="20" placeholder="Password *:">
								</p>
								<p class="wrap-input-name">
									<input type="password" id="name" name="confermaPassword"
										maxlength="20" pattern="[A-Za-z0-9._-]{8,}"
										onblur="validatePassword()" title="Formato non corretto"
										required="required" placeholder="Conferma Password *:">
								</p>
								<p class="wrap-input-name">
									<input type="text" id="name" name="codiceFiscale"
										maxlength="16" pattern="[A-Za-z0-9]{16}"
										title="Formato non corretto [16 caratteri]"
										required="required" placeholder="C.F. *:">
								</p>
								<p class="wrap-input-name">
									<input type="text" id="name" name="luogoNascita" maxlength="40"
										pattern="[A-Za-z\s]{3,}" required="required"
										title="Inserire minimo 3 lettere"
										placeholder="Luogo di Nascita *:">
								</p>
								<p class="wrap-input-name">
									<input type="date" id="dataS" name="dataNascita"
										onblur="validateDateS()" required="required"
										placeholder="Data di Nascita (gg/mm/aaaa) *:">
								</p>
								<div class="div_my_wrap-input-name"
									id="div_my_wrap-input-name_sex"
									style="margin: 35px auto 25px auto">
									<p>Sesso:</p>
									<div class="radio_div"
										style="display: inline; vertical-align: middle;">
										<p class="my_wrap-input-name">
											<input type="radio" id="M" name="sesso" value="Maschio"
												required="required" checked="checked"> <label
												for="M">Maschio</label>
										</p>
										<p class="my_wrap-input-name">
											<input type="radio" id="F" name="sesso" value="Femmina"
												required="required"> <label for="F">Femmina</label>
										</p>
									</div>
								</div>
								<p class="wrap-input-name">
									<input type="text" id="name" name="residenza" maxlength="40"
										pattern="[A-Za-z\s]{3,}" required="required"
										title="Inserire minimo 3 lettere" placeholder="Residenza *:">
								</p>
								<p class="wrap-input-name">
									<input type="text" id="name" name="via" maxlength="40"
										pattern="via\s+[A-Za-z\s]+,\s+[0-9]{1,}"
										title="Formato corretto: via Roma, 125" required="required"
										placeholder="via Roma, 125*:">
								</p>
								<p class="wrap-input-phone">
									<input type="text" id="phone" name="telefono" maxlength="10"
										pattern="[0-9]{10}" title="Inserire solo numeri [10 cifre]"
										required="required" placeholder="Telefono *:">
								</p>
								<div class="div_my_wrap-input-name" style="display: grid">
									<p class="my_wrap-input-name" style="margin-bottom: 20px">
										<input type="checkbox" id="trattamento_dati" name="privati"
											value="" required="required"> <label
											for="trattamento_dati" style="display: inline;">
											Acconsento al trattamento dei dati privati</label>
									</p>
									<p class="my_wrap-input-name" style="margin-bottom: 20px">
										<input type="checkbox" id="120CFU" name="CFU" value=""
											required="required"> <label for="120CFU"
											style="display: inline;"> Confermo di avere più di
											120 CFU</label>
									</p>
									<p class="my_wrap-input-name" style="margin-bottom: 50px">
										<input type="checkbox" id="legge" name="privati" value=""
											required="required"> <label for="legge"
											style="display: inline;"> Accetti di confermare la
											tua identità altrimenti sei perseguibile penalmente</label>
									</p>
								</div>
								<div class="wrap-btn" style="display: grid;">
									<input type="submit" name="dati" value="Invia"
										id="submitRegistration" style="display: none"> <label
										for="submitRegistration" class="flat-btn"
										style="margin: 0 auto 5% auto">REGISTRATI</label> <input
										type="reset" value="Reset" style="display: none"> <label
										for="submitRegistration" class="flat-btn"
										style="margin: 0 auto">RESET FORM</label>
								</div>
							</div>
						</div>
					</form>
				</div>
				<!-- FINE DIV REGISTRAZIONE STUDENTE -->

				<!-- DIV REGISTRAZIONE DI TUTOR ACCADEMICO -->
				<div id="divRegistrazioneTA" style="display: none;">

					<!-- FORM REGISTRAZIONE TUTOR ACCADEMICO -->
					<form action="./it.tirociniosmart.view.utente/Registrazione"
						method="post" id="form-register" name="modulo2"
						class="form-register">
						<div class="form-register-title">
							<h3 class="register-title">
								CREA UN ACCOUNT<br> <i class="wrap-box ispace7"></i>DOCENTE
							</h3>
						</div>

						<input type="hidden" name="tipo" value="tutorAccademico">
						<div class="info-register">
							<p class="wrap-input-name">
								<input type="text" id="nome2" name="nome" maxlength="20"
									pattern="[A-Za-z\s]{3,}" title="Inserisci minimo 3 lettere"
									required="required" placeholder="Nome *:" autofocus>
							</p>
							<p class="wrap-input-name">
								<input type="text" id="name" name="cognome" maxlength="20"
									pattern="[A-Za-z\s]{3,}" title="Inserire minimo 3 lettere"
									required="required" placeholder="Cognome *:">
							</p>
							<p class="wrap-input-name">
								<input type="text" id="name" name="codiceDocente" maxlength="10"
									pattern="[0-9]{10}"
									title="Inserisci correttamente il codice docente"
									required="required" placeholder="Codice Docente *:">
							</p>
							<p class="wrap-input-name">
								<select name="dipartimento" required="required">
									<option value="dipartimento" selected="selected"
										disabled="disabled">Dipartimento</option>
									<option value="Informatica">Informatica</option>
								</select>
							</p>
							<p class="wrap-input-email">
								<input type="text" id="emailT" name="email"
									onkeyup="validateEmail()" pattern="[A-Za-z0-9._-]{5,}"
									title="Inserire minimo 5 caratteri [Caratteri accettati: A-Z, a-z, 0-9, ._-]"
									maxlength="40" required="required"
									placeholder="prefisso e-mail *:">
							</p>
							<p class="wrap-input-name">
								<input type="password" id="name" name="password"
									pattern="[A-Za-z0-9._-]{8,}"
									title="Inserire minimo 8 caratteri [Caratteri accettati: A-Z, a-z, 0-9, ._-]"
									required="required" maxlength="20" placeholder="Password *:">
							</p>
							<p class="wrap-input-name">
								<input type="password" id="name" name="confermaPassword"
									maxlength="20" pattern="[A-Za-z0-9._-]{8,}"
									onblur="validatePassword()" title="Formato non corretto"
									required="required" placeholder="Conferma Password *:">
							</p>
							<p class="wrap-input-name">
								<input type="text" id="name" name="codiceFiscale" maxlength="16"
									pattern="[A-Za-z0-9]{16}"
									title="Formato non corretto [16 caratteri]" required="required"
									placeholder="C.F. *:">
							</p>
							<p class="wrap-input-name">
								<input type="text" id="name" name="luogoNascita" maxlength="40"
									pattern="[A-Za-z\s]{3,}" required="required"
									title="Inserire minimo 3 lettere"
									placeholder="Luogo di Nascita *:">
							</p>
							<p class="wrap-input-name">
								<input type="date" id="dataT" name="dataNascita"
									onblur="validateDateT()" required="required"
									placeholder="Data di Nascita (gg/mm/aaaa) *:">
							</p>
							<div class="div_my_wrap-input-name"
								id="div_my_wrap-input-name_sex"
								style="margin: 35px auto 25px auto">
								<p>Sesso:</p>
								<div class="radio_div"
									style="display: inline; vertical-align: middle;">
									<p class="my_wrap-input-name">
										<input type="radio" id="TA_M" name="sesso" value="Maschio"
											required="required" checked="checked"> <label
											for="TA_M">Maschio</label>
									</p>
									<p class="my_wrap-input-name">
										<input type="radio" id="TA_F" name="sesso" value="Femmina"
											required="required"> <label for="TA_F">Femmina</label>
									</p>
								</div>
							</div>
							<p class="wrap-input-name">
								<input type="text" id="name" name="residenza" maxlength="40"
									pattern="[A-Za-z\s]{3,}" required="required"
									title="Inserire minimo 3 lettere" placeholder="Residenza *:">
							</p>
							<p class="wrap-input-name">
								<input type="text" id="name" name="via" maxlength="40"
									pattern="via\s+[A-Za-z\s]+,\s+[0-9]{1,}"
									title="Formato corretto: via Roma, 125" required="required"
									placeholder="via Roma, 125*:">
							</p>
							<p class="wrap-input-phone">
								<input type="text" id="phone" name="telefono" maxlength="10"
									pattern="[0-9]{10}" title="Inserire solo numeri [10 cifre]"
									required="required" placeholder="Telefono *:">
							</p>
							<div class="div_my_wrap-input-name" style="display: grid">
								<p class="my_wrap-input-name" style="margin-bottom: 20px">
									<input type="checkbox" id="trattamento_dati_ta" name="privati"
										value="" required="required"> <label
										for="trattamento_dati_ta" style="display: inline;">
										Acconsento al trattamento dei dati privati</label>
								</p>
								<p class="my_wrap-input-name" style="margin-bottom: 50px">
									<input type="checkbox" id="legge_ta" name="privati" value=""
										required="required"> <label for="legge_ta"
										style="display: inline;"> Accetti di confermare la tua
										identità altrimenti sei perseguibile penalmente</label>
								</p>
							</div>
							<div class="wrap-btn" style="display: grid;">
								<input type="submit" name="dati" value="Invia"
									id="submitRegistration2" style="display: none"> <label
									for="submitRegistration2" class="flat-btn"
									style="margin: 0 auto 5% auto">REGISTRATI</label> <input
									type="reset" value="Reset" style="display: none"> <label
									for="submitRegistration" class="flat-btn"
									style="margin: 0 auto">RESET FORM</label>
							</div>
						</div>
					</form>
				</div>
				<!-- FINE DIV REGISTRAZIONE TUTOR ACCADEMICO -->
			</div>

			<!-- DESCRIZIONE LATERALE REGISTRAZIONE -->
			<div class="col-md-7 no-paddingright">
				<div class="wrap-register-right wrap-box pdtopleft">
					<div class="wrap-register-title">
						<div class="title-top">OPPURE...</div>
						<div class="title-register">VAI ALLA HOMEPAGE</div>
						<div class="wrap-btn">
							<a class="flat-btn"
								href="it.tirociniosmart.view.utente/homepage.jsp">HOMEPAGE</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- FOOTER -->
	<%@ include file="footer_folder/footer_index.jsp"%>

	<!-- Javascript -->
	<!-- SCRIPT AJAX -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
		
	</script>
	<script>
		$(document).ready(function() {
			$("#Studente").click(function() {
				$("#divRegistrazioneTA").hide(500);
				$("#divRegistrazioneStudente").show(1000, function() {
					$("#M").prop('checked', true);
					$("#nome").focus();
				});
			});
		});
		$(document).ready(function() {
			$("#TA").click(function() {
				$("#divRegistrazioneStudente").hide(500);
				$("#divRegistrazioneTA").show(1000, function() {
					$("#TA_M").prop('checked', true);
					$("#nome2").focus();
				});

			});
		});
	</script>

	<!-- SCRIPT EMAIL -->
	<script type="text/javascript">
		function validateEmail() {
			var attore = document.getElementsByName("tipo");
			for (var i = 0; i < attore.length; i++) {
				if (attore[i].checked) {
					break;
				}
			}

			if (attore[i].value == "studente") {
				var emailS = document.getElementById("emailS");

				if (emailS.value.includes("@") > 0) {
					alert("Non c'è bisogno di inserire @studenti.unisa.it.");
					emailS.value = emailS.value.substring(0, (emailS.value
							.indexOf("@")));
				}
			} else {
				var emailT = document.getElementById("emailT");
				if (emailT.value.includes("@") > 0) {
					alert("Non c'è bisogno di inserire @unisa.it.");
					emailT.value = emailT.value.substring(0, (emailT.value
							.indexOf("@")));
				}
			}

		}
	</script>

	<!-- SCRIPT CONFERMA PASSWORD -->
	<script type="text/javascript">
		function validatePassword() {
			var attore = document.getElementsByName("tipo");
			for (var i = 0; i < attore.length; i++) {
				if (attore[i].checked) {
					break;
				}
			}
			var pass = document.getElementsByName("password");
			var confPass = document.getElementsByName("confermaPassword");

			if (attore[i].value == "studente") {
				if (pass[0].value != confPass[0].value) {
					alert("Le password non corrispondono");
					confPass[0].value = "";
				}
			} else {
				if (pass[1].value != confPass[1].value) {
					alert("Le password non corrispondono");
					confPass[1].value = "";
				}
			}
		}
	</script>

	<!-- SCRIPT CONTROLLO DATA NASCITA STUDENTE-->
	<script type="text/javascript">
		function validateDateS() {
			var nascitaS = document.getElementById("dataS").value.replace(/-/g,
					"/");

			//Ottieni anno corrente
			var today = new Date();
			var year = today.getFullYear();

			//Effettua il controllo sul campo DATA DI NASCITA
			if (nascitaS.substring(0, 4) < 1950) {
				alert("Impossibile utilizzare un valore inferiore a 1950 per l'anno");
				document.getElementById("dataS").value = "";
			}
			//Controllo per verificare che hai almeno 18 anni e potresti esser iscritto all'università
			//se hai fatto la primina (controllare meglio il mese di nascita per questo)
			else if (nascitaS.substring(0, 4) > (year - 18)) {
				alert("Non puoi essere iscritto all'università");
				document.getElementById("dataS").value = "";
			}
		}
	</script>

	<!-- SCRIPT CONTROLLO DATA NASCITA TUTOR ACCADEMICO-->
	<script type="text/javascript">
		function validateDateT() {
			var nascitaT = document.getElementById("dataT").value.replace(/-/g,
					"/");

			//Ottieni anno corrente
			var today = new Date();
			var year = today.getFullYear();

			//Effettua il controllo sul campo DATA DI NASCITA
			if (nascitaT.substring(0, 4) < 1950) {
				alert("Impossibile utilizzare un valore inferiore a 1950 per l'anno");
				document.getElementById("dataT").value = "";
			}
			//Controllo per verificare che hai almeno 18 anni e potresti esser iscritto all'università
			//se hai fatto la primina (controllare meglio il mese di nascita per questo)
			else if (nascitaT.substring(0, 4) > (year - 18)) {
				alert("Non puoi essere iscritto all'università");
				document.getElementById("dataT").value = "";
			}
		}
	</script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/main.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/countdown.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/imagesloaded.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.isotope.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/owl.carousel.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.easing.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.flexslider.js"></script>

	<!-- Revolution Slider -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/jquery.themepunch.tools.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/slider.js"></script>

	<!-- SLIDER REVOLUTION 5.0 EXTENSIONS  (Load Extensions only on Local File Systems !  The following part can be removed on Server for On Demand Loading) -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.carousel.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.kenburn.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.migration.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.parallax.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/bootstrap/revolution/js/extensions/revolution.extension.video.min.js"></script>
</body>
</html>