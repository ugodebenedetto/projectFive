<%@page import="it.tirociniosmart.model.annuncio.Annuncio"%>
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

	<section class="flat-row pd-blog bg-theme blog-list2 style2">
	   
                <div class="container">  
                <div class="wrap-btn" style="margin-bottom: 5%;">
                <a class="flat-btn" href="crea_annuncio.jsp" style="padding: 10px 20px">Crea Nuovo Annuncio</a>
                </div>
                <% ArrayList<Annuncio> annunci = (ArrayList<Annuncio>) request.getSession().getAttribute("annunci");
                if(annunci!= null){
                   for(Annuncio n : annunci){%>                  
                    <div class="wrap-post">                    
                        <div class="row" style="margin-right: 0;margin-left: 0;">          
                                   
                            <div class="col-md-6 wrap-grid">
                                <article class="entry">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-6">
                                            <div class="entry-post">
                                                <div class="entry-meta">
                                                
                                                     
                                                    <span><%=n.getData() %></span>
                                                </div>
                                                <h3 class="entry-title"><a href="#"><%=n.getTitolo() %> <br></a></h3>
                                                   <div class="entry-content">
                                                    <p><%=n.getBody() %></p>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6 col-sm-6">
                                            <div class="wrap-btn">
                                            <a class="flat-btn" href="modifica_annuncio.jsp?titolo=<%=n.getTitolo() %>" style="padding: 10px 20px">Modifica</a>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-6">
                                            <div class="wrap-btn">
                                            <a href="${pageContext.request.contextPath}/UsersFiles/files/ok/<%=n.getFilePosition()%>" target="about_blank"><%=n.getFilePosition()%></a><br>
                                            </div>
                                        </div>
                                         
                                    </div>
                                </article>
                            </div><!-- col-md-6 -->
                            <%}
                            } %>        
                            
                           
                        </div><!-- row -->
                    </div>
                    
                </div><!-- container -->
            </section>

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