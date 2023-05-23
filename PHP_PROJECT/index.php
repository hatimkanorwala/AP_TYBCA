<?php
$arr1 = ["a","b","c","d"];
$arr2 = ["1","2","3","4"];
$arr3 = array();
$arr4 = array_merge($arr1,$arr2);
$count_arr1 = count($arr1);
$count_arr2 = count($arr2);

echo "Count of Array1:->".$count_arr1 . "<br />";
echo "Count of Array2:->".$count_arr2;
echo "<br />Array1: ";
//echo "<pre>";
print_r($arr1);

echo "<br />Array2: ";
//echo "<pre>";
print_r($arr2);


echo "<br />Merging Array: <br />";
for($i=0;$i<$count_arr1;$i++)
{
	$arr3[$i] = $arr1[$i];
}
for($i=$count_arr1,$j=0;$i<($count_arr2+$count_arr1);$i++,$j++)
{
	
	$arr3[$i] = $arr2[$j];
}
echo "<br />Array3: ";
print_r($arr3);
echo "<br />Array4: ";
print_r($arr4);
?>