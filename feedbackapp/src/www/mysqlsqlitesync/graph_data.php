<?php
/**
 * DB configuration variables
 */
define("DB_HOST", "182.50.133.79:3306");
define("DB_USER", "mgradmin");
define("DB_PASSWORD", "@dM1n$");
define("DB_DATABASE", "MGRFeedBackDB");
include("includes/fusioncharts.php");
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
$jsn = $_POST["coldata"];
//Decode JSON into an Array
$data = json_decode($jsn,true);
$aa=$data['ColName'];
$db = new DB_Connect();
$con=$db->connect();
$sql="SELECT '$aa', COUNT(*) AS CT FROM feedback GROUP BY '$aa' ORDER BY CT DESC";
$result = mysql_query($sql,$con);
// If the query returns a valid response, prepare the JSON string
  if ($result) {
    // The `$arrData` array holds the chart attributes and data
    $arrData = array(
      "chart" => array(
          "caption" => "",
          "paletteColors" => "#0075c2",
          "bgColor" => "#ffffff",
          "borderAlpha"=> "20",
          "canvasBorderAlpha"=> "0",
          "usePlotGradientColor"=> "0",
          "plotBorderAlpha"=> "10",
          "showXAxisLine"=> "1",
          "xAxisLineColor" => "#999999",
          "showValues" => "0",
          "divlineColor" => "#999999",
          "divLineIsDashed" => "1",
          "showAlternateHGridColor" => "0"
        )
    );
	$arrData["chart"]["caption"] = $aa;
    $arrData["data"] = array();

    // Push the data into the array
    while($row = mysqli_fetch_array($result)) {
      array_push($arrData["data"], array(
          "label" => $row["'$aa'"],
          "value" => $row["CT"]
          )
      );
    }
    $jsonEncodedData = json_encode($arrData);
	$columnChart = new FusionCharts("column2D", "Feedback Chart" , 600, 300, "chart-1", "json", $jsonEncodedData);
    $columnChart->render();
?>
<html>
	<head>
		<script type="text/javascript" src="/includes/fusioncharts.js"></script>
		<script type="text/javascript" src="/includes/fusioncharts.theme.ocean.js"></script>
	</head>
</html>
	