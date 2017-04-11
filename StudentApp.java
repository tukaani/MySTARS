import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;
/**
 Handles Students functionalites
 @version 1.0
 @since 2017-04-10
*/
public class StudentApp{
	private Scanner sc = new Scanner(System.in);

	/**
	* Student variable holds current users student instance
	*/
	private Student student;
	/**
	* Creates StudentList class
	*/
	private StudentList studentList = new StudentList();
	/**
	* Creates CourseList class
	*/
	private CourseList courseList = new CourseList();
	
	/**
	* Handles student login
	*/
	public void loginStudent(){
		Console cnsl = System.console();
		String matricN = cnsl.readLine("Give your matriculation number: ");
		char[] passwd = cnsl.readPassword("password: ");

		for(Student student:studentList.getStudents()){
			if(Integer.toString(student.getID()).equals(matricN) 
				&& student.getPassword().equals(new String(passwd))
				&& student.checkDate()){
					this.student = student;
					System.out.println("Welcome " + this.student.getName());
					System.out.println();
					int res = start();
					if(res == -1){
						System.out.println("Logging out!");
						return;
					}
				}
		}
		System.out.println("Login failed!");
		return;
	}
	/**
	* StudentApp's control flow
	*/
	public int start(){
		Scanner sca = new Scanner(System.in);
		int ch = 0;
		do{
			printMenu();
			ch = sca.nextInt();
			switch(ch){
				case(1):
					addCourse();
					break;
				case(2):
					dropCrourse();
					break;
				case(3):
					printCourses();
					break;
				case(4):
					checkVacancies();
					break;
				case(5):
					changeIndex();
					break;
				case(6):
					swapIndex();
					break;
				case(7):
					changeNotPref();
					break;
				case(8):
					return -1;
				default:
					System.out.println("Invalid input");
					break;
			}

		}while(ch < 8);
		return 1;
	}
	/**
	* Prints menu
	*/
	public void printMenu(){
		System.out.println("Choose from options below");
		System.out.println("1. Add course");
		System.out.println("2. Drop course");
		System.out.println("3. Check/print Courses registered");
		System.out.println("4. Check vacancies available");
		System.out.println("5. Change index number of course");
		System.out.println("6. Swap index number with with another student");
		System.out.println("7. Change notification preference");
		System.out.println("8. Log out");
	}
	/**
	* Add course for student
	*/
	public void addCourse(){
		Scanner sca = new Scanner(System.in);
		courseList.printAllCourses();
		System.out.print("Give course name: ");
		String name = sca.nextLine();
		ArrayList<Course> C = courseList.findCourseByName(name);
		if(C.size() == 0){
			System.out.println("Course name could not be found\n");
			start();			
		}
		System.out.println("Timetable:");
		for(Course course : C)
			course.printTimeTable();
		System.out.println("Write wanted index number: ");

		int ind = sca.nextInt();
		if(!checkClash(ind, this.student)){
			System.out.println("Clash!");
		}
		else if(courseList.getVacancy(ind) == 0){
			System.out.println("Course (index) is full. You are added to waiting list");
			courseList.addToWaitList(ind, student.getID());
		}
		else{
			System.out.println("Course added!");
			courseList.reduceVacancy(ind);
			studentList.addCourse(student.getID(), ind);
			
		}
		courseList.saveCourses();
		studentList.saveStudents();
					
	}
	/**
	* Check if there is class if index is added to student
	* @param ind Index to check
	* @param stud Student instance
	* @return returns true if there is no clash, false otherwise
	*/
	public boolean checkClash(int ind, Student stud){
		for(Integer i : stud.getIndexes()){
			if(!courseList.checkClash(i, ind))
				return false;
		}
		return true;
	}
	/**
	* Drop course
	*/
	public void dropCrourse(){

		printCourses();
		System.out.print("Write wanted index number: ");
		int ind = sc.nextInt();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes = student.getIndexes();
		if(!indexes.contains(ind)){
			System.out.println("Index was not in list");
			start();
		}
		studentList.removeCourse(student.getID(), ind);
		System.out.println("Course removed!");
		Integer ID = courseList.increaseVacancy(ind);
		if(ID != 0){
			studentList.addCourse(ID, ind);
			studentList.sendNotification(ID, ind);
		}
		courseList.saveCourses();
		studentList.saveStudents();

	}
	/**
	* Print registered courses
	*/
	public void printCourses(){
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		indexes = student.getIndexes();
		if(indexes.size() == 0){
			System.out.println("No courses has been registered!");
			return;
		}
		for(Integer i: indexes){
			for(Course c:courseList.getCourses()){
				if(i.equals(c.getIndex())){
					c.printInfo();
					}
			}
		}

	}
	/**
	* Check if course has vacancies available
	*/
	public void checkVacancies(){
		Scanner sca = new Scanner(System.in);
		System.out.println("Write course name: ");
		String name = sca.nextLine();

		ArrayList<Course> C = courseList.findCourseByName(name);
		if(C.size() == 0){
			System.out.println("Course name could not be found\n");
			start();			
		}
		for(Course course : C){
			course.printInfo();
		}
	}

