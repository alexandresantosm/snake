package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.com.softblue.snake.core.Direction;

public class Shape extends Drawable {

	private List<Rect> rects;
	
	public Shape(Color color) {
		super(color);
		
		rects = new ArrayList<>();
	}
	
	public List<Rect> getRects() {
		return rects;
	}

	public void addRect(Rect rect) {
		rects.add(rect);
	}
	
	public Rect duplicate(Rect baseRect, Direction direction) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();
		
		int baseWidth = (int) baseRect.getDimension().getWidth();
		int baseHeight = (int) baseRect.getDimension().getHeight();
		
		Point newPoint = new Point(
				baseX + direction.getSgnX() * baseWidth, 
				baseY + direction.getSgnY() * baseHeight
		);
		
		Rect newRect = new Rect(newPoint, baseRect.getDimension());
		
		return newRect;
	}
	
	public Rect getFirstRect() {
		return rects.get(0);
	}
	
	public Rect getLastRect() {
		return rects.get(rects.size() - 1);
	}
	
	public boolean intersects(Rect other) {
		for (Rect rect : rects) {
			if (rect.intersects(other)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		for (Rect rect : rects) {
			rect.draw(g);
		}
	}

}
