import java.util.ArrayList;

public class CourseList {

	private ArrayList<Course> courses = new ArrayList<Course>();

	public CourseList(){
		FileIO.loadCourses(this.courses);
	}

	public ArrayList<Course> getCourses(){
		return this.courses;
	}
	public ArrayList<Course> findCourseByName(String name){
		ArrayList<Course> C = new ArrayList<Course>();
		for(Course course : this.courses){
			if(name.equals(course.getCourseName()))
				C.add(course);
		}
		return C;
	}

	public Course findCourseByIndex(int ind){
		for(Course course : this.courses){
			if(ind == course.getIndex())
				return course;
		}
		return null;
	}
	public int getVacancy(int ind){
		Course course = findCourseByIndex(ind);
		return course.getVacancy();
	}
	public void changeVacancy(int ind, int amount){
		for(Course c : courses){
			if(c.getIndex() == ind)
				c.setVacancy(amount);
		}
	}
	public void reduceVacancy(int ind){
		for(Course c : courses){
			if(c.getIndex() == ind)
				c.reduceVacancy();
		}
	}
	public Integer increaseVacancy(int ind){
		for(Course c : courses){
			if(c.getIndex() == ind)
				return c.increaseVacancy();
		}
		return 0;
	}
	public void addToWaitList(int ind, int ID){
		for(Course course : courses){
			if(course.getIndex() == ind){
				course.addToWaitList(ID);
				}
		}

	}
	
	public void printCourses(String name){
		ArrayList<Course> C = findCourseByName(name);
		for(Course c : C){
			c.printInfo();
		}
	}
	public boolean checkClash(int ind1, int ind2){
		Course course1 = findCourseByIndex(ind1);
		Course course2 = findCourseByIndex(ind2);
		if (course1.getTimeTable()[2] == course2.getTimeTable()[2] &&
			course1.getTimeTable()[3] == course2.getTimeTable()[3])
			return false;
		return true;
	}
	public void updateCourse(String coursecode){
		//update from coursecode or indexnumber? As one course will have multiple indexnumbers..

	}
	// public int getVacancies(String coursecode){
	// 	//same as above, coursecode or index?
	// 	for (int i=0;i<coursesInArray;i++) {
	// 		if (courses[i].getCoursecode==coursecode){
	// 			return courses[i].getVacancies;
	// 		}		
	// 	}
	// }
	public void sortCourses(){/*NOT FINISHED*/}
}
