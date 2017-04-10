/**
 Represents a student using mySTARS
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/
import java.util.ArrayList;
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
	* Student's start access date
	*/
	private Date startDate = new Date();
	/**
	* Student's end access date
	*/
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
	/**
	* Checks if student allowed to MySTARS
	* @return boolean true if allowed, else false
	*/
	public boolean checkDate(){
		Date today = new Date();
		if(startDate.compareTo(today) > 0 ||
			endDate.compareTo(today) < 0 ){
				System.out.println("STARS is not open at this time!");
				return false;
			}
		return true;
		}
	/**
	* Set start date
	* @param String Format: "2017-06-14"
	*/
	public void setStartDate(String date){
		this.startDate = parseDate(date);
	}
	/**
	* Set end date
	* @param String Format: "2017-06-14"
	*/
	public void setEndDate(String date){
		this.endDate = parseDate(date);
	}
	/**
	* Get start date
	* @return String Format: "2017-06-14"
	*/
	public String getStartDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.startDate);
	}
	/**
	* Get end date
	* @return String Format: "2017-06-14"
	*/
	public String getEndDate(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this.endDate);
		
	}
	/**
	* Get student's indexes
	* @return ArrayList<Integer>
	*/
	public ArrayList<Integer> getIndexes(){
		return this.indexes;
	}
	/**
	* Find index
	* @return Integer
	*/
	public Integer findIndex(int ind){
		for(Integer i : indexes){
			if(i == ind){
				return i;
			}
		}
		return -1;
	}
	/**
	* Print indexes
	*/
	public void printIndexes(){
		for(Integer i : indexes){
			System.out.println(i);
		}
	}
	/**
	* Register student for course
	*/
	public void addIndex(int ind){
		indexes.add(ind);
	}
	/**
	* Change student's index
	* @param int indFrom
	* @param int indTo
	*/
	public void changeIndex(int indFrom, int indTo){
		for(Integer i : indexes){
			if(i == indFrom){
				indexes.set(indexes.indexOf(i),indTo);
			}
		}
	}
	/**
	* Method for creating date object
	* @param String date
	* @return Date object
	*/
	 public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }

}
