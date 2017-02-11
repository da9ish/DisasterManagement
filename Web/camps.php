<?php

	ob_start();
	include ('/xampp/htdocs/dm/DBConnect.php');

	$con = new DB_Connect();
    $db = $con->connect();

	$query = "SELECT * FROM  `rescue_camp` WHERE 1";
	$row = mysqli_query($db, $query);

	while ($fet = mysqli_fetch_assoc($row)) {
		$result[] = $fet;
	}
	ob_clean();
	echo json_encode($result);

?>