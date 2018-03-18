<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
<head>
<meta charset="utf-8" />
<title>Projekt</title>

<link rel="stylesheet" href="bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>
<header class="container-fluid page-header">
<div class="col-sm-10">
<h1>Datenanalyse</h1>
<h3>Krisenkommunikation</h3>
</div>
<img class="col-sm-2" src="uni_logo2.png">

<nav class="col-sm-12 navbar navbar-inverse">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="Startseite.html">Data</a></li>
          
         
          </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>
</header>

<main class="container-fluid">

<article class="blog-main blog-sidebar col-sm-9">
<section class="jumbotron">
<div>
<%String name = (String)request.getAttribute("name"); %>


</div>
</section>
<img src=<%=(String)request.getAttribute("unigram") %> width ="400" height="300" alt="" >
<img src=<%=(String)request.getAttribute("bigrampath") %> width ="400" height="300" alt="" >
<img src=<%=(String)request.getAttribute("trigrampath") %> width ="400" height="300" alt="" >   
<h3>Sentiment Results</h3>
<table border=1>
<tr>
<th>Text</th>
<th>Score</th>

</tr>
<c:forEach var="entry" items="${sentiment}">
<tr>
 <td> Text : <c:out value="${entry.key}"/></td>
  <td>Score : <c:out value="${entry.value}"/></td>
  </tr>
</c:forEach>
</table>

 
<br>
</article>

</main>

<footer class="footer container-fluid">
<div class="jumbotron col-sm-12 text-center">
Impressum <br>
Hong-Le Kim, Leon Weisbrot, Iuliia Astrakhantseva
</div>
</footer>
</body>
</html>