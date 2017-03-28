import java.util.ArrayList;
import java.util.List;
public class Index{
	/**
	* Index number for course
	*/
	protected int indexNum;
	/**
	* Number of vacancies left 
	*/
	protected int vacancy;
	/**
	* Course that index is tight to
	*/
	//protected Course course; // I think we don't need this because we can find corresponding course from course list
	/**
	* Student's in this index
	*/
	protected ArrayList<Integer> studentIDs = new ArrayList<Integer>();
	/**
	* Waitlist of students 
	*/
	protected ArrayList<Integer> waitingListIDs = new ArrayList<Integer>();

	//protected String[] timeTable = new String[8]; //(type, venue, weekday, time)
	protected ArrayList<String[]> timeTable = new ArrayList<String[]>();
	//List<List<String>> timeTable = new ArrayList<List<String>>();
	//protected String[][] timeTable = new String[2][4];
	/**
	* Constuctor for Index class
	*/
	public Index(int indexNum, int capacity  ){// String[] timeTable
		this.indexNum = indexNum;
		//this.course = course;
		this.vacancy = capacity;
		//this.timeTable.add(timeTable);
	}
	public void setIndex(int to){
		this.indexNum = to;
	}
	public int getIndex(){
		return this.indexNum;
	}
	public int getVacancy(){
		return this.vacancy;
	}
	public void addTimeTable(String[] timeTable){
		this.timeTable.add(timeTable);
	}
	public ArrayList<String[]> getTimeTable(){
		return this.timeTable;
	}

	  public void addLab (int day, int start, int stop, String venue) {
    // add something
    System.out.println("You have now added the lab.");
    }
    public void addTutorial (int day, int start, int stop, String venue, int index) {
    // add something
    System.out.println("You have now added the tutorial for index number " + index);
    }

}

