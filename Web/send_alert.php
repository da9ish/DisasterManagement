<?php
	
	ob_start();
	include ('/xampp/htdocs/dm/DBConnect.php');

	$con = new DB_Connect();
    $db = $con->connect();

    $name = $_POST['name'];
    $note = $_POST['note'];
    $lat = $_POST['lat'];
    $lon = $_POST['lon'];

    $query = "INSERT INTO `alert`(`_id`, `username`, `text`, `latitude`, `longitude`) VALUES (NULL,'".$name."','".$note."','".$lat."','".$lon."')";
    $result = mysqli_query($db, $query);
    ob_clean();
    if ($result > 0) {
    	echo "Inserted";
    }else{
    	echo "Not Inserted";
    }


?>