<?php
$arr =array("1","5","7","2","4","6","15","14","12","20","19","26","25");
echo "<br />Unsorted Array: <br />";
print_r($arr);

for($i=0;$i<count($arr);$i++)
{
	for($j=0;$j<count($arr)-1;$j++)
	{
		//echo "<br />Index ".$j . " - " .$arr[$j] ."Next Index ". ($j+1) .  " - ".$arr[$j+1] . "<br />";
		if($arr[$j]>$arr[$j+1])
		{
			$temp = $arr[$j+1];
			$arr[$j+1] = $arr[$j];
			$arr[$j] = $temp;
		}
	}
}
echo "<br /><br />Sorted Array: <br />";
print_r($arr);

?>