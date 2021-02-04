package br.com.softblue.snake.core;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Background;
import br.com.softblue.snake.scene.Snake;

public class Game {
	
	private GameWindow gameWindow;
	private Snake snake;
	private Renderer renderer;
	
	public void start() {
		gameWindow = new GameWindow();
		snake = new Snake();
		
		renderer = gameWindow.getRenderer();
		renderer.add(new Background());
		renderer.add(snake);
	}
	
	public void run() {
		if (isGameOver()) {
			gameWindow.repaint();
		}
	}
	
	public boolean isGameOver() {
		return false;
	}
}
