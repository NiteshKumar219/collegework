<?php
/**
 * DB configuration variables
 */
define("DB_HOST", "182.50.133.79:3306");
define("DB_USER", "mgradmin");
define("DB_PASSWORD", "@dM1n$");
define("DB_DATABASE", "MGRFeedBackDB");

class DB_Connect {

	// constructor
	function __construct() {

	}

	// destructor
	function __destruct() {
		// $this->close();
	}

	// Connecting to database
	public function connect() {
		// connecting to mysql
		$con = mysql_connect(DB_HOST, DB_USER, DB_PASSWORD);
		// selecting database
		mysql_select_db(DB_DATABASE);

		// return database handler
		return $con;
	}

	// Closing database connection
	public function close() {
		mysql_close();
	}

}

class DB_Functions {

	private $db;

	//put your code here
	// constructor
	function __construct() {
		// connecting to database
		$this->db = new DB_Connect();
		$this->db->connect();
	}

	// destructor
	function __destruct() {

	}

	public function viewAllData(){
    	$res = mysql_query("SELECT * from feedback");
    	return $res;	
    }
}
?>
<html>
	<head>
		<title>View Users</title>
		<style>
			body {
  				font: normal medium/1.4 sans-serif;
			}
			table {
  				border-collapse: collapse;
  				width: 20%;
  				margin-left: auto;
  				margin-right: auto;
			}
			tr > td {
  				padding: 0.25rem;
  				text-align: center;
  				border: 1px solid #ccc;
			}
			tr:nth-child(even) {
  				background: #FAE1EE;
			}
			tr:nth-child(odd) {
  				background: #edd3ff;
			}
			tr#header{
				background: #c1e2ff;
			}
			td#sync{
				background: #fff;
			}
			div.header{
				padding: 10px;
				background: #e0ffc1;
				width:30%;
				color: #008000;	
				margin:5px;
			}
			div.refresh{
				margin-top:10px;
				width: 5%;
				margin-left: auto;
				margin-right: auto;
			}
			div#norecord{
				margin-top:10px;
				width: 15%;
				margin-left: auto;
				margin-right: auto;
			}
			img{
				height: 32px;
				width: 32px;
			}
		</style>
		<script>
			var val= setInterval(function(){
				location.reload();
			},2000);
		</script>
	</head>
	<body>
		<center>
			<div class="header">
				Android SQLite and MySQL Sync - View Users
			</div>
		</center>
		<?php
    		$db = new DB_Functions();
    		$fdata = $db->getAllUsers();
    		if ($fdata != false)
		        $no_of_data = mysql_num_rows($fdata);
    		else
        		$no_of_data = 0;
 		?>
		<?php
    		if ($no_of_data > 0) {
		?>
		<table>
			<tr id="header">
				<td>Id</td>
				<td>Person_Identity</td><td>How_Know_Event</td><td>Event_Started_Ontime</td>
				<td>EventVenue_Hospitality</td><td>Overall_EventOrganization_Satisified</td>
				<td>Content_Usefulness</td><td>Speaker_PPtSkill</td><td>Demo_Effectivnes</td><td>Event_Strength</td>
				<td>Key_Messages</td><td>Interested_Events</td><td>Other_Info</td><td>Overall_PPT_Rating</td>
				<td>Overall_Performance</td>
			</tr>
			<?php
    			while ($row = mysql_fetch_array($fdata)) {
			?> 
			<tr>
				<td><span><?php echo $row["_id"] ?></span></td>
				<td><span><?php echo $row["person_identity"] ?></span></td>
				<td><span><?php echo $row["how_know_event"] ?></span></td>
				<td><span><?php echo $row["event_started_ontime"] ?></span></td>
				<td><span><?php echo $row["eventvenue_hospitality"] ?></span></td>
				<td><span><?php echo $row["overall_eventorganization_satisfied"] ?></span></td>
				<td><span><?php echo $row["content_usefulness"] ?></span></td>
				<td><span><?php echo $row["speaker_pptskill"] ?></span></td>
				<td><span><?php echo $row["demo_effectiveness"] ?></span></td>
				<td><span><?php echo $row["event_strength"] ?></span></td>
				<td><span><?php echo $row["key_messages"] ?></span></td>
				<td><span><?php echo $row["interested_events"] ?></span></td>
				<td><span><?php echo $row["other_info"] ?></span></td>
				<td><span><?php echo $row["overall_ppt_rating"] ?></span></td>
				<td><span><?php echo $row["overall_performance"] ?></span></td>
			</tr>
			<?php } ?>
		</table>
		<?php }else{ ?>
			<div id="norecord">
				No records in MySQL DB
			</div>
		<?php } ?>
	</body>
</html>