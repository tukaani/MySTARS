/**
 Represents a student using mySTARS
 Parent class for Student and Admin
 @version 1.0
 @since 2016-04-31
*/

public class Person{
	/**
	* Enum for person genders
	*/
	public enum GENDER{FEMALE, MALE}

	public enum NOTIFICATION{MAIL,PHONE,MAILANDPHONE};
	/**
	* Name of the person
	*/
	protected String name;
	/**
	* ID of the person aka matriculation number
	*/
	protected int ID;
	/**
	* Person's password
	*/
	protected String password;
	/**
	* Gender variable of the person
	*/

	protected GENDER gender;
	/**
	* Nationality of the person
	*/
	protected String nationality;
	/**
	* Staff's title
	*/
	protected String title;

	protected int phone;

	/**
	* Notification preferences
	*/
	protected NOTIFICATION notificationPref; 
	/**
	* Constructor for person class
	* @param name Person's name
	* @param ID Person's ID
	* @param gender Person's gender
	* @param nationality Person's nationality
	*/
	public Person(String name, int ID, String password, GENDER gender, String nationality, 
		int phone, NOTIFICATION notificationPref){
		this.name = name;
		this.ID = ID;
		this.password = password;
		this.gender = gender;
		this.nationality = nationality;
		this.phone = phone;
		this.notificationPref = notificationPref;
	}
	/**
	* Constructor for person(staff) class
	* @param name Person's name
	* @param ID Person's ID
	* @param gender Person's gender
	* @param nationality Person's nationality
	*/
	public Person(String name, int ID, String password, String title){
		this.name = name;
		this.ID = ID;
		this.password = password;
		this.title = title;
	}
	/**
	* Get person's name
	* @return this person's name
	*/
	public String getName(){
		return this.name;
	}
	/**
	* Get person's ID
	* @return this person's ID
	*/
	public int getID(){
		return this.ID;
	}
	/**
	* Get person's password
	* @return this person's passwords
	*/
	public String getPassword(){
		return this.password;
	}
	/**
	* Get person's GENDER
	* @return this person's GENDER
	*/
	public GENDER getGender(){
		return this.gender;
	}
	/**
	* Get person's nationality
	* @return this person's nationality
	*/
	public String getNationality(){
		return this.nationality;
	}
	/**
	* Get person's title
	* @return this person's title
	*/
	public String getTitle(){
		return this.title;
	}
	/**
	* Print Person's info
	*/
	public void printInfo(){
		System.out.println(name + " " + ID);
	}
	/**
	* Set person's notificaton preference
	* @param NOTIFICATION
	*/
	public void setNotPref(NOTIFICATION not){
		this.notificationPref = not;
	}
	/**
	* Get person's phone
	* @return this person's phone
	*/
	public int getPhone(){
		return this.phone;
	}
	/**
	* Get person's notification preference
	* @return this person's NOTIFICATION
	*/
	public NOTIFICATION getNotPref(){
		return this.notificationPref;
	}

}