import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		FileIO values = new FileIO();
		Board sudoku = new Board();

		//test1.setSquare(1, 1);

		sudoku.print();
		
		
		sudoku.setSquare(1,1);
		
		System.out.println("MOD PUZZLE BELOW");
		
		sudoku.print();
		
		
		values.getValues();
		
		
		
		
		
		/*
		
		int[] vals = new int[81];
				
		values.getValues().clone();
		*/
		

	}
}
