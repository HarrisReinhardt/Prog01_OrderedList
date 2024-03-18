/**
*<Main class which takes in user input to find files and sort the info into another file>
*
* CSC 1351 Programming Project No <1>

* Section <2>
*
* @author <Harris Reinhardt>
* @since <3/17/2024>
* */





import java.util.Scanner;
import java.io.*;
public class Prog01_aOrderedList {

	public static void main(String[] args) throws FileNotFoundException {
		    aOrderedList list = new aOrderedList();
			Scanner scan = GetInputFile("What is the  input file name? ");
			readFile(scan,list);
			PrintWriter writer = GetOutputFile("What is the output file name ");
			printFile(writer,list);
			writer.close();
		
		
		}
	
	/**
	* <reads the file inputed by the user and adds/removes based on A or D>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	public static void readFile(Scanner scan, aOrderedList list) {
	    while (scan.hasNextLine()) {
	        String line = scan.nextLine();
	        String[] parts = line.split(",");
	        if (parts.length == 4 && parts[0].equals("A")) {
	            String make = parts[1];
	            int year = Integer.parseInt(parts[2]);
	            int price = Integer.parseInt(parts[3]);
	            Car newCar = new Car(make, year, price);
	            list.add(newCar);
	        } else if (parts.length == 3 && parts[0].equals("D")) {
	            String make = parts[1];
	            int year = Integer.parseInt(parts[2]);
	            removeCarChecker(list, make, year);
	        }
	    }
	}

	/**
	* <ensures the correct car is getting removed and removes it>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	private static void removeCarChecker(aOrderedList list, String make, int year) {
	    for (int i = 0; i < list.size(); i++) {
	        Car car = (Car) list.get(i);
	        if (car.getMake().equals(make) && car.getYear() == year) {
	            list.remove(i);
	            break;
	        }
	    }
	}
	
	
	/**
	* <prints the object in three different lines by make, year, and price>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public static void printFile(PrintWriter writer, aOrderedList list) {
	    writer.print("Number of cars: " + list.size());
	    writer.println();
	    for (int i = 0; i < list.size(); i++) {
	        Car car = (Car) list.get(i);
	        if (car != null) {
	            writer.println("Make: " + car.getMake());
	            writer.println("Year: " + car.getYear());
	            writer.println("Price: " + car.getPrice());
	            writer.println();
	        }
	    }
	}
	
	/**
	* <gets the input file from the user and checks if it exists >
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/

	
	public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println(UserPrompt);
			String fileName = "./src/" + scan.nextLine();
			File inputFile = new File(fileName);
			if(inputFile.exists()) {
				try {
				return new Scanner(inputFile);
				}
			catch(FileNotFoundException exception) {
				System.out.println("File <" + fileName + "> does not exist. Would you like to continue? <Y/N>" );
				String yesNo = scan.nextLine();
				if(!yesNo.equalsIgnoreCase("Y")) {
					throw exception;
				}
			}
		}else {
			System.out.println("File <" + fileName + "> does not exist. Would you like to continue? <Y/N>" );
			String yesNo = scan.nextLine();
			if(!yesNo.equalsIgnoreCase("Y")) {
				throw new FileNotFoundException("File not found");
				
		}
				
	}
		}
}

	/**
	* <gets the output file from the user>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Harris Reinhardt>
	* @since <3/17/2024>
	*
	*/
	
	
	public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println(UserPrompt);
			String fileName = scan.nextLine();
			File outputFile = new File(fileName);
				try {
					if(outputFile.exists()) {
				return new PrintWriter(outputFile);
					
				
			}else {
					System.out.println("File <" + fileName + "> does not exist. Add path" );
					String path = scan.nextLine();
					File newFile = new File(path,fileName);
					if("cancel".equalsIgnoreCase(path)) {
						throw new FileNotFoundException("File not found");
					}
					outputFile = new File(path, fileName);
					if(outputFile.exists()) {
						return new PrintWriter(outputFile);
					}
					
				}
			
		}catch(FileNotFoundException exception) {
				System.out.println("File <" + fileName + "> does not exist. Would you like to continue? <Y/N>" );
				String yesNo = scan.nextLine();
				if(!yesNo.equalsIgnoreCase("Y")) {
					throw exception;
				}
			}
	}
}
}


