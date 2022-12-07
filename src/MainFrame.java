import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.awt.event.ActionEvent;
/**
 * @author zakgl - zglawless
 * CIS152 - Fall 2022
 * Dec 7, 2022
 */
public class MainFrame {

	private JFrame frame; // main frame
	private static PriorityQueue<Recipient> recipientQueue = new PriorityQueue<Recipient>(); // Priority Queue
	private static LinkedList<Recipient> recipientHistory = new LinkedList<Recipient>(); // History List
	private static int id = 1; // Used to create ids for recipients

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // main program
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	public static void addRecipient(String fname, String lname, String bloodType, int prior) { // method to add recipient
		Recipient temp = new Recipient(); // create object from class
		temp.setFirstName(fname);
		temp.setLastName(lname);
		temp.setBloodType(bloodType);
		temp.setPriority(prior);
		temp.setId(id); // set all values
		id++; // increment id

		recipientQueue.add(temp); // add the recipient to the priority queue
	}

	public static void displayQueue() { // method to display the queue
		JFrame viewQ = new JFrame("Recipient Queue");
		viewQ.getContentPane().add(new JList(recipientQueue.toArray())); // create a Jlist object from the queue and add to the new frame
		viewQ.pack();
		viewQ.setLocationRelativeTo(null);
		viewQ.setBounds(100, 100, 828, 355); // set bounds
		viewQ.setVisible(true); // set visibility to true

	}

	public static void displayHistory() { // same thing as display queue but with history list instead
		JFrame viewList = new JFrame("Recipient History");
		viewList.getContentPane().add(new JList(recipientHistory.toArray()));
		viewList.pack();
		viewList.setLocationRelativeTo(null);
		viewList.setBounds(100, 100, 828, 355);
		viewList.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); // frame creation
		frame.setBounds(100, 100, 828, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel txtrWelcomeToZaks = new JLabel(); // Label for title
		txtrWelcomeToZaks.setText("Welcome to Zak's Liver Recipient List Please select one of the following");
		txtrWelcomeToZaks.setBounds(187, 11, 420, 53);
		frame.getContentPane().add(txtrWelcomeToZaks);

		JButton btnNewButton = new JButton("Add recipient"); // button to add recipient
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRecipient add = new AddRecipient(); // action event when button clicked take them to the add recipient frame
				add.setVisible(true);
			}
		});
		btnNewButton.setBounds(301, 99, 181, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View Recipient Queue"); // view queue button
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recipientQueue.isEmpty()) { // if queue is empty a popup comes up stating the queue is empty
					JFrame viewQ = new JFrame("Recipient Queue");
					JLabel empty = new JLabel("Queue is Empty");
					viewQ.setLocationRelativeTo(null);
					viewQ.setSize(100, 100);
					viewQ.getContentPane().add(empty);
					viewQ.setVisible(true);
				} else { // if not display the queue using method
					displayQueue();
				}
			}
		});
		btnNewButton_1.setBounds(301, 133, 181, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Take out recipient"); // button to remove recipient from queue
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recipientQueue.isEmpty()) { // if queue is empty popup comes up
					JFrame viewQ = new JFrame("Recipient Queue");
					JLabel empty = new JLabel("Queue is Empty");
					viewQ.setLocationRelativeTo(null);
					viewQ.setSize(100, 100);
					viewQ.getContentPane().add(empty);
					viewQ.setVisible(true);
				} else {
					Recipient temp = new Recipient(); // if not create a temp recipient object
					temp = recipientQueue.remove(); // make it equal to the object being removed from the queue
					recipientHistory.add(temp); // add it to the history list

					JFrame remove = new JFrame("Removed"); // popup displaying the object has been successfully removed
					JLabel text = new JLabel("Recipient has been removed and placed in history list");
					remove.getContentPane().add(text);
					remove.pack();
					remove.setLocationRelativeTo(null);
					remove.setSize(350, 80);
					remove.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(301, 167, 181, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("View recipient history list"); // button to view the history list
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recipientHistory.isEmpty()) { // if empty popup comes up
					JFrame viewList = new JFrame();
					JLabel empty = new JLabel("History List is Empty");
					viewList.setLocationRelativeTo(null);
					viewList.setSize(140, 100);
					viewList.getContentPane().add(empty);
					viewList.setVisible(true);
				} else {
					displayHistory(); // if not display the list with the method
				}
			}
		});

		btnNewButton_3.setBounds(301, 201, 181, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Exit"); // exit button
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exits program
			}
		});
		btnNewButton_4.setBounds(301, 235, 181, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}
