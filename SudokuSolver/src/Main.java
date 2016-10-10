import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		FileIO values = new FileIO();
		Board sudoku = new Board();
		int sudokuValues[] = Arrays.copyOf(values.getValues(), 81);

		int counter= 0;
		
		sudoku.fillBoard(sudokuValues);
		sudoku.boardValidation();
		sudoku.print();
		System.out.println("\n UPDATED SUDOKU \n");
		
		
		
		sudoku.checkSolvable();
		
		
		while(counter<100){
			sudoku.boardValidation();
			sudoku.checkSolvable();
			counter++;
			
		}
		
		sudoku.print();
	}
}
