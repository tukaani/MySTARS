import java.util.ArrayList;

public class Course {

    protected String courseCode;
    protected String courseName;
    protected String school;
    protected ArrayList<Index> = new ArrayList<Index>();
    protected String lecture; // 
    //protected ArrayList[] staff = new ArrayList[0]; // Not required
    
    public Course(String code, String name, int capacity, String school) {
    courseCode=code;
    courseName=name;
    capacity=capacity;
    }
    
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
 
}
    