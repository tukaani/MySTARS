
/**
 Represents a staff using mySTARS
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/

import java.util.Date;
public class Staff extends Person{
	/**
	* Title of staff's
	*/
	String title;
	/**
	* Staff's consturctor
	*/
	public Staff(String name, int ID, String password, GENDER gender, 
		String nationality, String title){
		super(name, ID, password, gender, nationality)
		this.title = title;
	}
}