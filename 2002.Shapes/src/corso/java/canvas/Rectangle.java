package corso.java.canvas;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle(int rx, int ry, int width, int height) {
		super(rx, ry);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Canvas c) {
		for (int i = 0; i <= width; ++i) {
			c.setPoint(getRx() + i, getRy());
			c.setPoint(getRx() + i, getRy() + height);
		}
		for (int i = 0; i <= height; ++i) {
			c.setPoint(getRx(), getRy() + i);
			c.setPoint(getRx() + width, getRy() + i);
		}
	}

}
