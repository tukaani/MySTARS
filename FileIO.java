import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileIO{
	//Assuming that students variable is not destroyed when the function that called this class has ended
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static ArrayList<Index> indexes = new ArrayList<Index>();
	public static final String SEPARATOR="|";

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
	public static void saveStudents(ArrayList<Student> studlist) throws IOException {
		String filename="StudentList.txt";
		List students = new ArrayList();
		for (int i=0;i<studlist.size();i++){
			StringBuilder st=new StringBuilder();
			Student stud = (Student)studlist.get(i);
			st.append(stud.getName().trim());
			st.append(SEPARATOR);
			st.append(stud.getID());
			st.append(SEPARATOR);
			st.append(stud.getGender());
			st.append(SEPARATOR);
			st.append(stud.getNationality());
			st.append(SEPARATOR);
			st.append(stud.getNotificationPreference());
			st.append(SEPARATOR);
			st.append(stud.getNotificationInfo());
			ArrayList[] index = stud.getIndexes();
			for (int j=0;j<index.size();j++){
				Index ind = (Index)index.get(j);
				st.append(SEPARATOR);
				st.append(ind.getIndex);
			}
			students.add(st.toString());
		}
		write(filename,students);
	}
	public static void saveIndexes(ArrayList<Index> indlist) throws IOException{
		String filename="IndexList.txt";
		List indexes = new ArrayList();
		for (int i=0;i<indlist.size();i++){
			StringBuilder st=new StringBuilder();
			Index ind = (Index)indlist.get(i);
			st.append(ind.getIndex().trim());
			st.append(SEPARATOR);
			st.append(ind.getCapacity()); //add capacity method
			st.append(SEPARATOR);
			st.append(ind.getVacancies());
			st.append(SEPARATOR);
			// something to add timetable. Not sure how it looks yet
			ArrayList<Integer> regIDs= new ArrayList<Integer>();
					regIDs=ind.getStudentIDs(); //add this method
			for (int j=0;j<regIDs.size();j++){
				st.append(SEPARATOR);
				st.append(regIDs(j)); //unknown error
			}
			ArrayList<Integer> waitIDs= new ArrayList<Integer>();
			waitIDs=ind.getWaitingListIDs(); //add this method
			for (int j=0;j<waitIDs.size();j++){
				st.append(SEPARATOR);
				st.append(waitIDs(j)); //unknown error
			}
			}
			indexes.add(st.toString());
		}
		write(filename,indexes);
	}
public static void saveCourses(ArrayList<Course> courselist) throws IOException {
String filename="CourseList.txt";
List courses = new ArrayList();
for (int i=0;i<courselist.size();i++){
	StringBuilder st=new StringBuilder();
	Course cour=(Course)courselist.get(i);
	st.append(cour.getCourseCode().trim()); //add method to Course
	st.append(SEPARATOR);
	st.append(cour.getCourseName().trim());
	st.append(SEPARATOR);
	st.append(cour.getCapacity());
	st.append(SEPARATOR);
	st.append(cour.getSchool());
	st.append(SEPARATOR);
	int[] indexes=cour.getIndexes; //add method to return indexnumbers
			for (int j=0;j<indexes.size();j++){
				st.append(SEPARATOR);
				st.append(indexes(i).getIndex());
			}
	st.append(SEPARATOR);
	st.append(cour.printTimeTable()); //should do something about line changes??
	
courses.add(st.toString()); 
}
write(filename,courses);
}
  public static void write(String fileName, List data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }
  public static ArrayList readStudents(String filename) throws IOException {
	  ArrayList stringArray=(ArrayList)read(filename);
	  ArrayList students = new ArrayList();
	  
	  for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		  String name=stok.nextToken().trim();
		  String ID=stok.nextToken().trim();
		  GENDER gender=stok.nextToken().trim();
		  String nationality=stok.nextToken().trim();
		  NOTIFICATION notificationPreference=stok.nextToken.trim();
		  String notificationInfo=stok.nextToken.trim();
		  int c=0; //counter
		  ArrayList<Integer> indexes; //write differently?
		  while something {// dont know how to run until no more indexes to choose from 
			  indexes[c]=stok.nextToken().trim();
			  c+=1;
		  }
		  Student stud= new Student(name,ID,gender,nationality);
		  stud.addNotificationPreference(/*add code*/)
		for (int k=0;k<indexes.size();k++){ //can't seem to find indexes??
			  stud.addIndex(indexes[i]);
			  }
		  students.add(stud);
	  }
	  return students;
  }
  public static ArrayList readIndexes(String filename) throws IOException{
	  ArrayList stringArray=(ArrayList)read(filename);
	  ArrayList indexes = new ArrayList();
	  
	  for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		 
		  int indexNum=Integer.parseInt(stok.nextToken().trim());
		  int capacity=Integer.parseInt(stok.nextToken().trim());
		  int vacancies=Integer.parseInt(stok.nextToken().trim());
		  //do something to timetable
		  int c=0; //counter
		  int[] regIDs = new int[]; //write differently?
		  while something {// dont know how to run until should stop
			  regIDs(c)=stok.nextToken().trim();
			  c+=1;
		  }
		  int k=0; //counter
		  int[] waitIDs = new int[]; //write differently?
		  while something {// dont know how to run until should stop
			  waitIDs(c)=stok.nextToken().trim();
			  k+=1;
		  }
		  Index ind=new Index(indexNum,capacity,vacancies) //add vacancies to Index creator
		  }
		  indexes.add(ind);
	  }
	  return students;
  }
  public static ArrayList readCourses(String filename) throws IOException{
	  ArrayList stringArray=(ArrayList)read(filename);
	  ArrayList courses = new ArrayList();
	  
	  for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		 
		  String courseCode=stok.nextToken().trim();
		  String courseName=stok.nextToken().trim();
		  int capacity=Integer.parseInt(stok.nextToken().trim());
		  String school=stok.nextToken().trim();
		  int c=0; //counter
		  int[] indexes = new int[]; //write differently?
		  while something {// dont know how to run until should stop
			  indexes(c)=Integer.parseInt(stok.nextToken().trim());
			  c+=1;
		  }
		  // do something to timetable
		  Course cour=new Course(code,name,capacity, vacancy, school, waitingList, timeTable); 
		  courses(i)=cour;
		  }
	  }
	  return courses;
  }
  public static List read(String fileName) throws IOException {
		List data = new ArrayList() ;
	    Scanner scanner = new Scanner(new FileInputStream(fileName));
	    try {
	      while (scanner.hasNextLine()){
	        data.add(scanner.nextLine());
	      }
	    }
	    finally{
	      scanner.close();
	    }
	    return data;
	  }
}
