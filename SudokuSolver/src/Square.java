import java.util.Arrays;

public class Square {

	private char row;
	private int col;
	private int quad; // quadrant within puzzle
	private int val; // value of square
	private boolean possibleVal[] = new boolean[10]; // 0-9 possible or not
	private int falseCount;

	// Square Constructor
	public Square(char row, int col) {
		this.row = row;
		this.col = col;
		this.quad = getQuad(row, col);
		Arrays.fill(this.possibleVal, true);
		this.falseCount=0;

	}

	public int getFalseCount() {
		return falseCount;
	}

	public void setFalseCount(int falseCount) {
		this.falseCount = falseCount;
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

	/**
	 * This function will be used when loading given values at the beginning.
	 * The given num will eliminate all other num possibilities. Only used to
	 * initialize the given values.
	 * 
	 * @param givenNum
	 *            given number that will be entered in a given square
	 */
	public void givenValue(int givenNum) {
		Arrays.fill(this.possibleVal, false);
		this.possibleVal[givenNum] = true;
		this.falseCount=9;
	}

	public void validationUpdate(int num) {
		this.possibleVal[num] = false;
		this.falseCount++;
	}
	
	public void validationReUpdate(int num) {
		if (this.possibleVal[num] == true) {
			this.possibleVal[num] = false;
			this.falseCount++;
		}
	}

	public String toString() {
		return " L" + row + col + "Q" + quad + "V" + val + " ";
	}

	public char getRow() {
		return row;
	}

	public void setRow(char row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getQuad() {
		return quad;
	}

	public void setQuad(int quad) {
		this.quad = quad;
	}

	public boolean[] getPossibleVal() {
		return possibleVal;
	}

	public void setPossibleVal(boolean[] possibleVal) {
		this.possibleVal = possibleVal;
	}
	
	public void squareValidCountReset(){
		this.falseCount = 0;
	}

}
