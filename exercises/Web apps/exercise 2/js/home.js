$(document).ready(function () {
    $('#mainInfoDiv, #akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
    $('#mainInfoDiv').show();
    $('td').hover(function(){
        $(this).css('background-color', 'DarkOrange');
      },
      function(){
        $(this).css('background-color', '');
      }
    )

    $('#akronButton').on('click', function(){
      $('#mainInfoDiv, #akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
      $('#akronInfoDiv').show();
      $('#akronWeather').hide();
      $('#akronWeatherButton').click(function(){
        $('#akronWeather').toggle();
      })
    })

    $('#minneapolisButton').on('click', function(){
      $('#mainInfoDiv, #akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
      $('#minneapolisInfoDiv').show();
      $('#minneapolisWeather').hide();
      $('#minneapolisWeatherButton').click(function(){
        $('#minneapolisWeather').toggle();
      })
    })

    $('#louisvilleButton').on('click', function(){
      $('#mainInfoDiv, #akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
      $('#louisvilleInfoDiv').show();
      $('#louisvilleWeather').hide();
      $('#louisvilleWeatherButton').click(function(){
        $('#louisvilleWeather').toggle();
      })
    })

    $('#mainButton').on('click', function(){
      $('#mainInfoDiv, #akronInfoDiv, #minneapolisInfoDiv, #louisvilleInfoDiv').hide();
      $('#mainInfoDiv').show();
    })
});
