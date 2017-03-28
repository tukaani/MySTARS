import java.util.ArrayList;

public class FileIO{
	//Assuming that students variable is not destroyed when the function that called this class has ended
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Index> indexes = new ArrayList<Index>();

	public static void test(){
		Student student = new Student("Jack", 123, Person.GENDER.FEMALE, "holland");
		Course course = new Course("first", "java", 10, "SCI");
		courses.add(course);
		// ArrayList<String> timeTable = new ArrayList<String>();
		// timeTable.add("lecture", "T2", "Monday", "9");
		String[] timeTable = {"lecture", "T2", "Monday", "9"};
		course.addIndex(1234);
		String[] timeTable2 = {"lecture", "T5", "Friday", "9"};
		course.addIndex(1234);
		course.addTimeTableforIndex(1234,timeTable);
		course.addTimeTableforIndex(1234,timeTable2);
		//System.out.println(course.getCourseName());
		System.out.println(course.getIndexNum(1234));

		//Write timetable for one index
		for(String[] timeSlot: course.getIndexTimeTable(1234)){
			for(String content: timeSlot)
				System.out.println(content);
		}

	}
	public static void loadStudents(){
		
		//TESTING
		Student student = new Student("Jack", 123, Person.GENDER.FEMALE, "holland");
		students.add(student);
	} 
	
}