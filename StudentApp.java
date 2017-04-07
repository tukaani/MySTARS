import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;

public class StudentApp{
	private Scanner sc = new Scanner(System.in);

	/**
	* student variable holds current users student instance
	*/
	private Student student;
	private studentList studentlist = new studentList();
	private CourseList courseList = new CourseList();
	/**
	* Course that student is currently checking. Saved for intance variable so
	* we don't need to pass it around
	*/
	//public Course course;
	
	public StudentApp(){
		//FileIO.test(this.students); 
		// FileIO.loadStudents(this.students);
		// FileIO.loadCourses(courses);
		//studentList = new studentList();
	}

	public void loginStudent(){
		Console cnsl = System.console();
		String matricN = cnsl.readLine("Give your matriculation number: ");
		char[] passwd = cnsl.readPassword("password: ");

		for(Student student:studentlist.getStudents()){
			if(Integer.toString(student.getID()).equals(matricN) 
				&& student.getPassword().equals(new String(passwd))
				&& student.checkDate()){
					this.student = student;
					System.out.println("Welcome " + this.student.getName());
					
					start();
				}
		}
		System.out.println("Login failed!");
		return;
	}
	public void start(){
		int ch = 0;
		do{
			printMenu();
			ch = sc.nextInt();
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
					// IMPLEMENT ME :(
					break;
				case(7):
					changeNotPref();
					break;
				default:
					return;
			}

		}while(ch < 8);
		
	}
	public void printMenu(){
		System.out.println("Choose from options below");
		System.out.println("1. Add course");
		System.out.println("2. Drop course");
		System.out.println("3. Check/print Courses registered");
		System.out.println("4. Check vacancies available");
		System.out.println("5. Change index number of course");
		System.out.println("6. Swap index number with with another student");
		System.out.println("7. Change notification preference");
	}
	// NO ERROR CHECKING
	public void addCourse(){
		System.out.print("Give course name: ");
		String name = sc.next();
		ArrayList<Course> C = courseList.findCourseByName(name);
		if(C.size() == 0){
			System.out.println("Course name could not be found\n");
			start();			
		}
		for(Course course : C)
			course.printTimeTable();
		System.out.println("Write wanted index number: ");

		int ind = sc.nextInt();
		if(!checkClash(ind)){
			System.out.println("Clash!");
		}
		else if(courseList.getVacancy(ind) == 0){
			System.out.println("Course (index) is full. You are added to waiting list");
			courseList.addToWaitList(ind, student.getID());
		}
		else{
			System.out.println("Course added!");
			courseList.reduceVacancy(ind);
			studentlist.addCourse(student.getID(), ind);
		}

					
	}

	public boolean checkClash(int ind){
		for(Integer i : this.student.getIndexes()){
			if(!courseList.checkClash(i, ind))
				return false;
		}
		return true;
	}
	public void dropCrourse(){

		printCourses();
		System.out.println("Write wanted index number: ");
		int ind = sc.nextInt();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes = student.getIndexes();
		if(!indexes.contains(ind)){
			System.out.println("Index was not in list");
			start();
		}
		studentlist.removeCourse(student.getID(), ind);
		System.out.println("Course removed!");
		Integer ID = courseList.increaseVacancy(ind);
		if(ID != 0){
			studentlist.addCourse(ID, ind);
			studentlist.sendMail(ID, ind);
		}

	}

	public void printCourses(){
		ArrayList<Integer> indexes = new ArrayList<Integer>();

		indexes = student.getIndexes();
		for(Integer i: indexes){
			for(Course c:courseList.getCourses()){
				if(i.equals(c.getIndex())){
					c.printInfo();
					}
			}
		}

	}
	public void checkVacancies(){
		System.out.println("Write course name: ");
		String name = sc.next();

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

		if(!checkClash(indTo)){
			System.out.println("Clash!");
		}
		else if(courseList.getVacancy(indTo) == 0){
			System.out.println("Course (index) is full.");
		}
		else{
			studentlist.changeIndex(indFrom, indTo, this.student.getID());	
			
			courseList.reduceVacancy(indTo);
			Integer ID = courseList.increaseVacancy(indFrom);
			if(ID != 0){
				studentlist.addCourse(ID, indFrom);
				studentlist.sendMail(ID, indFrom);
		}
			System.out.println("Index changed!");
			
		}
	}

	public void changeNotPref(){
		System.out.print("Choose preferedded notification. 1. Mail 2. Phone. (Default is mail) ");

		int pref = sc.nextInt();
		System.out.println(studentlist.findStudentByID(student.getID()).getNotPref());
		if(pref == 1)
			studentlist.findStudentByID(student.getID()).setNotPref(true);
		else if(pref == 2){
			studentlist.findStudentByID(student.getID()).setNotPref(false);
		}
		else
			System.out.println("Nothing was changed!");
	}
	
}