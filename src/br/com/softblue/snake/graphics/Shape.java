package br.com.softblue.snake.graphics;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

	private List<Rect> rects;
	
	public Shape() {
		rects = new ArrayList<>();
	}
	
	public void addRect(Rect rect) {
		rects.add(rect);
	}
	
	public Rect duplicate(Rect baseRect) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();
		int baseWidth = (int) baseRect.getDimension().getWidth();
		
		Point newPoint = new Point(baseX - baseWidth, baseY);
		
		Rect newRect = new Rect(newPoint, baseRect.getDimension());
		
		return newRect;
	}
	
	@Override
	public void draw(Graphics g) {
		for (Rect rect : rects) {
			rect.draw(g);
		}
	}

}
