import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MatrixReseauRoutier {
	public static double eventsReseau[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0 };

	public static String infoTraficRoute1, infoTraficRoute2, infoTraficRoute3,
			infoTraficRoute4, infoTraficRoute5;
	public static troncon[] axe;
	final static int nombreTroncon = 15; // taille initiale du tableau
	// eventsReseau[] = new double[nombreTroncon];
	// troncon[] axe = new troncon[nombreTroncon]; // création du tableau

	private static int tabTroncon[]= new int[15];

	public static class troncon {
		String nom;
		double longueur;
		int etat;
		double retard;

		public troncon(String nom1, double longueur1, int etat1, double retard1) {
			nom = nom1;
			longueur = longueur1;
			etat = etat1;
			retard = retard1;

		}

		public troncon() {
			nom = " ";
			longueur = 0;
			etat = 0;
			retard = 0;
		}

	}

	public static void chargeTronconEvents() {
		troncon axe[] = new troncon[nombreTroncon];
		for (int i = 0; i < nombreTroncon; i++) {
			axe[i] = new troncon(" ", 0, 0, 0);
			
		}
		for (int i = 0; i < eventsReseau.length; i++) {
			eventsReseau[i]=0;
		}
		
		/*
		 * Choix aleatoire des routes affectees par les evenements Nous prenons
		 * une hypothese de 5 routes affectees aleatoirement dans le reseau
		 */

		/*
		 * Cas 0 fluide. cas 1 congestion entrainant un retard de 2 kms. Cas 2
		 * travaux sur le troncon entrainant un retard de 5 kms . Cas 3 accident
		 * entrainant un retard de 9 kms
		 */
		/*
		 * 5 routes sont tirees au sort et les evenements qui les affectent sont
		 * aussi tires au sort.
		 */
		Random randomGenerator = new Random();
		for (int i = 0; i < 5; i++) {
			int j = randomGenerator.nextInt(15);
			int typeEvent = randomGenerator.nextInt(4);

			switch (typeEvent) {
			case 1:
				eventsReseau[j] = 2;
				break;
			case 2:
				eventsReseau[j] = 5;
				break;
			case 3:
				eventsReseau[j] = 9;
				break;
			default:
			}

		}

		// Chargement des noms et longueurs des axes

		axe[0].nom = "Nationale 1 : Point A - Point B";
		axe[0].longueur = 50.20;
		axe[1].nom = "Nationale 2 : Point A - Point C";
		axe[1].longueur = 59.70;
		axe[2].nom = "Plaisance  : Point A - Point D";
		axe[2].longueur = 78.50;
		axe[3].nom = "Masson-Angers : Point A - Point E";
		axe[3].longueur = 27.10;
		axe[4].nom = "Buckingham : Point A - Point H";
		axe[4].longueur = 32.70;
		axe[5].nom = "Hull : Point A - Point I";
		axe[5].longueur = 22.50;
		axe[6].nom = "Kanata : Point B - Point C";
		axe[6].longueur = 78.50;
		axe[7].nom = "Orleans : Point B - Point D";
		axe[7].longueur = 59.70;
		axe[8].nom = "Montreal Rd : Point B - Point E";
		axe[8].longueur = 27.10;
		axe[9].nom = "Mtee Paiement : Point B - Point G";
		axe[9].longueur = 14.20;
		axe[10].nom = "Mc Arthur Blv : Point B - Point H";
		axe[10].longueur = 32.10;
		axe[11].nom = "Greber : Point C - Point F";
		axe[11].longueur = 19.55;
		axe[12].nom = "La Chute : Point C - Point I";
		axe[12].longueur = 42.10;
		axe[13].nom = "Greenville : Point D - Point F ";
		axe[13].longueur = 41.13;
		axe[14].nom = "Orleans : Point D - Point G";
		axe[14].longueur = 65.24;
		// Chargement des evenements survenus
		for (int i = 0; i < axe.length; i++) {
			axe[i].retard = eventsReseau[i];
		}
		 
		//
		for (int i = 0; i < eventsReseau.length; i++) {
			switch ((int) eventsReseau[i]) {
			case 2:
				axe[i].etat = 1;
			

				break;// congestion
			case 5:
				axe[i].etat = 2;

				break;// travaux
			case 9:
				axe[i].etat = 3;

				break;// accident
			default:
			}
			 
			tabTroncon[i]=axe[i].etat;
			 
			map map = new map();
		}  map.evenement(tabTroncon);

		// Charger les infos du trafic
		int compteurInfo = 1;
		infoTraficRoute1 = " ";
		infoTraficRoute2 = " ";
		infoTraficRoute3 = " ";
		infoTraficRoute4 = " ";
		infoTraficRoute5 = " ";
		for (int i = 0; i < eventsReseau.length; i++) {
			if (eventsReseau[i] > 0) {
				if (compteurInfo == 1) {
					switch ((int) eventsReseau[i]) {
					case 2:
						infoTraficRoute1 = axe[i].nom + " Congestion. Retard "
								+ axe[i].retard + " kms";
						break;// congestion
					case 5:
						infoTraficRoute1 = axe[i].nom + " Travaux. Retard "
								+ axe[i].retard + " kms";
						break;// travaux
					case 9:
						infoTraficRoute1 = axe[i].nom + " Accident. Retard "
								+ axe[i].retard + " kms";
						break;// accident
					default:
					}
				}
				if (compteurInfo == 2) {
					switch ((int) eventsReseau[i]) {
					case 2:
						infoTraficRoute2 = axe[i].nom + " Congestion. Retard "
								+ axe[i].retard + " kms";
						break;// congestion
					case 5:
						infoTraficRoute2 = axe[i].nom + " Travaux. Retard "
								+ axe[i].retard + " kms";
						break;// travaux
					case 9:
						infoTraficRoute2 = axe[i].nom + " Accident. Retard "
								+ axe[i].retard + " kms";
						break;// accident
					default:
					}
				}
				if (compteurInfo == 3) {
					switch ((int) eventsReseau[i]) {
					case 2:
						infoTraficRoute3 = axe[i].nom + " Congestion. Retard "
								+ axe[i].retard + " kms";
						break;// congestion
					case 5:
						infoTraficRoute3 = axe[i].nom + " Travaux. Retard "
								+ axe[i].retard + " kms";
						break;// travaux
					case 9:
						infoTraficRoute3 = axe[i].nom + " Accident. Retard "
								+ axe[i].retard + " kms";
						break;// accident
					default:
					}
				}
				if (compteurInfo == 4) {
					switch ((int) eventsReseau[i]) {
					case 2:
						infoTraficRoute4 = axe[i].nom + " Congestion. Retard "
								+ axe[i].retard + " kms";
						break;// congestion
					case 5:
						infoTraficRoute4 = axe[i].nom + " Travaux. Retard "
								+ axe[i].retard + " kms";
						break;// travaux
					case 9:
						infoTraficRoute4 = axe[i].nom + " Accident. Retard "
								+ axe[i].retard + " kms";
						break;// accident
					default:
					}
				}
				if (compteurInfo == 5) {
					switch ((int) eventsReseau[i]) {
					case 2:
						infoTraficRoute5 = axe[i].nom + " Congestion. Retard "
								+ axe[i].retard + " kms";
						break;// congestion
					case 5:
						infoTraficRoute5 = axe[i].nom + " Travaux. Retard "
								+ axe[i].retard + " kms";
						break;// travaux
					case 9:
						infoTraficRoute5 = axe[i].nom + " Accident. Retard "
								+ axe[i].retard + " kms";
						break;// accident
					default:
					}
				}

				compteurInfo++;
			}
		}
	}

	//

	public static List<Vertex> loader(String param1, String param2) {
		Vertex par_source = new Vertex(param1);
		Vertex par_but = new Vertex(param2);
		Vertex v0 = new Vertex("Point A");// "Route A-A"
		Vertex v1 = new Vertex("Point B");// "Route A-B"
		Vertex v2 = new Vertex("Point C");// "Route A-C"
		Vertex v3 = new Vertex("Point D");// "Route A-D"
		Vertex v4 = new Vertex("Point E");// "Route A-E"
		Vertex v5 = new Vertex("Point F");// "Route A-H"
		Vertex v6 = new Vertex("Point G");// "Route B-C"
		Vertex v7 = new Vertex("Point H");// "Route B-D"
		Vertex v8 = new Vertex("Point I");// ("Route B-E");

		// chemin retour plus long de 1km que chemin aller

		v0.adjacencies = new Edge[] { new Edge(v1, eventsReseau[0] + 50.20),
				new Edge(v2, eventsReseau[1] + 59.70),
				new Edge(v3, eventsReseau[2] + 78.50),
				new Edge(v4, eventsReseau[3] + 27.10),
				new Edge(v7, eventsReseau[6] + 32.70),
				new Edge(v8, eventsReseau[7] + 22.50) };
		v1.adjacencies = new Edge[] { new Edge(v0, eventsReseau[1] + 50.20),
				new Edge(v2, eventsReseau[1] + 78.50),
				new Edge(v3, eventsReseau[2] + 59.70),
				new Edge(v4, eventsReseau[3] + 27.10),
				new Edge(v6, eventsReseau[7] + 14.25),
				new Edge(v7, eventsReseau[6] + 32.12) };
		v2.adjacencies = new Edge[] { new Edge(v0, eventsReseau[1] + 60.70),
				new Edge(v1, 79.50), new Edge(v5, 19.55), new Edge(v8, 42.31) };
		v3.adjacencies = new Edge[] { new Edge(v0, 79.50), new Edge(v1, 60.70),
				new Edge(v5, 41.13), new Edge(v6, 65.24) };
		v4.adjacencies = new Edge[] { new Edge(v0, 27.10), new Edge(v1, 28.10) };
		v5.adjacencies = new Edge[] { new Edge(v2, 43.31), new Edge(v3, 42.13) };
		v6.adjacencies = new Edge[] { new Edge(v1, 15.25), new Edge(v3, 66.24) };
		v7.adjacencies = new Edge[] { new Edge(v0, 33.70), new Edge(v1, 33.12) };
		v8.adjacencies = new Edge[] { new Edge(v0, 23.50), new Edge(v2, 43.31) };
		Vertex[] vertices = { v0, v1, v2, v3, v4, v5, v6, v7, v8 };

		int select = 0;
		if (par_source.name == v0.name) {
			select = 0;
			DijkstraPath.computePaths(v0);
		} else {
			if (par_source.name == v1.name) {
				select = 1;
				DijkstraPath.computePaths(v1);
			} else {
				if (par_source.name == v2.name) {
					select = 2;
					DijkstraPath.computePaths(v2);
				} else {
					if (par_source.name == v3.name) {
						select = 3;
						DijkstraPath.computePaths(v3);
					} else {
						if (par_source.name == v4.name) {
							select = 4;
							DijkstraPath.computePaths(v4);
						} else if (par_source.name == v5.name) {
							select = 5;
							DijkstraPath.computePaths(v5);
						} else {
							if (par_source.name == v6.name) {
								select = 6;
								DijkstraPath.computePaths(v6);
							} else {
								if (par_source.name == v7.name) {
									select = 7;
									DijkstraPath.computePaths(v7);
								} else {
									if (par_source.name == v8.name) {
										select = 8;
										DijkstraPath.computePaths(v8);
									}
								}
							}
						}
					}
				}
			}
		}

		List<Vertex> path = Collections.emptyList();
		// for (Vertex v : vertices){
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].name == par_but.name) {
				// System.out.println("Distance to " + vertices[i] + ": " +
				// vertices[i].minDistance);
				path = DijkstraPath.getShortestPathTo(vertices[i]);
				// System.out.println("Path: " + path);
			}
		}

		return path;
	}

}
