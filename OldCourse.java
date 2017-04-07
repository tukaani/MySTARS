import java.util.ArrayList;

public class Course {

    protected String courseCode;
    protected String courseName;
    protected int capacity; 
    protected String school;
    protected ArrayList<Index> indexes = new ArrayList<Index>();
    //protected ArrayList<Integer> indexes = new ArrayList<Integer>();
    //protected String[] lecture = new String[4]; // type, venue, weekday, time  
    //protected ArrayList[] staff = new ArrayList[0]; // Not required
    
    public Course(String code, String name, int capacity, String school,
        ArrayList<Index> indexes) {
        courseCode=code;
        courseName=name;
        capacity=capacity;
        // for(Index i: indexes)
        //     this.indexes.add(i);

    }
    public String getCourseName(){
        return this.courseName;
    }

    //Add new index for this course
    // public void addIndex(int indexNum){ 
    //     indexes.add(new Index(indexNum, this.capacity));    
    // }
    // public void addTimeTableforIndex(int indexNum, String[] timeTable){
    //     getIndex(indexNum).addTimeTable(timeTable);
    // }

    // public int getIndexNum(int indexNum){
    //     for(Index index: indexes){
    //         if(index.getIndex() == indexNum)
    //             return indexNum;
    //     }
    //     return -1;
    // }
    /**
    * Get Index instance
    * @param indexNum
    * @return Index instance or null if not found
    */
    // public Index getIndex(int indexNum){
    //     for(Index index: indexes){
    //         if(index.getIndex() == indexNum)
    //             return index;
    //     }
    //     return null; // Index instance could not be found
    // }
    // public ArrayList<String[]> getIndexTimeTable(int indexNum){
    //     return getIndex(indexNum).getTimeTable();
    // }
    // public void setIndexNumber(int from, int to){
    // for(Index index: indexList){
    // 	if(from == index.getIndex())
    // 		index.setIndex(to);
    // 	}
    // }

    public void addLecture (int day, int start, int stop, String venue) {
    // add something
    System.out.println("You have now added the lecture.");
    }
 
}
    