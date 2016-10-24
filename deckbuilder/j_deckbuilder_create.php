
<?php		
define('_JEXEC', 1 );
define('JPATH_BASE', $_SERVER['DOCUMENT_ROOT'] ); 
define( 'DS','/' );



function popOptions()

{
	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");
//--select a card-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id'] . ".png"; ?>">--------<?php echo $rows['card_name']; ?>--------</option>
<?php
}
//--5* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>---------- 5* Cards ----------</option>
<?php
}
//5* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 4 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}

//--4* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>--------- 4* Cards ----------</option>
<?php
}
//4* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 3 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}

//--3* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>---------- 3* Cards ----------</option>
<?php
}
//3* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 2 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}


//--2* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>--------- 2* Cards ----------</option>
<?php
}
//2* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 1 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>">--------<?php echo $rows['card_name']; ?>--------</option>
<?php
}
//--5* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>---------- 1* Cards ----------</option>
<?php
}
//1* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 0 and card_id > 1000000000 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}

//--0* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);


//--Vehicles header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
/*while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>--------- Vehicles ----------</option>
<?php
}
//2* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = -10 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/custom/images/vehicles/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}*/



}

?>


<form method="POST" name="deckchoice" action="j_deckbuilder_bounce.php">

<p>How many simulations?: <input type="text" name="amount" value="1"/></p>
<p>Formation 1 Name: <input type="text" name="name1" /></p>
<p>Formation 1 Force Side:<select name="force1" id="force1">
<option value="L" selected>Light Side Force Boost</option>
<option value="D">Dark Side Force Boost</option>
</select>
<p>Formation 2 Name: <input type="text" name="name2" /></p>
<p>Formation 2 Force Side:<select name="force2" id="force2">
<option value="L" selected>Light Side Force Boost</option>
<option value="D">Dark Side Force Boost</option>
</select>
<br><br>
<table>

<tr>
<td colspan=2><h2>Formation 1 Front Row</h2></td>
</tr>

<tr>
<td>

<img id="imageToSwap1" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card1" id="card1" onChange="swapImage1()">
<?php popOptions(); ?>
</select>
<select name="state1" id="state1">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader1" id="leader1">
<option value="-1">No leader</option>
<option value="0" selected>Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap2" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card2" id="card2" onChange="swapImage2()">
<?php popOptions(); ?>
</select>
<select name="state2" id="state2">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader2" id="leader2">
<option value="-1" selected>No leader</option>
<option value="1">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap3" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card3" id="card3" onChange="swapImage3()">
<?php popOptions(); ?>
</select>
<select name="state3" id="state3">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader3" id="leader3">
<option value="-1" selected>No leader</option>
<option value="2">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap4" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card4" id="card4" onChange="swapImage4()">
<?php popOptions(); ?>
</select>
<select name="state4" id="state4">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader4" id="leader4">
<option value="-1" selected>No leader</option>
<option value="3">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap5" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card5" id="card5" onChange="swapImage5()">
<?php popOptions(); ?>
</select>
<select name="state5" id="state5">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader5" id="leader5">
<option value="-1" selected>No leader</option>
<option value="4">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap6" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card6" id="card6" onChange="swapImage6()">
<?php popOptions(); ?>
</select>
<select name="state6" id="state6">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader6" id="leader6">
<option value="-1" selected>No leader</option>
<option value="5">Leader</option>
</select>
<br>&nbsp;
</td>
</tr>


<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 1 Middle Row</h2></td>
</tr>






<tr>
<td>

<img id="imageToSwap7" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card7" id="card7" onChange="swapImage7()">
<?php popOptions(); ?>
</select>
<select name="state7" id="state7">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader7" id="leader7">
<option value="-1" selected>No leader</option>
<option value="6">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap8" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card8" id="card8" onChange="swapImage8()">
<?php popOptions(); ?>
</select>
<select name="state8" id="state8">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader8" id="leader8">
<option value="-1" selected>No leader</option>
<option value="7">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap9" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>
<select name="card9" id="card9" onChange="swapImage9()">
<?php popOptions(); ?>
</select>
<select name="state9" id="state9">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader9" id="leader9">
<option value="-1" selected>No leader</option>
<option value="8">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap10" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card10" id="card10" onChange="swapImage10()">
<?php popOptions(); ?>
</select>
<select name="state10" id="state10">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader10" id="leader10">
<option value="-1" selected>No leader</option>
<option value="9">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap11" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card11" id="card11" onChange="swapImage11()">
<?php popOptions(); ?>
</select>
<select name="state11" id="state11">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader11" id="leader11">
<option value="-1" selected>No leader</option>
<option value="10">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap12" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card12" id="card12" onChange="swapImage12()">
<?php popOptions(); ?>
</select>
<select name="state12" id="state12">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader12" id="leader12">
<option value="-1" selected>No leader</option>
<option value="11">Leader</option>
</select>
<br>&nbsp;
</td>
</tr>



