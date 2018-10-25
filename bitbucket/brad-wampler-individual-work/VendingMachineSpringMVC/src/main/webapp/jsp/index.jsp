<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Vending Machine</h1>
            <hr/>
        </div>

        <div class="container">
            <div class="col-md-8 left-sside">
                <div id="itemBoxes">
                    <c:forEach var="currentItem" items="${itemList}">
                        <div class="col-md-4">
                            <form class="form-inline" 
                                  role="form" method="POST" 
                                  action="selectItem">
                                <button class ="well" type="submit">
                                    <div class="column3 well">
                                        <p> ${currentItem.itemNumber} </p><br/>
                                        <input type="hidden" value="${currentItem.itemNumber}" name="itemNumber"/>
                                        <div class="text-center" id= "itemAttributes">
                                            <p> ${currentItem.item} </p><br/>
                                            <input type="hidden" value="${currentItem.item}" name="item"/>
                                            <p> ${currentItem.price} </p><br/>
                                            <input type="hidden" value="${currentItem.price}" name="price"/>
                                            <p>Quantity: ${currentItem.amount} </p>
                                            <input type="hidden" value="${currentItem.amount}" name="amount"/>
                                        </div>
                                    </div>
                                </button>
                                
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-4 right-sside">

                <div class="form1 text-center">
                    <label for="moneyInput">Total $ In</label><br>
                    <input class="form-control" type="text" readonly="readonly" id="moneyInput" value="${displayMoney}"/>
                    <a href="addMoney?moneyAmount=1">
                        <button type="button" class="btn btn-default moneybutton" id="dollar">Add Dollar</button>
                    </a>
                    <a href="addMoney?moneyAmount=.25">
                        <button type="button" class="btn btn-default moneybutton" id="quarter">Add Quarter</button>
                    </a>
                    <a href="addMoney?moneyAmount=.10">
                        <button type="button" class="btn btn-default moneybutton" id="dime">Add Dime</button>
                    </a>
                    <a href="addMoney?moneyAmount=.05">
                        <button type="button" class="btn btn-default moneybutton" id="nickel">Add Nickel</button>
                    </a>
                    <br>
                </div>

                <div class="form2 text-center">
                    <hr/>
                    <form action="vendItem" method="POST" role="form">
                        <div class="messages">
                            <label for="messageBox">Messages</label><br>
                            <input class="form-control" type=text readonly="readonly" id="messageBox" value="${message}"/><br/>
                        </div>

                        <div class="items">
                            <div class="form-inline">
                                <label for"Item">Item</label>
                                <input class="form-control" type="text" readonly="readonly" id="itemNumber" name="itemNumber" value="${storedItem.itemNumber}"/>
                                <input type="hidden" id="itemPrice" name="itemToVend" value="${newItem}" />
                            </div>
                        </div>
                        <br>
                        
                        <div class="vendButton">
                            <button type="submit" class="btn btn-default" id="vendItem">Make Purchase</button>
                        </div>
                    </form>
                </div>
                <hr/>

                <div class="form3 text-center">
                    <div class="vendingChange">
                        <label for="change">Change</label><br>
                        <input class="form-control" type=text readonly="readonly" id="change" value="${change}" /><br/>
                    </div>

                    <div class="changebutton">
                        <a href="returnChange">
                            <button type="button" class="btn btn-default" id="getChange">Change Return</button>
                        </a>
                    </div>

                </div>

            </div>
        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

