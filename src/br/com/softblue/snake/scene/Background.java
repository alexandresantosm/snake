package br.com.softblue.snake.scene;

import static br.com.softblue.snake.util.Constants.BACKGROUND_COLOR;
import static br.com.softblue.snake.util.Constants.WINDOW_HEIGHT;
import static br.com.softblue.snake.util.Constants.WINDOW_WIDTH;

import br.com.softblue.snake.graphics.Rect;

public class Background extends Rect {

	public Background() {
		super(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		setColor(BACKGROUND_COLOR);
	}
}
