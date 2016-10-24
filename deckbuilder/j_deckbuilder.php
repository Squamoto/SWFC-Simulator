<head>
<link rel="stylesheet" type="text/css" href="dropt2.css" />
<style>
  td { font-size: 0.85em; }
</style>
</head>
   
    <div id="centercolumn">

	
	
      <p>&nbsp;</p>
	  
	  <center>
	  <table cellpadding=0 cellspacing=0 class="builderTable">
	  <tr>
	  
<?php
	
mysql_connect("localhost", "root", "")or die("cannot connect"); 
mysql_select_db("cardinfo")or die("cannot select DB");

$deck_full=$_GET['deck'];

$new_row= 0;
if (!isset($_GET["deck"]))
{
	$deck_full="";    
	include "j_deckbuilder_create.php";
}
$deck_chunk=(explode("-", $deck_full));
		
$card_count = 0;
$totalatk = 0;
$totaldef = 0;
$totalacc = 0;
$totaleva = 0;
$totalhp = 0;
$totalcost = 0;
$totalbs = 0;
$totalskills = "";
$position = 0;	
	
// VEHICLE IMPLEMENTATION
foreach ($deck_chunk as $key => $value)
{
	$deck_sub = (explode(",", $value));
	$position++;
	$card_id = $deck_sub[0];
	$card_state = $deck_sub[1];
	// CHECK FOR VEHICLES. AND MOVE HORIZONTALLY IF PLACED OUTSIDE OF DECK BOUNDARIES.
	
	$sql="SELECT * FROM cardinfo WHERE card_id = $card_id";
	$result=mysql_query($sql);
	while($rows=mysql_fetch_array($result))
	{
		if($rows['slot_x'] > 1 || $rows['slot_y'] > 1)
		{
		
			$x_size= $rows['slot_x'];
			$y_size= $rows['slot_y'];
			
		// IF VEHICLE WIDTH = 2 BUT IS PLACED IN A MANNER SUCH THAT IT WOULD BE OFF THE EDGE OF DECK THEN MOVE VEHICLE LEFT ONE SPACE.
			If($x_size == "2")
			{
				If($key == "5")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "11")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "17")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
			}
			
		// IF VEHICLE WIDTH = 3 BUT IS PLACED IN A MANNER SUCH THAT IT WOULD BE OFF THE RIGHT EDGE OF DECK THEN MOVE VEHICLE LEFT ONE OR TWO SPACES AS NEEDED.
			If($x_size == "3")
			{
				If($key == "5")
				{
					$newkey = $key-2;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "11")
				{
					$newkey = $key-2;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "17")
				{
					$newkey = $key-2;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "4")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "10")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
				If($key == "16")
				{
					$newkey = $key-1;
					list($scrap, $new_state) = split(',', $deck_chunk[$newkey]);
					If($new_state < 10)
					{
						$deck_chunk[$newkey] = $deck_chunk[$key];
						$deck_chunk[$key] = "0,0";
					}
					else
					{
						$deck_chunk[$key] = "0,0";
					}
				}
			}
		}
	}
}
	
foreach ($deck_chunk as $key => $value)
{
	$deck_sub = (explode(",", $value));
	$position++;
	$card_id = $deck_sub[0];
	$card_state = $deck_sub[1];
	// CHECK FOR VEHICLES AGAIN. AND MOVE VERTICALLY IF PLACED OUTSIDE OF DECK BOUNDARIES.
	
	$sql="SELECT * FROM cardinfo WHERE card_id = $card_id";
	$result=mysql_query($sql);
	while($rows=mysql_fetch_array($result))
	{
		if($rows['slot_x'] > 1 || $rows['slot_y'] > 1)
		{
			$x_size= $rows['slot_x'];
			$y_size= $rows['slot_y'];
				
		// IF VEHICLE HEIGHT > 2 BUT IS PLACED IN A MANNER SUCH THAT IT WOULD BE OFF THE BOTTOM OF DECK THEN MOVE VEHICLE UP ONE OR TWO SPACES AS NEEDED.
			if($y_size == "2")
			{
				If($key > 11)
				{
					$newkey = ($key-6);
					$deck_chunk[$newkey] = $deck_chunk[$key];
					$deck_chunk[$key] = "0,0";
				}			
			}
			if($y_size == "3")
			{
				If($key > 11)
				{
					$newkey = ($key-12);
					$deck_chunk[$newkey] = $deck_chunk[$key];
					$deck_chunk[$key] = "0,0";
				}			
			}
			if($y_size == "3")
			{
				If($key > 5 && $key < 12)
				{
					$newkey = ($key-6);
					$deck_chunk[$newkey] = $deck_chunk[$key];
					$deck_chunk[$key] = "0,0";
				}			
			}	
		}
	}
}
/*
$chunkey=0;
While ($chunkey <18){
echo $chunkey."=".$deck_chunk[$chunkey]."   ";
$chunkey++;
}
*/

