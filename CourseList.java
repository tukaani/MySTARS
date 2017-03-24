import java.util.ArrayList;

public class CourseList {
private int coursesInArray;
private ArrayList[] courses;
public CourseList(){
	coursesInArray=0;
	courses=new ArrayList[0];
}
public void addCourse(){
	//DO SOMETHING
	coursesInArray+=1;
}
public void updateCourse(String coursecode){
	//update from coursecode or indexnumber? As one course will have multiple indexnumbers..

}
public int getVacancies(String coursecode){
	//same as above, coursecode or index?
	for (int i=0;i<coursesInArray;i++) {
		if (courses[i].getCoursecode==coursecode){
			return courses[i].getVacancies;
		}		
	}
}
public void sortCourses(){/*NOT FINISHED*/}
}
