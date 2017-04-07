import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;
import java.util.InputMismatchException;
public class StaffApp{

	private Scanner sc = new Scanner(System.in);
	private studentList studentlist = new studentList();
	private CourseList courseList = new CourseList();
	

	public void loginStaff(){
		Console cnsl = System.console();
		String matricN = cnsl.readLine("Give your ID number: ");
		char[] passwd = cnsl.readPassword("password: ");

		start();
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
					editAccessPeriod();
					break;
				case(2):
					addStudent();
					break;
				case(3):
					addCourse();
					break;
				case(4):
					updateCourse();
					break;
				case(5):
					//checkVacancies();
					break;
				case(6):
					printStudentsByIndex();
					break;
				case(7):
					printStudentsByCourse();
					break;

			}

		}while(ch < 7);
		
	}

	public void editAccessPeriod(){
		System.out.println("Give students ID ");
		int ID = sc.nextInt();

		Student student = studentlist.findStudentByID(ID);
		if(student == null){
			System.out.println("Student could not be found");
			return;
		}
		System.out.print("Start Date in format: 2017-06-14 " +
			"Push Enter if you wish to skip date change ");
		
		sc.nextLine();
		String date  = sc.nextLine();
		if(!date.equals("")){
			student.setStartDate(date);
		}
		System.out.print("End Date in format: 2017-06-14 " +
			"Push Enter if you wish to skip date change ");
		date = sc.nextLine();
		if(!date.equals("")){
			student.setEndDate(date);
		}
		System.out.println("Access period succesfully changed!");
	}

	public void addStudent(){
		try {
			Scanner sca = new Scanner(System.in);
			System.out.println("New student will be created but without any courses");
			System.out.print("Give name ");
			String name = sca.next();
			System.out.print("Give ID ");
			int ID = sca.nextInt();
			System.out.print("Give password ");
			String password = sca.next();
			System.out.print("Give gender. Format male/female ");
			String gend = sca.next();
			Person.GENDER gender;
			if(gend.equals("male"))
				gender = Person.GENDER.MALE;
			else
				gender = Person.GENDER.FEMALE;
			System.out.print("Give nationality ");
			String nationality = sc.next();
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			System.out.print("Give start access date in format: 2017-06-14 ");
			String startDate = sca.next();
			System.out.print("Give end access date in format: 2017-06-14 ");
			String endDate = sca.next();
			System.out.print("Give phone number ");
			int phone = sca.nextInt();
			Student student = new Student(name, ID, password, gender, nationality, indexes,
				startDate, endDate, phone);
			studentlist.addStudent(student);
			// for(Student s : studentlist.getStudents()){
			// 	s.printInfo();
			// 	System.out.println(s.getStartDate());
			// 	for(Integer i : s.getIndexes())
			// 		System.out.println(i);
			// }
			System.out.println("Student added!");
		}
		catch(InputMismatchException e){
		 	System.out.println("Error in inputs ");
		 }
	}

	public void addCourse(){
		try {
			Scanner sca = new Scanner(System.in);
			System.out.print("Give code for the course ");
			String code = sca.next();
			System.out.print("Give name for the course ");
			String name = sca.next();
			System.out.print("Give index number for the course ");
			int index = sca.nextInt();
			System.out.print("Give capacity for the course ");
			int capacity = sca.nextInt();
			System.out.print("Give vacancy ");
			int vacancy = sca.nextInt();
			System.out.print("Give school ");
			String school = sca.next();
			ArrayList<Integer> waitingList = new ArrayList<Integer>();
			String[] timeTable = new String[4];
			System.out.print("Give type of the course ");
			timeTable[0] = sca.next();
			System.out.print("Give venue for the course ");
			timeTable[1] = sca.next();
			System.out.print("Give weekday for the course ");
			timeTable[2] = sca.next();
			System.out.print("Give time for the course ");
			timeTable[3] = sca.next();
			Course course = new Course(code, name, index, capacity, vacancy, school,
				waitingList, timeTable);
			courseList.addCourse(course);
			// for(Course c : courseList.getCourses()){
			// 	System.out.println(c.getCourseName());
			// 	for(String s : c.getTimeTable())
			// 		System.out.println(s);
			// 	}
			System.out.println("Course added!");
		}
		catch(InputMismatchException e){
		 	System.out.println("Error in inputs ");
		 }
	}
	public void updateCourse(){
		System.out.print("Given index number for the course to update ");
		int index = sc.nextInt();
		Course course = courseList.findCourseByIndex(index);
		if(course == null){
			System.out.println("Course index could not be found");
			start();			
		}
		int val = sc.nextInt();
		System.out.print("What do you wish to change?")
		System.out.println("1. Code");
		System.out.println("2. Name");
		System.out.println("3. Index");
		System.out.println("4. Capacity");
		System.out.println("5. School");
		System.out.println("6. Timetable");
		System.out.println("7. Abort");
		switch(val){
			case(1):
				course.setCode(sc.nextInt());
				System.out.println("Code changed!");
				break;
			case(2):
				course.setCourseName(sc.nextLine())
				System.out.println("Name changed!");
				break;
			case(3):
				
			case(4):
			case(5):
				if(course.setVacancy(sc.nextInt() == null){
					System.out.println("Vacancy could not be reduced because " +
						"there is students in the waiting list");
						break;
					}

		}
	}

	public void printStudentsByIndex(){
		System.out.print("Give index number ");
		int ind = sc.nextInt();
		studentlist.printStudentsByIndex(ind);

	}
	//ask course name
	//list all possible indexes
	//go throuhg student list to find out who has those indexes, 
	//	add those students to list
	// prin the list
	public void printStudentsByCourse(){
		System.out.print("Give course name where to list students: ");
		String name = sc.next();
		ArrayList<Course> c = courseList.findCourseByName(name);
		if(c.size() == 0){
			System.out.println("Course name could not be found");
			start();			
		}
		studentlist.printStudentsInCourse(c);
	}
	public void printMenu(){
		System.out.println("Choose from options below");
		System.out.println("1. Edit students access period");
		System.out.println("2. Add student");
		System.out.println("3. Add course");
		System.out.println("4. Update course");
		System.out.println("5. Check vacancies available");
		System.out.println("6. Print student list by index number");
			//all students registered for the selected course
		System.out.println("7. Print student list by course"); 
	}

}	