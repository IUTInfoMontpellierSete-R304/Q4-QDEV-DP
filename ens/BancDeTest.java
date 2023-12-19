package ens;

import java.util.Collections;
import java.util.LinkedList;

public class BancDeTest {

	private LinkedList<Fiche> fiches;

	public BancDeTest() {
		fiches = new LinkedList<>();
	}

	public void ajouterVoiture(Voiture voitureATester) {
		fiches.add(new Fiche(voitureATester));
	}

	public LinkedList<Fiche> lancerTests() {
		int i = 1;
		for (Fiche fiche : fiches) {
			
			System.out.println("====================================");
			
			System.out.println("Voiture " + (i++) + " : ");
			Voiture voiture = fiche.getVoiture();
			DynamiqueVoiture dynamique = new DynamiqueVoiture(voiture);
			float masse = voiture.getMasse();
			System.out.println("Masse = " + masse);
			float regimeOptimal = voiture.getRegimeOptimal();
			float coupleMoteur = dynamique.getCoupleMoteur(regimeOptimal);
			System.out.println("Couple = " + coupleMoteur);
			float vitesse = dynamique.getVitesse(regimeOptimal);
			System.out.println("Vitesse max = " + vitesse);
			float force = dynamique.getForce(regimeOptimal);
			System.out.println("Force = " + force);
			float acceleration = dynamique.getAcceleration(regimeOptimal);
			System.out.println("Accelération = " + acceleration);
			float tempsCroisiere = dynamique.getTempsCroisiere(regimeOptimal);
			System.out.println("Temps nécessaire = " + tempsCroisiere);
			for (int t = 0; t < 60; ++t) {
				float distanceParcourue = dynamique.getDistanceParcourue(regimeOptimal, t);
				System.out.println("t=" + t + " \t " + distanceParcourue + " m");
				fiche.setDistance(t, distanceParcourue);
			}
			float distanceArret = dynamique.getDistanceArret(vitesse);
			System.out.println("Distance d'arrêt = " + distanceArret);
			fiche.setAcceleration(acceleration);
			fiche.setCouple(coupleMoteur);
			fiche.setDistanceArret(distanceArret);
			fiche.setForceTraction(force);
			fiche.setMasse(masse);
			fiche.setTempsCroisiere(tempsCroisiere);
			fiche.setVitesseMax(vitesse);
		}
		return fiches;
	}

	public static void main(String[] args) {
		BancDeTest tests = new BancDeTest();
		Voiture voiture;
		voiture = new MoteurEssence(new Chassis());
		tests.ajouterVoiture(voiture);
		voiture = new MoteurDiesel(new Chassis());
		tests.ajouterVoiture(voiture);
		voiture = new FreinDisque(new MoteurEssence(new Chassis()));
		tests.ajouterVoiture(voiture);
		voiture = new FreinFoucault(new MoteurEssence(new Chassis()));
		tests.ajouterVoiture(voiture);
		voiture = new FreinDisque(new FreinFoucault(new MoteurEssence(new Chassis())));
		tests.ajouterVoiture(voiture);

		LinkedList<Fiche> resultats = tests.lancerTests();
		System.out.println("===============Fiches non triées=====================");

		tests.fiches.forEach(v -> System.out.println(v));

		System.out.println("===============Tri avec comparateur dans Fiche=====================");

		Collections.sort(resultats, (ficheResultat, autre) -> ficheResultat.compareAcceleration(autre));
		
		resultats.forEach(v -> System.out.println(v));

		System.out.println("===============Tri avec comparateur dans TriFicheVitesse=====================");

		LinkedList<TriFicheVitesse> resultatsTri = new LinkedList<>();

		for(Fiche f : resultats) {
			resultatsTri.add(new TriFicheVitesse(f));
		}

//		Collections.sort(resultatsTri, (ficheResultat, autre) -> ficheResultat.compareTo(autre));
		Collections.sort(resultatsTri, TriFicheVitesse::compareTo);

		resultatsTri.forEach(v -> System.out.println(v));

	}
}
