/**
 * @author zakgl - zglawless
 * CIS152 - Fall 2022
 * Nov 27, 2022
 */
import java.util.*;
public class PriorityDonor {
	/*
	public static int id = 1;

	public static void main(String[] args) {
		PriorityQueue<Recipient> recipientQueue = new PriorityQueue<Recipient>();
		LinkedList<Recipient> recipientHistory = new LinkedList<Recipient>();
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to Zak's Liver Recipient List Please select one of the following");
			System.out.println("1: Add a recipient.");
			System.out.println("2: View the priority list");
			System.out.println("3: Take out a recipient who has recieved an liver");
			System.out.println("4: View the recipient history list");
			System.out.println("5: Exit");
			
			int option = input.nextInt();
			
			if (option == 1) {
				Recipient temp = new Recipient();
				
				System.out.println("Please enter the recipients first name");
				temp.setFirstName(input.next());
				System.out.println("Please enter the recipients last name");
				temp.setLastName(input.next());
				System.out.println("Please enter the recipients blood type");
				temp.setBloodType(input.next());
				System.out.println("Please enter the recipients priority (1 being the highest 5 being the lowest)");
				temp.setPriority(Integer.parseInt(input.next()));
				temp.setId(id);
				id++;
				
				recipientQueue.add(temp);
			}
			
			if(option == 2) {
				PriorityQueue<Recipient> temp = new PriorityQueue<Recipient>();
				temp = recipientQueue;
				int count = 1;
				while(!temp.isEmpty()) {
					System.out.println("Recipient #" + count + " " + temp.remove());
					count ++;
				}
			}
			
			if(option == 3) {
				Recipient temp = new Recipient();
				temp = recipientQueue.remove();
				recipientHistory.add(temp);
				System.out.println("Recipient " + temp + " has been removed from the queue and added to the history list");
			}
			
			if(option == 4) {
				System.out.println(recipientHistory);
			}
			
			else {
				input.close();
				System.out.println("GoodBye!");
				break;
			}
		}

	}
	*/

}
