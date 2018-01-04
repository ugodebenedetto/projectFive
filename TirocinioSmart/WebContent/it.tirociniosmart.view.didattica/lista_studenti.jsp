<%@page import="it.tirociniosmart.model.tirocinio.RichiestaTirocinio"%>
<%@page import="it.tirociniosmart.model.utente.Studente"%>
<%@page import="java.util.ArrayList"%>
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
</head>

<body>

	<!-- Preloader -->
	<section class="loading-overlay">
	<div class="Loading-Page">
		<h2 class="loader">Loading</h2>
	</div>
	</section>

	<%@ include file="header_didattica.jsp"%>

	<!-- AGGIUNGERE CODICE DA QUI -->
	 <!-- Portfolio -->
        <section class="flat-row bg-theme pd-top-100 pd-bottom-no">
            <div class="container">
                <div class="row">
                        <div class="col-md-12">
                            <form action="./contact/contact-process.php" method="post" id="formsearch-flatcourse" class="formsearch">
                                <ul class="form-wrap">
                                    <li class="col-md-4 form-select">
                                        <p class="search-form-select">
                                            <select class="select-field" >
                                                <option value="">Matricola</option>
                                                <option value="">Cognome Nome</option>
                                                <option value="">Nome Tirocinio</option>                                          
                                            </select>
                                        </p>
                                    </li>
                                    <li class="col-md-5 form-key">
                                        <p class="search-form-keyword">
                                            <input type="text" id="keyword" name="keyword" value="" required="required" placeholder="Caio">
                                        </p>
                                    </li>
                                    <li class=" form-btn">
                                        <div class="search-form-btn">
                                    <div class="wrap-btn">
                                        <a class="flat-btn bg-color style3" href="#">SEARCH</a> 
                                    </div>
                                </div>
                                    </li>
                                </ul>
                            </form>
                        </div>
                    </div>
            </div>
            <div class="dividers h33">   
            </div><!-- dividers h33 -->
	<div class="container">
                <div class="table-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>MATRICOLA</th>
                                <th>COGNOME</th>
                                <th>NOME</th>
                                <th>STATO RICHIESTA</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <% ArrayList<RichiestaTirocinio> studenti = (ArrayList<RichiestaTirocinio>) request.getSession().getAttribute("studenti");
                           if(studenti != null){
                             for (RichiestaTirocinio s : studenti){
                               %>
                            <tr>
                                <td><%=s.getRichiedente().getMatricola()%></td>
                                 <td><%=s.getRichiedente().getCognome() %></td>   
                                <td> <%=s.getRichiedente().getNome() %> </td>
                                <td><%=s.getStato() %></td>
                                 <td><div class="wrap-btn">
                            <a class="flat-btn" href="visualizza_studente.jsp?nome=<%=s.getRichiedente().getNome() %>&cognome=<%=s.getRichiedente().getCognome() %>&matricola=<%=s.getRichiedente().getMatricola() %>&data=<%=s.getRichiedente().getDataNascita() %>&nomeT=<%=s.getTirocinio().getNome() %>&tutor=<%=s.getTirocinio().getResponsabile() %>&stato=<%=s.getStato() %>" style="padding: 10px 20px">VISUALIZZA</a>
                        </div></td>
                            </tr>
                             <%  }
                           }
                        %>
                           
                      </tbody>
                    </table>
                </div>
            </div><!-- container-->
            </section>
	<!-- A QUI -->

	<!-- FOOTER -->
	<%@ include file="../footer_folder/footer.jsp"%>
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

    <!-- Javascript -->
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