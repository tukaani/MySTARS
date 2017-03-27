
/**
 Represents a staff using mySTARS
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/

import java.util.Date;
public class Staff extends Person{

	private Date startDate; //NOT FINISHED
	private Date endDate;	//NOT FINISHED
	/**
	* Title of staff's
	*/
	String title;
	/**
	* Staff's consturctor
	*/
	public Staff(String name, int ID, GENDER gender, String nationality){
		super(name, ID, gender, nationality)
	}
}