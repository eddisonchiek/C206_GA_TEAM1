import java.util.ArrayList;

public class RegistrationAccount {
	
	private int registrationId;
	private String studentId;
	
	private ArrayList<String> registeredCCAs;
	private ArrayList<String> status;

	public RegistrationAccount (int registrationId, String studentId) {
		

		this.registrationId = registrationId;
		this.studentId = studentId;
		registeredCCAs = new ArrayList<String>();
		status = new ArrayList<String>();
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void addRegisteredCCAs(String addCCA) {
		registeredCCAs.add(addCCA);
		status.add("Pending");
	}
	
	public String getRegisteredCCAsAndStatus() {
		String msg = "";

		for (int i = 0; i < registeredCCAs.size(); i++) {
			msg += registeredCCAs.get(i) + " [" + status.get(i) + "] \n";
		}
		return msg;
	}

	@Override
	public String toString() {
		return "RegistrationAccount [registrationId=" + registrationId + ", studentId=" + studentId
				+ ", registeredCCAs=" + registeredCCAs + ", status=" + status + "]";
	}
	
}
