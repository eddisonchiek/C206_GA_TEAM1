import java.util.ArrayList;
import java.util.Random;


public class C206_CaseStudy {

	public static void main(String[] args) {
		
//---------------------------------------- Initialise Arraylist ----------------------------------------//
		//User Arraylists
		ArrayList<Users> adminList = new ArrayList<>();
		ArrayList<RegistrationAccount> studentRegisterAccList = new ArrayList<>();

		//Student Database
		ArrayList<Students> studentsList = new ArrayList<>();
		
		//CCA Arraylists
		ArrayList<CCA> ccaList = new ArrayList<>();
		
//---------------------------------------- Populate Arraylist ----------------------------------------//
		
		//CCA Admin
		//Parameters: String name, String password
		adminList.add(new Users("admin", "admin"));
		
		//Students Database
		//String studentname, String address, String grade, String class_code, String class_teacher,
		//String parentName, String parentEmail, int parentContact
		studentsList.add(new Students("Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));
		studentsList.add(new Students("Marcus", "Orchard Road 765432", "P3", "P3-100", "Amran Mohamed", "Lucious", "21040247@myrp.edu.sg", 12345678));

		//CCAs
		//String category, String title, String description, int vacancyOpen, int vacancyTaken, 
		//String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor)
		ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Basketball", "Bounce ball", 10, 2, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
		ccaList.add(new CCA("Culinary", "Baking", "Make cake", 20, 5, "Thursday", 15.00, 18.00, "Kitchen", "Mr Amran"));
		ccaList.add(new CCA("Business", "Investment", "Buy Stocks", 20, 8, "Thursday, Friday", 15.00, 18.00, "W65D", "Mr Amran"));

//---------------------------------------- 1. Main Program ----------------------------------------//

//---------------------------------------- 1A. Login ----------------------------------------//
		boolean loggedin = false;
		int option = 0;
		int optionTask = 0;
		System.out.println(studentsList);

			while (loggedin == false) {

			//Login Menu	
			C206_CaseStudy.loginregistermenu();
			option = Helper.readInt("Choose option > ");
			
			//Admin
			if (option == 1) {
				if (loginAdmin(adminList) == true){						
					loggedin = true;
					
					while (optionTask != 5) {
						C206_CaseStudy.menu("CCA Admin");
						optionTask = Helper.readInt("Choose option > ");
					
						//1. upload cca
						if (optionTask == 1) {
							C206_CaseStudy.addCCA(ccaList);
						//2. delete cca	
						} else if (optionTask == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
						//3. update cca
						//4. view cca
						} else if (optionTask == 4) {
							C206_CaseStudy.viewCCAs(ccaList);	
						//5. log out
						} else if (optionTask == 5) {
							loggedin = false; 
						}
					
					}
				}		
			}
			
			if (option == 2) {
				if (registerStudent(studentsList, studentRegisterAccList) == true){	
					C206_CaseStudy.setHeader("Register successful");
					System.out.println(studentRegisterAccList);
				}		
			
			if (option == 3) {
				if (registerStudent(studentsList, studentRegisterAccList) == true){	
					C206_CaseStudy.setHeader("Register successful");
					System.out.println(studentRegisterAccList);
				}		
			}
			
			
//---------------------------------------- 1B. Task ----------------------------------------//			
	}
			}
	}
			
	
//---------------------------------------- 2. Methods ----------------------------------------//

	//Header
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Menu Login
	public static void loginregistermenu() {
		C206_CaseStudy.setHeader("Login/Register");
		
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Student");
		System.out.println("3. Register");
		System.out.println("4. Close");
		Helper.line(80, "-");
	}
	
	//User Menu
	public static void menu(String role) {
		C206_CaseStudy.setHeader("Menu");
		//Admin
		if (role.equals("CCA Admin")) {
			System.out.println("1. Add CCA");
			System.out.println("2. Delete CCA");
			System.out.println("3. Update CCA");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		//Parent
		} else if (role.equals("Student")) {
			System.out.println("1. Register for CCA");
			System.out.println("2. Delete registration for CCA");
			System.out.println("3. View registered for CCA");
			System.out.println("4. View CCAs");
			System.out.println("5. Log out");
			Helper.line(80, "-");
		} 	
	}
	
//---------------------------------------- 2A. Admin ----------------------------------------//

	//login
	public static boolean loginAdmin(ArrayList<Users> adminAL) {
		boolean loggedin = false;
		String name = Helper.readString("Enter name > ");
		String password = Helper.readString("Enter password > ");
		
		for (int i = 0; i < adminAL.size(); i++) {
			if (adminAL.get(i).getName().equals(name) && adminAL.get(i).getPassword().equals(password)) {
				loggedin = true;
				C206_CaseStudy.setHeader("Login successful");
			} else {
				C206_CaseStudy.setHeader("Login unsuccessful");
			}
		}
		return loggedin;
	}
	
	//add cca
	public static void addCCA(ArrayList<CCA> ccalist) {
		String category = Helper.readString("Enter category > ");
		String title = Helper.readString("Enter cca title > ");
		String description = Helper.readString("Enter description > ");
		int vacancy = Helper.readInt("Enter no. of vacancy for cca > ");
		int vacancyTaken = Helper.readInt("Enter no. of taken vacancy for cca > ");
		String dayOfWeek = Helper.readString("Enter cca day(s) of week > ");
		double timeStart = Helper.readDouble("Enter cca start time > ");
		double timeEnd = Helper.readDouble("Enter cca end time > ");
		String venue = Helper.readString("Enter venue > ");
		String instructor = Helper.readString("Enter instructor in charge > ");
		
		if (ccalist.add(new CCA(category, title, description, vacancy, vacancyTaken, dayOfWeek, timeStart, timeEnd, venue, instructor))) {
			C206_CaseStudy.setHeader("Add CCA successful");
		} else {
			C206_CaseStudy.setHeader("Add CCA unsuccessful");
		}
	}
	
	//delete cca
	public static void deleteCCA(ArrayList<CCA> ccalist) {
		int ccaid = Helper.readInt("Enter CCA id > ");
		
		for (int i = 0; i < ccalist.size(); i++) {
			
			CCA current = ccalist.get(i);
			
			if (ccalist.get(i).getId() == ccaid) {
				if (ccalist.remove(i) == current) {
					C206_CaseStudy.setHeader("Delete CCA Successful");
				} else {
					C206_CaseStudy.setHeader("Delete CCA unsuccessful");
				}
			}
		}
	}
	
	//view cca
//	public static void viewCCA(ArrayList<CCA> ccalist) {
//		int ccaid = Helper.readInt("Enter CCA id > ");
//		
//		for (int i = 0; i < ccalist.size(); i++) {
//			if (ccalist.get(i).getId() == ccaid) {
//				ccalist.get(i).toString();
//				}
//			}
//		}
//	}
	
	//view ccas
	public static void viewCCAs(ArrayList<CCA> ccalist) {	
		String output = "";
		for (int i = 0; i < ccalist.size(); i++) {
			output += ccalist.get(i).toString();
		}
		
		C206_CaseStudy.setHeader("CCA List");
		String headers = String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 
				"ID", "Category", "Name", "Description","Vacancy", "Days", "Time Start", "Time End", "Venue", "Teacher-in-charge");
		
		System.out.println(headers+output);
	}
	
	
//---------------------------------------- 2B. Student ----------------------------------------//

	//information such as the student ID, name, grade and class, classroom teacher, parent’s name, 
	//parent’s email address, contact No. etc.
	
	//register student
	public static boolean registerStudent(ArrayList<Students> studentlist, ArrayList<RegistrationAccount> reglist) {
		boolean registered = false;
		
		String name = Helper.readString("Enter your name > ");
		String email = Helper.readString("Enter your email > ");
		int number = Helper.readInt("Enter your contact number > ");
		String address = Helper.readString("Enter your address > ");
		
		String studentid = Helper.readString("Enter your child's student ID > ");
		String studentname = Helper.readString("Enter your child's name > ");
		String grade = Helper.readString("Enter your child's grade > ");
		String classcode = Helper.readString("Enter your child's class > ");
		String classroomteacher = Helper.readString("Enter classroom teacher > ");
		
//		ArrayList<Students> validationList = new ArrayList<>();
		
		//see studentList, enter same inputs.
//		validationList.add(new Students(studentname, null, address, grade, classcode, classroomteacher, name, email, number));

		

		for (int i = 0; i < studentlist.size(); i++) {
			if (studentlist.get(i).getParentName().equals(name) &&
				studentlist.get(i).getParentEmail().equals(email) &&
				number == studentlist.get(i).getParentContact() &&
				studentlist.get(i).getAddress().equals(address) &&
				studentlist.get(i).getId().equals(studentid) &&
				studentlist.get(i).getStudentname().equals(studentname) &&
				studentlist.get(i).getGrade().equals(grade) &&
				studentlist.get(i).getClass_code().equals(classcode) &&
				studentlist.get(i).getClass_teacher().equals(classroomteacher)) {
				
			     Random ran = new Random();
			     int upperBound = 10;
			     int regID = ran.nextInt(upperBound);
			     reglist.add(new RegistrationAccount(regID, studentid));
			     registered = true;
			}
		}
				return registered;	
}
	
	//login
	public static boolean loginStudent(ArrayList<RegistrationAccount> studentlist) {
		boolean loggedin = false;
		
		String studentid = Helper.readString("Enter student id > ");
		int regid = Helper.readInt("Enter registration id > ");
		
		for (int i = 0; i < studentlist.size(); i++) {
			if (studentlist.get(i).getStudentId().equals(studentid) && regid == studentlist.get(i).getRegistrationId()) {
				loggedin = true;
				C206_CaseStudy.setHeader("Login successful");
			} else {
				C206_CaseStudy.setHeader("Login unsuccessful");
			}
		}
		return loggedin;
	}
  	        
	    
//	    for (int i = 0; i < studentlist.size(); i++) {
//	    	if (studentlist.get(i).getId().equals(studentid)) {
//	    		if (studentlist.equals(validationList)) {
//	    			generateRegistrationID(studentlist);
//		    	}
//	    	}
//	    
//	    }
//	    
//		return registered;
//		
//
//		}
	
	
	}
	

	
