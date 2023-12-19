package ens;
/** Représente un moteur diesel */
public class MoteurDiesel extends DecorateurVoiture {
  /** Décore une voiture avec un moteur diesel */
  public MoteurDiesel(Voiture voiture) {
    super(voiture);
  }

  @Override
  public float getMasse() {
    return super.getMasse() + 500;
  }

  @Override
  public float getPuissanceMoteur() {
    return super.getPuissanceMoteur() + 150;
  }

  @Override
  public float getRegimeOptimal() {
    return 2000;
  }
}