<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 1 Back Row</h2></td>
</tr>




<tr>
<td>

<img id="imageToSwap13" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card13" id="card13" onChange="swapImage13()">
<?php popOptions(); ?>
</select>
<select name="state13" id="state13">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader13" id="leader13">
<option value="-1" selected>No leader</option>
<option value="12">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap14" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card14" id="card14" onChange="swapImage14()">
<?php popOptions(); ?>
</select>
<select name="state14" id="state14">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader14" id="leader14">
<option value="-1" selected>No leader</option>
<option value="13">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap15" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card15" id="card15" onChange="swapImage15()">
<?php popOptions(); ?>
</select>
<select name="state15" id="state15">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader15" id="leader15">
<option value="-1" selected>No leader</option>
<option value="14">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap16" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card16" id="card16" onChange="swapImage16()">
<?php popOptions(); ?>
</select>
<select name="state16" id="state16">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader16" id="leader16">
<option value="-1" selected>No leader</option>
<option value="15">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>


<td>

<img id="imageToSwap17" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card17" id="card17" onChange="swapImage17()">
<?php popOptions(); ?>
</select>
<select name="state17" id="state17">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader17" id="leader17">
<option value="-1" selected>No leader</option>
<option value="16">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>


<td>

<img id="imageToSwap18" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card18" id="card18" onChange="swapImage18()">
<?php popOptions(); ?>
</select>
<select name="state18" id="state18">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader18" id="leader18">
<option value="-1" selected>No leader</option>
<option value="17">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 1 Possible Undercover Cards (Will be sent into Formation 2)</h2></td>
</tr>




<tr>
<td>

<img id="imageToSwap19" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card19" id="card19" onChange="swapImage19()">
<?php popOptions(); ?>
</select>
<select name="state19" id="state19">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap20" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card20" id="card20" onChange="swapImage20()">
<?php popOptions(); ?>
</select>
<select name="state20" id="state20">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap21" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card21" id="card21" onChange="swapImage21()">
<?php popOptions(); ?>
</select>
<select name="state21" id="state21">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>
</tr>
</table>

<table>
<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 1 Support Skills</h2></td>
</tr>




<tr>
<td>
Ambush
</td>
<td>

<select name="ambush1" id="ambush1">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Call to the Light Side
</td>
<td>

<select name="call1" id="call1">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Character Card HP Up
</td>
<td>

<select name="hp_up1" id="hp_up1">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
<option value="4">Level 4</option>
<option value="5">Level 5</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Lure of the Dark Side
</td>
<td>

<select name="lure1" id="lure1">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>
<td>
Prep Skill Nullification
</td>
<td>

<select name="null1" id="null1">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Prep Skill Trigger Up
</td>
<td>

<select name="prep1" id="prep1">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
<option value="4">Level 4</option>
<option value="5">Level 5</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>
<td>
Proximity Alarm
</td>
<td>

<select name="prox1" id="prox1">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
</select>
<br>&nbsp;
</td>

</tr>
</tr>
<tr>
<td>
Anti Lightsaber Tactics
</td>
<td>

<select name="anti1" id="anti1">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>
</table>

<table>

<tr>
<td colspan=2><h2>Formation 2 Front Row</h2></td>
</tr>

<tr>
<td>

