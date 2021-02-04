package br.com.softblue.snake.scene;

import br.com.softblue.snake.graphics.Rect;
import br.com.softblue.snake.graphics.Shape;
import br.com.softblue.snake.util.Constants;

public class Snake extends Shape {
	
	public Snake() {
		setColor(Constants.SNAKE_COLOR);
		
		Rect rect = new Rect(
				Constants.SNAKE_INITIAL_X, 
				Constants.SNAKE_INITIAL_Y, 
				Constants.SNAKE_PIECE_SIZE, 
				Constants.SNAKE_PIECE_SIZE
		);
		
		addRect(rect);
		
		for (int i = 1; i < Constants.SNAKE_PIECE_SIZE; i++) {
			rect = duplicate(rect);
			rect.setColor(Constants.SNAKE_COLOR);
			addRect(rect);
		}
	}
}
