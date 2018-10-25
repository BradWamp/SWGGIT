<%-- 
    Document   : response
    Created on : Oct 8, 2018, 7:40:54 AM
    Author     : bwamp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Results page</h1>
        <p>
            You bet $${userMoney}.
        </p>
        <p>
            You are broke after ${roundCounter} rounds.
        </p>
        <p>
            You should have quit in round ${maxMoneyRound} when you had $${maxMoney}.
        </p>
        <p>
            <a href="index.jsp">Try again</a>
        </p>
    </body>
</html>
