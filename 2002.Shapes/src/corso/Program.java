package corso;

import corso.java.canvas.Canvas;
import corso.java.canvas.Drawable;
import corso.java.canvas.Rectangle;
import corso.java.canvas.Shape;
import corso.java.canvas.Square;

public class Program {

	static void graphicSystem(Canvas c, Drawable[] e) {
		for (int i = 0; i < e.length; ++i)
			e[i].draw(c);
	}

	public static void main(String[] args) {
		Canvas c = new Canvas(80, 23);
		for (int i = 0; i < 10; ++i)
			c.setPoint(10 + i, 15);
		c.setPoint(3, 18);
		Shape[] shapes = { new Rectangle(3, 3, 15, 10),
				new Square(5, 5, 15)};
		graphicSystem(c, shapes);
		c.print();

	}

}
