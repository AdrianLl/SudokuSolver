import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

	private ArrayList<Square> boardSquares;
	private final int boardCol[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private final char boardRow[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };

	public Board() {
		this.boardSquares = new ArrayList<Square>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				this.boardSquares.add(new Square(boardRow[i], boardCol[j]));

			}
		}

	}

	/**
	 * This will set the value of a square within the board.
	 * 
	 * @param val
	 * @param loc
	 */
	public void setSquare(int val, int loc) {

		this.boardSquares.get(loc).setVal(val);

	}

	public void setInitialPossibible(int val, int loc) {

		this.boardSquares.get(loc).givenValue(val);
	}

	public void print() {

		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				this.boardSquares.add(new Square(boardRow[i], boardCol[j]));
				// System.out.print(boardSquares.get(index).toString());
				System.out.print(" " + boardSquares.get(index).getVal() + " ");
				index++;

			}
			System.out.print("\n");
		}
		/*
		for (int i = 0; i < 81; i++) {
			System.out.println(this.boardSquares.get(i));
			System.out.println(Arrays.toString(this.boardSquares.get(i).getPossibleVal()));
			System.out.println(this.boardSquares.get(i).getFalseCount());
		}
		*/
	}

	public void fillBoard(int[] values) {

		for (int i = 0; i < 81; i++) {

			if (values[i] == 0) {
				this.setSquare(values[i], i);
			} else {
				this.setSquare(values[i], i);
				this.setInitialPossibible(values[i], i);
			}
		}

	}

	public void boardValidation() {

		for (int i = 0; i < 81; i++) {
			if (this.boardSquares.get(i).getVal() == 0) {
				this.squareValidation(i);
			}
		}

	}

	public void squareValidation(int squareNumber) {

		List<Integer> givenValues = new ArrayList<>(); // all given values row
														// col quad
		Set<Integer> uniqueValues = new HashSet<>(); // only unique values
		char squareRow = this.boardSquares.get(squareNumber).getRow();
		int squareCol = this.boardSquares.get(squareNumber).getCol();
		int squareQuad = this.boardSquares.get(squareNumber).getQuad();

		for (int i = 0; i < 81; i++) {

			int squareVal = this.boardSquares.get(i).getVal();
			char squareRowCheck = this.boardSquares.get(i).getRow();
			int squareColCheck = this.boardSquares.get(i).getCol();
			int squareQuadCheck = this.boardSquares.get(i).getQuad();

			if (squareVal == 0) {
				continue;
			} else {
				if (squareRow == squareRowCheck) {
					givenValues.add(squareVal);
				} else if (squareCol == squareColCheck) {
					givenValues.add(squareVal);
				} else if (squareQuad == squareQuadCheck) {
					givenValues.add(squareVal);
				}
			}
		}

		if (!givenValues.isEmpty()) {
			uniqueValues.addAll(givenValues);
			givenValues.clear();
			givenValues.addAll(uniqueValues);
		}

		for (int k = 0; k < givenValues.size(); k++) {

			this.boardSquares.get(squareNumber).validationUpdate(givenValues.get(k));

		}

	}
	
	public void checkSolvable() {
		// List<Integer> indexSolvable = new ArrayList<>();

		for (int i = 0; i < 81; i++) {

			if (this.boardSquares.get(i).getFalseCount() == 8) {
				int index=0;
				boolean vals[] = Arrays.copyOf(this.boardSquares.get(i).getPossibleVal(), 10);
				for (int k = 1; k < 10; k++) {
					if (vals[k]) {
						index = k;
						this.boardSquares.get(i).validationUpdate(index);
						this.boardSquares.get(i).setVal(index);
						
						break;
					}
				}
				this.boardSquares.get(i).validationUpdate(index);
			}

		}
	}

	// create function to test possibilities left over in puzzle.**********

}