//foreach ($deck_chunk as $key => $value) {
$chunkey=0;
While($chunkey<18)
{
	$key=$chunkey;
	$deck_sub = (explode(",", $deck_chunk[$chunkey]));
	$position = $key+1;
	$card_id = $deck_sub[0];
	$card_state = $deck_sub[1];
	// WRITE PIECES INTO DECK.

	$sql2="SELECT * FROM cardinfo WHERE card_id = $card_id";
	$result2=mysql_query($sql2);
	while($rows2=mysql_fetch_array($result2))
	{
		If ($rows2['slot_x'] > 1 || $rows2['slot_y'] > 1)
		{
			If($card_state <10)
			{	
				$veh_x = $rows2['slot_x'];
				$veh_y = $rows2['slot_y'];
			
				$x_count = 1;
				while($x_count <= $veh_x)
				{
					$key_count = $key + ($x_count - 1);
					$deck_chunk[$key_count] = $card_id.",".($x_count+10);
					$x_count++;				
				}
				if($veh_y > 1)
				{
					$key = $key+6;
					$x_count = 1;
						while($x_count <= $veh_x)
						{
							$key_count = $key + ($x_count - 1);
							$deck_chunk[$key_count] = $card_id.",".($x_count+20);
							$x_count++;
						}	
				}
					
				if($veh_y == 3)
				{
					$key = $key+6;
					$x_count = 1;
					while($x_count <= $veh_x)
					{
						$key_count = $key + ($x_count - 1);
						$deck_chunk[$key_count] = $card_id.",".($x_count+30);
						$x_count++;
					}
				}	
			}
		}
	}
	$chunkey++;
}

// BUILD DECK

foreach ($deck_chunk as $value) {

$new_row++;

$deck_sub = (explode(",", $value));

// echo "sub[0]= $deck_sub[0] <br>";
// echo "sub[1]= $deck_sub[1] <br>";

$card_id = $deck_sub[0];
$card_state = $deck_sub[1];




$sql="SELECT * FROM cardinfo WHERE card_id = $card_id";
$result=mysql_query($sql);
while($rows=mysql_fetch_array($result)){

If ($card_count <18 && $card_state <12){




// Let's find out where we are. 
$dir = dirname(__FILE__); 

$class_count = 0;
$timestamp = time();
$output_name = $timestamp . $card_count . $rand . '.png';




//If short range then add overlay.
If ($rows['card_range'] == 'S'){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/short_range.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 5, 5);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 1;
}

//If med range then add overlay.
If ($rows['card_range'] == 'M'){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/med_range.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 5, 5);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 1;
}

//If long range then add overlay.
If ($rows['card_range'] == 'L'){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/long_range.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 5, 5);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 1;
}

