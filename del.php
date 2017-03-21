<?php

include("connect.php");

@$name = $_POST['name'];

$sql = "DELETE FROM contacts WHERE name = '$name'";

$result =@ mysqli_query($conn,$sql);

if($result == false)
echo "  couldn't   delete  ";

mysqli_close($conn);

include("index.php");

?>
