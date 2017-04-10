import java.util.ArrayList;
import java.io.IOException;
/**
 Holds list of Staff objects
 @version 1.0
 @since 2017-04-10
*/
public class StaffList {

	/**
	 * Creating the list. Use ArrayList as this can be extended
	 */
	protected ArrayList<Staff> staff = new ArrayList<Staff>();
	/**
	 * Staff list's constructor.
	 */
	public StaffList(){
		try{
			this.staff = FileIO.readStaff();
			}
		catch(IOException e){
			System.out.println("Error in FileIO: " + e);
		}
	}
	/**
	 * Returns Staff list
	 * @return ArrayList<Staff>
	 */
	public ArrayList<Staff> getStaff(){
		return this.staff;
	}
	/**
	 * Find staff by ID
	 * @param int ID staffs id
	 * @return Staff object
	 */
	public Staff findStaffByID(int ID){
		for(Staff s : staff){
			if(s.getID() == ID)
				return s;
		}
		return null;
	}
}
