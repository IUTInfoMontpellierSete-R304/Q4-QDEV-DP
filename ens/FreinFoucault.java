package ens;
/** Représente des freins à courant de foucault */
public class FreinFoucault extends DecorateurVoiture {

  /** Décore une voiture avec des freins à disque */
  public FreinFoucault(Voiture voiture) {
    super(voiture);
  }

  @Override
  public float getPrix() {
    return super.getPrix() + 500;
  }

  @Override
  public float getMasse() {
    return super.getMasse() + 2;
  }

  @Override
  public float getCoeffFreinageProp() {
    return super.getCoeffFreinageProp() + 0.5f;
  }
}
