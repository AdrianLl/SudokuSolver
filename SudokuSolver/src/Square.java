
public class Square {

	private char row;
	private int col;
	private int quad; // quadrant within puzzle
	private int val; // value of square
	// private int arrPos; // position within input array

	// might have to use bool validation for checking

	// Square Constructor
	public Square(char row, int col) {
		this.row = row;
		this.col = col;
		this.quad = getQuad(row, col);
	}

	public Square(char row, int col, int val) {
		this(row, col);
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {

		this.val = val;
	}

	public int getQuad(char row, int col) {

		int Quadrant = 0; // no quadrant given yet

		if (row == 'A' || row == 'B' || row == 'C') {
			if (col >= 1 && col <= 3) {
				Quadrant = 1;
			} else if (col >= 4 && col <= 6) {
				Quadrant = 2;
			} else if (col >= 7 && col <= 9) {
				Quadrant = 3;
			}
		}

		if (row == 'D' || row == 'E' || row == 'F') {
			if (col >= 1 && col <= 3) {
				Quadrant = 4;
			} else if (col >= 4 && col <= 6) {
				Quadrant = 5;
			} else if (col >= 7 && col <= 9) {
				Quadrant = 6;
			}
		}

		if (row == 'G' || row == 'H' || row == 'I') {
			if (col >= 1 && col <= 3) {
				Quadrant = 7;
			} else if (col >= 4 && col <= 6) {
				Quadrant = 8;
			} else if (col >= 7 && col <= 9) {
				Quadrant = 9;
			}
		}

		return Quadrant;

	}

	public String toString() {
		return " L" + row + col + "Q" + quad + "V" + val + " ";
	}

}
