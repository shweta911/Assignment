package nasdaq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.text.DecimalFormat;
import java.util.ArrayList;



public class testing {
	static int counter;
	static float sum ;
	static float difference ;
	public static void main(String[] args) {
		testing Nasdaq = new testing();
		System.out.print("2nd Column of CSV file is Security");
	//	Nasdaq.displayLargestRise("GOOG");
	//	Nasdaq.display2ndColumn();
		Nasdaq.displayAverageTrade("MSFT");

	}



public void display2ndColumn()
{
	String csvFile = "C:\\Users\\Lenovo\\eclipse-workspace\\nasdaq\\demo.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = " ";
	try {

		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) 
				{
		String[] reader = line.split(cvsSplitBy);

		System.out.println("SECURITY [value= " + reader[1] + "]");
		

		}

		}
	catch (FileNotFoundException e) {
		
		} catch (IOException e) {
		
		} 
	catch (Exception e) {
		} 
	//finally {
		//if (br != null) {
		try {
			br.close();
		} catch (IOException e) {
			
		}
		
		}

public void displayAverageTrade(String security)
{
	counter = 0;
	sum =0;
	String csvFile = "C:\\Users\\Lenovo\\eclipse-workspace\\nasdaq\\demo.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = " ";
	try {
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			
		String[] reader = line.split(cvsSplitBy);
		String currentSecurity = reader[1];
		if (security.equals(currentSecurity)) {
				System.out.println("SECURITY [value= " + reader[1] + "]");
		counter++;
		String s1 = reader[3].trim();
		
		sum += Float.parseFloat(s1);
		System.out.println("Price = "+ sum);
		
		}
		
		}	
		
		}	
	catch (FileNotFoundException e) {
		//e.printStackTrace();
		} 
	catch (IOException e) {
		//e.printStackTrace();
		} 
	catch (Exception e) {
		//e.printStackTrace();
		} 
	finally {
		System.out.println("Total Occurrence of Security code is ="+counter);
		System.out.println("Average Price of Security code is ="+ sum/counter);
				if (br != null) {
		try {
		br.close();
		} catch (IOException e) {
		}
		}
		}
	}

public void displayLargestRise(String security)
{
	System.out.println("\nIn Function DisplayLargestRise \n" );

	float x = 0;
	ArrayList<String> a1 = new ArrayList();
	difference = 0;
	String csvFile = "C:\\Users\\Lenovo\\eclipse-workspace\\nasdaq\\demo.csv";
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
		System.out.println("End of While " );

		str = a1.toArray();
		float diff, x1, x2;
		for (int i=0;i<str.length-1;i++)
		{
			x1 = Float.parseFloat(str[i].toString());
			x2 = Float.parseFloat(str[i+1].toString()); 
			diff = x2 - x1;
			System.out.println("Difference " + diff);
			x = diff > x ? diff : x;			
				
		}
	
	
	}	
	catch (FileNotFoundException e) {
	
		} 
	catch (IOException e) {
		
		} 
	finally {
	
		System.out.println(" Array size = " + a1.size());
		System.out.println(" Print array " + a1);
		System.out.println(" Largest Difference is = " + String.format("%.2g%n", x));
		
		if (br != null) {
		try {
		br.close();
		} catch (IOException e) {
		}
		}
		}
	}

}