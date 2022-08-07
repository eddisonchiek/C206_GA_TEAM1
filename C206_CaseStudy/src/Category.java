import java.util.ArrayList; 

public class Category {
	
	private int id;
	private String name;
	private String details;
	private ArrayList<CCA> cca;
	
	public Category(int id, String name, String details, ArrayList<CCA> cca) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.cca = cca;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ArrayList<CCA> getCCAs() {
		return cca;
	}

	public void setCCAs(ArrayList<CCA> ccas) {
		cca = ccas;
	}
}
