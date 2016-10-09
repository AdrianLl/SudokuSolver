import java.util.ArrayList;

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

		this.boardSquares.get(loc - 1).setVal(val);

	}

	public void print() {

		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				this.boardSquares.add(new Square(boardRow[i], boardCol[j]));
				System.out.print(boardSquares.get(index).toString());
				System.out.print(" " + boardSquares.get(index).getVal() + " ");
				index++;

			}
			System.out.print("\n");
		}
	}

	public void fillBoard(int[] values) {
/*
		for (int i = 0; i < 81; i++) {
			values[i] = boardSquares.get(i).setVal(val);
		}
*/
	}

}