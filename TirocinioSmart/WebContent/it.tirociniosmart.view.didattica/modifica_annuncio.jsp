<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
   String titolo = (String) request.getParameter("titolo");
%>
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
    
  <div class="title-section color-title">
    <h1 class="title">
        COMPILA<span class="color-orange"> ANNUNCIO</span> 
    </h1>
    
    <section class="flat-row pd-blog bg-theme blog-list2 style2">
    
      <div class="container">  
      <div style="text-align: center; margin-left: 10%;" class="col-md-12">
        <title>ANNUNCIO</title>
        
           <form action="./ModificaAnnuncio" method="post" enctype="multipart/form-data" id="modulo">
            
            <br/>
            <table>
                <tr>

                <td>Titolo</td>
                <td><label>
                <input name="nome" type="text" id="nome" size="100%" required/>
                </label></td>
                </tr>



                <tr>
                <td>Annuncio</td>
                <td>
                <textarea name="body" cols="30" rows="5" id="body" required></textarea>
                </td>
                </tr>
                 <!-- FILE -->
                <td>Allega File</td>
                <td>
                <div class="wrap-btn">
                <input type="file" name="file1" id="inputFile" required>   
                </div>
                </td>
                </tr>
                <input type="hidden" name="title" value=<%=titolo %>>

               
                </table>
                
                <div   class="wrap-btn"  style="margin-top:10%; ">
                <input style="padding: 0px 50px 0px 50px;" class="flat-btn bg-color style3 " type="submit" name="submit" id="submit" value="Invia" />&nbsp; 
                
                </dov>
                <div   class="wrap-btn"  style="margin-top:10%">
                <input style="padding: 0px 50px 0px 50px;" class="flat-btn bg-color style3 " type="reset" name="cancella" id="cancella" value="Cancella" /></div>
                </form>
                </div>
      </div>
    </section>
    </div>
    
    

    <!-- A QUI -->

    <!-- FOOTER -->
    <%@ include file="../footer_folder/footer.jsp"%>

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