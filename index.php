<html>
<head>
<link rel="stylesheet" href="style.css"/>
<title>Phonebook</title>
</head>
<body>
<h1>My Contacts</h1>

<?php

include("connect.php");
$sql ="SELECT * FROM contacts";

$result = @mysqli_query($conn,$sql);

if($result)
{
echo "<table align=\"left\">
<thead> <th align=\"left\"><b>NAME</b></th>
	<th align=\"left\"><b>CONTACT</b></th>
	<th align=\"left\"><b>E-MAIL</b></th>
</thead>";
while($row = mysqli_fetch_array($result))
{
echo "<tr><td>".$row['name']."</td>
<td>".$row['phone'] ."</td>
<td>".$row['email'] ."</td>
</tr>";
}
echo "</table>";
}
else
echo "Couldn't display!";
?>
<br>
<br>
<br>
<ul>
<li><form  action="add.html"><input class= "button" type="submit" value="ADD"/></form></li><li><form action="del.html"><input class="button" type="submit" value="DELETE"/></form></li></ul>
</body>
</html>

