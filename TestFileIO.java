import java.util.ArrayList;

public class TestFileIO{
	 
	public static void loadStudents(ArrayList<Student>students){
		

		ArrayList<Integer> indexes = new ArrayList<Integer>();
		indexes.add(1234);
		indexes.add(4567);
		indexes.add(12);
		Student student = new Student("Jack", 123, "pwd", Person.GENDER.MALE, "holland", indexes,
			"2017-02-14", "2017-06-14", 421421, Person.NOTIFICATION.MAIL);
		students.add(student);
		
		ArrayList<Integer> indexes2 = new ArrayList<Integer>();
		 indexes2.add(1234);
		student = new Student("Marie", 567, "pwd", Person.GENDER.FEMALE, "holland", indexes2,
			"2017-02-14", "2017-06-14", 421421, Person.NOTIFICATION.MAIL);
		students.add(student);
		
	} 
	public static void loadCourses(ArrayList<Course>courses){
		
		ArrayList<Integer> waitingList = new ArrayList<Integer>();
		ArrayList<Integer> waitingList2 = new ArrayList<Integer>();
		//ArrayList<Integer> staff = new ArrayList<Integer>();
		//staff.add(new Staff("Chun woo", 888, "pwd", "Professor"));
		String[] staff = {"888", "777"};
		
		int index = 1234;
		int capacity = 10;
		int vacancy = 9;
		waitingList2.add(123);
		String[] timeTable = {"lecture", "T2", "Monday", "9", "tut", "tr-8", "Wendnesday", "9"};
		Course course = new Course("cs2002", "java",index, capacity, 
			vacancy, "SCI",waitingList2, timeTable,staff);
		courses.add(course);
		
		String[] timeTable2 = {"lecture", "T5", "Friday", "9", "tut", "tr-1", "Wendnesday", "10"};
		course = new Course("cs2002", "java",4567, capacity, 
			vacancy, "SCI",waitingList, timeTable2,staff);
		courses.add(course);

		String[] timeTable3 = {"lecture", "T5", "Friday", "8", "tut", "tr-5", "Wendnesday", "12"};
		course = new Course("cs4002", "cpp",12, capacity, 
			5, "SCI",waitingList, timeTable3, staff);
		courses.add(course);

		String[] timeTable4 = {"lecture", "T5", "Tuesday", "8", "tut", "tr-2", "Wendnesday", "11"};
		course = new Course("cs4002", "cpp",12, capacity, 
			5, "SCI",waitingList, timeTable4, staff);


	}

	
}