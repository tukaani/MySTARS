import java.util.Scanner;

public class MyStarsApp{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome to login! 1. Student or 2. admin? Write 3 to quit");
		int ch = sc.nextInt();

		if(ch== 1){
			StudentApp studentApp = new StudentApp();
			studentApp.start();
		}
		else if(ch == 2){
		
		}
		else{
			System.out.println("Good bye!");
			return;
		}
	}
}