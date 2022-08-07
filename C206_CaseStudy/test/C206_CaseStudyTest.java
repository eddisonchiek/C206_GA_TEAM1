import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	ArrayList<Students> studentsList = new ArrayList<>();
	studentsList.add(new Students("Wunhon", "King Albert Park 765432", "P4", "P4-100", "Amran Mohamed", "Michelle", "21040247@myrp.edu.sg", 12345678));
	
	public void testAddStudent() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Student arraylist to add to", studentsList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.Students(studentsList, 1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, studentsList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", 1, studentsList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addStudent(studentsList);
		C206_CaseStudy.addStudent(studentsList);
		assertEquals("Test that Camcorder arraylist size is 3?", 3, studentsList.size());
		assertSame("Test that Camcorder is added same as 3rd item of the list?", 3, studentsList.get(2));
	}

}
