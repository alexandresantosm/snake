package br.com.softblue.snake.scene;

import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT;
import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT_SCORE;
import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT_COLOR;
import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT_LOCATION;
import static br.com.softblue.snake.util.Constants.GAME_OVER_TEXT_LOCATION_SCORE;

import br.com.softblue.snake.graphics.Text;

public class GameOverText extends Text {

	public GameOverText() {
		super(GAME_OVER_TEXT, GAME_OVER_TEXT_LOCATION, GAME_OVER_TEXT_COLOR);
	}
	
	public GameOverText(int score) {
		super(String.format(GAME_OVER_TEXT_SCORE, score), GAME_OVER_TEXT_LOCATION_SCORE, GAME_OVER_TEXT_COLOR);
	}

}
