package br.com.softblue.snake.scene;

import static br.com.softblue.snake.core.Direction.DOWN;
import static br.com.softblue.snake.core.Direction.LEFT;
import static br.com.softblue.snake.core.Direction.NONE;
import static br.com.softblue.snake.core.Direction.RIGHT;
import static br.com.softblue.snake.core.Direction.UP;

import static br.com.softblue.snake.util.Constants.SNAKE_COLOR;
import static br.com.softblue.snake.util.Constants.SNAKE_INITIAL_X;
import static br.com.softblue.snake.util.Constants.SNAKE_INITIAL_Y;
import static br.com.softblue.snake.util.Constants.SNAKE_PIECE_SIZE;
import static br.com.softblue.snake.util.Constants.SNAKE_SIZE;
import static br.com.softblue.snake.util.Constants.SNAKE_ELONGATE_PIECES;

import br.com.softblue.snake.core.Direction;
import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Shape;
import br.com.softblue.snake.util.GameUtils;

public class Snake extends Shape {
	
	private Direction direction;
	private int piecesToElongate;
	
	public Snake() {
		super(SNAKE_COLOR);
		
		direction = NONE;
		
		Rect rect = new Rect(
				SNAKE_INITIAL_X, 
				SNAKE_INITIAL_Y, 
				SNAKE_PIECE_SIZE, 
				SNAKE_PIECE_SIZE
		);
		
		addRect(rect);
		
		for (int i = 1; i < SNAKE_SIZE; i++) {
			rect = duplicate(rect, LEFT);
			addRect(rect);
		}
	}
	
	public synchronized void move() {
		if (direction != NONE) {
			Rect head = getFirstRect();
			Rect tail = getLastRect();
			
			GameUtils.moveRect(getRects());
			
			Rect newHead = duplicate(head, direction);
			
			getRects().set(0, newHead);
			
			if (piecesToElongate > 0) {
				getRects().add(tail);
				
				piecesToElongate--;
			}
		}
	}
	
	public synchronized void up() {
		if (direction.canChangeTo(UP)) {
			direction = UP;
		}
	}
	
	public synchronized void down() {
		if (direction.canChangeTo(DOWN)) {
			direction = DOWN;
		}
	}
	
	public synchronized void left() {
		if (direction.canChangeTo(LEFT)) {
			direction = LEFT;
		}
	}
	
	public synchronized void right() {
		if (direction.canChangeTo(RIGHT)) {
			direction = RIGHT;
		}
	}
	
	public boolean collidesWithItself() {
		Rect head = getFirstRect();
		
		for (int i = 1; i < getRects().size(); i++) {
			Rect rect = getRects().get(i);
			
			if (head.intersects(rect)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void elongate() {
		piecesToElongate = SNAKE_ELONGATE_PIECES;
	}
}