//If male class then add overlay.
If ($rows['race'] % 2 > 1){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/mal.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If female class then add overlay.
If ($rows['race'] % 4 > 2){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/fem.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If droid class then add overlay.
If ($rows['race'] % 8 > 4){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/dro.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If empire class then add overlay.
If ($rows['race'] % 65536 > 32768){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/emp.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If rebel class then add overlay.
If ($rows['race'] % 32768 > 16384){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/reb.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If ewok class then add overlay.
If ($rows['race'] % 2048 > 1024){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/ewo.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If gungan class then add overlay.
If ($rows['race'] % 8192 > 4096){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/gun.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If nabooan class then add overlay.
If ($rows['race'] % 16384 > 8192){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/nab.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If bounty hunter class then add overlay.
If ($rows['race'] % 512 > 256){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/bou.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If sith class then add overlay.
If ($rows['race'] % 128 > 64){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/sit.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If jedi class then add overlay.
If ($rows['race'] % 64 > 32){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/jed.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}
//If clone class then add overlay.
If ($rows['race'] % 4096 > 2048){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/clo.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/short_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}
//If wookie class then add overlay.
If ($rows['race'] % 524288 > 262144){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/woo.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/short_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If beast class then add overlay.
If ($rows['race'] % 1024 > 512){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/bea.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/short_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 58, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If republic class then add overlay.
If ($rows['race'] % 131072 > 65536){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/rep.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}

//If separatist class then add overlay.
If ($rows['race'] % 262144 > 131072){
	$class = new Imagick(); 
	if (FALSE === $class->readImage($dir . '/images/classes/new/sep.png')) 
	{ 
		throw new Exception(); 
	} 
	If ($class_count == 0){
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . '/SWFC/images/cards/all/blank_overlay.png')) 
	{ 
		throw new Exception(); 
	} 
	}
	else{
	$overlay = new Imagick(); 
	if (FALSE === $overlay->readImage($dir . "/SWFC/images/cards/all/outputs/$output_name")) 
	{ 
		throw new Exception(); 
	} 
	}
	$overlay->compositeImage($class, Imagick::COMPOSITE_DEFAULT, 75, $class_count);  
	$overlay->flattenImages(); 
	$overlay->setImageFileName($dir . '/SWFC/images/cards/all/outputs/' . $output_name); 
	
	if  (FALSE == $overlay->writeImage()) 
	{ 
		throw new Exception(); 
	} 
	$class_count = $class_count + 25;
	
}


If ($class_count == 0){
$output_name = 'blank_overlay.png';
}
else{
$output_name = 'outputs/' . $output_name;
}



If ($card_state == 0){
$card_pic = 0;
}
elseIf ($card_state == 1){
$card_pic = 1;
}
elseIf ($card_state == 2){
$card_pic = 2;
}
elseIf ($card_state == 3){
$card_pic = 2;
}
elseIf ($card_state > 3 && $card_state < 10){
$card_pic = 3;
}


If ($rows['slot_x'] > 1 || $rows['slot_y'] > 1){
$rowspan=$rows['slot_y'];
//$rowspan = ($rows['slot_y']*2) -1;
$tdwidth = $rows['slot_x']*80;
$tdheight = (($rows['slot_y']*2) -1 )*142;
?>
<td width="<?php echo $tdwidth; ?>" height="<?php echo $tdheight; ?>" colspan="<?php echo $rows['slot_x']; ?>" rowspan="<?php echo $rowspan; ?>"><img style="background:url(/SWFC/images/vehicles/full/<?php echo $rows['card_id'] . $card_state . ".png" ?>) no-repeat; background-repeat:no-repeat; background-position:center;" src=/SWFC/images/cards/all/blank_overlay.png width=<?php echo $tdwidth; ?> height=<?php echo $tdheight; ?>>
<?php
}
else{
?>
<td width=80><img style=background:url(/SWFC//SWFC/images/cards/all/<?php echo $rows['card_id'] . $card_pic . ".png" ?>) src=/SWFC/images/cards/all/<?php echo $output_name; ?>>
<?php
}
	
	
	
	
	
$baseatk = $rows['lvup_attack'];
$basedef = $rows['lvup_defence'];
$card_acc = $rows['accuracy'];
$card_eva = $rows['avoid'];
$card_apt = $rows['per_num'];

// BS = Attack x Accuracy + Defense x (HP/1000) x (Evasion+100)/100
// $card_bs = floor($card_atk * $card_acc + $card_def * ($card_hp / 1000) * ($card_eva + 100) / 100);



//new atk
$halfatk = floor($rows['lvup_attack'] * 0.07);

$evo1atk = $rows['lvup_attack'] + (floor(($rows['lvup_attack'] * 0.07)*2));

$evo23cardatk = floor(($evo1atk * 1.07) + $halfatk);
$evo24cardatk = $evo1atk + (floor(($evo1atk * 0.07)*2));

$evomax47atk = floor(($evo23cardatk * 1.07) + $halfatk);
$evomax815atk = $evo24cardatk + (floor(($evo24cardatk * 0.07)*2));

//new def
$halfdef = floor($rows['lvup_defence'] * 0.07);

$evo1def = $rows['lvup_defence'] + (floor(($rows['lvup_defence'] * 0.07)*2));

$evo23carddef = floor(($evo1def * 1.07) + $halfdef);
$evo24carddef = $evo1def + (floor(($evo1def * 0.07)*2));

$evomax47def = floor(($evo23carddef * 1.07) + $halfdef);
$evomax815def = $evo24carddef + (floor(($evo24carddef * 0.07)*2));

//old formulas for weird evos


$evomax59atk = floor(($evo23cardatk * 1.07) + ($evo1atk * 0.07));
$evomax59def = floor(($evo23carddef * 1.07) + ($evo1def * 0.07));

$evomax611atk = floor($evo23cardatk * 1.14);
$evomax611def = floor($evo23carddef * 1.14);

$evomax713atk = floor(($evo24cardatk * 1.07) + ($evo23cardatk * 0.07));
$evomax713def = floor(($evo24carddef * 1.07) + ($evo23carddef * 0.07));

//end formulas


switch ($card_state) {
    case "0":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Base</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $baseatk";
		 echo "<br>";
		 echo "DEF: $basedef";
		 echo "<br>";
	$totalatk = $totalatk + $baseatk;
	$totaldef = $totaldef + $basedef;
	If ($rows['card_id'] > 0){
	$card_hp = 1000;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $baseatk;
	$card_def = $basedef;
    break;
    case "1":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo 1</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evo1atk";
		 echo "<br>";
		 echo "DEF: $evo1def";
		 echo "<br>";
	$totalatk = $totalatk + $evo1atk;
	$totaldef = $totaldef + $evo1def;
	If ($rows['card_id'] > 0){
	$card_hp = 1250;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evo1atk;
	$card_def = $evo1def;
    break;
    case "2":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo 2 (3 Card)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evo23cardatk";
		 echo "<br>";
		 echo "DEF: $evo23carddef";
		 echo "<br>";
	$totalatk = $totalatk + $evo23cardatk;
	$totaldef = $totaldef + $evo23carddef;
	If ($rows['card_id'] > 0){
	$card_hp = 1500;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evo23cardatk;
	$card_def = $evo23carddef;
    break;
    case "3":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo 2 (4 Card)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evo24cardatk";
		 echo "<br>";
		 echo "DEF: $evo24carddef";
		 echo "<br>";
	$totalatk = $totalatk + $evo24cardatk;
	$totaldef = $totaldef + $evo24carddef;
	If ($rows['card_id'] > 0){
	$card_hp = 1500;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evo24cardatk;
	$card_def = $evo24carddef;
	break;
    case "4":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo Max (4-7)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evomax47atk";
		 echo "<br>";
		 echo "DEF: $evomax47def";
		 echo "<br>";
	$totalatk = $totalatk + $evomax47atk;
	$totaldef = $totaldef + $evomax47def;
	If ($rows['card_id'] > 0){
	$card_hp = 1750;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax47atk;
	$card_def = $evomax47def;
    break;
	case "5":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo Max (5-9)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evomax59atk";
		 echo "<br>";
		 echo "DEF: $evomax59def";
		 echo "<br>";
	$totalatk = $totalatk + $evomax59atk;
	$totaldef = $totaldef + $evomax59def;
	If ($rows['card_id'] > 0){
	$card_hp = 1750;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax59atk;
	$card_def = $evomax59def;
    break;
	case "6":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo Max (6-11)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evomax611atk";
		 echo "<br>";
		 echo "DEF: $evomax611def";
		 echo "<br>";
	$totalatk = $totalatk + $evomax611atk;
	$totaldef = $totaldef + $evomax611def;
	If ($rows['card_id'] > 0){
	$card_hp = 1750;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax611atk;
	$card_def = $evomax611def;
    break;
	case "7":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo Max (7-13)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evomax713atk";
		 echo "<br>";
		 echo "DEF: $evomax713def";
		 echo "<br>";
	$totalatk = $totalatk + $evomax713atk;
	$totaldef = $totaldef + $evomax713def;
	If ($rows['card_id'] > 0){
	$card_hp = 1750;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax713atk;
	$card_def = $evomax713def;
    break;
	case "8":
		If ($rows['card_id'] > 0){
         echo "<br><strong>Evo Max (8-15)</strong><br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
		 echo "ATK: $evomax815atk";
		 echo "<br>";
		 echo "DEF: $evomax815def";
		 echo "<br>";
	$totalatk = $totalatk + $evomax815atk;
	$totaldef = $totaldef + $evomax815def;
	If ($rows['card_id'] > 0){
	$card_hp = 1750;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax815atk;
	$card_def = $evomax815def;
    break;
	case "11":
		If ($rows['card_id'] > 0){
         echo "<br><strong>",$rows['card_name'],"</strong><br>";
		 echo "ATK: $baseatk";
		 echo "<br>";
		 echo "DEF: $basedef";
		 echo "<br>";
		 }
		else{
         echo "<br><strong>Empty</strong><br>";
		 }
	$totalatk = $totalatk + $baseatk;
	$totaldef = $totaldef + $baseatk;
	If ($rows['card_id'] > 0){
	$card_hp = ($rows['slot_x']*$rows['slot_y'])*1000;
	}
	else{
	$card_hp = 0;
	}
	$totalhp = $totalhp + $card_hp;
	$card_atk = $evomax815atk;
	$card_def = $evomax815def;
    break;
	default:
	echo "<br><strong>Empty</strong><br>";
		 echo "ATK: N/A";
		 echo "<br>";
		 echo "DEF: N/A";
		 echo "<br>";
	}

?>

ACC: <?php echo $rows['accuracy']; ?>
<br>
EVA: <?php echo $rows['avoid']; ?>
<br>
Cost: <?php echo $rows['cost']; ?>
<br>
&nbsp;

</td> 

 <?php
 $totalacc = $totalacc + $rows['accuracy'];
 $totaleva = $totaleva + $rows['avoid'];
 $totalcost = $totalcost + $rows['cost'];
 if($rows['skill_name'] != ''){
 
 $totalskills .= $rows['skill_name'];
  $totalskills .= "<br>";
 
 }
 
	// BS = Attack x Accuracy + Defense x (HP/1000) x (Evasion+100)/100
	if ($card_hp > 0){
	$card_bs = floor((($card_atk * $card_apt) * $card_acc + $card_def * $card_hp / 1000 * ($card_eva + 100)) / 100);
	}
	else{
	$card_bs = 0;
	}
 
	$totalbs = $totalbs + $card_bs;
	$card_count++;
	}
	}
 // end of While Loop
	
	// after 6 cards start a new row
	if ($new_row % 6 == 0){
	
	
	echo "</tr>";
	echo "<tr>";
	$new_row = 0;
	}
	
	
	}
	
	unset($value);
	
	  ?>
	  
	  </tr>
	  </table>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  </center>
	  <?php
	   if (isset($_GET["deck"])) {
	  
	  ?>
	  
	  <table>
	  <tr>
	  <td>
	  <center>
	  <table>
	  <tr>
	  <td colspan=2><h1>Total Stats:</h1></td>
	  </tr>
	  <tr>
	  <td width=130><strong>Approximate Battle Strength:</strong></td>
	  <td><?php echo number_format($totalbs); ?></td>
	  </tr>
	  <tr>
	  <td><strong>Attack:</strong></td>
	  <td><?php echo number_format($totalatk); ?></td>
	  </tr>
	  <tr>
	  <td><strong>Defense:</strong></td>
	  <td><?php echo number_format($totaldef); ?></td>
	  </tr>
	  <tr>
	  <td><strong>ACC:</strong></td>
	  <td><?php echo number_format($totalacc); ?></td>
	  </tr>
	  <tr>
	  <td><strong>EVA:</strong></td>
	  <td><?php echo number_format($totaleva); ?></td>
	  </tr>
	  <tr>
	  <td><strong>Cost:</strong></td>
	  <td><?php echo $totalcost; ?></td>
	  </tr>
	  <tr>
	  <td><strong>HP:</strong></td>
	  <td><?php echo number_format($totalhp); ?></td>
	  </tr>
	  <tr>
	  <td valign="top"><strong>Skills:</strong></td>
	  <td><?php echo $totalskills; ?></td>
	  </tr>
	  </table>
	  	    
			
		</td></tr></table>
			<?php
}


if (isset($_GET["deck"])) {
	  $realdeck = implode("-", $deck_chunk);
	   $deckimglink = "http://www.swfcstats.com/dynamic_deck_image.php?deck=";
	   //$deckimglink .= $_GET["deck"];
	   $deckimglink .= $realdeck;
	   
	   $decklink = "http://www.swfcstats.com/deck-builder?deck=";
	   //$decklink .= $_GET["deck"];
	    $decklink .= $realdeck;
		
		?><p>&nbsp;</p>
		<center><strong>Link to this deck:</strong><br>
		<textarea rows="4" cols="50"><?php echo "$decklink"; ?></textarea>
		
		<center><strong>Link to this deck's image:</strong><br>
		<textarea rows="4" cols="50"><?php echo "$deckimglink"; ?></textarea><br>
		<center><strong>This deck's image (Right-Click to Save):</strong><br>
		<img src=<?php echo "$deckimglink"; ?>><p>&nbsp;</p>
		
		<center>
		<table>
		<tr>
		<td>
	<form method="POST" name="editdeck" action="j_deckbuilder_edit.php">
		<input type="hidden" name="deck" value="<?php echo $realdeck; ?>">
		<center><input type="submit" value="Edit This Deck">
	</form>
		</td>
		<td>
		&nbsp;
		</td>
		<td>
	<form method="POST" name="newdeck" action="j_deckbuilder.php">
		<input type="hidden" name="deck" value="">
		<input type="submit" value="Build a New Deck"><br>
	</form>
		</td>
		</tr>
		</table>
		</center>
		<P>
		
		<table>
		<tr>
			<th colspan=12>Type Key</th>
		</tr>
		<tr>
			<td><img src=/SWFC/images/classes/new/mal.png></td>
			<td>Male</td>
			<td><img src=/SWFC/images/classes/new/fem.png></td>
			<td>Female</td>
			<td><img src=/SWFC/images/classes/new/dro.png></td>
			<td>Droid</td>
			<td><img src=/SWFC/images/classes/new/emp.png></td>
			<td>Empire</td>
			<td><img src=/SWFC/images/classes/new/reb.png width=20 title='Rebel'></td>
			<td>Rebel</td>
			<td><img src=/SWFC/images/classes/new/ewo.png></td>
			<td>Ewok</td>
			</tr>
			<tr>
			<td><img src=/SWFC/images/classes/new/gun.png></td>
			<td>Gungan</td>
			<td><img src=/SWFC/images/classes/new/nab.png></td>
			<td>Nabooan</td>
			<td><img src=/SWFC/images/classes/new/bou.png></td>
			<td>Bounty Hunter</td>
			<td><img src=/SWFC/images/classes/new/sit.png></td>
			<td>Sith</td>
			<td><img src=/SWFC/images/classes/new/jed.png></td>
			<td>Jedi</td>
			<td><img src=/SWFC/images/classes/new/clo.png></td>
			<td>Clone</td>
			</tr>
			<tr>
			<td><img src=/SWFC/images/classes/new/woo.png></td>
			<td>Wookie</td>
			<td><img src=/SWFC/images/classes/new/bea.png></td>
			<td>Beast</td>
			<td><img src=/SWFC/images/classes/new/sep.png></td>
			<td>Separatist</td>
			<td><img src=/SWFC/images/classes/new/rep.png></td>
			<td>Galactic Republic</td>
			<td><img src=/SWFC/images/classes/new/tat.png></td>
			<td>Tatooinian</td>
			<td><img src=/SWFC/images/classes/new/pod.png></td>
			<td>Pod Racer</td>
			
		</tr>
		</table>

		<?php
		}
		?>
    </div>
    
	
	
    