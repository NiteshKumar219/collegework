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
$db = new DB_Connect();
$db->connect();
// Retrieve data from database       
$result = mysql_query("SELECT EventName,EventDate,EventDept,Venue,Code FROM formdata WHERE Eid=1");
if ($row = mysql_fetch_assoc($result)){ 
   echo json_encode($row);
   return json_encode($row);
} 
else {            
	// For other errors
        echo "no data";
	return null;
}
 
?><?php
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
$db = new DB_Connect();
$db->connect();
// Retrieve data from database       
$result = mysql_query("SELECT EventName,EventDate,EventDept,Venue FROM formdata WHERE Eid=1");
if ($row = mysql_fetch_assoc($result)){ 
   echo json_encode($row);
   return json_encode($row);
} 
else {            
	// For other errors
        echo "no data";
	return null;
}
 
?>