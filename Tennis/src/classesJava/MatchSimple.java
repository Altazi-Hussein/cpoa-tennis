package classesJava;

import java.util.Date;

public class MatchSimple extends Match {

   private Boolean tournoi;
   
   private int[] lesJoueurs;

    public MatchSimple(Boolean tournoi, int[] lesJoueurs, int idMatch, int idPlanning, ArbitreDeChaise arbitreDeChaise, EquipeArbitreDeLigne equipeArbitresDeLigne, EquipeRamasseur equipeDeRamasseur, Date dateDébut, Date dateFin, Court court, ScoreMatch score, int tour, int idGagnant) {
        super(idMatch, idPlanning, arbitreDeChaise, equipeArbitresDeLigne, equipeDeRamasseur, dateDébut, dateFin, court, score, tour, idGagnant);
        this.tournoi = tournoi;
        this.lesJoueurs = lesJoueurs;
    }

    public int[] getLesJoueurs() {
        return lesJoueurs;
    }

    public void setLesJoueurs(int[] lesJoueurs) {
        this.lesJoueurs = lesJoueurs;
    }

    public Boolean getTournoi() {
        return tournoi;
    }

    public void setTournoi(Boolean tournoi) {
        this.tournoi = tournoi;
    }
   
}