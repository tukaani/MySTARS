import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
public class FileIO{

	public static String filenameStud = "StudentList.txt";
	public static String filenameCour = "CourseList.txt";
	public static String filenameStaff = "StaffList.txt";
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Course> courses = new ArrayList<Course>();
	public static final String SEPARATOR="|";
	public static final String SEPARATOR2 = "!";
	public static final String SEPARATOR3 = "-";

	public static void saveStudents(ArrayList<Student> studlist) throws IOException {
		
		List students = new ArrayList();
		for (int i=0;i<studlist.size();i++){
			StringBuilder st=new StringBuilder();
			Student stud = (Student)studlist.get(i);
			st.append(stud.getName().trim());
			st.append(SEPARATOR);
			st.append(stud.getID());
			st.append(SEPARATOR);
			st.append(stud.getPassword());
			st.append(SEPARATOR);
			st.append(stud.getGender());
			st.append(SEPARATOR);
			st.append(stud.getNationality());
			st.append(SEPARATOR);
			ArrayList indexList=new ArrayList<Integer>();
			indexList=stud.getIndexes();
			for (int j=0;j<indexList.size();j++){
				st.append(indexList.get(j));
				st.append(SEPARATOR2);
			}
			st.append(SEPARATOR);
			st.append(stud.getStartDate());
			st.append(SEPARATOR);
			st.append(stud.getEndDate());
			st.append(SEPARATOR);
			st.append(stud.getPhone()); 
			st.append(SEPARATOR);
			st.append(stud.getNotPref()); 
			st.append(SEPARATOR);
			
			students.add(st.toString());
		}
		write(filenameStud, students);
	}
	
