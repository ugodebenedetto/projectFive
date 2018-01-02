<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
                    <form action="./registrazione" method="post" id="form-register"
                        name="modulo" class="form-register">
                        <div class="form-register-title">
                            <h3 class="register-title">
                                CREA UN ACCOUNT<br> <i class="wrap-box ispace7"></i>STUDENTE
                            </h3>
                        </div>
                        <div class="info-register">
                            <input type="hidden" name="tipo" value="studente">
                            <p class="wrap-input-name">
                                <input type="text" id="nome" name="nome" maxlength="20" min="3"
                                    required="required" placeholder="Nome *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="cognome" maxlength="20"
                                    min="3" required="required" placeholder="Cognome *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="matricola" maxlength="10"
                                    min="10" required="required" placeholder="Matricola *:">
                            </p>
                            <p class="wrap-input-name">
                                <select name="tipoLaurea" required="required">
                                    <option value="" selected="selected" disabled="disabled">Tipo
                                        di laurea</option>
                                    <option value="triennale">Triennale</option>
                                    <option value="magistrale">Magistrale</option>
                                </select>
                            </p>
                            <p class="wrap-input-email">
                                <input type="email" id="email" name="email" maxlength="40"
                                    value="@studenti.unisa.it" min="23" required="required"
                                    placeholder="esempio@studenti.unisa.it *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="password" id="name" name="password" maxlength="20"
                                    min="8" required="required" placeholder="Password *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="password" id="name" name="confermaPassword"
                                    maxlength="20" min="8" required="required"
                                    placeholder="Conferma Password *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="codiceFiscale" maxlength="16"
                                    min="16" required="required" placeholder="C.F. *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="luogoNascita" maxlength="40"
                                    required="required" placeholder="Luogo di Nascita *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="date" id="name" name="dataNascita"
                                    required="required"
                                    placeholder="Data di Nascita (gg/mm/aaaa) *:">
                            </p>
                            <div class="div_my_wrap-input-name"
                                style="margin: 35px auto 25px auto">
                                <p>Sesso:</p>
                                <div class="radio_div"
                                    style="display: inline; vertical-align: middle;">
                                    <p class="my_wrap-input-name">
                                        <input type="radio" id="M" name="sesso" value="Maschio"
                                            required="required" checked="checked"> <label for="M">Maschio</label>
                                    </p>
                                    <p class="my_wrap-input-name">
                                        <input type="radio" id="F" name="sesso" value="Femmina"
                                            required="required"> <label for="F">Femmina</label>
                                    </p>
                                </div>
                            </div>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="residenza" maxlength="40"
                                    required="required" placeholder="Residenza *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="via" maxlength="40"
                                    required="required" placeholder="Via Roma, 125*:">
                            </p>
                            <p class="wrap-input-phone">
                                <input type="text" id="phone" name="telefono" maxlength="10"
                                    min="10" required="required" placeholder="Telefono *:">
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
                                        style="display: inline;"> Confermo di avere più di 120
                                        CFU</label>
                                </p>
                                <p class="my_wrap-input-name" style="margin-bottom: 10%">
                                    <input type="checkbox" id="legge" name="privati" value=""
                                        required="required"> <label for="legge"
                                        style="display: inline;"> Accetti di confermare la tua
                                        identità altrimenti sei perseguibile penalmente</label>
                                </p>
                            </div>
                            <div class="wrap-btn" style="display: grid;">
                                <input type="submit" name="dati" value="Invia"
                                    onclick="Modulo()" id="submitRegistration"
                                    style="display: none"> <label for="submitRegistration"
                                    class="flat-btn" style="margin: 0 auto 5% auto">REGISTRATI</label>
                                <input type="reset" value="Reset" style="display: none">
                                <label for="submitRegistration" class="flat-btn"
                                    style="margin: 0 auto">RESET FORM</label>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- FINE DIV REGISTRAZIONE STUDENTE -->

                <!-- DIV REGISTRAZIONE DI TUTOR ACCADEMICO -->
                <div id="divRegistrazioneTA" style="display: none;">

                    <!-- FORM REGISTRAZIONE TUTOR ACCADEMICO -->
                    <form action="./registrazione" method="post" id="form-register"
                        name="modulo2" class="form-register">
                        <div class="form-register-title">
                            <h3 class="register-title">
                                CREA UN ACCOUNT<br> <i class="wrap-box ispace7"></i>DOCENTE
                            </h3>
                        </div>

                        <input type="hidden" name="tipo" value="tutorAccademico">
                        <div class="info-register">
                            <p class="wrap-input-name">
                                <input type="text" id="nome2" name="nome" maxlength="20" min="3"
                                    required="required" placeholder="Nome *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="cognome" maxlength="20"
                                    min="3" required="required" placeholder="Cognome *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="codiceDocente" maxlength="10"
                                    min="10" required="required" placeholder="Codice Docente *:">
                            </p>
                            <p class="wrap-input-name">
                                <select name="dipartimento" required="required">
                                    <option value="dipartimento" selected="selected"
                                        disabled="disabled">Dipartimento</option>
                                    <option value="Informatica">Informatica</option>
                                    <option value="Altro">Altro</option>
                                </select>
                            </p>
                            <p class="wrap-input-email">
                                <input type="email" id="email" name="email" maxlength="30"
                                    value="@unisa.it" min="14" required="required"
                                    placeholder="esempio@unisa.it *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="password" id="name" name="password" maxlength="20"
                                    min="8" required="required" placeholder="Password *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="password" id="name" name="confermaPassword"
                                    maxlength="20" min="8" required="required"
                                    placeholder="Conferma Password *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="codiceFiscale" maxlength="16"
                                    min="16" required="required" placeholder="C.F. *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="luogoNascita" maxlength="40"
                                    required="required" placeholder="Luogo di Nascita *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="date" id="name" name="dataNascita"
                                    required="required"
                                    placeholder="Data di Nascita (gg/mm/aaaa) *:">
                            </p>
                            <div class="div_my_wrap-input-name"
                                style="margin: 35px auto 25px auto">
                                <p>Sesso:</p>
                                <div class="radio_div"
                                    style="display: inline; vertical-align: middle;">
                                    <p class="my_wrap-input-name">
                                        <input type="radio" id="TA_M" name="sesso" value="Maschio"
                                            required="required"> <label for="TA_M">Maschio</label>
                                    </p>
                                    <p class="my_wrap-input-name">
                                        <input type="radio" id="TA_F" name="sesso" value="Femmina"
                                            required="required"> <label for="TA_F">Femmina</label>
                                    </p>
                                </div>
                            </div>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="residenza" maxlength="40"
                                    required="required" placeholder="Residenza *:">
                            </p>
                            <p class="wrap-input-name">
                                <input type="text" id="name" name="via" maxlength="40"
                                    required="required" placeholder="Via Roma, 125*:">
                            </p>
                            <p class="wrap-input-phone">
                                <input type="text" id="phone" name="telefono" maxlength="10"
                                    min="10" required="required" placeholder="Telefono *:">
                            </p>
                            <div class="div_my_wrap-input-name" style="display: grid">
                                <p class="my_wrap-input-name">
                                    <input type="checkbox" id="trattamento_dati_ta" name="privati"
                                        value="" required="required"> <label
                                        for="trattamento_dati_ta" style="margin-bottom: 20px">
                                        Acconsento al trattamento dei dati privati</label>
                                </p>
                                <p class="my_wrap-input-name" style="margin-bottom: 10%">
                                    <input type="checkbox" id="legge_ta" name="privati" value=""
                                        required="required"> <label for="legge_ta"
                                        style="display: inline;"> Accetti di confermare la tua
                                        identità altrimenti sei perseguibile penalmente</label>
                                </p>
                            </div>
                            <div class="wrap-btn" style="display: grid;">
                                <input type="submit" name="dati" value="Invia"
                                    onclick="Modulo2()" id="submitRegistration2"
                                    style="display: none"> <label for="submitRegistration2"
                                    class="flat-btn" style="margin: 0 auto 5% auto">REGISTRATI</label>
                                <input type="reset" value="Reset" style="display: none">
                                <label for="submitRegistration" class="flat-btn"
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

    <!-- SCRIPT CONTROLLO CAMPI FORM REGISTRAZIONE STUDENTE-->
    <script type="text/javascript">
        function Modulo() {
            // Variabili associate ai campi del modulo
            var password = document.modulo.password.value;
            var confermaPassword = document.modulo.confermaPassword.value;
            var nascita = document.modulo.nascita.value;
            var telefono = document.modulo.telefono.value;
            var email = document.modulo.email.value;
            var matricola = document.modulo.matricola.value;

            //Ottieni anno corrente
            var today = new Date();
            var year = today.getFullYear();

            // Espressione regolare dell'email
            var email_reg_studente = "@studenti.unisa.it";
            var email_length = email.length;
            var last_index_email = email.lastIndexOf("@");

            //Verifica l'uguaglianza tra i campi PASSWORD e CONFERMA PASSWORD
            if (password != conferma) {
                alert("La password confermata è diversa da quella scelta, controllare.");
                document.modulo.conferma.value = "";
                document.modulo.conferma.focus();
                return false;
            }
            //Controllo sulla matricola
            else if ((isNaN(matricola)) || matricola.substring(0, 1) == "-"
                    || matricola.substring(0, 1) == " ") {
                alert("Il campo Matricola è numerico ed obbligatorio.");
                document.modulo.matricola.value = "";
                document.modulo.matricola.focus();
                return false;
            }
            //Effettua il controllo sul campo DATA DI NASCITA
            else if (document.modulo.nascita.value.substring(2, 3) != "/"
                    || document.modulo.nascita.value.substring(5, 6) != "/"
                    || isNaN(document.modulo.nascita.value.substring(0, 2))
                    || isNaN(document.modulo.nascita.value.substring(3, 5))
                    || isNaN(document.modulo.nascita.value.substring(6, 10))) {
                alert("Inserire nascita in formato gg/mm/aaaa");
                document.modulo.nascita.value = "";
                document.modulo.nascita.focus();
                return false;
            } else if (document.modulo.nascita.value.substring(0, 2) > 31) {
                alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
                document.modulo.nascita.select();
                return false;
            } else if (document.modulo.nascita.value.substring(3, 5) > 12) {
                alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
                document.modulo.nascita.value = "";
                document.modulo.nascita.focus();
                return false;
            } else if (document.modulo.nascita.value.substring(6, 10) < 1900) {
                alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
                document.modulo.nascita.value = "";
                document.modulo.nascita.focus();
                return false;
            }
            //Controllo per verificare che hai almeno 18 anni e potresti esser iscritto all'università
            //se hai fatto la primina (controllare meglio il mese di nascita per questo)
            else if (document.modulo.nascita.value.substring(6, 10) > (year - 18)
                    && document.modulo.nascita.value.substring(3, 5) > 5) {
                alert("Non puoi essere iscritto all'università");
                document.modulo.nascita.value = "";
                document.modulo.nascita.focus();
                return false;
            }
            //Effettua il controllo sul campo TELEFONO
            else if ((isNaN(telefono)) || telefono.substring(0, 1) == "-"
                    || telefono.substring(0, 1) == " ") {
                alert("Il campo Telefono è numerico ed obbligatorio.");
                document.modulo.telefono.value = "";
                document.modulo.telefono.focus();
                return false;
            } else if (!email_reg_studente != email.substring(last_index_email,
                    email_length)) {
                alert("Inserire un indirizzo email corretto.");
                document.modulo.email.select();
                return false;
            } else {
                document.modulo.action = "./registrazione";
                document.modulo.submit();
            }
        }
    </script>

    <!-- SCRIPT CONTROLLO CAMPI FORM REGISTRAZIONE TUTOR ACCADEMICO-->
    <script type="text/javascript">
        function Modulo2() {
            // Variabili associate ai campi del modulo
            var password = document.modulo2.password.value;
            var confermaPassword = document.modulo2.confermaPassword.value;
            var nascita = document.modulo2.nascita.value;
            var telefono = document.modulo2.telefono.value;
            var email = document.modulo2.email.value;
            var codiceDocente = document.modulo2.codiceDocente.value;

            //Ottieni anno corrente
            var today = new Date();
            var year = today.getFullYear();

            // Espressione regolare dell'email
            var email_reg_tutorAccademico = "@unisa.it";
            var email_length = email.length;
            var last_index_email = email.lastIndexOf("@");

            //Verifica l'uguaglianza tra i campi PASSWORD e CONFERMA PASSWORD
            if (password != conferma) {
                alert("La password confermata è diversa da quella scelta, controllare.");
                document.modulo2.conferma.value = "";
                document.modulo2.conferma.focus();
                return false;
            }
            //Controllo sulla matricola
            else if ((isNaN(codiceDocente))
                    || codiceDocente.substring(0, 1) == "-"
                    || matricola.substring(0, 1) == " ") {
                alert("Il campo Codice Docente è numerico ed obbligatorio.");
                document.modulo2.codiceDocente.value = "";
                document.modulo2.codiceDocente.focus();
                return false;
            }
            //Effettua il controllo sul campo DATA DI NASCITA
            else if (document.modulo2.nascita.value.substring(2, 3) != "/"
                    || document.modulo2.nascita.value.substring(5, 6) != "/"
                    || isNaN(document.modulo2.nascita.value.substring(0, 2))
                    || isNaN(document.modulo2.nascita.value.substring(3, 5))
                    || isNaN(document.modulo2.nascita.value.substring(6, 10))) {
                alert("Inserire nascita in formato gg/mm/aaaa");
                document.modulo2.nascita.value = "";
                document.modulo2.nascita.focus();
                return false;
            } else if (document.modulo2.nascita.value.substring(0, 2) > 31) {
                alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
                document.modulo.nascita.select();
                return false;
            } else if (document.modulo2.nascita.value.substring(3, 5) > 12) {
                alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
                document.modulo2.nascita.value = "";
                document.modulo2.nascita.focus();
                return false;
            } else if (document.modulo2.nascita.value.substring(6, 10) < 1900) {
                alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
                document.modulo2.nascita.value = "";
                document.modulo2.nascita.focus();
                return false;
            }
            //Controllo per verificare che hai almeno 18 anni e potresti esser iscritto all'università
            //se hai fatto la primina (controllare meglio il mese di nascita per questo)
            else if (document.modulo2.nascita.value.substring(6, 10) > (year - 18)
                    && document.modulo2.nascita.value.substring(3, 5) > 5) {
                alert("Non puoi essere iscritto all'università");
                document.modulo2.nascita.value = "";
                document.modulo2.nascita.focus();
                return false;
            }
            //Effettua il controllo sul campo TELEFONO
            else if ((isNaN(telefono)) || telefono.substring(0, 1) == "-"
                    || telefono.substring(0, 1) == " ") {
                alert("Il campo Telefono è numerico ed obbligatorio.");
                document.modulo2.telefono.value = "";
                document.modulo2.telefono.focus();
                return false;
            } else if (!email_reg_tutorAccademico != email.substring(
                    last_index_email, email_length)) {
                alert("Inserire un indirizzo email corretto.");
                document.modulo2.email.select();
                return false;
            } else {
                document.modulo2.action = "./registrazione";
                document.modulo2.submit();
            }
        }
    </script>

    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/jquery.min.js"></script>
    <script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/javascript/bootstrap.min.js"></script>
    <script type="text/javascript" src="../bootstrap/javascript/main.js"></script>
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