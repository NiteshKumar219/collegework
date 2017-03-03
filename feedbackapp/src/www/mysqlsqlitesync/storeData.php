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
//Get JSON posted by Android Application
$jsn = $_POST["formdata"];
//Decode JSON into an Array
$data = json_decode($jsn,true);
$aa=$data['EventName'];
$ab=$data['EventDate'];
$ac=$data['EventDept'];
$ad=$data['Venue'];
$ae=$data['Code'];
$db = new DB_Connect();
$con=$db->connect();
$sql="INSERT INTO formdata('EventName','EventDate','EventDept','Venue','Code') VALUES('$aa','$ab','$ac','$ad','$ae') WHERE Eid=1";
$res = mysql_query($sql,$con);
?>