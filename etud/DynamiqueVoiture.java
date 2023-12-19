package etud;

/** Calcule la dynamique d'une voiture */
public class DynamiqueVoiture {
	Voiture voiture;

	public DynamiqueVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	// Puissance (cv) = Couple(Nm)*Regime(tr/min)/7000
	// Couple(Nm) = Puissance * 7000 / Regime(tr/min)
	// F (N) = C (Nm) / rayon (m)

	/**
	 * Retourne la vitesse de la voiture en fonction du régime moteur
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @return la vitesse de la voiture en km/h
	 */
	public float getVitesse(float regimeMoteur) {
		float regimeRoues = regimeMoteur * voiture.getRapportRouesMoteur();
		float perimetreRoues = (float) (2 * Math.PI * voiture.getRayonRoues());
		return regimeRoues * perimetreRoues * 60 / 1000; // 60 minutes par heure, 1000m par km.
	}

	/**
	 * Retourne le couple du moteur en fonction de son régime moteur
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @return le couple en Newtons-Mètres
	 */
	public float getCoupleMoteur(float regimeMoteur) {
		return voiture.getPuissanceMoteur() * 7000 / regimeMoteur;
	}

	/**
	 * Retourne la force de traction de la voiture en fonction du régime moteur
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @return la force de traction en Newtons
	 */
	public float getForce(float regimeMoteur) {
		float coupleMoteur = voiture.getPuissanceMoteur() * 7000 / regimeMoteur;
		float coupleRoues = coupleMoteur / voiture.getRapportRouesMoteur();
		return coupleRoues / voiture.getRayonRoues();
	}

	/**
	 * Retourne l'accelération de la voiture à un régime donné
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @return l'accelération en m/s/s
	 */
	public float getAcceleration(float regimeMoteur) {
		float force = getForce(regimeMoteur);
		return force / voiture.getMasse();
	}

	/**
	 * Retourne le temps nécessaire pour atteindre la vitesse de croisière pour un
	 * régime moteur donné en partant de l'arrêt complet.
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @return le temps en secondes pour atteindre la vitesse de croisière
	 */
	public float getTempsCroisiere(float regimeMoteur) {
		// F = m*a
		// v = a*t
		float force = getForce(regimeMoteur);
		float accel = force / voiture.getMasse();
		float vitesse = getVitesse(regimeMoteur) * 1000 / 3600; // 1000m par km, 3600 sec par heure
		return vitesse / accel;
	}

	/**
	 * Retourne la distance parcourue en mètres en fonction du régime moteur et du
	 * temps, départ arrêté
	 * 
	 * @param regimeMoteur la vitesse de rotation du moteur en tr/min
	 * @param temps        la durée du parcours en secondes
	 * @return la distance parcourue en m, départ arrêté
	 */
	public float getDistanceParcourue(float regimeMoteur, float temps) {
		// d = v*t = 1/2*a*t*t si acceleration constante
		float force = getForce(regimeMoteur);
		float accel = force / voiture.getMasse();
		float tc = getTempsCroisiere(regimeMoteur) * 1000 / 3600; // 1000m par km, 3600 sec par heure
		if (temps < tc)
			return 0.5f * accel * temps * temps;
		else {
			float vitesse = getVitesse(regimeMoteur);
			return 0.5f * accel * tc * tc + vitesse * (temps - tc);
		}
	}

	/**
	 * Retourne la distance parcourue pendant un arrêt d'urgence.
	 * 
	 * @param vitesse la vitesse initiale en km/h
	 * @return le distance en mètres pour atteindre une vitesse nulle.
	 */
	public float getDistanceArret(float vitesse) {
		vitesse = vitesse / 3.6f; // En mètres/secondes
		if (voiture.getCoeffFreinageProp() == 0) {
			// f = m.d
			// v = v0 - d.t
			// tf = v0/d
			// dist = v0.t - 1/2 d.t²
			float deceleration = voiture.getForceFreinageCst() / voiture.getMasse();
			float tf = vitesse / deceleration;
			return vitesse * tf - 0.5f * deceleration * tf * tf;
		} else {
			// a(t) = -B.v(t) -F => Thanks to Wolfram Alpha
			// dist(t) = (F-F*exp(-B*t) - B*F*t + B*v0 + B*v0*exp(-B*t))/B/B
			// v(t) = (F - F*exp(B*t) + B*v0) / B / exp(B*t)
			// v(tf) = 0 => tf=ln((B*v0)/F + 1) / B (Thanks to Wolfram Alpha)
			double tf = Math.log(1 + (voiture.getCoeffFreinageProp() * vitesse / voiture.getForceFreinageCst()));
			double exp = Math.exp(-voiture.getCoeffFreinageProp() * tf);
			return (float) ((voiture.getCoeffFreinageProp() * vitesse * (1 - exp)
					+ voiture.getForceFreinageCst() * (1 - exp)
					- voiture.getCoeffFreinageProp() * voiture.getForceFreinageCst() * tf)
					/ voiture.getCoeffFreinageProp() / voiture.getCoeffFreinageProp());
		}
	}
}
