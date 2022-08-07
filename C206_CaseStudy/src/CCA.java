import java.util.ArrayList;

public class CCA {
	//The system shall allow school CCA coordinators or various CCA instructors in-charge to upload CCAs before the 
	//registration open such as little league soccer, LEGO expert, dig the ground, bakery, jewellery making etc.
	//Different CCA may belong to different categories.  

	//Each CCA shall capture information such as title, description, class size (ie. 20), 
	//which day of the week (i.e., either Tuesday or Wednesday) time (i.e. 3:00PM- 4:00PM), venue, and 
	//name of the instructor in-charge etc.  
	
	
	private int id;
	public static int nextId = 1;
	
	private String category;
	private String title;
	private String description;
	private int vacancyOpen;
	private int vacancyTaken;
	private String dayOfWeek;
	private Double timeStart;
	private Double timeEnd;
	private String venue; 
	private String instructor;
	
	private ArrayList<String> registeredStudents;
	private ArrayList<String> status;
	
	public CCA(String category, String title, String description, int vacancyOpen, int vacancyTaken, 
			String dayOfWeek, double timeStart, double timeEnd, String venue, String instructor) {
		
		id = nextId;
		nextId++;
	
		registeredStudents = new ArrayList<String>();
		status = new ArrayList<String>();
		
		this.category = category;
		this.title = title;
		this.description = description;
		this.vacancyOpen = vacancyOpen;
		this.vacancyTaken = vacancyTaken;
		this.dayOfWeek = dayOfWeek;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.venue = venue;
		this.instructor = instructor;
	}
	
	public void addRegisteredStudent(String studentId) {
		registeredStudents.add(studentId);
		status.add("Pending");
	}
	
	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
	}
	
	
	public int getVacancyOpen() {
		return vacancyOpen;
	}

	public void setVacancyOpen(int vacancyOpen) {
		this.vacancyOpen = vacancyOpen;
	}

	public int getVacancyTaken() {
		return vacancyTaken;
	}

	public void setVacancyTaken(int vacancyTaken) {
		this.vacancyTaken = vacancyTaken;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}
	
	public void setDayOfWeek(String newDayOfWeek) {
		dayOfWeek = newDayOfWeek;
	}
	
	public double getTimeStart() {
		return timeStart;
	}
	
	public void setTimeStart(double newTimeStart) {
		timeStart = newTimeStart;
	}
	
	public double getTimeEnd() {
		return timeEnd;
	}
	
	public void setEndTime(double newTimeEnd) {
		timeEnd = newTimeEnd;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String newVenue) {
		venue = newVenue;
	}
	
	public String getInstructor() {
		return instructor;
	}
	
	public void setInstructorName(String newInstructor) {
		instructor = newInstructor;
	}

	@Override
	public String toString() {
		//13
		String output = String.format("%-4s %-11s %-13s %-15s %-10s %-20s %-12s %-10s %-10s %-15s\n", 
				id, category, title, description, vacancyTaken+"/"+vacancyOpen,
				dayOfWeek, timeStart, timeEnd, venue, instructor);		
		return output;
	}
	
}