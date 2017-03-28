import java.util.Scanner;
import java.util.ArrayList;

public class StudentApp{

	public void start(){
		Scanner sc = new Scanner(System.in);
		//FileIO.loadStudents(); //Also assuming that FileIO.students ArrayList is not destreyd when this function exits
		int ch = 0;
		FileIO.test();
		
		do{
			printMenu();
			ch = sc.nextInt();
			//System.out.println(FileIO.students.get(0).getName());
			
			switch(ch){
				case(1):
					System.out.print("Give course name ");
					String name = sc.next();
					Course course = findCourse(name);
					if(course == null){
						System.out.println("Course name could not be found\n");
						start();			
					}
					course.getCourseName();
					
					break;
				case(2):
					break;
			}

		}while(ch < 7);
		
	}
	public void printMenu(){
		System.out.println("Choose from options below");
		System.out.println("1. Add course");
		System.out.println("2. Drop course");
		System.out.println("3. Check/print Courses registered");
		System.out.println("4. Check vacancies available");
		System.out.println("5. Change index number of course");
		System.out.println("6. Swop index number with with another student");
	}

	public Course findCourse(String name){
		for(Course course:FileIO.courses){
			if(name.equals(course.getCourseName()))
				return course;
		}
		return null;
	}
}