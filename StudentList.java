import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			     BufferedReader bufferedReader = new BufferedReader(
					      new InputStreamReader(
							       new FileInputStream("students.txt")));
			     String line = bufferedReader.readLine();
			     String strings[] = line.split(",");
				 for(String string : strings) {
				    System.out.println(string);
			     }
			}
			catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
			    BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			    String readLine = bufferedReader.readLine();
			   // System.out.println(readLine);
			    String strings[] = readLine.split(", ");
				int length = strings.length;
				Random random = new Random();
				int nextInt = random.nextInt(length);
				System.out.println(strings[nextInt]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try { 
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
				String substring = args[0].substring(1);
				Date date = new Date();
				String string = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(string);
				String format= dateFormat.format(date);
				bufferedWriter.write(", "+substring+"\nList last updated on "+format);
				bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
				String readLine = bufferedReader.readLine();
				String strings[] = readLine.split(",");
				boolean done = false;
				String substring = args[0].substring(1);
				for(int idx = 0; idx<strings.length && !done; idx++) {
					if(strings[idx].equals(substring)) {
					System.out.println("We found it!");
					done=true;
				}
			}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
				String readLine = bufferedReader.readLine();
				char chars[] = readLine.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:chars) {
					if(c ==' ') {
						if (!in_word) {	count++; in_word =true;	} 
						else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + chars.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}
