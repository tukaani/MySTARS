import java.util.ArrayList;

public class FileIO{
	//Assuming that students variable is not destroyed when the function that called this class has ended
	public static ArrayList<Student> students = new ArrayList<Student>();

	public static void loadStudents(){
		//for each line in students.txt this.students.add(line);
		
		//TESTING
		Student student = new Student("Jack", 123, Person.GENDER.FEMALE, "holland");
		students.add(student);
	} 
	
}