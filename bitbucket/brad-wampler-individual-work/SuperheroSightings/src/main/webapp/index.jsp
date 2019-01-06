<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Superhero Sighting Home Page</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/allheroes">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/alllocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Sightings</a></li>
                </ul>    
            </div>
            

            <div class="onoffswitch3">
                <label class="onoffswitch3-label" for="myonoffswitch3">
                    <span class="onoffswitch3-switch">BREAKING NEWS <span class="glyphicon glyphicon-remove"></span></span>
                    <marquee class="scroll-text">Latest Sighting:  <span class="glyphicon glyphicon-forward"></span> Test Sighting 
                        <span class="glyphicon glyphicon-forward"></span> 
                        just a test still </marquee> 
                </label>
            </div>
                
            <h2>Recent Sightings from all over</h2>
            
            <p>Welcome to the most up-to-date sight that tracks the latest Hero sightings. We aren't talking your "normal heroes" like the ones you did your reports on
                when you were growing up(e.g. your mom/dad or your favorite athelete). We are talking about real Heros with real powers. 
                If you are here it is because you have seen one
                of these famous, or infamous, individuals and are wanting to collect the reward for the sighting. If adding a new Superhero, be sure to add a power
                a location of where you saw them. Otherwise, how would we know if they were really a superhero if you didn't see their power, or even see them at all.
                We are only adding confirmed superheroes to our database.
            </p>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

