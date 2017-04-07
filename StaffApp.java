import java.util.Scanner;
import java.util.ArrayList;
import java.io.Console;

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
					
					break;
				case(2):
					
					break;
				case(3):
					
					break;
				case(4):
					//checkVacancies();
					break;
				case(5):
					printClassByIndex();
					break;
				case(6):
					break;
			}

		}while(ch < 7);
		
	}
	//ask course name
	//list all possible indexes
	//go throuhg student list to find out who has those indexes, 
	//	add those students to list
	// prin the list
	public void printClassByIndex(){
		System.out.print("Give course name where to list students: ");
		String name = sc.next();
		ArrayList<Course> c = courseList.findCourseByName(name);
		if(c.size() == 0){
			System.out.println("Course name could not be found\n");
			start();			
		}
		studentlist.printStudentsInCourse(c);
		// for(Student s : students){
		// 	System.out.println(s.getName());
		// }
		

	}
	public void printMenu(){
		System.out.println("Choose from options below");
		System.out.println("1. Edit students access period");
		System.out.println("2. Add student");
		System.out.println("3. Add/Update course");
		System.out.println("4. Check vacancies available");
		System.out.println("5. Print student list by index number");
			//all students registered for the selected course
		System.out.println("6. Print student list by course"); 
	}

}	