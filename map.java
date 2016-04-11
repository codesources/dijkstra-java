import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class map extends JPanel {

	String pointCourant = null, pointPrecedent;

	int tab[][];
	static int tabEtat[] = new int[15];
	int x1, y1, x2, y2;

	static final int xA = 105, yA = 75,

	xB = 305, yB = 75,

	xC = 105, yC = 300,

	xD = 305, yD = 305,

	xE = 200, yE = 45,

	xF = 155, yF = 355,

	xG = 350, yG = 55,

	xH = 205, yH = 145,

	xI = 50, yI = 145;

	int tabTroncon[][] = { { xA, yA, xB, yB }, { xA, yA, xC, yC },
			{ xA, yA, xD, yD }, { xA, yA, xE, yE }, { xA, yA, xH, yH },
			{ xA, yA, xI, yI }, { xB, yB, xC, yC }, { xB, yB, xD, yD },
			{ xB, yB, xE, yE }, { xB, yB, xG, yG }, { xB, yB, xH, yH },
			{ xC, yC, xF, yF }, { xC, yC, xI, yI }, { xD, yD, xF, yF },
			{ xD, yD, xG, yG } };

	public map() {

	}

	public void maps(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

	}

	public void tab(int[][] tab) {
		this.tab = tab;
	}

	public void initialisation(Graphics g) {

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 465, 379);
		g.setColor(Color.BLACK);
		// x y gy gx
		// Les points
		g.fillOval(100, 70, 10, 10);// point A
		g.fillOval(300, 70, 10, 10); // Point B
		g.fillOval(100, 300, 10, 10); // Point C
		g.fillOval(300, 300, 10, 10); // Point D
		g.fillOval(200, 40, 10, 10); // Point E
		g.fillOval(350, 50, 10, 10); // Point G
		g.fillOval(150, 350, 10, 10); // Point F
		g.fillOval(200, 140, 10, 10); // Point H
		g.fillOval(50, 140, 10, 10); // Point I
		// Les intersections
		g.drawString("Point A", 60, 70);
		g.drawString("Point B", 290, 55);
		g.drawString("Point C", 60, 300);
		g.drawString("Point D", 310, 315);
		g.drawString("Point E", 205, 35);
		g.drawString("Point F", 165, 365);
		g.drawString("Point G", 355, 50);
		g.drawString("Point H", 185, 165);
		g.drawString("Point I", 15, 140);

		// Les troncons ou arcs
		g.drawLine(105, 70, 205, 145); // point A vers H
		g.drawLine(105, 70, 50, 145); // point A vers I
		g.drawLine(305, 70, 305, 300); // point B vers D
		g.drawLine(305, 70, 205, 40); // point B vers E
		g.drawLine(305, 70, 350, 55); // oint B vers G
		g.drawLine(105, 75, 305, 300); // Poin A vers D
		g.drawLine(350, 55, 305, 305); // Poin A vers D
		g.drawLine(105, 75, 305, 75);// Point A vers B
		g.drawLine(305, 70, 205, 145);// Point B vers C
		g.drawLine(50, 145, 105, 300);// Point I vers C==
		g.drawLine(105, 70, 205, 145);// Point C vers
		g.drawLine(105, 305, 105, 70);// Point C vers D
		g.drawLine(155, 355, 305, 305);// Point F vers D
		g.drawLine(105, 305, 155, 355);// Point C vers F
		g.drawLine(105, 75, 200, 45);// Point A vers E
		g.drawLine(305, 75, 105, 305);// Point B vers C

	}

	public void paintComponent(Graphics g) {
		// Materialisation par le dessin des evenements survenus sur le reseau
		// routier
		Graphics2D g2 = (Graphics2D) g;
		BasicStroke line = new BasicStroke(2.0f);
		g2.setStroke(line);

		initialisation(g2);
		try {
			for (int i = 0; i < tab.length; i++) {

				g2.setColor(Color.GREEN);
				g2.drawLine(tab[i][0], tab[i][1], tab[i][2], tab[i][3]);

			}
			for (int i = 0; i < 15; i++) {

				if (tabEtat[i] == 1) {
					g.setColor(Color.PINK);
					g.drawLine(tabTroncon[i][0] - 4, tabTroncon[i][1] - 4,
							tabTroncon[i][2] - 4, tabTroncon[i][3] - 4);
				}// Congestion
				if (tabEtat[i] == 2) {
					g.setColor(Color.ORANGE);
					g.drawLine(tabTroncon[i][0] + 2, tabTroncon[i][1] + 2,
							tabTroncon[i][2] + 2, tabTroncon[i][3] + 2);
				}// Travaux
				if (tabEtat[i] == 3) {
					g.setColor(Color.RED);
					g.drawLine(tabTroncon[i][0] - 2, tabTroncon[i][1] - 2,
							tabTroncon[i][2] - 2, tabTroncon[i][3] - 2);

				}// Accident
			}
		} catch (NullPointerException e) {

		}

	}

	// Cette methode permet de recuperer la
	public static void evenement(int[] tabT) {
		// TODO Auto-generated method stub
		tabEtat = tabT;

	}

}
