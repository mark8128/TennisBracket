import java.applet.*;
import java.awt.*;

public class DisplayBracket extends Applet {
	public void paint(Graphics g) {
		drawBranch(g, 100, 100, new Match(new Team()), new Match(new Team()));
	}
	
	public void drawBranch(Graphics g, int x, int y, Match m1, Match m2) {
		Team t1 = m1.t; //Team in Match 1
		Team t2 = m2.t; //Team in Match 2
		
		//Offsets for printing
		int 
		
		//Team 1's Players
		g.drawString(t1.getNames(), x, y);
		g.drawLine(x, y+4, x+100, y+4);
		
		//Team 2's Players
		g.drawString(t2.getNames(), x, y+25);
		g.drawLine(x, y+29, x+100, y+29);
	}
}
