<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <h2>Dvd Library: Search Results All</h2
        <br>
        <div class="container">
            <div class="navbar">
                <form class="form-horizontal" role="form" modelAttribute="dvdSearch"
                      action="searchDvd" method="GET">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="col-md-2">
                            <a href="${pageContext.request.contextPath}/createDvd">
                                <button type="button" class="btn btn-default createDVD" id="createDvd">Create Dvd</button>
                            </a> 
                        </li>
                        <li role="presentation" class="col-md-2">
                            <a href="${pageContext.request.contextPath}/searchDvd">
                                <button type="submit" class="btn btn-default createDVD" id="searchDVD">Search</button>
                            </a>
                        </li>
                        <li role="presentation" class = "col-md-2">
                            <select name="searchCategory">
                                <option value="title">Title</option>
                                <option value="releaseYear">Release Year</option>
                                <option value="directorsName">Director</option>
                                <option value="mpaaRating">Rating</option>
                            </select>
                        </li>
                        <li>
                            <input class="form-control" type="text" id="searchTerm" placeholder="search term" name="searchTerm"/>
                        </li>
                    </ul>  
                </form>
            </div>
            <br>

            <table id="DvdTable" class="table table-hover">
                <tr>
                    <th width="20%">Title</th>
                    <th width="20%">Release Date</th>
                    <th width="20%">Director</th>
                    <th width="20%">Rating</th>
                    <th width="20%">Notes</th>
                </tr>
                <c:forEach var="currentDvd" items="${newList}">
                    <tr>
                        <td>
                            <a href="dvdDetail?title=${currentDvd.title}">
                                <c:out value="${currentDvd.title}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.releaseDate}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.directorsName}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.mpaaRatng}"/>
                        </td>
                        <td>
                            <c:out value="${currentDvd.userRatingNotes}"/>
                        </td>
                        <td>
                            <a href="editDvdDetails?title=${currentDvd.dvdId}">
                                <button>Edit</button>
                            </a>
                        </td>
                        <td>
                            <a href="deleteDvd?title=${currentDvd.dvdId}" onclick="return confirm('Are you sure? Dvd will be deleted.')">
                                <button>Delete</button>
                            </a>
                        </td>
                    </c:forEach>
            </table>                  

        </div>
    </div>
    <div class="navbar">
        <ul class="nav nav-tabs">
            <li role="presentation" class="col-md-2">
                <a href="${pageContext.request.contextPath}/cancel">
                    <button type="cancel" class="btn btn-default " id="createDvd">Back</button>
                </a> 
            </li>
    </div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    }
</script>
</body>
</html>

