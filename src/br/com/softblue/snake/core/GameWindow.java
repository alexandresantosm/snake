package br.com.softblue.snake.core;

import static br.com.softblue.snake.util.Constants.GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS;
import static br.com.softblue.snake.util.Constants.GAME_TITLE;
import static br.com.softblue.snake.util.Constants.WINDOW_HEIGHT;
import static br.com.softblue.snake.util.Constants.WINDOW_WIDTH;

import static java.awt.event.KeyEvent.VK_UP;
import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_ESCAPE;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import br.com.softblue.snake.graphics.Renderer;
import br.com.softblue.snake.scene.Snake;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements KeyListener {
	
	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private long lastKeyboardEventTime;
	
	public GameWindow(Snake snake) {
		renderer = new Renderer();
		
		this.snake = snake;
		
		setTitle(GAME_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);
		
		buffer = createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
		gImage = buffer.getGraphics();
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public void paint(Graphics gScreen) {
		if (renderer != null && gImage != null && buffer != null ) {
			renderer.render(gImage);
			
			gScreen.drawImage(buffer, 0, 0, null);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		long now = System.currentTimeMillis();
		
		if (now - lastKeyboardEventTime < GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS) {
			return;
		}
		
		switch (e.getKeyCode()) {
		case VK_UP:
			snake.up();
			break;
		case VK_DOWN:
			snake.down();
			break;
		case VK_LEFT:
			snake.left();
			break;
		case VK_RIGHT:
			snake.right();
			break;
		case VK_ESCAPE:
			System.exit(0);
			break;
		default:
			break;
		}
		
		lastKeyboardEventTime = now;
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
