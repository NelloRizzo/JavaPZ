package corso.java.canvas;

public class Canvas {

	private int width;
	private int height;

	private boolean[][] grid;

	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;

		grid = new boolean[height][];
		for (int i = 0; i < height; ++i) {
			grid[i] = new boolean[width];
		}
	}

	public void setPoint(int x, int y) {
		grid[y][x] = true;
	}

	public void resetPoint(int x, int y) {
		grid[y][x] = false;
	}

	public void print() {
		for (int r = 0; r < height; ++r) {
			for (int c = 0; c < width; ++c) {
				if (grid[r][c])
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
	}
}
