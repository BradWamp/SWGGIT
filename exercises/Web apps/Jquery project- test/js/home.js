// home.js
//can use jQuery or $
// home must always come after the script calling for jquery.
// must surround code with (document) 
// jquery uses css to select html elements
$(document).ready(function(){
	$('#third').remove();
	$('#emptyDiv').append('p').text('A new paragraph of text');
	$('#first').css('color', 'blue');
	
});