import java.util.Scanner;

public class BookOrder extends AVLTree{
	static AVLTree tree = new AVLTree();
	static boolean running = true;
	static Scanner scan = new Scanner(System.in);
	static int nodes;
	
	//function that prints out commands//
	public static void start() {
		System.out.println("Welcome to the book ordering system please input a command:");
		System.out.println("1: add");
		System.out.println("2: remove");
		System.out.println("3: print");
		System.out.println("4: find");
		System.out.println("5: oldest/latest");
		System.out.println("6: exit");
	}
	
	public static void add() {
		System.out.println("Please input the orderID");
		if (scan.hasNextInt()) {
			int input = scan.nextInt();
			System.out.println("Please input the book name");
			scan.nextLine();
			String name = scan.nextLine();
			tree.addOrder(input, name);
			nodes = tree.getNodes();
			System.out.println("Order sucessfully added!");
			System.out.println("Total nodes: " + nodes);
		}
		else {
			System.out.println("Please input a valid orderID");
		}
	}
	
	public static void remove() {
		System.out.println("Please input the orderID");
		if (scan.hasNextInt()) {
			int input = scan.nextInt();
			tree.removeOrder(input);
			if (nodes == tree.getNodes()) {
				System.out.println("Order not found");
			}
			else {
				nodes = tree.getNodes();
				System.out.println("Order sucessfully removed!");
				System.out.println("Total nodes: " + nodes);
			}
		}
		else {
			System.out.println("Please input a valid orderID");
		}
	}
	
	public static void search() {
		System.out.println("Please input the orderID of the book you want to find");
		if (scan.hasNextInt()) {
			int input = scan.nextInt();
			String title = tree.findOrder(input);
			if (title != null) {
				System.out.println("Order found : " + title);
				System.out.println("Total nodes: " + nodes);
			}
			else {
				System.out.println("Order not found");
			}
		}
	}
	
	public static void main(String argsp[]) {
		while(running == true) {
			start();
			if (scan.hasNextInt()) {					//checks if user inputs an integer*/
				int input = scan.nextInt();				//sets the int to a variable and checks if the int is valid
				if (input == 1) {
					add();
				}
				else if (input == 2) {
					remove();
				}
				else if (input == 3) {
					tree.printTree();
				}
				else if (input == 4) {
					search();
					}
				else if (input == 5) {
					System.out.println("In order from newest to oldest: ");
					tree.findOldest();	
					System.out.println("Total nodes: " + nodes);
				}
				else if(input == 6) {
					running = false;
				}
				else {
					System.out.println("Please input a valid number 1-4 or command");
				}
				}
			else if (scan.hasNextLine()) {				//same thing as before but with strings
				String input = scan.nextLine();
				if (input.equals("add")) {
					add();
				}
				else if (input.equals("remove")) {
					remove();
				}
				else if(input.equals("print")) {
					tree.printTree();
				}
				else if(input.equals("find")) {
					search();
				}
				else if (input.equals("oldest")) {
					System.out.println("In order from newest to oldest: ");
					tree.findOldest();	
					System.out.println("Total nodes: " + nodes);
				}
				else if (input.equals("latest")) {
					System.out.println("In order from newest to oldest: ");
					tree.findOldest();	
					System.out.println("Total nodes: " + nodes);
				}
				else if(input.equals("exit")) {
					running = false;
				}
				else {
					System.out.println("Please input a valid number 1-4 or command");
				}
			}
				}
			}
			
		}