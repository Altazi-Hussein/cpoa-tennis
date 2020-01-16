/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesJava;

/**
 *
 * @author angel
 */
public class ScoreMatch {
    
    private int idMatch;
    
    /**
     * Les lignes de scoreMatch correspondent aux différentes manches, la premiere colonne le score du joueur ou de l'equipe 1, la deuxième celle de l'autre
     */
    private int[][] scoreMatch;

    public ScoreMatch(int idMatch, int[][] scoreMatch) {
        this.idMatch = idMatch;
        this.scoreMatch = scoreMatch;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int[][] getScoreMatch() {
        return scoreMatch;
    }

    public void setScoreMatch(int[][] scoreMatch) {
        this.scoreMatch = scoreMatch;
    }
    
    
}
