import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<int[]> allValues = new ArrayList<int[]>();
		ValuesReader valueIntake = new ValuesReader();
		String[] valueString = Arrays.copyOf(valueIntake.readLines("res/sudokus.txt"), 500);
		
		for (int k = 0; k < 500; k++) {
			int tempArr[] = new int[81];
			for (int i = 0; i < 81; i++) {
				
				String tempString = valueString[k];	
				tempArr[i] = (int) tempString.charAt(i) - 48;
			}
			allValues.add(tempArr);
		}
		
		
		
		

		//FileIO values = new FileIO();
		Board sudoku = new Board();
		//int sudokuValues[] = Arrays.copyOf(values.getValues(), 81);

		int counter= 0;
		
		sudoku.fillBoard(allValues.get(0));
		sudoku.boardValidation();
		sudoku.checkSolvable();
		
		while(counter<50){
			sudoku.boardUpdate();
			sudoku.checkSolvable();
			counter++;
		}
		
		System.out.println("\n Solved Sudoku 1 \n");
		sudoku.print();
		
	}
}
