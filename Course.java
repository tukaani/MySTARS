import java.util.ArrayList;
/**
 Represents a Course object
 Inherits from Person class
 @author 
 @version 1.0
 @since 2016-04-31
*/
public class Course {
    /**
    * Courses course code
    */
    protected String courseCode;
    /**
    * Courses name
    */
    protected String courseName;
    /**
    * Courses index number
    */
    protected int index;
    /**
    * Courses capacity
    */
    protected int capacity; 
    /**
    * Courses vacancy
    */
    protected int vacancy;
    /**
    * Courses school
    */
    protected String school;
   
    /**
    * Waitlist of students 
    */
    protected ArrayList<Integer> waitingListIDs = new ArrayList<Integer>();

    /**
    * Courses timetable. Course can have two timetables
    */
    protected String[] timeTable = new String[8];
    /**
    * Courses staff. Course can have two staff 
    */
    protected String[] staff = new String[2];
    /**
    * Course constuctor
    */
    public Course(String code, String name, int index, int capacity, 
        int vacancy, String school, ArrayList<Integer> waitingListIDs, 
        String[] timeTable, String[] staff) {
        this.courseCode=code;
        this.courseName=name;
        this.index = index;
        this.capacity=capacity;
        this.vacancy = vacancy;
        this.school = school;
        this.waitingListIDs = waitingListIDs;
        this.timeTable = timeTable;
        this.staff = staff;
    }
    /**
    * Get course code
    * @return String code
    */
    public String getCourseCode(){
        return this.courseCode;
    }
    public void setCode(String code){
        this.courseCode = code;
    }
    /**
    * Get course code
    * @return String code
    */
    public String getCourseName(){
        return this.courseName;
    }
    /**
    * Set Course name
    * @param String name
    */
    public void setCourseName(String name){
        this.courseName = name;
    }
    /**
    * Get Index
    * @return int Index
    */
    public int getIndex(){
        return this.index;
    }
    /**
    * Set Index
    * @param int Index
    */
    public void setIndex(int index){
        this.index = index;
    }
    /**
    * Get capacity
    * @return int capacity
    */
    public int getCapacity(){
        return this.capacity;
    }
    /**
    * Get vacancy
    * @return int vacancy
    */
    public int getVacancy(){
        return this.vacancy;
    }
    /**
    * Set Course vacancy
    * @param int amount
    */
    public void setVacancy(int amount){
        this.vacancy = amount;
    }
    /**
    * Get course school
    * @return String school
    */
    public String getSchool(){
        return this.school;
    }
    /**
    * Set Course school
    * @param String school
    */
    public void setSchool(String school){
        this.school = school;
    }
    /**
    * Get course staff
    * @param int array index
    * @return String staff ID
    */
    public String getStaff(int indx){
        return this.staff[indx];
    }
    /**
    * Set Course staff
    * @param String[] ID
    */
    public void setStaff(String[] staff){
        this.staff = staff;
    }
    /**
    * Set Course capacity. 
    * @param int new capacity
    * @return ArrayList<Integer> Returns list on student ID's that will be registed to course
    *                            else null.
    */
    public ArrayList<Integer> setCapacity(int amount){
        ArrayList<Integer> IDs= new ArrayList<Integer>();
        if(amount < capacity && waitingListIDs.size() != 0)
            return null;
        if(waitingListIDs.size() != 0){
            for(int i = 0; i < (amount - capacity);i++){
                IDs.add(waitingListIDs.get(0));
                waitingListIDs.remove(0);
            }
        }
        this.capacity = amount;
        return IDs;

    }
    /**
    * Set Course vacancy by one
    */
    public void reduceVacancy(){
        this.vacancy -= 1;
    }
    /**
    * Increases courses vacancy and return student's ID if he/she can be registered to course
    * @return Integer name
    */
    public Integer increaseVacancy(){
        this.vacancy += 1;
        if(waitingListIDs.size() != 0){
            Integer removedWaitlist = waitingListIDs.get(0);
            waitingListIDs.remove(0);
            return removedWaitlist;
        }
        // No students in the waiting list
        return 0;
    }
    /**
    * Get course timetable
    * @return String[] timetable
    */
    public String[] getTimeTable(){
        return this.timeTable;
    }
    /**
    * Set Course timetable
    * @param String[] timetable
    */
    public void setTimetable(String[] timetable){
        this.timeTable = timetable;
    }
    /**
    * Get course watinglist
    * @return ArrayList<Integer>
    */
    public ArrayList<Integer> getWaitingList(){
        return this.waitingListIDs;
    }
    /**
    * Add student's ID to waitinglist
    * @param ind ID
    */
    public void addToWaitList(int ID){
        this.waitingListIDs.add(ID);
    }
    /**
    * Print course info
    */
    public void printInfo(){
        System.out.print("Name: " + this.courseName + " ");
        System.out.print("Index: " + this.index + " ");
        System.out.print("Vacancy: " + this.vacancy + " ");
        System.out.print("Capacity: " + this.capacity + " ");
        System.out.print(" :: ");
        for(String string:timeTable){
            System.out.print(" " + string + " ");
        }
        System.out.println("");
    }
    /**
    * Print timetable
    */
    public void printTimeTable(){
        System.out.println(this.index);
        int counter = 0;
        for(String string:timeTable){
            System.out.print(" " + string);
            if(counter == 3)
                System.out.println("");
            counter +=1;
        }
        System.out.println("");
    }

}
    