import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddRecipient extends JPanel {
	
	JFrame frame = new JFrame();
	
	public AddRecipient() { // frame to add recipient
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 824, 345);
		frame.setVisible(true);
		JPanel contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtrAddRecipient = new JLabel(); // labels and textfields for all properties
		txtrAddRecipient.setBounds(337, 34, 109, 22);
		txtrAddRecipient.setText("Add Recipient");
		contentPane.add(txtrAddRecipient);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(251, 70, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(251, 107, 137, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Blood Type");
		lblNewLabel_2.setBounds(251, 145, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Priority (1-5) 1 being highest");
		lblNewLabel_3.setBounds(251, 181, 137, 14);
		contentPane.add(lblNewLabel_3);
		
		JTextField textField = new JTextField();
		textField.setBounds(398, 67, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(398, 104, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(398, 142, 115, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textField_3.setBounds(398, 178, 115, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(251, 250, 262, 33);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Submit"); // submit button
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // action event to add recipient when button clicked
				if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() || textField_2.getText().trim().isEmpty() || textField_3.getText().trim().isEmpty()) {
					lblNewLabel_4.setText("Field(s) are Empty"); // input validation for empty fields
				}
				else {
				int prior = Integer.parseInt(textField_3.getText());
				if(prior > 5 || prior < 1) { // input validation for priority
					lblNewLabel_4.setText("Priority has to be between 1 - 5");
				}
				else {	// if input is correct
				String fname = textField.getText();
				String lname = textField_1.getText();
				String blood = textField_2.getText(); // set strings from the text fields
				MainFrame.addRecipient(fname, lname, blood, prior); // pass them to the add recipient method
				frame.setVisible(false); // close frame
				}

				}
			}
		});
		btnNewButton.setBounds(273, 216, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit"); // exit button
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(398, 216, 89, 23);
		contentPane.add(btnNewButton_1);
		

		
		
	}
}
