package corso.java.canvas;

public abstract class Shape implements Drawable {

	private int rx;
	private int ry;

	public int getRx() {
		return rx;
	}

	public int getRy() {
		return ry;
	}

	public Shape(int rx, int ry) {
		this.rx = rx;
		this.ry = ry;
	}

	@Override
	public abstract void draw(Canvas c);
}
