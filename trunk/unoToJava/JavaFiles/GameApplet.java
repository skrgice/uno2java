import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.io.IOException;



public class GameApplet extends Applet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Game m_game;
	

	public void init()
	{
		getPlayerNumber();
		try {
			m_game = new Game(5, 
					"../unoDeck.txt");
					//f.getAbsolutePath()+"./unoDeck.txt");
					//"C:/Eclipse/workspace/uno2Java/unoDeck.txt");
		} catch (IOException e) {
			//fail-safe
			//ideally we want to read from the file, because thats the way the 
			//program was originally designed in DOS, but if for some reason, java can't
			//locate the text file, we have the deck hard-coded in
			m_game = new Game(5);
		}
		m_game.setup();
		//m_game.gamesetupdraw();
		addKeyListener(m_game.getUI());
		addMouseListener(m_game.getUI());
		//Thread t = new Thread(m_game);
		//t.start();
	}
	
	public void paint(Graphics g)
	{
		m_game.draw(g);
	
	}
	
	public Game getGame()
	{
		return m_game;
	}
	
	public int getPlayerNumber()
	{
		int buttonCount = 9;
		Button player[];
		player = new Button[buttonCount];
		for(int i = 0; i < buttonCount; ++i)
		{
			player[i] = new Button(" " + (i+2));
			add(player[i]);
		}
		
		return 0;
	}
}
