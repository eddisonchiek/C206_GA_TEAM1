	import java.util.ArrayList;
	import java.util.Random;
	
	
	public class C206_CaseStudy {
	
		public static void main(String[] args) {
			
	
			ArrayList<Users> adminList = new ArrayList<>();
			ArrayList<RegistrationAccount> studentRegisterAccList = new ArrayList<>();
	
		
			ArrayList<Students> studentsList = new ArrayList<>();
			
	
			ArrayList<CCA> ccaList = new ArrayList<>();
	
			adminList.add(new Users("admin", "admin"));
			
	
			studentsList.add(new Students("suhaify", "sesame street 123", "P4", "P410", "Amran Mohamed", "eddison", "21034014@myrp.edu.sg", 12345678));
			studentsList.add(new Students("qianyi", "sesame street 321", "P3", "P311", "Amran Mohamed", "marianne", "21034014@myrp.edu.sg", 12345678));
	
			ccaList.add(new CCA("Sports", "Football", "Kick ball", 10, 1, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
			ccaList.add(new CCA("Sports", "Volleyball", "Smack ball", 10, 0, "Friday", 15.00, 18.00, "Field", "Mr Amran"));
			ccaList.add(new CCA("Culinary", "Baking", "Cup Cakes", 20, 5, "Monday", 15.00, 18.00, "Kitchen", "Mr Amran"));
	
	
	
			boolean loggedin = false;
			int option = 0;
			int optionTask = 0;
			System.out.println(studentsList);
	
				while (loggedin == false) {
	
				C206_CaseStudy.loginregistermenu();
				option = Helper.readInt("Choose option > ");
				
		
				if (option == 1) {
					if (loginAdmin(adminList) == true){						
						loggedin = true;
						
						while (optionTask != 5) {
							C206_CaseStudy.menu("CCA Admin");
							optionTask = Helper.readInt("Choose option > ");
					
							if (optionTask == 1) {
								C206_CaseStudy.addCCA(ccaList);
					
							} else if (optionTask == 2) {
								C206_CaseStudy.deleteCCA(ccaList);
							
							} else if (optionTask == 4) {
								C206_CaseStudy.viewCCAs(ccaList);	
							
							} else if (optionTask == 5) {
								loggedin = false; 
							}
						
						}
					}		
				}
				
				if (option == 2) {
					if (loginStudent(studentRegisterAccList) == true){	
						C206_CaseStudy.setHeader("Register successful");
						System.out.println(studentRegisterAccList);
					}		
				
				if (option == 3) {
					if (registerStudent(studentsList, studentRegisterAccList) == true){	
						C206_CaseStudy.setHeader("Register successful");
						System.out.println(studentRegisterAccList);
					}		
				}
				
				
			
		}
				}
		}
				
	
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
		}
		
	
		public static void loginregistermenu() {
			C206_CaseStudy.setHeader("Login/Register");
			
			System.out.println("1. Login as Admin");
			System.out.println("2. Login as Student");
			System.out.println("3. Register");
			System.out.println("4. Close");
			Helper.line(80, "-");
		}
		
	
		public static void menu(String role) {
			C206_CaseStudy.setHeader("Menu");
	
			if (role.equals("CCA Admin")) {
				System.out.println("1. Add CCA");
				System.out.println("2. Delete CCA");
				System.out.println("3. Update CCA");
				System.out.println("4. View CCAs");
				System.out.println("5. Log out");
				Helper.line(80, "-");
	
			} else if (role.equals("Student")) {
				System.out.println("1. Register for CCA");
				System.out.println("2. Delete registration for CCA");
				System.out.println("3. View registered for CCA");
				System.out.println("4. View CCAs");
				System.out.println("5. Log out");
				Helper.line(80, "-");
			} 	
		}
		
	
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
		
	
		public static void addCCA(ArrayList<CCA> ccalist) {
			String category = Helper.readString("Enter category > ");
			String title = Helper.readString("Enter CCA title > ");
			String description = Helper.readString("Enter description > ");
			int vacancy = Helper.readInt("Enter no. of vacancy for CCA > ");
			int vacancyTaken = Helper.readInt("Enter no. of taken vacancy for cca > ");
			String dayOfWeek = Helper.readString("Enter CCA days of week > ");
			double timeStart = Helper.readDouble("Enter CCA start time > ");
			double timeEnd = Helper.readDouble("Enter CCA end time > ");
			String venue = Helper.readString("Enter venue > ");
			String instructor = Helper.readString("Enter instructor in charge > ");
			
			if (ccalist.add(new CCA(category, title, description, vacancy, vacancyTaken, dayOfWeek, timeStart, timeEnd, venue, instructor))) {
				C206_CaseStudy.setHeader("Add CCA successful");
			} else {
				C206_CaseStudy.setHeader("Add CCA unsuccessful");
			}
		}
		
	
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
	  	        
		    
	
		
		
		}