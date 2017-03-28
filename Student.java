import java.util.ArrayList;
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
	* Student's index list
	*/
	protected ArrayList <Index> indexes= new ArrayList<Index>();
	/**
	* Notification preferences for student
	*/
	private enum NOTIFICATION{MAIL, PHONE, MAILANDPHONE};
	private NOTIFICATION notificationPreference;

	private Date startDate; //NOT FINISHED
	private Date endDate;	//NOT FINISHED

	/**
	* Student's consturctor
	*/
	public Student(String name, int ID, GENDER gender, String nationality){
		super(name, ID, gender, nationality);
	}
	
	/**
	* Set the student's notification preference
	*/
	// public setNotificationPreference(NOTIFICATION preference){
	// 	notificationPreference=preference;
	// }
}
