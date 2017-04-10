import java.util.ArrayList;
import java.io.IOException;
/**
 Holds list of Student objects
 @version 1.0
 @since 2017-04-10
*/
public class studentList {

	/**
	 * ArrayList Student
	 */
	protected ArrayList<Student> students = new ArrayList<Student>();
	/**
	 * Student list's constructor. Uses FileIO class to read students
	 */
	public studentList(){
		try{
			students = FileIO.readStudents();
			}
		catch(IOException e){
			System.out.println("Error in FileIO: " + e);
		}
	}
	/**
	 * Saves students to file
	 */
	public void saveStudents(){
		try{

			FileIO.saveStudents(this.students);
			}
		catch(IOException e){
			System.out.println("Error in FileIO: " + e);
			}
	}
	/**
	 * Returns Student list
	 * @return ArrayList<Student>
	 */
	public ArrayList<Student> getStudents(){
		return this.students;
	}
	/**
	 * Prints students by index
	 * @param int Index
	 */
	public void printStudentsByIndex(int ind){
		for(Student s : students){
			if(s.getIndexes().indexOf(ind) != -1)
				s.printInfo();
		}
	}
	/**
	 * Adds studnet to Student list
	 * @param Student 
	 */
	public void addStudent(Student student){
		this.students.add(student);
	}
	/**
	 * Find student by ID
	 *@param int ID
	 * @return Student or null if student not found
	 */
	public Student findStudentByID(int ID){
		for(Student student : students){
			if(student.getID() == ID){
				return student;
			}
		}
		return null;
	}
	/**
	 * Find student by Name
	 * @param String name
	 * @return Student or null if student not found
	 */
	public Student findStudentByName(String name){
		for(Student student : students){
			if(student.getName().equals(name)){
				return student;
			}
		}
		return null;
	}
	/**
	 * Print Students in course
	 * @param Arraylist<Course>
	 */
	public void printStudentsInCourse(ArrayList<Course> courses){
		//Go throught index list
		boolean flag = false;
		for(Course c : courses){
			//Compare each index in student list
			for(Student s : this.students){
				if(s.getIndexes().indexOf(c.getIndex()) != -1){
					System.out.println(s.getName() + " " + c.getIndex());
					flag = true;
					}
			}
		}
		if(!flag)
			System.out.println("No student is registered to that index number");
	}
	/**
	 * Register course for student
	 * @param int ID students ID
	 * @param int ind Registered courses index
	 */
	public void addCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID)
				s.addIndex(ind);
		}
	}
	/**
	 * Unregister course for student
	 * @param int ID 
	 * @param int ind
	 */
	public void removeCourse(int ID, int ind){
		for(Student s : students){
			if(s.getID() == ID){
				s.getIndexes().remove(s.getIndexes().indexOf(ind));
				}
		}
	}
	/**
	 * Change students registered courses index
	 * @param int indFrom
	 * @param int indTo
	 * @param int ID students ID
	 */
	public void changeIndex(int indFrom, int indTo, int ID){
		for(Student s : students){
			if(s.getID() == ID){
				s.changeIndex(indFrom, indTo);
			}
		}
	}
	/**
	 * Send notification according to students preferencies
	 * @param Integer ID
	 * @param int index Index that information concerns
	 */
	public void sendNotification(Integer ID, int ind){
		Student s = findStudentByID(ID);
		if(s.getNotPref() == Person.NOTIFICATION.MAIL)
			System.out.println("MAIL SENT!");
		else if(s.getNotPref() == Person.NOTIFICATION.PHONE)
			System.out.println("Send text message");	
		else
			System.out.println("MAIL AND TEXT MESSAGE SEND");
		
	}
	/**
	 * Print student list
	 */
	public void printStudentList(){
		for(Student student : students){
			System.out.println(student.getName() + " " + student.getID());
		}
	}
}
