<?php
	session_start();
	ob_start();
	include ('/xampp/htdocs/dm/DBConnect.php');

	$con = new DB_Connect();
    $db = $con->connect();

    $head_name = $_POST['head_name'];
    $pass = $_POST['pass'];
				
	$query = "SELECT * FROM `rescue_camp` WHERE `head_name` = '".$head_name."'";
	$res = mysqli_query($db, $query);        
    $user = mysqli_fetch_assoc($res);  
    ob_clean();
    if (count($user) > 0) {
    	if($user["password"] == $pass){				
			$_SESSION['username'] = $username;	
			$_SESSION['camp_id'] = $user['_id'];
			ob_clean();		
			echo "Verified";
			header("Location: maspss ver2.php");
		}else{			
			ob_clean();
			echo "Password Incorrect";
		}
    }else{    	
    	ob_clean();
    	echo "Username Not Valid";
    }		
		
?>