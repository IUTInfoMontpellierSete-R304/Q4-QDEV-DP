package etud;

/** Représente une voiture de course */
public interface Voiture {
	/**
	 * Retourne le prix de cette voiture.
	 * 
	 * @return le prix en euros
	 */
	float getPrix();

	/**
	 * Retourne la masse de cette voiture.
	 * 
	 * @return la masse en Kilogrammes
	 */
	float getMasse();

	/**
	 * Retourne la puissance du moteur.
	 * 
	 * @return la puissance du moteur en Chevaux-DIN
	 */
	float getPuissanceMoteur();

	/**
	 * Retourne le régime optimal (vitesse de fonctionnement "normal" du moteur)
	 * 
	 * @return le régime optimal en tours par minute
	 */
	float getRegimeOptimal();

	/**
	 * Retourne la force de freinage indépendante de la vitesse.
	 * 
	 * @return la force de freinage en Newtons
	 */
	float getForceFreinageCst();

	/**
	 * Retourne le coefficient de freinage proportionnel à la vitesse.
	 * 
	 * @return le coefficient B tel que F=-B*V
	 */
	float getCoeffFreinageProp();

	/**
	 * Retourne la démultiplication moteur/roues
	 * 
	 * @return 1/2 si les roues à la moitié de la vitesse du moteur
	 */
	float getRapportRouesMoteur();

	/**
	 * Retourne le rayon des roues.
	 * 
	 * @return le rayon des roues en mètres
	 */
	float getRayonRoues();

}
