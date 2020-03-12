/**
 * 
 */
package parkinglot.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parkinglot.controller.ParkingRequestProcessor;

/**
 * 
 * 
 * @author aniket
 *
 */
public class ParkingLotAdmin {

	/**
	 * 
	 * Runner class which can accept file input or command input and invoke
	 * {@code ParkingRequestProcessor} accordingly.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ParkingRequestProcessor parkingRequestProcessor = new ParkingRequestProcessor();

		String parkingInput;
		BufferedReader bufferReader =null;
		if (args.length == 0) {// command line input
			while (true) // until exit is option is not selected
			{

				//System.out.println("\n");
				//Arrays.asList(ParkingCommands.values())
			//			.forEach(command -> System.out.println(command.getParkingCommands()));
			//	System.out.println("Please select your desired option");

				try {
					 bufferReader = new BufferedReader(new InputStreamReader(System.in)); 
					parkingInput = bufferReader.readLine().trim();
					parkingRequestProcessor.execute(parkingInput);
				} catch (IOException e) {
				} 

			}

		} else if (args.length == 1) {// reading from the file.

			File inputFile = new File(args[0]);

			try (BufferedReader bufferReader1 = new BufferedReader(new FileReader(inputFile))) {
				while ((parkingInput = bufferReader1.readLine()) != null) {
					parkingRequestProcessor.execute(parkingInput.trim());

				}
			} catch (FileNotFoundException ex) {
				System.out.println("FilePath :" + args[0] + " , Not found  Please enter a valid file path");
			}
			catch (IOException e) {
				e.printStackTrace();
			} 

		}

	}

}
