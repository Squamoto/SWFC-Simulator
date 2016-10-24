<?php
$amount = $_POST['amount'];
if(!is_numeric($amount) || $amount < 1)
{
	$amount = 1;
}
elseif($amount > 1000)
{
	$amount = 1000;
}
$name1 = str_replace(" ", "", $_POST['name1']);
if($name1 == "")
{
	$name1 = "Formation1";
}
$force1 = $_POST['force1'];
$name2 = str_replace(" ", "", $_POST['name2']);
if($name2 == "")
{
	$name2 = "Formation2";
}
$force1 = $_POST['force1'];
$force2 = $_POST['force2'];
$cardimage1 = $_POST['card1'];
$cardstate1 = $_POST['state1'];
$leader1 = $_POST['leader1'];
$cardimage2 = $_POST['card2'];
$cardstate2 = $_POST['state2'];
$leader2 = $_POST['leader2'];
$cardimage3 = $_POST['card3'];
$cardstate3 = $_POST['state3'];
$leader3 = $_POST['leader3'];
$cardimage4 = $_POST['card4'];
$cardstate4 = $_POST['state4'];
$leader4 = $_POST['leader4'];
$cardimage5 = $_POST['card5'];
$cardstate5 = $_POST['state5'];
$leader5 = $_POST['leader5'];
$cardimage6 = $_POST['card6'];
$cardstate6 = $_POST['state6'];
$leader6 = $_POST['leader6'];
$cardimage7 = $_POST['card7'];
$cardstate7 = $_POST['state7'];
$leader7 = $_POST['leader7'];
$cardimage8 = $_POST['card8'];
$cardstate8 = $_POST['state8'];
$leader8 = $_POST['leader8'];
$cardimage9 = $_POST['card9'];
$cardstate9 = $_POST['state9'];
$leader9 = $_POST['leader9'];
$cardimage10 = $_POST['card10'];
$cardstate10 = $_POST['state10'];
$leader10 = $_POST['leader10'];
$cardimage11 = $_POST['card11'];
$cardstate11 = $_POST['state11'];
$leader11 = $_POST['leader11'];
$cardimage12 = $_POST['card12'];
$cardstate12 = $_POST['state12'];
$leader12 = $_POST['leader12'];
$cardimage13 = $_POST['card13'];
$cardstate13 = $_POST['state13'];
$leader13 = $_POST['leader13'];
$cardimage14 = $_POST['card14'];
$cardstate14 = $_POST['state14'];
$leader14 = $_POST['leader14'];
$cardimage15 = $_POST['card15'];
$cardstate15 = $_POST['state15'];
$leader15 = $_POST['leader15'];
$cardimage16 = $_POST['card16'];
$cardstate16 = $_POST['state16'];
$leader16 = $_POST['leader16'];
$cardimage17 = $_POST['card17'];
$cardstate17 = $_POST['state17'];
$leader17 = $_POST['leader17'];
$cardimage18 = $_POST['card18'];
$cardstate18 = $_POST['state18'];
$leader18 = $_POST['leader18'];
$ambush1 = $_POST['ambush1'];
$call1 = $_POST['call1'];
$hp_up1 = $_POST['hp_up1'];
$lure1 = $_POST['lure1'];
$null1 = $_POST['null1'];
$prep1 = $_POST['prep1'];
$prox1 = $_POST['prox1'];
$anti1 = $_POST['anti1'];
$undercover1 = substr($_POST['card19'], -14, 10);
$uc_state1 = $_POST['state19'];
$undercover2 = substr($_POST['card20'], -14, 10);
$uc_state2 = $_POST['state20'];
$undercover3 = substr($_POST['card21'], -14, 10);
$uc_state3 = $_POST['state21'];
$cardtrim1 = substr($cardimage1, -14, 10);
$cardtrim2 = substr($cardimage2, -14, 10);
$cardtrim3 = substr($cardimage3, -14, 10);
$cardtrim4 = substr($cardimage4, -14, 10);
$cardtrim5 = substr($cardimage5, -14, 10);
$cardtrim6 = substr($cardimage6, -14, 10);
$cardtrim7 = substr($cardimage7, -14, 10);
$cardtrim8 = substr($cardimage8, -14, 10);
$cardtrim9 = substr($cardimage9, -14, 10);
$cardtrim10 = substr($cardimage10, -14, 10);
$cardtrim11 = substr($cardimage11, -14, 10);
$cardtrim12 = substr($cardimage12, -14, 10);
$cardtrim13 = substr($cardimage13, -14, 10);
$cardtrim14 = substr($cardimage14, -14, 10);
$cardtrim15 = substr($cardimage15, -14, 10);
$cardtrim16 = substr($cardimage16, -14, 10);
$cardtrim17 = substr($cardimage17, -14, 10);
$cardtrim18 = substr($cardimage18, -14, 10);

