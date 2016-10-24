
<div id="centercolumn">
<?php

if (!isset($_POST["deck"])) {
		header( "Location: j_deckbuilder.php" ) ;
		}
	else{
	//echo $_POST["deck"];
	}
	
	/*
	function popOptions($card){



	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

$sql="SELECT * FROM cardinfo WHERE `rarity` >= 0 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

if ($rows['card_id'] == $card){
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
}


}
*/


//##############################################








function popOptions($card){

	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");
//--select a card-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
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
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>---------- 5* Cards ----------</option>
<?php
}
//5* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 4 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){
if ($rows['card_id'] == $card){
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
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
if ($rows['card_id'] == $card){
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
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
if ($rows['card_id'] == $card){
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
}


//--2* cards header-- disabled
$sql="SELECT * FROM cardinfo WHERE `card_id` = 0";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>--------- 2* Skill Cards ----------</option>
<?php
}
//2* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = 1 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){
if ($rows['card_id'] == $card){
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
}



//--Vehicles header-- disabled
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
	
while($rows=mysql_fetch_array($result)){

?>
<option value="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>" disabled>--------- Vehicles ----------</option>
<?php
}
//2* Cards
$sql="SELECT * FROM cardinfo WHERE `rarity` = -10 ORDER BY card_name ASC";

$result=mysql_query($sql);
	
while($rows=mysql_fetch_array($result)){
if ($rows['card_id'] == $card){
?>
<option value="images/vehicles/<?php echo $rows['card_id']; ?>.png" selected><?php echo $rows['card_name']; ?></option>
<?php
}
else{
?>
<option value="images/vehicles/<?php echo $rows['card_id']; ?>.png"><?php echo $rows['card_name']; ?></option>
<?php
}
}



}











//################################################





















function popEvos($state)
{
switch($state){

	case "0":
	?>
	<option value="0" selected>Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
	<?php
    break;
    case "1":
	?>
	<option value="0">Base</option>
	<option value="1" selected>Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    
	<?php
   break;
	case "2":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2" selected>Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "3":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3" selected>Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "4":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4" selected>Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "5":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5" selected>Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "6":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6" selected>Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "7":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7" selected>Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
    	<?php
   break;
	case "8":
	?>
	<option value="0">Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8" selected>Evo Max (8-15)</option>
   	<?php
    break;
	default:
	?>
	<option value="0" selected>Base</option>
	<option value="1">Evo 1</option>
	<option value="2">Evo 2 (3 Card)</option>
	<option value="3">Evo 2 (4 Card)</option>
	<option value="4">Evo Max (4-7)</option>
	<option value="5">Evo Max (5-9)</option>
	<option value="6">Evo Max (6-11)</option>
	<option value="7">Evo Max (7-13)</option>
	<option value="8">Evo Max (8-15)</option>
   	<?php

	}
}



	
	
	
	
	$deckfull = $_POST["deck"];
	
	
	$deck_chunk = explode("-", $deckfull);
	
	//var_dump($deck_chunk);
	
	
	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

	
	
	$new_row = 0;
	?>
	<center>
	<form method="POST" name="deckchoice" action="j_deckbuilder_bounce.php">
<table>

<tr>
<td colspan=2><h2>Front Row</h2></td>
</tr>

<?php
	foreach ($deck_chunk as $value) {
	

	
	$deck_sub = (explode(",", $value));

	$card_id = $deck_sub[0];
	$card_state = $deck_sub[1];
	
	$sql="SELECT * FROM cardinfo WHERE card_id = $deck_sub[0]";
	$result=mysql_query($sql);
	$rows=mysql_fetch_array($result);
	
	?>
	
	<tr>
	<td>

	<img id="imageToSwap<?php echo $new_row+1; ?>" width="50" height="70" src="/SWFC/images/cards/all/<?php echo $rows['card_id']; ?>.png" />
	</td>
	<td>

	<select name="card<?php echo $new_row+1; ?>" id="card<?php echo $new_row+1; ?>" onChange="swapImage<?php echo $new_row+1; ?>()">
	<?php popOptions($deck_sub[0]); ?>
	</select>
	<select name="state<?php echo $new_row+1; ?>" id="state<?php echo $new_row+1; ?>">
	<?php popEvos($deck_sub[1]); ?>
	</select>

	<br>&nbsp;
	</td>

	</tr>
	
	<?php
	
	//echo "$card_id";
	//echo $rows['card_name'];
	//echo "$new_row"; works
	//var_dump($deck_sub);
	
	$new_row++;
	
	if($new_row == 6){
	?>
<tr>
<td colspan=2><h2>Middle Row</h2></td>
</tr>
<?php
	}
	if($new_row == 12){
	?>
<tr>
<td colspan=2><h2>Back Row</h2></td>
</tr>
<?php
	}
	
}
	
	?>
	
	
	
</table>


<p>&nbsp;</p>
<input type="submit" value="Build This Deck"><br>

<p>&nbsp;</p>
</form>

</center>

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

</script>

</div>