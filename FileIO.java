import java.util.ArrayList;

public class FileIO{
	
	public static void loadStudents(ArrayList<Student>students){
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes.add(1234);
		indexes.add(4567);
		indexes.add(12);
		Student student = new Student("Jack", 123, "pwd", Person.GENDER.MALE, "holland", indexes,
			"2017-02-14", "2017-06-14");
		students.add(student);
		
		ArrayList<Integer> indexes2 = new ArrayList<Integer>();
		 indexes2.add(1234);
		student = new Student("Marie", 567, "pwd", Person.GENDER.FEMALE, "holland", indexes2,
			"2017-02-14", "2017-06-14");
		students.add(student);
		
	} 
	public static void loadCourses(ArrayList<Course>courses){
		
		ArrayList<Integer> waitingList = new ArrayList<Integer>();
		// Read waiting list students
		waitingList.add(123);
		int index = 1234;
		int capacity = 10;
		int vacancy = 9;
		String[] timeTable = {"lecture", "T2", "Monday", "9"};
		Course course = new Course("cs2002", "java",index, capacity, 
			vacancy, "SCI",waitingList, timeTable);
		courses.add(course);

		String[] timeTable2 = {"lecture", "T5", "Friday", "9"};
		course = new Course("cs2002", "java",4567, capacity, 
			vacancy, "SCI",waitingList, timeTable2);
		courses.add(course);

		String[] timeTable3 = {"lecture", "T5", "Friday", "8"};
		course = new Course("cs4002", "cpp",12, capacity, 
			5, "SCI",waitingList, timeTable3);
		courses.add(course);

		String[] timeTable4 = {"lecture", "T5", "Tuesday", "8"};
		course = new Course("cs4002", "cpp",12, capacity, 
			5, "SCI",waitingList, timeTable4);


	}
	
}