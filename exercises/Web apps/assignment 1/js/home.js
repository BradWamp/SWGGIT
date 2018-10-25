$(document).ready(function () {
  $('#weatherInfo').hide();

  $('#get-weather-button').on('click', function(){
    var zipcode = $('#zipcode');
    $('#zipWarning').empty();

    if(zipcode.val().length !=5){
      $('#zipWarning').append($('<li>')
      .attr({class: 'list-group-item list-group-item-danger'})
      .text('Zip code: please enter a 5-digit zip code.'));
    }
    else {
    $('#weatherInfo').show();
    var zipcode = $('#zipcode').val().toString();
    var unit = $('#tempUnit').val();

    if(unit == "metric"){
      var degree = "C";
      var speed = "KPH";
    }else{
      var degree = "F";
      var speed = "MPH";
    }

    $.ajax({
      type:'GET',
      url: 'https://api.openweathermap.org/data/2.5/forecast?zip='
        + zipcode + ',us&units=' + unit +
        '&APPID=326d4b32922d584b5fc6e8160e9711e5',
      success: function(data, status){

        var cityDiv = $('#cityName');
        var newDiv = '<h1> Current Conditions in ' + data.city.name + '</h1>'
        cityDiv.append(newDiv);

        var cityConditions = $('#cityConditions');
        var newDiv1 = '<tr><td> Temperature: '+ data.list[0].main.temp + ' ' + degree +'</td></tr>'
            newDiv1 += '<tr><td> Humidity: ' + data.list[0].main.humidity + '%</td></tr>'
            newDiv1 += '<tr><td> Wind: ' + data.list[0].wind.speed + ' ' + speed +'</td></tr>'
        cityConditions.append(newDiv1);

        var currentDescription = $('#currentDescription');
        var newDescription = '<img src="http://openweathermap.org/img/w/' +
            data.list[0].weather[0].icon + '.png"><p>' +
            data.list[0].weather[0].description + '</p>';
        currentDescription.append(newDescription);
// populate the 5 day forecast below.
        var firstDate = data.list[0].dt;
        var counter = 1;
        var newDate = new Date();

      $.each(data.list, function(index, data){

       if (data.dt == firstDate){ // this doesn't seem to work.

             firstDate += 86400;

            var dd = newDate.getDate();
            var mm = newDate.getMonth();
            var fivedaydiv = $('#info'+counter);
            var forecastDescription = '<p>'+ mm + '/' + dd + '</p>' +
                '<img src="http://openweathermap.org/img/w/' +
             data.weather[0].icon + '.png"><p>L: ' +
             data.main.temp_min + degree + ' H: '+
             data.main.temp_max + degree + index + '</p>';

            fivedaydiv.append(forecastDescription);
            counter += 1;
            newDate.setDate(newDate.getDate() + 1)
        }

        });
      },
      error: function(){
        alert("it does not work. MAKE SURE THE GREEN BUTTON IS SELECTED");
      }
    });
  }
  });
});
