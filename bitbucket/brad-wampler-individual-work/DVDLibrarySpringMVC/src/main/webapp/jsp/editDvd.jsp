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
                        <sf:input type="text" class="form-control" id="add-title"
                                  path="title" placeholder="title"/>
                        <sf:errors path="title" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-releaseDate" class="col-md-4 control-label">Release Date:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-releaseDate"
                                  path="releaseDate" placeholder="Release Date"/>
                        <sf:errors path="releaseDate" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-mpaaRatng" class="col-md-4 control-label">MPAA Rating:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-mpaaRatng"
                                  path="mpaaRatng" placeholder="mpaaRatng"/>
                        <sf:errors path="mpaaRatng" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-directorsName" class="col-md-4 control-label">directorsName:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-directorsName"
                                  path="directorsName" placeholder="directorsName"/>
                        <sf:errors path="directorsName" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-studio" class="col-md-4 control-label">studio:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-studio"
                                  path="studio" placeholder="studio"/>
                        <sf:errors path="studio" cssclass="error"></sf:errors>
                    </div>
                    <div class="form-group">
                        <label for="add-userRatingNotes" class="col-md-4 control-label">Notes:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-userRatingNotes"
                                  path="userRatingNotes" placeholder="userRatingNotes"/>
                        <sf:errors path="userRatingNotes" cssclass="error"></sf:errors>
                        <sf:hidden path="dvdId"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-default" value="Update Dvd"/>
                    </div>
                </div>
            </sf:form>
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