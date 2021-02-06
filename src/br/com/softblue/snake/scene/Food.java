package br.com.softblue.snake.scene;

import static br.com.softblue.snake.util.Constants.FOOD_SIZE;
import static br.com.softblue.snake.util.GameUtils.random;

import static java.awt.Color.GREEN;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.softblue.snake.graphics.Rect;

public class Food extends Rect {
	
	private int eatenTimes;

	public Food(Rectangle drawingArea, Snake snake) {
		setRandomLocation(drawingArea, snake);
		setDimension(new Dimension(FOOD_SIZE, FOOD_SIZE));
		setColor(GREEN);
	}
	
	public void setRandomLocation(Rectangle drawingArea, Snake snake) {
		do {
			int offset = 3;
			int x = random(
					(int) drawingArea.getMinX() + offset, 
					(int) drawingArea.getMaxX() - offset - FOOD_SIZE
			);
			int y = random(
					(int) drawingArea.getMinY() + offset, 
					(int) drawingArea.getMaxY() - offset - FOOD_SIZE
			);
			
			setLocation(new Point(x, y));
		} while (snake.intersects(this));
	}
	
	public void checkIfEaten(Snake snake, Rectangle drawingArea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			
			setRandomLocation(drawingArea, snake);
			
			snake.elongate();
		}
	}
}
