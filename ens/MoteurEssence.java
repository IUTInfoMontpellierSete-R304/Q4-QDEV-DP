package ens;
/** Représente un moteur à essence */
public class MoteurEssence extends DecorateurVoiture {
  /** Décore la voiture spécifiée avec un moteur à essence */
  public MoteurEssence(Voiture voiture) {
    super(voiture);
  }

  @Override
  public float getMasse() {
    return super.getMasse() + 300;
  }

  @Override
  public float getPuissanceMoteur() {
    return super.getPuissanceMoteur() + 115;
  }

  @Override
  public float getRegimeOptimal() {
    return 4000;
  }
}
