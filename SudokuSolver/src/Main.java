/*
 * Adrian Lliguichuzhca
 * 
 * CISC 3410 Program #2
 * Sudoku Solver with CSP
 * 
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<int[]> allValues = new ArrayList<int[]>();
		ValuesReader valueIntake = new ValuesReader();
		String[] valueString = Arrays.copyOf(valueIntake.readLines("res/sudokus.txt"), 500);
		int solvedCounter=0;
		
		for (int k = 0; k < 500; k++) {
			int tempArr[] = new int[81];
			for (int i = 0; i < 81; i++) {
				
				String tempString = valueString[k];	
				tempArr[i] = (int) tempString.charAt(i) - 48;
			}
			allValues.add(tempArr);
		}
		
		
		for(int puzzleCount = 0; puzzleCount<500;puzzleCount++){
			
			Board sudoku = new Board();

			int counter= 0;
			
			
			sudoku.fillBoard(allValues.get(puzzleCount));
			sudoku.boardValidation();
			sudoku.checkSolvable();
			
			while(counter<50){
				sudoku.boardValidation();
				sudoku.checkSolvable();
				counter++;
			}
			
			
			if(sudoku.isSolved()){
				solvedCounter++;
			System.out.println("\n Solved Sudoku Puzzle " + puzzleCount+ "\n");
			sudoku.print();
			}
			
		}
		
		System.out.println("Number of solved Puzzles: "+ solvedCounter);
		
		
	}
}
