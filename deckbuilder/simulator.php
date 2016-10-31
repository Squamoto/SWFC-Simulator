<?php
$parameters = $_GET['parameters'];
$string = "java -jar simulator.jar $parameters";
//exit($string);
$output =  shell_exec($string);
if($output == NULL)
{
	echo "Error!";
}
else
{
	echo $output;
}
?>