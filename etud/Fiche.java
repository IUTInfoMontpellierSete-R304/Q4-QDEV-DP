package etud;

/** Une fiche pour regrouper tous les résultats */
public class Fiche {
	private Voiture voiture;
	private float masse;
	private float couple;
	private float vitesseMax;
	private float forceTraction;
	private float acceleration;
	private float tempsCroisiere;
	private float distanceArret;
	private float[] distances60;

	/** Prépare la fiche de la voiture spécifiée. */
	public Fiche(Voiture voiture) {
		this.voiture = voiture;
		distances60 = new float[60];
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public float getMasse() {
		return masse;
	}

	public void setMasse(float masse) {
		this.masse = masse;
	}

	public float getCouple() {
		return couple;
	}

	public void setCouple(float couple) {
		this.couple = couple;
	}

	public float getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(float vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public float getForceTraction() {
		return forceTraction;
	}

	public void setForceTraction(float forceTraction) {
		this.forceTraction = forceTraction;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(float acceleration) {
		this.acceleration = acceleration;
	}

	public float getTempsCroisiere() {
		return tempsCroisiere;
	}

	public void setTempsCroisiere(float tempsCroisiere) {
		this.tempsCroisiere = tempsCroisiere;
	}

	public float getDistanceArret() {
		return distanceArret;
	}

	public void setDistanceArret(float distanceArret) {
		this.distanceArret = distanceArret;
	}

	public float[] getDistances() {
		return distances60;
	}

	public float getDistance(int temps) {
		return distances60[temps];
	}

	public void setDistance(int temps, float distance) {
		this.distances60[temps] = distance;
	}

	/**
	 * Compare les masses de deux voitures. Moins est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareMasse(Fiche autre) {
		return Float.compare(masse, autre.getMasse());
	}

	/**
	 * Compare les couples de deux voitures. Plus est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareCouple(Fiche autre) {
		return -Float.compare(couple, autre.getCouple());
	}

	/**
	 * Compare les vitesses max de deux voitures. Plus est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareVitesseMAx(Fiche autre) {
		return -Float.compare(vitesseMax, autre.getVitesseMax());
	}

	/**
	 * Compare les forces de traction de deux voitures. Plus est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareForceTraction(Fiche autre) {
		return -Float.compare(forceTraction, autre.getForceTraction());
	}

	/**
	 * Compare les accelérations de deux voitures. Plus est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareAcceleration(Fiche autre) {
		return -Float.compare(acceleration, autre.getAcceleration());
	}

	/**
	 * Compare le temps pour arriver à la vitesse de croisière de deux voitures.
	 * Moins est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareTempsCroisiere(Fiche autre) {
		return Float.compare(tempsCroisiere, autre.getTempsCroisiere());
	}

	/**
	 * Compare les distances d'arrêt de deux voitures. Moins est meilleur.
	 * 
	 * @see Float#compare(float, float)
	 */
	public int compareDistanceArret(Fiche autre) {
		return Float.compare(distanceArret, autre.getDistanceArret());
	}

	@Override
	public String toString() {
		return "Fiche de " + voiture.toString();
	}
}
