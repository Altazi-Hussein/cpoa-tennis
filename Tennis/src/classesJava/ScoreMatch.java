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
    
    public int getGagnant(){
        int num1 = 0;
        int num2 = 0;
        int numGagnant = 0;
        
        for(int i = 0; i<scoreMatch.length; i++){
            if (scoreMatch[i][1] > scoreMatch[i][2])num1++;
            else if (scoreMatch[i][1] > scoreMatch[i][2]) num2++;
        }
        
        if (num1>num2) numGagnant = 1;
        if (num1<num2) numGagnant = 2;
        
        return numGagnant;
    }
    
}
