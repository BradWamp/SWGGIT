<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h2>Edit Dvd</h2>
            <hr>
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="editDvd" method="POST">
                <div class="form-group">
                    <label for="add-title" class="col-md-4 control-label">Title:</label>
                    <div class="col-md-8">
                        <c:out value="${dvd.title}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-releaseDate" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-8">
                        <c:out value="${dvd.releaseDate}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-mpaaRatng" class="col-md-4 control-label">MPAA Rating:</label>                          
                        <div class="col-md-8">
                        <c:out value="${dvd.mpaaRatng}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-directorsName" class="col-md-4 control-label">Director:</label>
                        <div class="col-md-8">
                        <c:out value="${dvd.directorsName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                        <div class="col-md-8">
                        <c:out value="${dvd.studio}"/>
                    </div>
                    </div>
                    <div class="form-group">
                        <label for="add-userRatingNotes" class="col-md-4 control-label">Notes:</label>
                        <div class="col-md-8">
                        <c:out value="${dvd.userRatingNotes}"/>
                    </div>
                    </div>
            </sf:form>
        </div>
        <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="col-md-2">
                        <a href="${pageContext.request.contextPath}/cancel">
                            <button type="cancel" class="btn btn-default " id="createDvd">Back</button>
                        </a> 
                    </li>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>