$cardimage22 = $_POST['card22'];
$cardstate22 = $_POST['state22'];
$leader22 = $_POST['leader22'];
$cardimage23 = $_POST['card23'];
$cardstate23 = $_POST['state23'];
$leader23 = $_POST['leader23'];
$cardimage24 = $_POST['card24'];
$cardstate24 = $_POST['state24'];
$leader24 = $_POST['leader24'];
$cardimage25 = $_POST['card25'];
$cardstate25 = $_POST['state25'];
$leader25 = $_POST['leader25'];
$cardimage26 = $_POST['card26'];
$cardstate26 = $_POST['state26'];
$leader26 = $_POST['leader26'];
$cardimage27 = $_POST['card27'];
$cardstate27 = $_POST['state27'];
$leader27 = $_POST['leader27'];
$cardimage28 = $_POST['card28'];
$cardstate28 = $_POST['state28'];
$leader28 = $_POST['leader28'];
$cardimage29 = $_POST['card29'];
$cardstate29 = $_POST['state29'];
$leader29 = $_POST['leader29'];
$cardimage30 = $_POST['card30'];
$cardstate30 = $_POST['state30'];
$leader30 = $_POST['leader30'];
$cardimage31 = $_POST['card31'];
$cardstate31 = $_POST['state31'];
$leader31 = $_POST['leader31'];
$cardimage32 = $_POST['card32'];
$cardstate32 = $_POST['state32'];
$leader32 = $_POST['leader32'];
$cardimage33 = $_POST['card33'];
$cardstate33 = $_POST['state33'];
$leader33 = $_POST['leader33'];
$cardimage34 = $_POST['card34'];
$cardstate34 = $_POST['state34'];
$leader34 = $_POST['leader34'];
$cardimage35 = $_POST['card35'];
$cardstate35 = $_POST['state35'];
$leader35 = $_POST['leader35'];
$cardimage36 = $_POST['card36'];
$cardstate36 = $_POST['state36'];
$leader36 = $_POST['leader36'];
$cardimage37 = $_POST['card37'];
$cardstate37 = $_POST['state37'];
$leader37 = $_POST['leader37'];
$cardimage38 = $_POST['card38'];
$cardstate38 = $_POST['state38'];
$leader38 = $_POST['leader38'];
$cardimage39 = $_POST['card39'];
$cardstate39 = $_POST['state39'];
$leader39 = $_POST['leader39'];
$ambush2 = $_POST['ambush2'];
$call2 = $_POST['call2'];
$hp_up2 = $_POST['hp_up2'];
$lure2 = $_POST['lure2'];
$null2 = $_POST['null2'];
$prep2 = $_POST['prep2'];
$prox2 = $_POST['prox2'];
$anti2 = $_POST['anti2'];
$undercover4 = substr($_POST['card40'], -14, 10);
$uc_state4 = $_POST['state40'];
$undercover5 = substr($_POST['card41'], -14, 10);
$uc_state5 = $_POST['state41'];
$undercover6 = substr($_POST['card42'], -14, 10);
$uc_state6 = $_POST['state42'];
$cardtrim22 = substr($cardimage22, -14, 10);
$cardtrim23 = substr($cardimage23, -14, 10);
$cardtrim24 = substr($cardimage24, -14, 10);
$cardtrim25 = substr($cardimage25, -14, 10);
$cardtrim26 = substr($cardimage26, -14, 10);
$cardtrim27 = substr($cardimage27, -14, 10);
$cardtrim28 = substr($cardimage28, -14, 10);
$cardtrim29 = substr($cardimage29, -14, 10);
$cardtrim30 = substr($cardimage30, -14, 10);
$cardtrim31 = substr($cardimage31, -14, 10);
$cardtrim32 = substr($cardimage32, -14, 10);
$cardtrim33 = substr($cardimage33, -14, 10);
$cardtrim34 = substr($cardimage34, -14, 10);
$cardtrim35 = substr($cardimage35, -14, 10);
$cardtrim36 = substr($cardimage36, -14, 10);
$cardtrim37 = substr($cardimage37, -14, 10);
$cardtrim38 = substr($cardimage38, -14, 10);
$cardtrim39 = substr($cardimage39, -14, 10);