<img id="imageToSwap22" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card22" id="card22" onChange="swapImage22()">
<?php popOptions(); ?>
</select>
<select name="state22" id="state22">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader22" id="leader22">
<option value="-1">No leader</option>
<option value="0" selected>Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap23" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card23" id="card23" onChange="swapImage23()">
<?php popOptions(); ?>
</select>
<select name="state23" id="state23">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader23" id="leader23">
<option value="-1" selected>No leader</option>
<option value="1">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap24" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card24" id="card24" onChange="swapImage24()">
<?php popOptions(); ?>
</select>
<select name="state24" id="state24">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader24" id="leader24">
<option value="-1" selected>No leader</option>
<option value="2">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap25" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card25" id="card25" onChange="swapImage25()">
<?php popOptions(); ?>
</select>
<select name="state25" id="state25">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader25" id="leader25">
<option value="-1" selected>No leader</option>
<option value="3">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap26" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card26" id="card26" onChange="swapImage26()">
<?php popOptions(); ?>
</select>
<select name="state26" id="state26">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader26" id="leader26">
<option value="-1" selected>No leader</option>
<option value="4">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap27" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card27" id="card27" onChange="swapImage27()">
<?php popOptions(); ?>
</select>
<select name="state27" id="state27">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader27" id="leader27">
<option value="-1" selected>No leader</option>
<option value="5">Leader</option>
</select>
<br>&nbsp;
</td>
</tr>


<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 2 Middle Row</h2></td>
</tr>






<tr>
<td>

<img id="imageToSwap28" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card28" id="card28" onChange="swapImage28()">
<?php popOptions(); ?>
</select>
<select name="state28" id="state28">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader28" id="leader28">
<option value="-1" selected>No leader</option>
<option value="6">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap29" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card29" id="card29" onChange="swapImage29()">
<?php popOptions(); ?>
</select>
<select name="state29" id="state29">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader29" id="leader29">
<option value="-1" selected>No leader</option>
<option value="7">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap30" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>
<select name="card30" id="card30" onChange="swapImage30()">
<?php popOptions(); ?>
</select>
<select name="state30" id="state30">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader30" id="leader30">
<option value="-1" selected>No leader</option>
<option value="8">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap31" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card31" id="card31" onChange="swapImage31()">
<?php popOptions(); ?>
</select>
<select name="state31" id="state31">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader31" id="leader31">
<option value="-1" selected>No leader</option>
<option value="9">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap32" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card32" id="card32" onChange="swapImage32()">
<?php popOptions(); ?>
</select>
<select name="state32" id="state32">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader32" id="leader32">
<option value="-1" selected>No leader</option>
<option value="10">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap33" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card33" id="card33" onChange="swapImage33()">
<?php popOptions(); ?>
</select>
<select name="state33" id="state33">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader33" id="leader33">
<option value="-1" selected>No leader</option>
<option value="11">Leader</option>
</select>
<br>&nbsp;
</td>
</tr>



<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 2 Back Row</h2></td>
</tr>




<tr>
<td>

<img id="imageToSwap34" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card34" id="card34" onChange="swapImage34()">
<?php popOptions(); ?>
</select>
<select name="state34" id="state34">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader34" id="leader34">
<option value="-1" selected>No leader</option>
<option value="12">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap35" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card35" id="card35" onChange="swapImage35()">
<?php popOptions(); ?>
</select>
<select name="state35" id="state35">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader35" id="leader35">
<option value="-1" selected>No leader</option>
<option value="13">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap36" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card36" id="card36" onChange="swapImage36()">
<?php popOptions(); ?>
</select>
<select name="state36" id="state36">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader36" id="leader36">
<option value="-1" selected>No leader</option>
<option value="14">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap37" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card37" id="card37" onChange="swapImage37()">
<?php popOptions(); ?>
</select>
<select name="state37" id="state37">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader37" id="leader37">
<option value="-1" selected>No leader</option>
<option value="15">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>


<td>

<img id="imageToSwap38" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card38" id="card38" onChange="swapImage38()">
<?php popOptions(); ?>
</select>
<select name="state38" id="state38">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader38" id="leader38">
<option value="-1" selected>No leader</option>
<option value="16">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>


<td>

<img id="imageToSwap39" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card39" id="card39" onChange="swapImage39()">
<?php popOptions(); ?>
</select>
<select name="state39" id="state39">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<select name="leader39" id="leader39">
<option value="-1" selected>No leader</option>
<option value="17">Leader</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 2 Possible Undercover Cards (Will be sent into Formation 1)</h2></td>
</tr>




<tr>
<td>

<img id="imageToSwap40" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card40" id="card40" onChange="swapImage40()">
<?php popOptions(); ?>
</select>
<select name="state40" id="state40">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap41" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card41" id="card41" onChange="swapImage41()">
<?php popOptions(); ?>
</select>
<select name="state41" id="state41">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>


<td>

<img id="imageToSwap42" width="50" height="70" src="/SWFC/images/cards/all/blank.png" />
</td>
<td>