	// ask index to be changed, 
	//check that courses name, 
	//find all indexes attached to
	// to that name and print them,
	// ask index to swap,
	// check classh and vacancy

	//if OK, change index number from student instance
	//reduce vancancy for that, increase for the other
	// add new index in student instance
	//check is anyone in the waiting list in the other course
	/**
	* Change course(index) for student
	*/
	public void changeIndex(){
		printCourses();
		System.out.println("Write index you wish to change: ");
		int indFrom = sc.nextInt();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes = student.getIndexes();
		if(!indexes.contains(indFrom)){
			System.out.println("Index was not in list");
			start();
		}

		//Find all courses that related to that index
		Course c = courseList.findCourseByIndex(indFrom);
		ArrayList<Course> C = courseList.findCourseByName(c.getCourseName());
		if(C.size() == 0){
			System.out.println("Course name could not be found\n");
			start();			
		}
		courseList.printCourses(c.getCourseName());

		System.out.print("Write index number to swap");
		int indTo = sc.nextInt();

		if(!checkClash(indTo, this.student)){
			System.out.println("Clash!");
		}
		else if(courseList.getVacancy(indTo) == 0){
			System.out.println("Course (index) is full.");
		}
		else{
			studentList.changeIndex(indFrom, indTo, this.student.getID());	
			
			courseList.reduceVacancy(indTo);
			Integer ID = courseList.increaseVacancy(indFrom);
			if(ID != 0){
				studentList.addCourse(ID, indFrom);
				studentList.sendNotification(ID, indFrom);
		}
			System.out.println("Index changed!");
			courseList.saveCourses();
			studentList.saveStudents();
			
		}
	}
	/**
	* Swaps course(index) between students.
	*/
	public void swapIndex(){
		Scanner sca = new Scanner(System.in);
		System.out.print("Give index to swap: ");
		int indFrom = sca.nextInt();
		if(student.findIndex(indFrom) == -1){
			System.out.println("Index could not be found. Aborting");
			return;
		}

		System.out.print("Give another users ID: ");
		int ID = sca.nextInt();

		Student target = studentList.findStudentByID(ID);
		if(target == null){
			System.out.println("Student could not be found. Aborting");
			return;
		}
		
		System.out.print("Give target student's index number to swap");
		int indTo = sca.nextInt();
		if(target.findIndex(indTo) == -1){
			System.out.println("Index could not be found. Aborting");
			return;	
		}

		if(!checkClash(indTo, this.student) || !checkClash(indFrom, target)){
			System.out.println("Index swap causes clash! Aborting");
			return;
		}
		student.changeIndex(indFrom, indTo);
		target.changeIndex(indTo, indFrom);
		System.out.println("Indexes swapped succesfully!");
		courseList.saveCourses();
		studentList.saveStudents();

	}
	/**
	* Changes students notification preference
	*/
	public void changeNotPref(){
		System.out.print("Choose preferedded notification. 1. Mail 2. Phone 3. Both ");

		int pref = sc.nextInt();
		System.out.println(studentList.findStudentByID(student.getID()).getNotPref());
		if(pref == 1)
			studentList.findStudentByID(student.getID()).setNotPref(Person.NOTIFICATION.MAIL);
		else if(pref == 2){
			studentList.findStudentByID(student.getID()).setNotPref(Person.NOTIFICATION.PHONE);
		}
		else
			studentList.findStudentByID(student.getID()).setNotPref(Person.NOTIFICATION.MAILANDPHONE);

		studentList.saveStudents();
	}
	
}