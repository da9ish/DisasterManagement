<?php

	ob_start();
	include ('/xampp/htdocs/dm/DBConnect.php');

	$con = new DB_Connect();
    $db = $con->connect();

    $query = "SELECT * FROM `alert_count`";
    $row = mysqli_query($db, $query);

    while($lt = mysqli_fetch_assoc($row)){
    	$result = $lt;
    }

    $count = $result['alert_id'];

    $query2 = "SELECT * FROM `alert` ORDER BY `_id` ASC";
    $row = mysqli_query($db, $query2);

    $count2 = mysqli_num_rows($row);

    ob_clean();
    if($count2 > $count){
    	
    	while ($read = mysqli_fetch_assoc($row)) {
    		$result2 = $read;
    	}

    	// $result2[] = $res12;

    	$count = $count + 1;
    	$query3 = "INSERT INTO `alert_count`(`_id`, `alert_id`) VALUES (NULL,'".$count."')";
    	mysqli_query($db, $query3);

    	ob_clean();

    	echo json_encode($result2);
    }

?>