<select name="card42" id="card42" onChange="swapImage42()">
<?php popOptions(); ?>
</select>
<select name="state42" id="state42">
<option value="0">Base</option>
<option value="1">Evo 1</option>
<option value="2">Evo 2 (3 Card)</option>
<option value="3">Evo 2 (4 Card)</option>
<option value="4" selected>Evo Max (4-7)</option>
<option value="5">Evo Max (5-9)</option>
<option value="6">Evo Max (6-11)</option>
<option value="7">Evo Max (7-13)</option>
<option value="8">Evo Max (8-15)</option>
<option value="9">Awakened</option>
<option value="10">Awakened+</option>
</select>
<br>&nbsp;
</td>
</tr>
</table>

<table>
<tr>
<td colspan=2>
<p>&nbsp;</p><h2>Formation 2 Support Skills</h2></td>
</tr>




<tr>
<td>
Ambush
</td>
<td>

<select name="ambush2" id="ambush2">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Call to the Light Side
</td>
<td>

<select name="call2" id="call2">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Character Card HP Up
</td>
<td>

<select name="hp_up2" id="hp_up2">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
<option value="4">Level 4</option>
<option value="5">Level 5</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Lure of the Dark Side
</td>
<td>

<select name="lure2" id="lure2">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>
<td>
Prep Skill Nullification
</td>
<td>

<select name="null2" id="null2">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>

<tr>
<td>
Prep Skill Trigger Up
</td>
<td>

<select name="prep2" id="prep2">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
<option value="4">Level 4</option>
<option value="5">Level 5</option>
</select>
<br>&nbsp;
</td>

</tr>
<tr>
<td>
Proximity Alarm
</td>
<td>

<select name="prox2" id="prox2">
<option value="0" selected></option>
<option value="1">Level 1</option>
<option value="2">Level 2</option>
<option value="3">Level 3</option>
</select>
<br>&nbsp;
</td>

</tr>
</tr>
<tr>
<td>
Anti Lightsaber Tactics
</td>
<td>

<select name="anti2" id="anti2">
<option value="false" selected></option>
<option value="true">Level 1</option>
</select>
<br>&nbsp;
</td>

</tr>
</table>

<p>&nbsp;</p>
<input type="submit" name="build" value="Simulate These Decks"><p>

<p>&nbsp;</p>
</form>
<script type="text/javascript">
function swapImage1(){
	var image = document.getElementById("imageToSwap1");
	var dropd = document.getElementById("card1");
	image.src = dropd.value;	
};
function swapImage2(){
	var image = document.getElementById("imageToSwap2");
	var dropd = document.getElementById("card2");
	image.src = dropd.value;	
};
function swapImage3(){
	var image = document.getElementById("imageToSwap3");
	var dropd = document.getElementById("card3");
	image.src = dropd.value;	
};
function swapImage4(){
	var image = document.getElementById("imageToSwap4");
	var dropd = document.getElementById("card4");
	image.src = dropd.value;	
};
function swapImage5(){
	var image = document.getElementById("imageToSwap5");
	var dropd = document.getElementById("card5");
	image.src = dropd.value;	
};
function swapImage6(){
	var image = document.getElementById("imageToSwap6");
	var dropd = document.getElementById("card6");
	image.src = dropd.value;	
};

function swapImage7(){
	var image = document.getElementById("imageToSwap7");
	var dropd = document.getElementById("card7");
	image.src = dropd.value;	
};
function swapImage8(){
	var image = document.getElementById("imageToSwap8");
	var dropd = document.getElementById("card8");
	image.src = dropd.value;	
};
function swapImage9(){
	var image = document.getElementById("imageToSwap9");
	var dropd = document.getElementById("card9");
	image.src = dropd.value;	
};
function swapImage10(){
	var image = document.getElementById("imageToSwap10");
	var dropd = document.getElementById("card10");
	image.src = dropd.value;	
};
function swapImage11(){
	var image = document.getElementById("imageToSwap11");
	var dropd = document.getElementById("card11");
	image.src = dropd.value;	
};
function swapImage12(){
	var image = document.getElementById("imageToSwap12");
	var dropd = document.getElementById("card12");
	image.src = dropd.value;	
};

