package hoon2woon2;

import org.psnbtech.Tetris;

public class Main {
	public static Tetris tetris;
	public static Client client;
	
	public static void main(String[] args) {
		client = new Client();
		tetris = new Tetris();
		tetris.startGame();
	}
}
