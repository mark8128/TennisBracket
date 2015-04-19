import java.applet.*;
import java.awt.*;

public class DisplayBracket extends Applet {
	public void paint(Graphics g) {
		//Offsets for printing
		int xOffset = 160;
		int pOffset = 0; //offset between branches in same level
		int tOffset = 15; //initial offset from top for each level
		int spacing = 24; //Space between branches in a level
		int maxPow2 = 6;
		
		for(int i = 0; i < maxPow2; i++) {
			pOffset = spacing * (int)Math.pow(2, i);
			System.out.println((int)Math.pow(2, (maxPow2 - i)));
		
			for(int j = 0; j < (int)Math.pow(2, (maxPow2 - i - 1)); j++) {
				drawBranch(g, 10 + i * xOffset, j*pOffset*2 + tOffset, pOffset, new Match(new Team()), new Match(new Team()));
			}
			tOffset += pOffset/2;
		}
		/*drawBranch(g, 10, 20, 25, new Match(new Team()), new Match(new Team()));
		drawBranch(g, 10, 70, 25, new Match(new Team()), new Match(new Team()));
		drawBranch(g, 170, 20 + 25/2, 50, new Match(new Team()), new Match(new Team()));
		drawBranch(g, 330, 20 + 25/2 + 50/2, 100, new Match(new Team()), new Match(new Team()));*/
	}
	
	public void drawBranch(Graphics g, int x, int y, int yOffset, Match m1, Match m2) {
		//Store the team values from the matches
		Team t1 = m1.t; //Team in Match 1
		Team t2 = m2.t; //Team in Match 2
		
		//Offsets for printing
		int lineLength = 150;
		int lineBelow = 4;
		int lineExtend = 10;
		
		//Team 1's Players
		g.drawString(t1.getNames(), x, y);
		g.drawLine(x, y + lineBelow, x + lineLength, y + lineBelow);
		
		//Team 2's Players
		g.drawString(t2.getNames(), x, y + yOffset);
		g.drawLine(x, y + yOffset + lineBelow, x + lineLength, y + yOffset + lineBelow);
		
		//Lines for the end of the bracket structure
		g.drawLine(x + lineLength, y + lineBelow, x + lineLength, y + yOffset + lineBelow);
		g.drawLine(x + lineLength, y + lineBelow + (yOffset / 2), x + lineLength + lineExtend, y + lineBelow + (yOffset / 2));
	}
}
