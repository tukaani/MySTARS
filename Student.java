
/**
 Represents a student using mySTARS
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/

import java.util.Date;
public class Student extends Person{
	/**
	* Student's course list
	*/
	private Course[] courses;

	private Date startDate; //NOT FINISHED
	private Date endDate;	//NOT FINISHED

	/**
	* Student's consturctor
	*/
	public Student(String name, int ID, GENDER gender, String nationality){
		super(name, ID, gender, nationality)
	}
}