package etud;
/** Représente le chassis d'une voiture. Classe de base à décorer... */
public class Chassis implements Voiture {
	@Override
	public float getMasse() {
		return 700;
	}

	@Override
	public float getPuissanceMoteur() {
		return 0;
	}

	@Override
	public float getRegimeOptimal() {
		return 0;
	}

	@Override
	public float getForceFreinageCst() {
		return 0.00001f; // frottement sur la route
	}

	@Override
	public float getCoeffFreinageProp() {
		return 0;
	}

	@Override
	public float getRapportRouesMoteur() {
		return 1.f / 3.8f; // 1/16f en moyenne pour la première vitesse d'une voiture de tourisme (d'apres
							// ADILCA)
		// environ 1/3.8 pour la 5° vitesse
	}

	@Override
	public float getRayonRoues() {
		return 0.3f; // 14*0.0127f; // 14 pouces de diamètre
	}

	@Override
	public float getPrix() {
		return 3000;
	}

	@Override
	public String toString() {
		return "Chassis";
	}
}
