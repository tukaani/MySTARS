import java.util.ArrayList;
import java.io.IOException;
public class studentList {

	/*
	 * Creating the list. Use ArrayList as this can be extended
	 */
	protected ArrayList<Student> students = new ArrayList<Student>();
	/*
	 * Student list's constructor.
	 */
	public studentList(){
		//ArrayList staff = new ArrayList();
		//staff.add(new Staff("Chun woo", 888, "pwd", "Professor"));
		//TestFileIO.loadStudents(this.students);
		try{
			//FileIO.saveStudents(this.students);
			students = FileIO.readStudents();
			//staff = FileIO.readStaff();
			}
		catch(IOException e){
			System.out.println("Error in FileIO: " + e);
		}
	}

	public void saveStudents(){
		try{

			FileIO.saveStudents(this.students);
			}
		catch(IOException e){
			System.out.println("Error in FileIO: " + e);
			}
	}
	public ArrayList<Student> getStudents(){
		return this.students;
	}

	public void printStudentsByIndex(int ind){
		for(Student s : students){
			if(s.getIndexes().indexOf(ind) != -1)
				s.printInfo();
		}
	}
	public void addStudent(Student student){
		this.students.add(student);
	}

	public Student findStudentByID(int ID){
		for(Student student : students){
			if(student.getID() == ID){
				return student;
			}
		}
		return null;
	}

	public void printStudentsInCourse(ArrayList<Course> courses){
		//ArrayList<Student> students = new ArrayList<Student>();
		//Go throught index list
		for(Course c : courses){
			//Gompare each index in student list
			for(Student s : this.students){
				if(s.getIndexes().indexOf(c.getIndex()) != -1){
					System.out.println(s.getName() + " " + c.getIndex());
					//students.add(s);
					}
			}
		}
		//return students;
	}

	public void addCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID)
				s.addIndex(ind);
		}
	}

	public void removeCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID){
				s.getIndexes().remove(s.getIndexes().indexOf(ind));
				//s.removeIndex(ind);
				}
		}
	}

	public void changeIndex(int indFrom, int indTo, int ID){
		for(Student s : students){
			if(s.getID() == ID){
				s.changeIndex(indFrom, indTo);
			}
		}
	}

	public void sendNotification(Integer ID, int ind){
		Student s = findStudentByID(ID);
		if(s.getNotPref() == Person.NOTIFICATION.MAIL)
			System.out.println("MAIL SENT!");
		else if(s.getNotPref() == Person.NOTIFICATION.PHONE)
			System.out.println("Send text message");	
		else
			System.out.println("MAIL AND TEXT MESSAGE SEND");
		
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
