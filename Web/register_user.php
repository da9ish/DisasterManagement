<?php
	session_start();
	ob_start();
	include ('/xampp/htdocs/dm/DBConnect.php');

	$con = new DB_Connect();
    $db = $con->connect();   

    if (isset($_POST['user_name']) && isset($_POST['phone']) && isset($_POST['pass'])) {
    	$user_name = $_POST['user_name'];
	    $phone = $_POST['phone'];
	    $pass = $_POST['pass'];

	    $query = "INSERT INTO `user`(`_id`, `name`, `phone_no`, `password`) VALUES (NULL,'".$user_name."','".$phone."','".$pass."')";
	    $result = mysqli_query($db, $query);
	    
	    if ($result) {
	    	ob_clean();
	    	echo "Registered";	    	
	    }else{
	    	ob_clean();
	    	echo "Not Registered";
	    }	    
	}			
	
		
?>