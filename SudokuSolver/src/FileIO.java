import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	private final int SIZE = 81;

	private int[] nums = new int[SIZE]; 

	public FileIO() {
	}
	
	public int[] getValues(){ 
		
		FileReader file;
		try {
			file = new FileReader("res/sudokus.txt");
			BufferedReader reader = new BufferedReader(file);
			
			String numbers;
			numbers = reader.readLine();
			
			for (int i = 0; i < SIZE; i++) {
				nums[i] = (int) numbers.charAt(i) - 48;
			}
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println(nums[2]);
		
		return nums;		
		
	}
	
}
