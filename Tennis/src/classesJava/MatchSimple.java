package classesJava;

import java.util.ArrayList;
import java.util.Date;

public class MatchSimple extends Match {

   private int tournoi;
   
   private ArrayList<Joueur> lesJoueurs;

    public MatchSimple(int tournoi, ArrayList<Joueur> lesJoueurs, int idMatch, int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDébut, Date dateFin, Court court, ScoreMatch score, int tour, int idGagnant) {
        super(idMatch, idPlanning, arbitreDeChaise, equipeArbitresDeLigne, equipeDeRamasseur, dateDébut, dateFin, court, score, tour, idGagnant);
        this.tournoi = tournoi;
        this.lesJoueurs = lesJoueurs;
    }

    public ArrayList<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    public void setLesJoueurs(ArrayList<Joueur> lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }

    public int getTournoi() {
        return tournoi;
    }

    public void setTournoi(int tournoi) {
        this.tournoi = tournoi;
    }
   
}