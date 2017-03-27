public class Course {

    protected string courseCode;
    protected int capacity;
    protected int vacancies;
    protected string courseName;
    protected studentList[] students;
    protected string school;
    protected int[] indexnumber;
    
    public Course(string code, string name, int capacity) {
    courseCode=code;
    courseName=name;
    capacity=capacity;
    vacancies=0;
    }
    public void setIndexNumber(int[] index){
    indexnumber=index;
    }
    public void addLecture (int day, int start, int stop, string venue) {
    \\ add something
    System.out.println("You have now added the lecture.");
    }
    public void addLab (int day, int start, int stop, string venue) {
    \\ add something
    System.out.println("You have now added the lab.");
    }
    public void addTutorial (int day, int start, int stop, string venue, int index) {
    \\ add something
    System.out.println("You have now added the tutorial for index number " + index);
    }
    public int getVacancies(){
    return vacancies;
    }
