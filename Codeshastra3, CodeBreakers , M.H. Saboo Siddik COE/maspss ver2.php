  <?php

    session_start();
  	include ('/xampp/htdocs/dm/DBConnect.php');

  	$con = new DB_Connect();
  	$db = $con->connect();  	


    function distance($lat1, $lon1, $lat2, $lon2, $unit) {
     
      $theta = $lon1 - $lon2;
      $dist = sin(deg2rad($lat1)) * sin(deg2rad($lat2)) +  cos(deg2rad($lat1)) * cos(deg2rad($lat2)) * cos(deg2rad($theta));
      $dist = acos($dist);
      $dist = rad2deg($dist);
      $miles = $dist * 60 * 1.1515;
      $unit = strtoupper($unit);
     
      if ($unit == "K") {
        return ($miles * 1.609344);
      } else if ($unit == "N") {
          return ($miles * 0.8684);
        } else {
            return $miles;
          }
    }

    ?>

  <!DOCTYPE html>
  <html>
  <head>

  	<link href="https://fonts.googleapis.com/css?family=Roboto:500|300" rel="stylesheet">
    <link rel="icon"  href="ic_launcher.png">

	  
  	<style>

  		body{
  			margin: 0;
  			padding: 0;  			
  		}


  		.cards{
  			position:fixed;
  			width: 100%;
  			top:100%;
  			transition: top 0.5s;

  		}
  		.cards1{
  			top: 70px;
  		}

  		.hoverTable{
  			border-spacing: 10px;
  			border-collapse: separate;
  			width: 100%;
  			color: black;  			
  		}

  		.hoverTable td{
  			background: #FAFAFA;
  			color: black;
  			height: auto;

  			webkit-transition: background .25s ease-in;
  			-moz-transition: background .25s ease-in;
  			-o-transition: background .25s ease-in;
  			-ms-transition: background .25s ease-in;
  			transition: background .25s ease-in;
  			color: #121212;

  		} 		
  		
  		.dropbtn {
  			display: none;
  			background-color: #F5F5F5;
  			color: #121212; 
  			height: 50px;
  			width: 100%; 
  			font-size: 16px;
  			border: none;
  			position:fixed;
  			cursor: pointer;
  			transition: top 0.5s;
  			box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.26);
  		}
  		.dropbtn1 {
  			background-color: #F5F5F5;
  			color: white;
  			color: #121212; 
  			width: 100%; 
  			font-size: 16px;
  			height:50px;
  			border: none;
  			position:fixed;  			
  			cursor: pointer;
  			box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.26);
  		}
  		.th1{
  			border-radius: 3px;
  			box-shadow: 0px 2px 5px 0px rgba(0,0,0,0.26);
  			padding: 0;
  		}

		.dropbtn:hover, .dropbtn:focus {
			background-color: #EEEEEE;
		}

		#map {
			height: 100%;
			width: 100%; 
			top : 0; 
			left : 0; 
			position : absolute;
			 z-index : -1;
			 transition-duration: 0.2s;

		}

		#loc1{
			font-family: 'Roboto', sans-serif;
			font-size: 15px;
			top: 50%;
			left: 50%;
			position: absolute;
			margin-top: -15px;			

		}

		p.header{
      display: inline-block;
			font-family: 'Roboto', sans-serif;
			margin-left: 16px;
			margin-top: 16px;
		}

    p{
      font-family: 'Roboto', sans-serif;
    }

		.divider{
			width: auto;
			height: 1px;
			background-color: #121212;
			margin: 0;
			padding: 0;
			margin-left: 16px;
			margin-right: 16px;
		}

		li{
			list-style-type: none;
			font-family: 'Roboto', sans-serif;
			font-style: none;
			padding-top: 15px;
			padding-bottom: 15px;
			padding-left: 16px;
      display: flex;
      align-items: center;
		}

		li:hover{
			background-color: #EEEEEE;
		}

		ul{
			padding: 0;
			margin: 0;
		}
    
    .icon{
      margin-right: 8px;
    }

    .available{
      width: 10px;
      height: 10px;
      background-color: #f44336;
      float: right;
      border-radius: 50%;
      margin-left: 32px;
    }

    .unavailable{
      width: 10px;
      height: 10px;
      background-color: #4CAF50;
      float: right;
      border-radius: 50%;
      margin-left: 32px;
    }

      
  	</style>
    
  	</head>
  	<body onload="getLocation()">

  		<section>

  		<div id="loc1">Fetching Location</div>


  		<div id="map"></div>

  		<div class="dropdown">
  			<button onclick="func()" class="dropbtn" id="bb">Show Actions</button> </div>


  			<div class="cards" id="cc"><table class="hoverTable"><tr >
  				<td class="th1"><p class="header">Co-Ordinators</p><div class="divider"></div>
  				<div style="overflow: auto; max-height: 200px;"><ul>
  					<?php

              $query = "SELECT * FROM `co_ordinator` WHERE `camp_id` = ".$_SESSION['camp_id'];
              $row = mysqli_query($db, $query);


  						while($result = mysqli_fetch_assoc($row)){
                if ($result['availability'] == "Available") {
                    $status = "unavailable";
                }else{                  
                    $status = "available";
                }
  							echo "<li>".$result['name']."<div class=\"".$status."\"></div></li>";                
  						}

              $query = "SELECT * FROM `resources` WHERE `camp_id` = ".$_SESSION['camp_id'];
              $row = mysqli_query($db, $query);
              $result = mysqli_fetch_assoc($row);
  					?>  					
  				</ul></div></td> 
  				<td class="th1"><a ><p class="header">Resources</p><p style="float: right; margin-right: 16px;"><?php echo "Rescuing Capacity:". $result['rescuing_capacity'];?></p><div class="divider"></div>
  				<div style="overflow: auto; max-height: 200px;"><ul>
  			       <?php
              
              echo "<li><img class=\"icon\" src=\"car.png\"/> ".$result['cars']."</li>";
              echo "<li><img class=\"icon\" src=\"ambulance.png\" />".$result['ambulance']."</li>";
              echo "<li><img class=\"icon\" src=\"bus.png\" />".$result['bus']."</li>";
              echo "<li><img class=\"icon\" src=\"airplane.png\" />".$result['airplanes']."</li>";              

              $query = "SELECT * FROM `rescue_camp` WHERE `_id` = ".$_SESSION['camp_id'];
              $row = mysqli_query($db, $query);
              $result = mysqli_fetch_assoc($row);             
              
            ?> 
  				</ul></div></td> 
  				<td class="th1"><p class="header">People</p><p style="float: right; margin-right: 16px;"><?php echo $result['occupied']."/".$result['capacity'];?></p><div class="divider"></div>
  				<div style="overflow: auto; max-height: 200px;"><ul>
  					<?php
              $query = "SELECT * FROM `people` WHERE `camp_id` = ".$_SESSION['camp_id'];
              $row = mysqli_query($db, $query);
              $result = mysqli_fetch_assoc($row); 
              while ($result = mysqli_fetch_assoc($row)) {
                echo "<li>".$result['username']."</li>";
              }
            ?>
  				</ul></div></td> </tr><tr>  		


  			</tr></table></div> 
  		</div>

  		</section>


  		<script async defer
	    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBtG8XxsdJAARzBZz4dFlN_C0nxpuTbCJo&callback=initMap"></script>
		</script>

    <?php

      $query = "SELECT * FROM `rescue_camp` WHERE ".$_SESSION['camp_id'];
      $row = mysqli_query($db, $query);
      
         ?>

		
	  	<script>
                    
	  			var x = document.getElementById("loc1");
          

	  			function getLocation() {	  				
	  				if (navigator.geolocation) {
	  					navigator.geolocation.getCurrentPosition(showPosition);
	  				} else { 
	  					x.innerHTML = "Geolocation is not supported by this browser.";
	  				}
	  			}

          var my = setInterval(callAjax, 5000);

          function callAjax(){
            console.log("callAjax");
            var ajax = new XMLHttpRequest();

            ajax.onreadystatechange = function(){
              if (this.readyState == 4 && this.status == 200) {
                var alert = JSON.parse(this.responseText);
                if (alert == "") {
                  
                }else{
                  showAlertPostition(alert);                 
                }
              }
            }



            ajax.open("GET", "http://localhost/dm/check.php", true);
            ajax.send();
            
          }

          function showAlertPostition(alert){    
            console.log(alert.latitude);
            console.log(parseFloat(alert.latitude));
            var infoWindow = new google.maps.InfoWindow();
            var uluru = {lat: parseFloat(alert.latitude), lng: parseFloat(alert.longitude)};
            var map = new google.maps.Map(document.getElementById('map'), {
              zoom: 10,
              center: uluru
            });            

            var marker = new google.maps.Marker({
              position: uluru,
              map: map
            });  

            infoWindow.setContent("<p><strong>Alert:</strong> " + alert.text + "<br> <strong>User:</strong> "+ alert.username +"</p>");
            infoWindow.open(map, marker);
            var j;
            google.maps.event.addListener(marker, 'click', (function(marker, j) {
                return function() {
                    infoWindow.setContent("<p><strong>Alert:</strong> " + alert.text + "<br> <strong>User:</strong> "+ alert.username +"</p>");
                    infoWindow.open(map, marker);
                }
            })(marker, j));

          }

	  			function showPosition(position) { 			
	  				x.style.display = "none";	

            var infoWindow = new google.maps.InfoWindow();
	  				var uluru = {lat: position.coords.latitude, lng: position.coords.longitude};
	  				var map = new google.maps.Map(document.getElementById('map'), {
	  					zoom: 10,
	  					center: uluru
	  				});

            console.log(uluru);

	  				var marker = new google.maps.Marker({
	  					position: uluru,
	  					map: map
	  				});

            var j=0;
             google.maps.event.addListener(marker, 'click', (function(marker, j) {
                  return function() {
                      infoWindow.setContent("<p>Current Location</p>");
                      infoWindow.open(map, marker);
                  }
              })(marker, j));
            

            <?php
              $i = 1;
              while ($result = mysqli_fetch_assoc($row)){
                
                echo "var i = ".$i.";
                \nvar k".$i." = {lat: ".$result['latitude'].", lng: ".$result['Longitude']."};                

                    var marker".$i." = new google.maps.Marker({
                      position: k".$i.",
                      map: map
                      });

                    google.maps.event.addListener(marker".$i.", 'click', (function(marker".$i.", i) {
                        return function() {
                            infoWindow.setContent(\"<p>".$result['name']." Camp. <br> Head: ".$result['head_name']." <br>Phone No: ".$result['head_phone_no']."</p>\");
                            infoWindow.open(map, marker".$i.");
                        }
                    })(marker".$i.", i));\n";
                    $i = $i + 1;             

              }

            ?>          
          

	  				document.getElementById("bb").style.display = "block";
	  			}
	  			function func(){
				   //var x = document.getElementById("bb");
					//x.className = x.className.toggle("dropbtn", "dropbtn1");
					if (document.getElementById("bb").innerHTML == "Show Actions") {
						document.getElementById("bb").innerHTML = "Hide Actions";	
						document.getElementById("map").style.opacity = 0.5;
					}else{
						document.getElementById("bb").innerHTML = "Show Actions";
						document.getElementById("map").style.opacity = 1;
					}

					
					
					
					document.getElementById("cc").classList.toggle("cards1");

				}
		</script>
  		

</body>
</html>