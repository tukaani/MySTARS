import java.util.ArrayList;
/**
 Represents a student using mySTARS
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
public class Student extends Person{
	/**
	* Student's index list
	*/
	protected ArrayList <Integer> indexes = new ArrayList<Integer>();
	/**
	* Notification preferences for student
	*/
	
	
	
	private Date startDate = new Date();
	private Date endDate = new Date();

	/**
	* Student's consturctor
	*/
	public Student(String name, int ID, String password, GENDER gender, 
		String nationality, ArrayList<Integer> indexes, 
		String startD, String endD, int phone, NOTIFICATION notificationPreference){
		super(name, ID, password, gender, nationality, phone, notificationPreference);
		this.indexes = indexes;
		setStartDate(startD);
		setEndDate(endD);

	}
	
	public boolean checkDate(){
		Date today = new Date();
		if(startDate.compareTo(today) > 0 ||
			endDate.compareTo(today) < 0 ){
				System.out.println("STARS is not open at this time!");
				return false;
			}
		return true;
		}
	// Format: "2017-06-14"
	public void setStartDate(String date){
		this.startDate = parseDate(date);
	}
	// Format: "2017-06-14"
	public void setEndDate(String date){
		this.endDate = parseDate(date);
	}
	public String getStartDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.startDate);
	}
	public String getEndDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.endDate);
		
	}
	public ArrayList<Integer> getIndexes(){
		return this.indexes;
	}
	public void printIndexes(){
		for(Integer i : indexes){
			System.out.println(i);
		}
	}
	public void addIndex(int ind){
		indexes.add(ind);
	}
	//Removed
	// public void removeIndex(int ind){
	// 	for(Integer i : indexes){
	// 		if(i == ind)
	// 			indexes.remove(i);
	// 	}
		
	// }
	public void changeIndex(int indFrom, int indTo){
		for(Integer i : indexes){
			if(i == indFrom){
				indexes.set(indexes.indexOf(i),indTo);
			}
		}
	}
	// public void sendMail(int ind){
	// 	System.out.println("MAIL SENT");
	// }

	 public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
	/**
	* Set the student's notification preference
	*/
	// public setNotificationPreference(NOTIFICATION preference){
	// 	notificationPreference=preference;
	// }
}
