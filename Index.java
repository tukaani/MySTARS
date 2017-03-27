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
	protected Student[] students;
	/**
	* Waitlist of students 
	*/
	protected Student[] waitingList;

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

}

