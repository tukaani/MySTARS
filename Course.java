import java.util.ArrayList;

public class Course {

    protected String courseCode;
    protected String courseName;
    protected String school;
    protected String venue;
    protected ArrayList[] indexList = new ArrayList[0];
    protected ArrayList[] staff = new ArrayList[0];
    
    public Course(String code, String name, int capacity, String school, String venue) {
    courseCode=code;
    courseName=name;
    capacity=capacity;
    }
    public 
    public void setIndexNumber(int from, int to){
    for(Index index: indexList){
    	if(from == index.getIndex())
    		index.setIndex(to)
    	}
    }
    public void addLecture (int day, int start, int stop, String venue) {
    \\ add something
    System.out.println("You have now added the lecture.");
    }
    public void addLab (int day, int start, int stop, String venue) {
    \\ add something
    System.out.println("You have now added the lab.");
    }
    public void addTutorial (int day, int start, int stop, String venue, int index) {
    \\ add something
    System.out.println("You have now added the tutorial for index number " + index);
    }
    