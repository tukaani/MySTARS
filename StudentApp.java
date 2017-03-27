import java.util.Scanner;
import java.util.ArrayList;

public class StudentApp{

	public void start(){
		Scanner sc = new Scanner(System.in);
		FileIO.loadStudents(); //Also assuming that FileIO.students ArrayList is not destreyd when this function exits
		int ch = 0;
		do{
			
			ch = sc.nextInt();
			System.out.println(FileIO.students.get(0).getName());
			switch(ch){
				case(1):
					break;
				case(2):
					break;
			}

		}while(ch < 7);
		
	}
	public void printMenu(){
		
		System.out.println("Choose from options below");
	}
}