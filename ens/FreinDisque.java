package ens;
/** Représente des freins à disque */
public class FreinDisque extends DecorateurVoiture {

  /** Décore une voiture avec des freins à disque */
  public FreinDisque(Voiture voiture) {
    super(voiture);
  }

  @Override
  public float getPrix() {
    return super.getPrix() + 150;
  }

  @Override
  public float getMasse() {
    return super.getMasse() + 3;
  }

  @Override
  public float getForceFreinageCst() {
    return super.getForceFreinageCst() + 7.95f; // Pour obtenir une distance de freinage cohérente avec la réalité
  }
}
