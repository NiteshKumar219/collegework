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

	/**
	 * Storing new Form Data
	 * returns boolean
	 */
	public function storeFormData($fdata) {
		// Insert user into database
		//$result = mysql_query("INSERT INTO formdata(EventName,EventDate,EventDept,Venue) VALUES('$fdata')");
		$result = mysql_query("UPDATE formdata SET EventName='$fdata[0]',EventDate='$fdata[1]',EventDept='$fdata[2]',Venue='$fdata[3]',Code='$fdata[4]' WHERE Eid=1");
		if ($result) {
			return true;
		} else {
			// For other errors
			return false;
		}
	}
}
?>
<html>
	<head>
		<style>
			body {
				font: normal medium/1.4 sans-serif;
			}
			div.header{
				padding: 10px;
				background: #e0ffc1;
				width:30%;
				color: #008000;
				margin:5px;
			}
			table {
				border-collapse: collapse;
				width: 25%;
				margin-left: auto;
				margin-right: auto;
			}
			form{
				width: 30%;
				margin-left: auto;
				margin-right: auto;
				padding: 10px;
				border: 2px solid #edd3ff;
			}
			div#msg{
				margin-top:10px;
				width: 30%;
				margin-left: auto;
				margin-right: auto;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<center>
			<div class="header">
				Android SQLite and MySQL Sync - Update Form Data
			</div>
		</center>
		<form method="POST">
			<table>
				<tr>
					<td>EventName:</td><td><input name="ename" /></td>
				</tr>
				<tr>
					<td>EventDate:</td><td><input name="edate" /></td>
				</tr>
				<tr>
					<td>EventDept:</td><td><input name="edept" /></td>
				</tr>
				<tr>
					<td>EventVenue:</td><td><input name="venue" /></td>
				</tr>
				<tr>
					<td>Code:</td><td><input name="code" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Update Form Data"/></td>
				</tr>
			</table>
		</form>
		<?php
			//Create Object for DB_Functions clas
			if(isset($_POST["ename"]) && !empty($_POST["ename"])&& isset($_POST["edate"]) && !empty($_POST["edate"])&& isset($_POST["edept"]) && !empty($_POST["edept"])&& isset($_POST["venue"]) && !empty($_POST["venue"])&& isset($_POST["code"]) && !empty($_POST["code"])){
				$db = new DB_Functions();
				//Store User into MySQL DB
				$fdata = array($_POST["ename"],$_POST["edate"],$_POST["edept"],$_POST["venue"],$_POST["code"]);
				$res = $db->storeFormData($fdata);
				//Based on inserttion, create JSON response
				if($res){ ?>
         			<div id="msg">Updation Successful</div>
    			<?php }
    			else{ ?>
         			<div id="msg">Updation Failed</div>
    			<?php }
			}
			else{ ?>
 				<div id="msg">Please enter all details and submit</div>
			<?php }
		?>
	</body>
</html>