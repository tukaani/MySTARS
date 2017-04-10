import java.util.ArrayList;

public class Course {

    protected String courseCode;
    protected String courseName;
    protected int index;
    protected int capacity; 
    protected int vacancy;
    protected String school;
   
    /**
    * Waitlist of students 
    */
    protected ArrayList<Integer> waitingListIDs = new ArrayList<Integer>();

    //(type, venue, weekday, time)
    protected String[] timeTable = new String[8];
    
    protected String[] staff = new String[2];

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
    public String getCourseCode(){
        return this.courseCode;
    }
    public void setCode(String code){
        this.courseCode = code;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }

    public int getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getVacancy(){
        return this.vacancy;
    }
    public void setVacancy(int amount){
        this.vacancy = amount;
    }
    public String getSchool(){
        return this.school;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public String getStaff(int indx){
        return this.staff[indx];
    }
    public void setStaff(String[] staff){
        this.staff = staff;
    }
    
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
    public void reduceVacancy(){
        this.vacancy -= 1;
    }
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
    public String[] getTimeTable(){
        return this.timeTable;
    }
    public void setTimetable(String[] timetable){
        this.timeTable = timetable;
    }
    public ArrayList<Integer> getWaitingList(){
        return this.waitingListIDs;
    }
    public void addToWaitList(int ID){
        this.waitingListIDs.add(ID);
    }
    
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
    