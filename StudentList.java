import java.util.ArrayList;

public class StudentList {
	/*
	 * The number of students currently in array
	 */
	private int studentsInArray=0;
	/*
	 * Creating the list. Use ArrayList as this can be extended
	 */
	private ArrayList[] students=new ArrayList[0];
	/*
	 * Student list's constructor. What to put inside?
	 */
	public StudentList(){
		
	}
	/*
	 * Adding a new student to the list
	 */
	public createStudent(String name, int ID, GENDER gender, String nationality){
		Student student = new Student(name, ID, gender, nationality);
		students[studentsInArray]=student;
	}
	/*
	 * Printing all the students currently in the list
	 */
	public printStudentList(){
		// is this students enrolled in course? All students? In which order to sort?
	}
}
