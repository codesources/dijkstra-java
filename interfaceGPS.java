import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class interfaceGPS {

	private JFrame frame;
	static String var_source, var_target;
	List<Vertex> chemin_optimal;
	map panel = new map();
	JLabel lblInfotrafic1, lblInfotrafic2, lblInfotrafic3, lblInfotrafic4,
			lblInfotrafic5;
	private String pointCourant;
	String pointPrecedent;
	int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

	// Coordonnees geographiques des intersections du reseau routier

	int xA = 105;
	int yA = 75;

	int xB = 305;
	int yB = 75;

	int xC = 105;
	int yC = 300;

	int xD = 305;
	int yD = 305;

	int xE = 200;
	int yE = 45;

	int xF = 155;
	int yF = 355;

	int xG = 350;
	int yG = 55;

	int xH = 205;
	int yH = 145;

	int xI = 50;
	int yI = 145;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaceGPS window = new interfaceGPS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfaceGPS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("GPS");
		frame.setBounds(100, 100, 1038, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel.setBounds(519, 11, 464, 379);
		frame.getContentPane().add(panel);

		// === Depart
		final JLabel labelText = new JLabel("Depart");
		labelText.setBounds(145, 69, 89, 23);
		frame.getContentPane().add(labelText);
		//
		JButton btnItineraireOptimal = new JButton(
				"Veuillez suivre l'itineraire ");
		btnItineraireOptimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnItineraireOptimal.setBounds(22, 280, 205, 23);
		frame.getContentPane().add(btnItineraireOptimal);

		final JLabel lblItineraireoptimal = new JLabel("... ");
		lblItineraireoptimal.setBounds(239, 277, 248, 28);
		frame.getContentPane().add(lblItineraireoptimal);
		//

		String[] noeudlabel = { "Depart", "Point A", "Point B", "Point C",
				"Point D", "Point E", "Point F", "Point G", "Point H",
				"Point I" };

		// Selection du point de Depart
		final JComboBox departBox = new JComboBox(noeudlabel);
		departBox.setSelectedIndex(0);
		departBox.setBounds(22, 70, 89, 20);
		frame.getContentPane().add(departBox);
		departBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == departBox) {
					JComboBox departChoix = (JComboBox) e.getSource();
					String afficher = (String) departChoix.getSelectedItem();
					//
					Vertex depart = new Vertex(afficher);
					var_source = afficher;

					//
					switch (afficher) {
					case "Depart":
						labelText.setText("Point depart");
						break;

					case "Point A":
						labelText.setText("Point A");
						break;

					case "Point B":
						labelText.setText("Point B");
						break;

					case "Point C":
						labelText.setText("Point C");
						break;

					case "Point D":
						labelText.setText("Point D");
						break;

					case "Point E":
						labelText.setText("Point E");
						break;

					case "Point F":
						labelText.setText("Point F");
						break;

					case "Point G":
						labelText.setText("Point G");
						break;

					case "Point H":
						labelText.setText("Point H");
						break;

					case "Point I":
						labelText.setText("Point I");
						break;

					default:
						labelText.setText(" ");

					}

				}
			}
		});

		// Selection du point Arrivee

		final JLabel labelText2 = new JLabel("Arrivee");
		labelText2.setBounds(145, 235, 89, 28);
		frame.getContentPane().add(labelText2);
		String[] noeudlabel2 = { "Arrivee", "Point A", "Point B", "Point C",
				"Point D", "Point E", "Point F", "Point G", "Point H",
				"Point I" };
		final JComboBox arriveeBox = new JComboBox(noeudlabel2);
		arriveeBox.setSelectedIndex(0);
		arriveeBox.setBounds(22, 239, 89, 20);
		frame.getContentPane().add(arriveeBox);
		arriveeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == arriveeBox) {
					JComboBox arriveeChoix = (JComboBox) e.getSource();
					String afficher = (String) arriveeChoix.getSelectedItem();
					//
					Vertex arrivee = new Vertex(afficher);
					var_target = afficher;

					switch (afficher) {
					case "Arrivee":
						labelText2.setText("Point d'arrivee");
						break;

					case "Point A":
						labelText2.setText("Point A");
						break;

					case "Point B":
						labelText2.setText("Point B");
						break;

					case "Point C":
						labelText2.setText("Point C");
						break;

					case "Point D":
						labelText2.setText("Point D");
						break;

					case "Point E":
						labelText2.setText("Point E");
						break;

					case "Point F":
						labelText2.setText("Point F");
						break;

					case "Point G":
						labelText2.setText("Point G");
						break;

					case "Point H":
						labelText2.setText("Point H");
						break;

					case "Point I":
						labelText2.setText("Point I");
						break;

					default:
						labelText2.setText(" ");

					}
					// Recherche du chemin optimal sans evenement survenu sur le
					// reseau
					chemin_optimal = MatrixReseauRoutier.loader(var_source,
							var_target);

					lblItineraireoptimal.setText(chemin_optimal.toString());
					itineraire();
				}
			}
		});

		JButton btnPointDeDepart = new JButton("Depart");
		btnPointDeDepart.setBounds(22, 22, 89, 23);
		frame.getContentPane().add(btnPointDeDepart);

		JButton btnArrivee = new JButton("Arrivee");
		btnArrivee.setBounds(22, 192, 89, 23);
		frame.getContentPane().add(btnArrivee);

		String[] reseau = { "Reseau Routier",
				"Nationale 1 : Point A - Point B    50.20 kms",
				"Nationale 2 : Point A - Point C    59.70 kms",
				"Plaisance  : Point A - Point D    78.50 kms",
				"Masson-Angers : Point A - Point E    27.10 kms",
				"Buckingham : Point A - Point H    32.70 kms",
				"Hull : Point A - Point I    22.50 kms",
				"Kanata : Point B - Point C    78.50 kms",
				"Orleans : Point B - Point D    59.70 kms",
				"Montreal Rd : Point B - Point E    27.10 kms",
				"Mtee Paiement : Point B - Point G     14.2 kms",
				"Mc Arthur Blv : Point B - Point H    32.10 kms",
				"Greber : Point C - Point F    19.55 kms",
				"La Chute : Point C - Point I     42.31 kms",
				"Greenville : Point D - Point F    41.13 kms",
				"Orleans : Point D - Point G    65.24 kms", };

		final JComboBox reseauBox = new JComboBox(reseau);
		reseauBox.setBounds(174, 25, 313, 33);
		frame.getContentPane().add(reseauBox);
		reseauBox.setSelectedIndex(0);

		final JButton btnValide = new JButton("Evenements");
		btnValide.setBounds(22, 327, 106, 23);
		frame.getContentPane().add(btnValide);

		lblInfotrafic2 = new JLabel("New Llabel");
		lblInfotrafic2.setText("...");
		lblInfotrafic2.setBounds(138, 352, 360, 23);
		frame.getContentPane().add(lblInfotrafic2);

		lblInfotrafic1 = new JLabel("infotrafic1");
		lblInfotrafic1.setText("...");
		lblInfotrafic1.setBounds(138, 327, 371, 23);
		frame.getContentPane().add(lblInfotrafic1);

		lblInfotrafic3 = new JLabel("infotrafic3");
		lblInfotrafic3.setText("...");
		lblInfotrafic3.setBounds(138, 374, 371, 28);
		frame.getContentPane().add(lblInfotrafic3);

		lblInfotrafic4 = new JLabel("infotrafic4");
		lblInfotrafic4.setText("...");
		lblInfotrafic4.setBounds(138, 403, 371, 28);
		frame.getContentPane().add(lblInfotrafic4);

		lblInfotrafic5 = new JLabel("infotrafic5");
		lblInfotrafic5.setText("...");
		lblInfotrafic5.setBounds(138, 431, 371, 26);
		frame.getContentPane().add(lblInfotrafic5);

		JPanel pAccident = new JPanel();
		pAccident.setBounds(611, 421, 30, 23);
		frame.getContentPane().add(pAccident);

		JPanel pTravaux = new JPanel();
		pTravaux.setBounds(709, 421, 30, 23);
		frame.getContentPane().add(pTravaux);

		JPanel pCongestion = new JPanel();
		pCongestion.setBounds(790, 421, 30, 23);
		frame.getContentPane().add(pCongestion);

		JLabel lblNewLabel = new JLabel("Accident");
		lblNewLabel.setBounds(598, 401, 67, 14);
		pAccident.setBackground(Color.RED);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Travaux");
		lblNewLabel_1.setBounds(703, 401, 46, 14);
		pTravaux.setBackground(Color.ORANGE);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Congestion");
		lblNewLabel_2.setBounds(775, 401, 77, 14);
		pCongestion.setBackground(Color.PINK);
		frame.getContentPane().add(lblNewLabel_2);

		btnValide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatrixReseauRoutier.chargeTronconEvents();

				// relance dijkstra a la survenu des evenements sur le reseau

				chemin_optimal = MatrixReseauRoutier.loader(var_source,
						var_target);
				lblItineraireoptimal.setText(chemin_optimal.toString());
				//
				lblInfotrafic1.setText(MatrixReseauRoutier.infoTraficRoute1);
				lblInfotrafic2.setText(MatrixReseauRoutier.infoTraficRoute2);
				lblInfotrafic3.setText(MatrixReseauRoutier.infoTraficRoute3);
				lblInfotrafic4.setText(MatrixReseauRoutier.infoTraficRoute4);
				lblInfotrafic5.setText(MatrixReseauRoutier.infoTraficRoute5);

				itineraire();

			}

		});

		//

	}

	public void itineraire() {
		/*
		 * Cette methode permet de parcourir le chemein optimal issu de vertex
		 * avec ses coordonnees geographiques associees et de faire la jonction
		 * visuelle au niveau de l'interface reseau.
		 */
		pointCourant = null;

		// declarer un tableau de chemin_optimal.size() a 4
		int tabChemin[][] = new int[chemin_optimal.size()][4];

		try {
			for (int i = 0; i < chemin_optimal.size(); i++) {

				if (i == 0) {
					pointCourant = chemin_optimal.get(i).name;
				} else {
					pointPrecedent = chemin_optimal.get(i).name;

					// Identifier le point courant
					switch (pointCourant) {
					case "Point A":
						x1 = xA;
						y1 = yA;
						break;
					case "Point B":
						x1 = xB;
						y1 = yB;
						break;
					case "Point C":
						x1 = xC;
						y1 = yC;
						break;
					case "Point D":
						x1 = xD;
						y1 = yD;
						break;
					case "Point E":
						x1 = xE;
						y1 = yE;
						break;
					case "Point F":
						x1 = xF;
						y1 = yF;
						break;
					case "Point G":
						x1 = xG;
						y1 = yG;
						break;
					case "Point H":
						x1 = xH;
						y1 = yH;
						break;
					case "Point I":
						x1 = xI;
						y1 = yI;
						break;

					}
					// Identifier le point precedent
					switch (pointPrecedent) {
					case "Point A":
						x2 = xA;
						y2 = yA;
						break;
					case "Point B":
						x2 = xB;
						y2 = yB;
						break;
					case "Point C":
						x2 = xC;
						y2 = yC;
						break;
					case "Point D":
						x2 = xD;
						y2 = yD;
						break;
					case "Point E":
						x2 = xE;
						y2 = yE;
						break;
					case "Point F":
						x2 = xF;
						y2 = yF;
						break;
					case "Point G":
						x2 = xG;
						y2 = yG;
						break;
					case "Point H":
						x2 = xH;
						y2 = yH;
						break;
					case "Point I":
						x2 = xI;
						y2 = yI;
						break;

					}
					// relier les 2 points precedent et courant

					panel.maps(x1, y1, x2, y2);
					// mettre
					tabChemin[i][0] = x1;
					tabChemin[i][1] = y1;
					tabChemin[i][2] = x2;
					tabChemin[i][3] = y2;

					panel.repaint();
					pointCourant = pointPrecedent;
				}
			}
			panel.tab(tabChemin);
		} catch (NullPointerException e) {
			System.err.println("erreur boucle line 320 " + e.getClass());
		}
	}
}
