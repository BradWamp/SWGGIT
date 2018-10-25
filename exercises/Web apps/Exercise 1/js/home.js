$(document).ready(function () {
  $('h1').addClass('text-center');
  $('h2').addClass('text-center');
  $('h1').removeClass('myBannerHeading').addClass('page-header');
  $('#yellowHeading').text('Yellow Team');
  $('#yellowHeading').css('background-color', 'yellow');
  $('#orangeHeading').css('background-color', 'orange');
  $('#redHeading').css('background-color', 'red');
  $('#blueHeading').css('background-color', 'blue');
  $('#yellowTeamList').append('<li>Joseph Banks</li>');
  $('#yellowTeamList').append('<li>Simon Jones</li>');
  $('#oops').hide();
  $('#footerPlaceholder').remove();
  $('#footer').append('p').text('test');
  $('#footer').css('font-family', 'Courier');
  $('#footer').css('fontSize', '24px');

});
