/**
 * @author zakgl - zglawless
 * CIS152 - Fall 2022
 * Nov 27, 2022
 */

/**
 * @author zakgl
 *
 */
public class Recipient implements Comparable <Recipient>{
	private String firstName;
	private String lastName;
	private String bloodType;
	private int priority;
	private int id;
	
	
	
	public Recipient() {
		
	}
	
	public boolean equals(Recipient r) {
		return this.getPriority() == r.getPriority();
	}
	
	public int compareTo(Recipient r) {
		if(this.equals(r)) {
			return 0;
		} 
		else if (getPriority() > r.getPriority()) {
			return 1;
		} else return -1;
	}
	
	
	public Recipient(String firstName, String lastName, String bloodType, int priority, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bloodType = bloodType;
		this.priority = priority;
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "First Name: " + firstName + " Last Name: " + lastName + " Blood Type: " + bloodType
				+ " Priority: " + priority + " ID: " + id;
	}
	
	
	
	
}
