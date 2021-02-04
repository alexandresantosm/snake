package br.com.softblue.snake.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Rect {

	private Point location;
	private Dimension dimension;
	private Color color;

	public Rect(int x, int y, int width, int height, Color color) {
		this.location = new Point(x, y);
		this.dimension = new Dimension(width, height);
		this.color = color;
	}

	public Rect(Point location, Dimension dimension, Color color) {
		this.location = location;
		this.dimension = dimension;
		this.color = color;
	}

	public Point getLocation() {
		return location;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Color getColor() {
		return color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		
		g.fillRect(
			(int) location.getX(), 
			(int) location.getY(), 
			(int) dimension.getWidth(), 
			(int) dimension.getHeight()
		);
	}

}
