package unitTestNasdaq;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.awt.color.*;

//Class Testjunit is class for unit test cases
public class Testjunit {
	 
	String Test_Pass ="Test Passed"; //Variable to be used in assert.
	String Test_Fail ="Test Failed"; //Variable to be used in assert.
    NasdaqAssignment object = null;  //Defining object of the class to be tested.
	
	/**Before class executed before each test.
	 * Assigning Object to value.
	 */
	@Before
	public void executedBeforeEach()
		{
			System.out.print("\n Executed once before every test\n");
			//Creating Object For Code To Be Tested Class
			 object = new NasdaqAssignment();
		}
	   
    /**
     * Test to Display Value of 2nd Column(Security in Given Case)
     */
	@Test
	public void testDisplay2ndColumn()
	{	  
		 System.out.print("\n*******Unit Testing - Print 2nd Column*******\n");
		 String Output =  object.display2ndColumn();
		 assertEquals(Test_Pass,Output);
	     
	}

	/**
	 * Test to Calculate Average Trade Value for Security Value =MSFT
	 */
	@Test
	public void testDisplayAvgTrade_01()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayAverageTrade("MSFT");
		assertEquals(Test_Pass,Output);
	}
	
	/**
	 * Test to Calculate Average Trade Value for Security Value =GOOG
	 */
	
	@Test
	public void testDisplayAvgTrade_02()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayAverageTrade("GOOG");
		assertEquals(Test_Pass,Output);
	}
	

	/**
	 * Test to Calculate Average Trade Value for Security Value =CTXS.
	 */
	
	@Test
	public void testDisplayAvgTrade_03()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayAverageTrade("CTXS");
		assertEquals(Test_Pass,Output);
	}
	
	/**
	 * Negative Test to Calculate Average Trade Value for Security Value =INVALID.
	 */
	
	@Test
	public void testDisplayAvgTrade_InvalidData()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayAverageTrade("INVALID");
		assertEquals(Test_Fail,Output);
	}
	
	/**
	 * Test to Calculate Largest Rise in Price for Security Value =MSFT.
	 */
	
	@Test
	public void testdisplayLargestRise_01()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayLargestRise("MSFT");
		assertEquals(Test_Pass,Output);
		
	}
	

	/**
	 * Test to Calculate Largest Rise in Price for Security Value =GOOG.
	 */
	
	@Test
	public void testdisplayLargestRise_02()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayLargestRise("GOOG");
		assertEquals(Test_Pass,Output);
	}
	

	/**
	 * Test to Calculate Largest Rise in Price for Security Value =CTXS.
	 */
	
	@Test
	public void testdisplayLargestRise_03()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayLargestRise("CTXS");
		assertEquals(Test_Pass,Output);
	}
	
	/**
	 * NEGATIVE Test to Calculate Largest Rise in Price for Security Value =INVALID.
	 */

	@Test
	public void testdisplayLargestRise_InvalidInput()
	{
		System.out.print("\n*******Unit Testing - Displaying Average Trade Price*******\n");
        String Output =  object.displayLargestRise("INVALID");
		assertEquals(Test_Fail,Output);
	}
	
	/**
	 * In order to clear the list after the execution of each test.
	 */
	@After
    public void after() {
        System.out.println("\n Runs after all Test Cases are executed\n");
        object =null;
        
    }


	
}
