<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Locations</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" ><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/allheroes">Heroes</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/alllocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Sightings</a></li>
                </ul>    
            </div>

            <div class =" row">
                <div class="col-md-12">
                    <h2>Add a New Location</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="createLocation">
                        <div class="form-group">
                            <label for="addLocationName" class="col-md-4 control-label">Location Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationName" placeholder="Location Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addLocationDesc" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="locationDesc" placeholder="Enter a short description"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addLat" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                                <input type="number" step = ".01" class="form-control" name="lat" placeholder="Enter the latitude"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addLong" class="col-md-4 control-label">Longitude:</label>
                            <div class="col-md-8">
                                <input type="number" step = ".01" class="form-control" name="longitude" placeholder="Enter the longitude"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addstreet" class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="street" placeholder="Street"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addstreet" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="city" placeholder="City"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addstreet" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="state" placeholder="State"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Hero"/>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <!-- 
                        Add a col to hold the summary table - have it take up half the row 
                    -->
                    <div class="col-md-8">
                        <h2>Locations Where Heroes Have Been Seen</h2>
                        <table id="locationTable" class="table table-hover">
                            <tr>
                                <th width="15%">Location Name</th>
                                <th width="40%">Description</th>
                                <th width="15%">Street</th>
                                <th width="15%">City</th>
                                <th width="15%">State</th>
                            </tr>
                            <c:forEach var="currentLocation" items="${locationList}">
                                <tr>
                                    <td>
                                        <a href="editLocationDetails?locationId=${currentLocation.locationId}">
                                            <c:out value="${currentLocation.locationName}"/> 
                                        </a>
                                    </td>
                                    <td>
                                        <c:out value="${currentLocation.locationDesc}"/>
                                    </td>
                                    <td>
                                        <c:out value="${currentLocation.street}"/>
                                    </td>
                                    <td>
                                        <c:out value="${currentLocation.city}"/>
                                    </td>
                                    <td>
                                        <c:out value="${currentLocation.state}"/>
                                    </td>
                                    <td>
                                        <a href="deleteLocation?locationId=${currentLocation.locationId}">
                                            Delete
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>                  
                    </div> <!-- End col div -->
                </div> <!-- End row div -->
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