	public static void saveCourses(ArrayList<Course> courselist) throws IOException {

		List courses = new ArrayList();
		for (int i=0;i<courselist.size();i++){
			StringBuilder st=new StringBuilder();
			Course cour=(Course)courselist.get(i);
			st.append(cour.getCourseCode().trim()); 
			st.append(SEPARATOR);
			st.append(cour.getCourseName().trim());
			st.append(SEPARATOR);
			st.append(cour.getIndex());
			st.append(SEPARATOR);
			st.append(cour.getCapacity());
			st.append(SEPARATOR);
			st.append(cour.getVacancy());
			st.append(SEPARATOR);
			st.append(cour.getSchool());
			st.append(SEPARATOR);
			
			String[] timeTable=cour.getTimeTable();
			for (int k=0;k<8;k++){
				st.append(timeTable[k]);
				st.append(SEPARATOR3);
			}
			st.append(SEPARATOR);
			st.append(cour.getStaff(0));
			st.append(SEPARATOR);
			st.append(cour.getStaff(1));
			st.append(SEPARATOR);
			ArrayList waitList=new ArrayList<Integer>();
			if (cour.getWaitingList().size() != 0) {
				waitList = cour.getWaitingList();
				st.append(waitList.get(0));
				for (int j=1;j<waitList.size();j++){
					st.append(SEPARATOR2);
					st.append(waitList.get(j));
				}
			}
			st.append(SEPARATOR);
			courses.add(st.toString()); 
		}	
		write(filenameCour, courses);
	}
  public static void write(String filename, List data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(filename));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }

  public static ArrayList readStudents() throws IOException {
	  ArrayList stringArray=(ArrayList)read(filenameStud);
	  ArrayList students = new ArrayList();
	  
	  for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		  String name=stok.nextToken().trim();
		  String ID=stok.nextToken().trim();
		  String password = stok.nextToken().trim();
		  String gender=stok.nextToken().trim();
		  Person.GENDER gender1;
		  if (gender=="FEMALE"){
			  gender1=Person.GENDER.FEMALE;
		  }
		  else {
			  gender1=Person.GENDER.MALE;
		  }
		  String nationality=stok.nextToken().trim();
		  String indexString;
		  ArrayList indexes=new ArrayList<Integer>();
		  indexString = stok.nextToken().trim();
		  String startD = "";
		  if(!indexString.contains("-")){
		  	StringTokenizer stok1=new StringTokenizer(indexString,SEPARATOR2);
		  	int count = stok1.countTokens();
			  for (int j=0;j<count;j++){ 
				  String part=stok1.nextToken();
				  indexes.add(Integer.parseInt(part));
			  }
			  startD = stok.nextToken().trim();
		  }
		  else{
		  	startD = indexString;
		  }
		  String endD = stok.nextToken().trim();
		  String phone = stok.nextToken().trim();
		  String notPref=stok.nextToken().trim();
		  Person.NOTIFICATION notificationPreference;
		  if (notPref=="MAIL"){
			  notificationPreference=Person.NOTIFICATION.MAIL;
		  }
		  else if (notPref=="PHONE"){
			  notificationPreference=Person.NOTIFICATION.PHONE;
		  }
		  else {
			  notificationPreference=Person.NOTIFICATION.MAILANDPHONE;
		  }
		  
		  Student stud= new Student(name,Integer.parseInt(ID),password,gender1,nationality,indexes,
		  	startD, endD, Integer.parseInt(phone),notificationPreference);
		  students.add(stud);
	  }
	  return students;
  }
  public static ArrayList readCourses() throws IOException{
  		

	  ArrayList stringArray=(ArrayList)read(filenameCour);
	  ArrayList courses = new ArrayList();
	  
	  for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		  
		  String courseCode=stok.nextToken().trim();
		  String courseName=stok.nextToken().trim();
		  int index = Integer.parseInt(stok.nextToken().trim());
		  int capacity=Integer.parseInt(stok.nextToken().trim());
		  int vacancy=Integer.parseInt(stok.nextToken().trim());
		  String school=stok.nextToken().trim();

		  String timeTab=stok.nextToken().trim();
		  StringTokenizer stok1=new StringTokenizer(timeTab,SEPARATOR3);
		  String[] timeTable = new String[8];
		  for (int k=0;k<8;k++){
		  		String temp = stok1.nextToken().trim(); 
			  timeTable[k]= temp;
		  }
		  

		  String[] staff = new String[2];
		  staff[0] = stok.nextToken().trim();
		  staff[1] =  stok.nextToken().trim();
		  
		  
		  ArrayList waitingList=new ArrayList<Integer>();
		  String waitList1;
		  try{
		  	waitList1=stok.nextToken();
		  }
		  catch(NoSuchElementException e){
		  	Course cour=new Course(courseCode,courseName,index, capacity, vacancy, school, 
		  	waitingList, timeTable,staff); 
		  	courses.add(cour);
		  	continue;
		  }
		  
		  StringTokenizer stok2= new StringTokenizer(waitList1, SEPARATOR2);	 
		  int count = stok2.countTokens();
		  for (int j=0;j<count;j++){ 
			  String part=stok2.nextToken();
			  waitingList.add(Integer.parseInt(part));
		  }
		  Course cour=new Course(courseCode,courseName,index, capacity, vacancy, school, 
		  	waitingList, timeTable, staff); 
		  courses.add(cour);
		  }
	  
	  return courses;
  }
 	public static ArrayList readStaff() throws IOException {
 		ArrayList stringArray=(ArrayList)read(filenameStaff);
	 	ArrayList<Staff> staff = new ArrayList();
	 	for (int i=0;i<stringArray.size();i++) {
		  String st = (String)stringArray.get(i);
		  StringTokenizer stok= new StringTokenizer(st, SEPARATOR);
		  String name=stok.nextToken().trim();
		  String ID=stok.nextToken().trim();
		  String password = stok.nextToken().trim();
		  String title=stok.nextToken().trim();
		  Staff s = new Staff(name, Integer.parseInt(ID), password, title);
			staff.add(s);
		}
		return staff;
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