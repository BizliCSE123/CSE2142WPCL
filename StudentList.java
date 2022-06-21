import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		if(args.length == 0 || args.length != 1){
			System.out.println(Constant.PleaseSearch);
			return;
		}

//		Check arguments
		if(args[0].equals( Constant.ShowAll)) {
			System.out.println(Constant.Loading);
			try {
				String[] names = getStrings();
				for(String name : names) {
					System.out.println(name);
			}
			} catch (Exception e){

			}
			System.out.println(Constant.Loaded);
		}
		else if(args[0].equals(Constant.ShowRandom)){
			System.out.println(Constant.Loading);
			try {
				String[] names = getStrings();
				Random randomNumber = new Random();
				int nextInt = randomNumber.nextInt(names.length);
				System.out.println(names[nextInt]);
			} catch (Exception e){

			}
			System.out.println(Constant.Loaded);
		}
		else if(args[0].contains(Constant.AddEntry)){
			System.out.println(Constant.Loading);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constant.StudentList, true));
				String substring = args[0].substring(1);
				Date date = new Date();
				String dateFormat = Constant.DateFormat;
				DateFormat format = null;
				assert format != null;
				format = new SimpleDateFormat(format);
				String formatDate= format.format(date);
				bufferedWriter.write(", "+substring+"\nList last updated on "+formatDate);
				bufferedWriter.close();
			} catch (Exception e){

			}
							
			System.out.println(Constant.Loaded);
		}
		else if(args[0].contains(Constant.FindEntry))
		{
			System.out.println(Constant.Loading);
			try {
				String[] names = getStrings();
				boolean done = false;
				String substring = args[0].substring(1);
				for(int idx = 0; idx<names.length && !done; idx++) {
					if(names[idx].equals(substring)) {
						System.out.println(Constant.Found);
						done=true;
				}
			}
			} catch (Exception e){

			}
			System.out.println(Constant.Loaded);
		}
		else if(args[0].contains(Constant.ShowCount))
		{
			System.out.println(Constant.Loading);
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constant.StudentList)));
				String readLine = bufferedReader.readLine();
				char a[] = readLine.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' '){
						if (!in_word) {
							count++;
							in_word =true;
						}
					else {
						in_word=false;
					}
				}
			}
			System.out.println(count +" word(bufferedReader) found " + a.length);
			} catch (Exception e){

			}
			System.out.println(Constant.Loaded);
		}
	}

	private static String[] getStrings() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(
					new FileInputStream(Constant.StudentList)));
		String studentName = bufferedReader.readLine();
		String names[] = studentName.split(Constant.StudentEntryDelimeter);
		return names;
	}
}
