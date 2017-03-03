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
$jsn = $_POST["feeddata"];
//$jsn1="{"how_know_event":"Circular","eventvenue_hospitality":"Yes","other_info":"oh","interested_events":"OK good","overall_performance":"Very //Good","demo_effectiveness":"Very //satisfied","event_strength":"good","event_started_ontime":"Yes","overall_ppt_rating":"Very //satisfied","person_identity":"Student","key_messages":"OK","content_usefulness":"Very //satisfied","speaker_pptskill":"Very satisfied","overall_eventorganization_satisfied":"Yes"}";
//Decode JSON into an Array
$data = json_decode($jsn,true);
$aa=$data['person_identity'];
$ab=$data['how_know_event'];
$ac=$data['event_started_ontime'];
$ad=$data['eventvenue_hospitality'];
$ae=$data['overall_eventorganization_satisfied'];
$af=$data['content_usefulness'];
$ag=$data['speaker_pptskill'];
$ah=$data['demo_effectiveness'];
$ai=$data['overall_ppt_rating'];
$aj=$data['event_strength'];
$ak=$data['key_messages'];
$al=$data['other_info'];
$am=$data['interested_events'];
$an=$data['overall_performance'];
$db = new DB_Connect();
$con=$db->connect();
$sql="INSERT INTO feedback(person_identity,how_know_event,event_started_ontime,eventvenue_hospitality,
		overall_eventorganization_satisfied,content_usefulness,speaker_pptskill,demo_effectiveness,overall_ppt_rating,
		event_strength,key_messages,other_info,interested_events,overall_performance) VALUES('$aa','$ab','$ac','$ad','$ae','$af','$ag','$ah','$ai','$aj','$ak','$al','$am','$an')";
$res = mysql_query($sql,$con);
?>