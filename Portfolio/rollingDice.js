var playerMoney = 0;
var maxMoney = 0;
var maxMoneyRound = 0;
var roundCounter = 0;
var dice1;
var dice2;
var sumDice;

//when I tried to hide/display table with a function before play() it would not work. why?
function play() 
{
	
	playerMoney = document.getElementById("startingBet").value;
   
var startingMoney = playerMoney

  /*console.log("playerMoney value after input = " + playerMoney );

  console.log("%%%%%%%%%%%%%%%%%%%%%%" );*/
  
  if (playerMoney <= 0) 
  {
  	document.getElementById("enterMoney").innerHTML = "Look! You've screwed up the game. You need to enter an actual amount!";
  }
 
  else
  {
  		document.getElementById("enterMoney").style.display = "none"
  
    while (playerMoney > .99)
  {
        dice1 = Math.ceil(Math.random() * 6);
        dice2 = Math.ceil(Math.random() * 6);
        sumDice = dice1 + dice2;
        


      if (playerMoney > maxMoney)
       {
         maxMoney = playerMoney;
         maxMoneyRound = roundCounter;
       }

      if (sumDice == 7)
        {
          playerMoney=playerMoney-(-4);
        }
      else 
        {
          playerMoney-=1;
        }  
      roundCounter = roundCounter -(-1);

      /*display variable values - comment out when not needed
  console.log("roundcounter = " + roundcounter);
  console.log("playermoney = " + playermoney);
  console.log("dice1 = " + dice1);
  console.log("dice2 = " + dice2 );
  console.log("<br/>");
  console.log("-----------------------");*/
  };
}

document.getElementById("tableId").style.display = 'block';
document.getElementById("output1").innerHTML = "$"+startingMoney;
document.getElementById("output2").innerHTML = maxMoney;
document.getElementById("output3").innerHTML = maxMoneyRound;
document.getElementById("output4").innerHTML = roundCounter;
document.getElementById("playAgain").innerHTML = "Why not play again?";

maxMoney=playerMoney;
maxMoneyRound = 0;
roundCounter =0;

}

