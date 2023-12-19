package etud;
/** Représente des freins à disque */
public class FreinDisque   {

  /** Décore une voiture avec des freins à disque */
  public FreinDisque() {
  }

  
  public float getPrix() {
 return 150;
  }

  
  public float getMasse() {
   return 3;
	   

  }

  
  public float getForceFreinageCst() {
   return 7.95f; // Pour obtenir une distance de freinage cohérente avec la réalité
	  

  }
}
