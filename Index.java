public class Index{
	/**
	* Index number for course
	*/
	protected int indexNum;
	/**
	* Total number vacancies
	*/
	protected int capacity;
	/**
	* Number of vacancies left 
	*/
	protected int vacancy;
	/**
	* Course that index is tight to
	*/
	protected Course course;
	/**
	* Student's in this index
	*/
	protected ArrayList<Integer> studentIDs = new ArrayList<Integer>();
	/**
	* Waitlist of students 
	*/
	protected ArrayList<Integer> waitingListIDs = new ArrayList<Integer>();

	
	//(venue : weekday, time(example 9)), (venue1: weekday, time)
	//ADD TIMETABLE
	/**
	* Constuctor for Index class
	*/
	public Index(int indexNum, int capacity, Course course){
		self.indexNum = indexNum;
		self.course = course;
		self.capacity = capacity;
		self.vacancy = capacity;
	}
	public void setIndex(int to){
		self.indexNum = to;
	}

	  public void addLab (int day, int start, int stop, String venue) {
    \\ add something
    System.out.println("You have now added the lab.");
    }
    public void addTutorial (int day, int start, int stop, String venue, int index) {
    \\ add something
    System.out.println("You have now added the tutorial for index number " + index);
    }

}

