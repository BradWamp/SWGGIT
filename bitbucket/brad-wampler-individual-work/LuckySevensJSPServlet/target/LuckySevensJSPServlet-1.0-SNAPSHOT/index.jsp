<%-- 
    Document   : index
    Created on : Oct 8, 2018, 7:39:34 AM
    Author     : bwamp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Welcome to Lucky Sevens</h1>
        <p>
            Each round, the program rolls a virtual pair of dice for the user
            If the sum of the 2 dice is equal to 7, the player wins $4; otherwise, the player loses $1.
        </p>
        <p>
            Please enter an amount below and press the button to begin the game.
        </p>
        <br>
        <form method="POST" action = "LuckySevensServlet">
            <input type="number" name="userMoney">
            <input type="submit" value="Play Game">
        </form>
    </body>
</html>
