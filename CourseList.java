import java.util.ArrayList;
import java.io.IOException;
/**
 Holds list of Course objects
 @version 1.0
 @since 2017-04-10
*/
public class CourseList {
	/**
	* Arraylist for courses
	*/
	private ArrayList<Course> courses = new ArrayList<Course>();
	/**
	* CourseList constuctor. Reads courses from file
	*/
	public CourseList(){
		try{
			//TestFileIO.loadCourses(this.courses);
			//FileIO.saveCourses(this.courses);
			this.courses = FileIO.readCourses();
			}
		catch(IOException e){
			System.out.println("Error reading courseList file: " + e);
			}
	}
	/**
	* Loads courses from file
	*/
	public void loadCourses(){
		try{
			this.courses = FileIO.readCourses();
		}
		catch(IOException e ){
			System.out.println("Error reading courseList file: " + e);
		}
	}
	/**
	* Saves courses to file
	*/
	public void saveCourses(){
		try{
			FileIO.saveCourses(this.courses);
		}
		catch(IOException e ){
			System.out.println("Error reading courseList file: " + e);
		}

	}
	/**
	* Get course list
	* @return ArrayList<Course>
	*/
	public ArrayList<Course> getCourses(){
		return this.courses;
	}
	/**
	* Add new course to list
	* @param Course course
	*/
	public void addCourse(Course course){
		courses.add(course);
	}
	/**
	* Find course by name
	* @param String name
	* @return ArrayList<Course>
	*/
	public ArrayList<Course> findCourseByName(String name){
		ArrayList<Course> C = new ArrayList<Course>();
		for(Course course : this.courses){
			if(name.equals(course.getCourseName()))
				C.add(course);
		}
		return C;
	}
	/**
	* Find Course by index
	* @param int ind
	* @return Course if found else null
	*/
	public Course findCourseByIndex(int ind){
		for(Course course : this.courses){
			if(ind == course.getIndex())
				return course;
		}
		return null;
	}
	/**
	* Get course vacancy
	* @param int ind
	* @return int 
	*/
	public int getVacancy(int ind){
		Course course = findCourseByIndex(ind);
		return course.getVacancy();
	}
	/**
	* Change vacancy for course
	* @param int ind
	* @param int amount
	*/
	public void changeVacancy(int ind, int amount){
		for(Course c : courses){
			if(c.getIndex() == ind)
				c.setVacancy(amount);
		}
	}/**
	* Reduce course's vacancy
	* @param int ind
	*/
	public void reduceVacancy(int ind){
		for(Course c : courses){
			if(c.getIndex() == ind)
				c.reduceVacancy();
		}
	}
	/**
	* Increase course vacanćy
	* @param int ind
	* @return Integer 
	*/
	public Integer increaseVacancy(int ind){
		for(Course c : courses){
			if(c.getIndex() == ind)
				return c.increaseVacancy();
		}
		return 0;
	}
	/**
	* Add student to course's waitinglist
	* @param int ind
	* @param int ID 
	*/
	public void addToWaitList(int ind, int ID){
		for(Course course : courses){
			if(course.getIndex() == ind){
				course.addToWaitList(ID);
				}
		}
	}
	/**
	* Print all course that are in MySTARS
	*/
	public void printAllCourses(){
		for(Course c : courses)
			c.printInfo();
	}
	/**
	* Print course information
	* @param String name
	*/
	public void printCourses(String name){
		ArrayList<Course> C = findCourseByName(name);
		for(Course c : C){
			c.printInfo();
		}
	}
	/**
	* Check if there is class between two courses
	* @param int ind1
	* @param int ind2
	* @param boolean return true is no clash, else false
	*/
	public boolean checkClash(int ind1, int ind2){
		Course course1 = findCourseByIndex(ind1);
		Course course2 = findCourseByIndex(ind2);

		if (course1.getTimeTable()[2] == course2.getTimeTable()[2] &&
			course1.getTimeTable()[3] == course2.getTimeTable()[3]
			|| (course1.getTimeTable()[6] == course2.getTimeTable()[6]) &&
			course1.getTimeTable()[7] == course2.getTimeTable()[7])
				return false;
		return true;
	}
}
