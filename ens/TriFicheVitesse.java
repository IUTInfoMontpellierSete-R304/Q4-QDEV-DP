package ens;

/*// Version 1
	public class TriFicheVitesse implements Comparable<TriFicheVitesse> {

	private Fiche fiche;

	public TriFicheVitesse(Fiche fiche) {
		this.fiche = fiche;
	}

	@Override
	public int compareTo(TriFicheVitesse f) {

		if (fiche.getVitesseMax() == f.getFiche().getVitesseMax())
			return 0;
		if (fiche.getVitesseMax() > f.getFiche().getVitesseMax())
			return 1;
		return -1;
	}

	public Fiche getFiche() {
		return this.fiche;
	}

}*/

// Version 2
public class TriFicheVitesse extends Fiche implements Comparable<TriFicheVitesse> {

	public TriFicheVitesse(Fiche f) {
		super(f.getVoiture());
		setVitesseMax(f.getVitesseMax());
	}

	@Override
	public int compareTo(TriFicheVitesse f) {
		if (getVitesseMax() == f.getVitesseMax())
			return 0;
		if (getVitesseMax() > f.getVitesseMax())
			return 1;
		return -1;
	}
}