$cardarray = array(	 
		"$cardtrim1",
		"$cardtrim2",
		"$cardtrim3",
		"$cardtrim4",
		"$cardtrim5",
		"$cardtrim6",
		"$cardtrim7",
		"$cardtrim8",
		"$cardtrim9",
		"$cardtrim10",
		"$cardtrim11",
		"$cardtrim12",
		"$cardtrim13",
		"$cardtrim14",
		"$cardtrim15",
		"$cardtrim16",
		"$cardtrim17",
		"$cardtrim18",
		 );

$uc_array = array(
		"$undercover1",
		"$undercover2",
		"$undercover3",
		);
		
$uc_state_array = array(
		"$uc_state1",
		"$uc_state2",
		"$uc_state3",
		);
		 
$statearray = array(	 
		"$cardstate1",
		"$cardstate2",
		"$cardstate3",
		"$cardstate4",
		"$cardstate5",
		"$cardstate6",
		"$cardstate7",
		"$cardstate8",
		"$cardstate9",
		"$cardstate10",
		"$cardstate11",
		"$cardstate12",
		"$cardstate13",
		"$cardstate14",
		"$cardstate15",
		"$cardstate16",
		"$cardstate17",
		"$cardstate18",
		 );
		 
$leaderarray = array(	 
		"$leader1",
		"$leader2",
		"$leader3",
		"$leader4",
		"$leader5",
		"$leader6",
		"$leader7",
		"$leader8",
		"$leader9",
		"$leader10",
		"$leader11",
		"$leader12",
		"$leader13",
		"$leader14",
		"$leader15",
		"$leader16",
		"$leader17",
		"$leader18",
		 );

$cardarray2 = array(	 
		"$cardtrim22",
		"$cardtrim23",
		"$cardtrim24",
		"$cardtrim25",
		"$cardtrim26",
		"$cardtrim27",
		"$cardtrim28",
		"$cardtrim29",
		"$cardtrim30",
		"$cardtrim31",
		"$cardtrim32",
		"$cardtrim33",
		"$cardtrim34",
		"$cardtrim35",
		"$cardtrim36",
		"$cardtrim37",
		"$cardtrim38",
		"$cardtrim39",
		 );

$uc_array2 = array(
		"$undercover4",
		"$undercover5",
		"$undercover6",
		);
		
$uc_state_array2 = array(
		"$uc_state4",
		"$uc_state5",
		"$uc_state6",
		);
		 
$statearray2 = array(	 
		"$cardstate22",
		"$cardstate23",
		"$cardstate24",
		"$cardstate25",
		"$cardstate26",
		"$cardstate27",
		"$cardstate28",
		"$cardstate29",
		"$cardstate30",
		"$cardstate31",
		"$cardstate32",
		"$cardstate33",
		"$cardstate34",
		"$cardstate35",
		"$cardstate36",
		"$cardstate37",
		"$cardstate38",
		"$cardstate39",
		 );
		 
