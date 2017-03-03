<?php
/**
 * DB operations functions
 */
class DB_Functions {
 
    private $db;
 
    //put your code here
    // constructor
    function __construct() {
        include_once './db_connect.php';
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
 		$result = mysql_query("UPDATE formdata SET EventName='$fdata[0]',EventDate='$fdata[1]',EventDept='$fdata[2]',Venue='$fdata[3]' WHERE Eid=1");
        if ($result) {
            return true;
        } else {            
                // For other errors
                return false;
        }
    }
    
    public function viewAllData(){
    	$res = mysql_query("SELECT * from feedback");
    	return $res;	
    }
}
 
?>