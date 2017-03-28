import java.util.ArrayList;

public class FileIO{
	//Assuming that students variable is not destroyed when the function that called this class has ended
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Index> indexes = new ArrayList<Index>();

	public static void loadStudents(){
		
		//TESTING
		Student student = new Student("Jack", 123, Person.GENDER.FEMALE, "holland");
		students.add(student);
	} 
	
}