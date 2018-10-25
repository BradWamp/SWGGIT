$(document).ready(function(){
  $('#moneyInput').val(0);

  loadItems();

  $('#vendItem').on('click',function(){
    var money = ($('#moneyInput').val());
    var id = ($('#itemNumber').val());

    $.ajax ({
        type: 'GET',
        url: 'http://localhost:8080/money/' + money + '/item/' + id,
        success: function (data, status) {
                $('#change').val(
                  data.quarters + " quarters " + data.dimes + " dimes " +
                  data.nickels + " nickels " + data.pennies + " pennies");
                $('#moneyInput').val(0);
                $('#messageBox').val("Thank You!!");
        },
        error: function(data, status) {
          var message = data.responseJSON.message;
          $('#messageBox').val(message);
        }
    });
  });

//this is the function for when items are clicked
  $('#itemBoxes').on('click', '#itemAttributes',function(){
    //alert("this worked");
    var price = $(this).find('#priceInput').val();
    var quantity = $(this).find('#quantityInput').val();
    var idNumber = $(this).find('#idInput').val();
    $('#itemNumber').val(idNumber);
    $('#itemPrice').val(price);
    $('#itemQuantity').val(quantity);
    $('#change').val("");
  });

  $('#dollar').click(function(){
    var money = parseFloat($('#moneyInput').val());
    var newmoney = money+1.00;
    $('#moneyInput').val(newmoney.toFixed(2));
  });

  $('#quarter').click(function(){
    var money = parseFloat($('#moneyInput').val());
    var newmoney = money+0.25;
    $('#moneyInput').val(newmoney.toFixed(2));
  });

  $('#dime').click(function(){
    var money = parseFloat($('#moneyInput').val());
    var newmoney = money+0.1;
    $('#moneyInput').val(newmoney.toFixed(2));
  });

  $('#nickel').click(function(){
    var money = parseFloat($('#moneyInput').val());
    var newmoney = money+0.05;
    $('#moneyInput').val(newmoney.toFixed(2));
  });

  $('#getChange').click(function(){
    returnChange();
  });

});
function returnChange(){
  var change = parseFloat($('#moneyInput').val()) * 100;
  var pennies =0;
  var quarters =0;
  var dimes =0;
  var nickels =0;

  while(change > 0){
      while(change >= 25)
      {
        change = change - 25;
        quarters += 1;
      }
      while(change >= 10)
      {
        change = change - 10;
        dimes += 1;
      }
      while(change >= 5)
      {
        change = change - 5;
        nickels += 1;
      }
      while(change >= 1)
      {
        change = change - 1;
        dollars += 1;
      }
  }
  $('#change')
  .val(quarters + " quarters " + dimes + " dimes " + nickels + " nickels " + pennies + " pennies");
  $('#moneyInput').val(0.00);
  $('#itemNumber').val(0);
  $('#itemPrice').val(0);
  $('#itemQuantity').val(0);
  $('#messageBox').val("");
  loadItems();
}
//load items into boxes
function loadItems(){
  var itemBoxes = $('#itemBoxes');

  clearItems();

  $.ajax ({
      type: 'GET',
      url: 'http://localhost:8080/items',
      success: function (data, status) {
          $.each(data, function (index, item) {
              var name = item.name;
              var price = item.price;
              var id = item.id;
              var quantity = item.quantity;

              var newDiv = '<div class="column3 well">';
                  newDiv += '<p>' + id + '</p><br/>';
                  newDiv += '<div class="text-center" id= "itemAttributes"><p>' + name + '</p><br/>';
                  newDiv += '<p>' + price + '</p><br/><input id="priceInput" type="hidden" value=' + price +'>';
                  newDiv += '<p>Quantity: ' + quantity + '</p><input id="quantityInput" type="hidden" value=' + quantity +'>';
                  newDiv += '<input type= "hidden" id="idInput" value=' + id + '></div></div>';
              itemBoxes.append(newDiv);

          });
      },
      error: function() {
          alert("MAKE SURE THAT GREEN BUTTON IS ON!!!");
      }
  });
}

function clearItems(){
  $('#itemBoxes').empty();
}
