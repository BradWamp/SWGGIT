<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <h2>Create Dvd</h2>
            <hr>
            <form class="form-horizontal" 
                  role="form" method="POST" 
                  action="createNewDvd">
                <div class="form-group">
                    <label for="addTitle" class="col-md-2 control-label">Title:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="title" placeholder="title"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="releaseYear" class="col-md-2 control-label">Release Year:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="releaseYear" placeholder="Release Year"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="director" class="col-md-2 control-label">Director:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="directorsName" placeholder="Director"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-rating" class="col-md-2 control-label">Rating:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="mpaaRatng" placeholder="Rating"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-notes" class="col-md-2 control-label">Notes:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="userRatingNotes" placeholder="Notes"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-studio" class="col-md-2 control-label">Studio:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="studio" placeholder="studio"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Create Dvd"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="navbar">
            <ul class="nav nav-tabs">
                <li role="presentation" class="col-md-2">
                    <a href="${pageContext.request.contextPath}/cancel">
                        <button type="cancel" class="btn btn-default " id="createDvd">Cancel</button>
                    </a> 
                </li>
                <!-- Placed at the end of the document so the pages load faster -->
                <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
                <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

                </body>
                </html>