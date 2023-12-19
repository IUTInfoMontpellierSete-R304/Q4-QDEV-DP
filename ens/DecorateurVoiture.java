package ens;
public abstract class DecorateurVoiture implements Voiture {
  private Voiture interne;
  public DecorateurVoiture(Voiture voiture) {
    interne = voiture;
  }

  @Override
  public float getMasse() {
    return interne.getMasse();
  }

  @Override
  public float getPuissanceMoteur() {
    return interne.getPuissanceMoteur();
  }

  @Override
  public float getForceFreinageCst() {
    return interne.getForceFreinageCst();
  }

  @Override
  public float getCoeffFreinageProp() {
    return interne.getCoeffFreinageProp();
  }

  @Override
  public float getPrix() {
    return interne.getPrix();
  }

  @Override
  public float getRegimeOptimal() {
    return interne.getRegimeOptimal();
  }

  @Override
  public float getRapportRouesMoteur() {
    return interne.getRapportRouesMoteur();
  }

  @Override
  public float getRayonRoues() {
    return interne.getRayonRoues();
  }

  @Override
  public String toString() {
    return interne.toString() + " avec " +getClass().getName();
  }
}