$leaderarray2 = array(	 
		"$leader22",
		"$leader23",
		"$leader24",
		"$leader25",
		"$leader26",
		"$leader27",
		"$leader28",
		"$leader29",
		"$leader30",
		"$leader31",
		"$leader32",
		"$leader33",
		"$leader34",
		"$leader35",
		"$leader36",
		"$leader37",
		"$leader38",
		"$leader39",
		 );		 

		 
$leader_f1 = -1;
$leader_f2 = -1;

for($i = 0; $i < sizeof($leaderarray); $i++)
{
	if($leader_f1 >= 0 && $leaderarray[$i] != -1)
	{
		exit("Two or more leaders selected!");
	}
	elseif($leader_f1 < 0 && $leaderarray[$i] != -1)
	{
		$leader_f1 = $leaderarray[$i];
	}
}

for($i = 0; $i < sizeof($leaderarray2); $i++)
{
	if($leader_f2 >= 0 && $leaderarray2[$i] != -1)
	{
		exit("Two or more leaders selected!");
	}
	elseif($leader_f2 < 0 && $leaderarray2[$i] != -1)
	{
		$leader_f2 = $leaderarray2[$i];
	}
}

$deckfinal = "$amount $name1 ";

foreach($cardarray as $key => $value) {

	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

	$sql="SELECT * FROM cardinfo WHERE card_id = '".$value."'";
	$result=mysql_query($sql);
	$rows=mysql_fetch_array($result);
	
	if($rows['card_id'] == 0)
	{
		$deckfinal .= -1;
	}
	else
	{
		$deckfinal .= $rows['card_id'];
	}
	$deckfinal .= " ";
	$deckfinal .= $statearray[$key];
	$deckfinal .= " ";
	
	
}

$deckfinal .= "$leader_f1 $force1 $ambush1 $call1 $hp_up1 $lure1 $null1 $prep1 $prox1 $anti1 ";

foreach($uc_array as $key => $value) {

	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

	$sql="SELECT * FROM cardinfo WHERE card_id = '".$value."'";
	$result=mysql_query($sql);
	$rows=mysql_fetch_array($result);
	
	if($rows['card_id'] == 0)
	{
		$deckfinal .= -1;
	}
	else
	{
		$deckfinal .= $rows['card_id'];
	}
	$deckfinal .= " ";
	$deckfinal .= $uc_state_array[$key];
	$deckfinal .= " ";
	
	
}

$deckfinal .= "$name2 ";

foreach($cardarray2 as $key => $value) {

	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

	$sql="SELECT * FROM cardinfo WHERE card_id = '".$value."'";
	$result=mysql_query($sql);
	$rows=mysql_fetch_array($result);
	
	if($rows['card_id'] == 0)
	{
		$deckfinal .= -1;
	}
	else
	{
		$deckfinal .= $rows['card_id'];
	}
	$deckfinal .= " ";
	$deckfinal .= $statearray2[$key];
	$deckfinal .= " ";
	
	
}

$deckfinal .= "$leader_f2 $force2 $ambush2 $call2 $hp_up2 $lure2 $null2 $prep2 $prox2 $anti2 ";

foreach($uc_array2 as $key => $value) {

	mysql_connect("localhost", "root", "")or die("cannot connect"); 
	mysql_select_db("cardinfo")or die("cannot select DB");

	$sql="SELECT * FROM cardinfo WHERE card_id = '".$value."'";
	$result=mysql_query($sql);
	$rows=mysql_fetch_array($result);
	
	if($rows['card_id'] == 0)
	{
		$deckfinal .= -1;
	}
	else
	{
		$deckfinal .= $rows['card_id'];
	}
	$deckfinal .= " ";
	$deckfinal .= $uc_state_array2[$key];
	$deckfinal .= " ";
	
	
}

//exit($deckfinal);
header( "Location: simulator.php?parameters=$deckfinal" );



?>