function swapImage13(){
	var image = document.getElementById("imageToSwap13");
	var dropd = document.getElementById("card13");
	image.src = dropd.value;	
};
function swapImage14(){
	var image = document.getElementById("imageToSwap14");
	var dropd = document.getElementById("card14");
	image.src = dropd.value;	
};
function swapImage15(){
	var image = document.getElementById("imageToSwap15");
	var dropd = document.getElementById("card15");
	image.src = dropd.value;	
};
function swapImage16(){
	var image = document.getElementById("imageToSwap16");
	var dropd = document.getElementById("card16");
	image.src = dropd.value;	
};
function swapImage17(){
	var image = document.getElementById("imageToSwap17");
	var dropd = document.getElementById("card17");
	image.src = dropd.value;	
};
function swapImage18(){
	var image = document.getElementById("imageToSwap18");
	var dropd = document.getElementById("card18");
	image.src = dropd.value;	
};
function swapImage19(){
	var image = document.getElementById("imageToSwap19");
	var dropd = document.getElementById("card19");
	image.src = dropd.value;	
};
function swapImage20(){
	var image = document.getElementById("imageToSwap20");
	var dropd = document.getElementById("card20");
	image.src = dropd.value;	
};
function swapImage21(){
	var image = document.getElementById("imageToSwap21");
	var dropd = document.getElementById("card21");
	image.src = dropd.value;	
};
function swapImage22(){
	var image = document.getElementById("imageToSwap22");
	var dropd = document.getElementById("card22");
	image.src = dropd.value;	
};
function swapImage23(){
	var image = document.getElementById("imageToSwap23");
	var dropd = document.getElementById("card23");
	image.src = dropd.value;	
};
function swapImage24(){
	var image = document.getElementById("imageToSwap24");
	var dropd = document.getElementById("card24");
	image.src = dropd.value;	
};
function swapImage25(){
	var image = document.getElementById("imageToSwap25");
	var dropd = document.getElementById("card25");
	image.src = dropd.value;	
};
function swapImage26(){
	var image = document.getElementById("imageToSwap26");
	var dropd = document.getElementById("card26");
	image.src = dropd.value;	
};
function swapImage27(){
	var image = document.getElementById("imageToSwap27");
	var dropd = document.getElementById("card27");
	image.src = dropd.value;	
};

function swapImage28(){
	var image = document.getElementById("imageToSwap28");
	var dropd = document.getElementById("card28");
	image.src = dropd.value;	
};
function swapImage29(){
	var image = document.getElementById("imageToSwap29");
	var dropd = document.getElementById("card29");
	image.src = dropd.value;	
};
function swapImage30(){
	var image = document.getElementById("imageToSwap30");
	var dropd = document.getElementById("card30");
	image.src = dropd.value;	
};
function swapImage31(){
	var image = document.getElementById("imageToSwap31");
	var dropd = document.getElementById("card31");
	image.src = dropd.value;	
};
function swapImage32(){
	var image = document.getElementById("imageToSwap32");
	var dropd = document.getElementById("card32");
	image.src = dropd.value;	
};
function swapImage33(){
	var image = document.getElementById("imageToSwap33");
	var dropd = document.getElementById("card33");
	image.src = dropd.value;	
};

function swapImage34(){
	var image = document.getElementById("imageToSwap34");
	var dropd = document.getElementById("card34");
	image.src = dropd.value;	
};
function swapImage35(){
	var image = document.getElementById("imageToSwap35");
	var dropd = document.getElementById("card35");
	image.src = dropd.value;	
};
function swapImage36(){
	var image = document.getElementById("imageToSwap36");
	var dropd = document.getElementById("card36");
	image.src = dropd.value;	
};
function swapImage37(){
	var image = document.getElementById("imageToSwap37");
	var dropd = document.getElementById("card37");
	image.src = dropd.value;	
};
function swapImage38(){
	var image = document.getElementById("imageToSwap38");
	var dropd = document.getElementById("card38");
	image.src = dropd.value;	
};
function swapImage39(){
	var image = document.getElementById("imageToSwap39");
	var dropd = document.getElementById("card39");
	image.src = dropd.value;	
};
function swapImage40(){
	var image = document.getElementById("imageToSwap40");
	var dropd = document.getElementById("card40");
	image.src = dropd.value;	
};
function swapImage41(){
	var image = document.getElementById("imageToSwap41");
	var dropd = document.getElementById("card41");
	image.src = dropd.value;	
};
function swapImage42(){
	var image = document.getElementById("imageToSwap42");
	var dropd = document.getElementById("card42");
	image.src = dropd.value;	
};

</script>