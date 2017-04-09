import java.util.ArrayList;
import java.io.IOException;
public class StaffList {

	/*
	 * Creating the list. Use ArrayList as this can be extended
	 */
	protected ArrayList<Staff> staff = new ArrayList<Staff>();
	/*
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
	public ArrayList<Staff> getStaff(){
		return this.staff;
	}
}
