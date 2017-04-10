import java.util.Scanner;

/**
 The main app for MySTARS
 @version 1.0
 @since 2017-04-10
*/
public class MyStarsApp{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("Welcome to login! 1. Student or 2. admin? Write 3 to quit ");
			int ch = sc.nextInt();
			if(ch== 1){
				StudentApp studentApp = new StudentApp();
				studentApp.loginStudent();
			}
			else if(ch == 2){
				StaffApp staffApp = new StaffApp();
				staffApp.loginStaff();
			}
			else{
				System.out.println("Good bye!");
				return;
			}
		}
	}
	
}