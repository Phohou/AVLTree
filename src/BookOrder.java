import java.util.Scanner;

public class BookOrder extends AVLTree{
	static AVLTree tree = new AVLTree();
	static boolean running = true;
	static Scanner scan = new Scanner(System.in);
	
	//function that prints out commands//
	public static void start() {
		System.out.println("Welcome to the book ordering system please input a command:");
		System.out.println("1: add");
		System.out.println("2: remove");
		System.out.println("3: print");
		System.out.println("4: find");
	}
	
	public static void main(String argsp[]) {
		while(running == true) {
			start();
			if (scan.hasNextInt()) {					//checks if user inputs an integer*/
				int input = scan.nextInt();				//sets the int to a variable and checks if the int is valid
				if (input == 1) {
					System.out.println("add");
				}
				if (input == 2) {
					System.out.println("remove");
				}
				if (input == 3) {
					System.out.println("print");
				}
				if (input == 4) {
					System.out.println("find");
					}
				else {
					System.out.println("Please input a valid number 1-4 or command");  //figure out why this keeps running 
				}
				}
			else if (scan.hasNextLine()) {				//same thing as before but with strings
				String input = scan.nextLine();
				if (input.equals("add")) {
					System.out.println("add");
				}
				if (input.equals("remove")) {
					System.out.println("remove");
				}
				if(input.equals("print")) {
					System.out.println("print");
				}
				if(input.equals("find")) {
					System.out.println("find");
				}
				else {
					System.out.println("Please input a valid number 1-4 or command");
				}
			}

				}
			}
			
		}