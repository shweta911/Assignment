package unitTestNasdaq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.DecimalFormat;
import java.util.ArrayList;

public class NasdaqAssignment 
{
	static int counter;            //Counter is variable counting occurrence of value.
	static float sum ;			   //Sum is variable to store total of Price.
	static float difference;	   
	
	//CSVFile is Path for the Data File
	static String csvFile = "C:\\Users\\Lenovo\\eclipse-workspace\\Assignment\\src\\DataFile.csv";
	
public static void main(String[] args)
{
	// Return Value from Function,Consumed by UnitTest.
	String ReturnValue;
	//Creating Object for the Class.
	NasdaqAssignment Nasdaq = new NasdaqAssignment();
	
	//Calling Function for Displaying 2nd Column of the Data File.
	ReturnValue =Nasdaq.display2ndColumn();
	
	//Calling Function for Displaying Average Trade Value for Given Security Code from the Data File.
	ReturnValue = Nasdaq.displayAverageTrade("MSFT");
	
	//Calling Function for Displaying Largest Rise for Given Security Code from the Data File.
	ReturnValue = Nasdaq.displayLargestRise("GOOG");
	
}
		
/**
 * Default Constructor to Create Object.
 */
public NasdaqAssignment()
{
	System.out.print("Object Created for class NasdaqAssignment\n");
}

/**
 * Function to Display 2nd Column (Security)from Data CSV File
 * @return String Return Code either Test Passed/Test Failed.
 * @Variables 
 * return_output :- To capture Success/Failure of function.
 * br            :- Reads the text from an Input stream.
 * line			 :- To read the file line by line.
 * cvsSplitBy    :- String that stores space as a seprator for the column.
 * 
 */

public String display2ndColumn()
{
		String return_output ="Test Failed";
		
		BufferedReader br = null;
		
		String line = "";
		
		String cvsSplitBy = " ";
			
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) 
					
				{
					String[] reader = line.split(cvsSplitBy);
					//Display value in 2nd Column
					System.out.println("SECURITY [value= " + reader[1] + "]");
					return_output ="Test Passed";
				}
			

	    	}
		//Catch Blocks defining a block of code to be executed, if an error occurs in the try block.
	catch (FileNotFoundException e) {
		
		} catch (IOException e) {
		
		} 
	catch (Exception e) {
		} 
	
		try {
			//Closing the Reader
			br.close();
		} catch (IOException e) {
			
		}
		finally {
			
		}
		return return_output;
		}

/**
 * Function to Display Average Price of Column (Security)from Data CSV File
 * @return String Return Code either Test Passed/Test Failed.
 * @Variables 
 * return_output :- To capture Success/Failure of function.
 * br            :- Reads the text from an Input stream.
 * line			 :- To read the file line by line.
 * cvsSplitBy    :- String that stores space as a seprator for the column.
 * 
 */


public String displayAverageTrade(String security)
{
	counter = 0;
	sum =0;
	String return_output ="Test Failed";

	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = " ";
	try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			
		String[] reader = line.split(cvsSplitBy);
		String currentSecurity = reader[1];
		if (security.equals(currentSecurity)) 
			{
				System.out.println("SECURITY [value= " + reader[3] + "]");
				counter++;
				String s1 = reader[3].trim();
				sum += Float.parseFloat(s1);
				System.out.println("Price = "+ sum);
				return_output = "Test Passed";
			}
			
		}
				
		}	
	catch (FileNotFoundException e) {
		
		} 
	catch (IOException e) {
		
		} 
	catch (Exception e) {
		
		} 
	finally 
		{
			System.out.println("\nTotal Occurrence of Security code is = "+counter);
			if (counter >0)
			{
				System.out.println("\nAverage Price of Security code is = "+  sum/counter);
				
			}
			else
				System.out.println("Security Code Not Found in File");
			if (br != null)
				{
					try {
						br.close();
				} 
	catch (IOException e)
		{
		}
		
		}
		}
	return return_output;
	}

/**
 * Function to Display Largest Rise in Price Column (for given Security)from Data CSV File
 * @return String Return Code either Test Passed/Test Failed.
 * @Variables 
 * return_output :- To capture Success/Failure of function.
 * br            :- Reads the text from an Input stream.
 * line			 :- To read the file line by line.
 * cvsSplitBy    :- String that stores space as a seprator for the column.
 * a1            :- Array list to Store the Value of given Security to be used to calculate difference latter in the code.
 * x1 & x2		 :- To store preceding and succeeding value of array.
 * x             :- To store the difference in x1 & x2.
 * reader		 :- To read the lines.
 */

public String displayLargestRise(String security)
{
	System.out.println("\nIn Function DisplayLargestRise \n" );
	String return_value;
	float x = 0;
	ArrayList<String> a1 = new ArrayList();
	difference = 0;
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = " ";
	Object[] str;
	try {
		br = new BufferedReader(new FileReader(csvFile));
		while((line=br.readLine())!=null && line.length()!=0) {
		
			String[] reader = line.split(cvsSplitBy);
			String currentSecurity = reader[1];
			if (security.equals(currentSecurity)) {

				a1.add(reader[3].trim());

			}

		}	// end while
	
		str = a1.toArray();
		float diff, x1, x2;
		for (int i=0;i<str.length-1;i++)
		{
			x1 = Float.parseFloat(str[i].toString());
			x2 = Float.parseFloat(str[i+1].toString()); 
			diff = x2 - x1;
			//Used for Debug System.out.println("Difference " + diff);
			x = diff > x ? diff : x;			
				
		}
	
	
	}	
	catch (FileNotFoundException e) {
	
		} 
	catch (IOException e) {
		
		} 
	finally {
	
		System.out.println(" Array size of Price Matcing the Security  = " + a1.size());
		System.out.println(" Print array Matching the Security " + a1);
		System.out.println(" Largest Rise in Price is = " + String.format("%.2g%n", x));
		
		if (br != null) {
		try {
		br.close();
		} catch (IOException e) {
		}
		}
		if (x > 0 && a1.size() > 1)
		{
		 	System.out.print("Largest Difference Printed");
		 	return_value ="Test Passed";
		}
		else if (x ==0 && a1.size() == 0)
		{
			System.out.print("\nSecurity value not found in list\n");
			return_value ="Test Failed";
		}
		else 
		{
			System.out.print("Security code exists only once");
			return_value ="Test Passed";
		}

		}
	return return_value;
	}


}