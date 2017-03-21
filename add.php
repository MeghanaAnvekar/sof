<?php

include("connect.php");
@$name = $_POST['name'];
@$phone = $_POST['phone'];
@$email = $_POST['email'];

$sql = "INSERT INTO contacts(name,phone,email) VALUES('$name','$phone','$email')";

$result =@mysqli_query($conn,$sql);

if($result === false)
echo "  coudnt insert  ";

mysqli_close($conn);

include('index.php');

?>
