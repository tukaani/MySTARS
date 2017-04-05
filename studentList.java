import java.util.ArrayList;

public class studentList {

	/*
	 * Creating the list. Use ArrayList as this can be extended
	 */
	protected ArrayList<Student> students = new ArrayList<Student>();
	/*
	 * Student list's constructor. What to put inside?
	 */
	public studentList(){
		FileIO.loadStudents(this.students);
	}

	public ArrayList<Student> getStudents(){
		return this.students;
	}

	public Student findStudentByID(int ID){
		for(Student student : students){
			if(student.getID() == ID){
				return student;
			}
		}
		return null;
	}

	public void addCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID)
				s.addIndex(ind);
		}
	}

	public void removeCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID)
				s.removeIndex(ind);
		}
	}

	public void changeIndex(int indFrom, int indTo, int ID){
		for(Student s : students){
			if(s.getID() == ID){
				s.changeIndex(indFrom, indTo);
			}
		}
	}

	public void sendMail(Integer ID, int ind){
		Student s = findStudentByID(ID);
		s.sendMail(ind);
	}
	/*
	 * Adding a new student to the list
	 */
	// public createStudent(String name, int ID, GENDER gender, String nationality){
	// 	Student student = new Student(name, ID, gender, nationality);
	// 	students.add(student);
	// }
	/*
	 * Printing all the students currently in the list
	 */
	public void printStudentList(){
		for(Student student : students){
			System.out.println(student.getName());
		}
		// is this students enrolled in course? All students? In which order to sort?
	}
}
